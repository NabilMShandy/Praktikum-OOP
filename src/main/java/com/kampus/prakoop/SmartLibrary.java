/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author NABIL MUHAMMAD S
 */
// Class utama
public class SmartLibrary implements Serializable {

    public static void simulasiPinjam(Koleksi item) {
        item.caraPinjam();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Perpustakaan perpusUnila = new Perpustakaan("Smart Library Unila");
        perpusUnila.bukaPerpustakaan();
        perpusUnila.muatDataDariFile();

        boolean isRunning = true;

        System.out.println("...............................");
        System.out.println("Selamat Datang di Smart Library");
        System.out.println("...............................");

        while (isRunning) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah Koleksi");
            System.out.println("2. Lihat Daftar Koleksi");
            System.out.println("3. Cari Koleksi (Demo Custom Exception)");
            System.out.println("4. Manajemen Anggota (Demo HashMap)");
            System.out.println("5. Peminjaman (Demo Association)");
            System.out.println("6. Baca File Log Transaksi");
            System.out.println("7. Simpan & Keluar");
            System.out.print("Pilih Menu 1-7 : ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("--Pilih Jenis Koleksi --");
                        System.out.println("1. Buku Cetak Fisik");
                        System.out.println("2. E-Book Digital");
                        System.out.println("3. Majalah");
                        System.out.print("Pilihan (1-3): ");

                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Judul: ");
                        String judul = scanner.nextLine();

                        System.out.print("Masukkan Pengarang: ");
                        String pengarang = scanner.nextLine();

                        System.out.print("Masukkan Tahun Terbit: ");
                        int tahunTerbit = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Halaman: ");
                            perpusUnila.tambahKoleksi(new BukuCetak(judul, pengarang, tahunTerbit, scanner.nextInt()));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran File (MB): ");
                            perpusUnila.tambahKoleksi(new EBook(judul, pengarang, tahunTerbit, scanner.nextInt()));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Edisi Majalah: ");
                            perpusUnila.tambahKoleksi(new Majalah(judul, pengarang, tahunTerbit, scanner.nextLine()));
                        }

                        System.out.println("Koleksi baru ditambahkan!");
                    }

                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi Perpustakaan ---");
                        perpusUnila.lihatSemuaKoleksi();
                    }

                    case 3 -> {
                        System.out.println("\n -- Fitur Cari Koleksi -- ");
                        System.out.println("Masukkan judul: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            perpusUnila.cariKoleksi(kataKunci);
                        } catch (KoleksiTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        System.out.println("\n-- Kelola Anggota (Hash Map) --");
                        System.out.println("1. Tambah Anggota Baru");
                        System.out.println("2. Cari Anggota via NPM");
                        System.out.println("3. Tampilkan Semua Anggota");
                        System.out.print("Pilih: ");
                        int menuA = scanner.nextInt();
                        scanner.nextLine();

                        if (menuA == 1) {
                            System.out.print("Masukkan NPM (sebagai Key): ");
                            String NPM = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String nama = scanner.nextLine();

                            perpusUnila.tambahAnggota(new Anggota(NPM, nama));

                        } else if (menuA == 2) {
                            System.out.print("Masukkan NPM yang dicari: ");
                            perpusUnila.cariAnggota(scanner.nextLine());

                        } else if (menuA == 3) {
                            perpusUnila.lihatSemuaAnggota();
                        }
                    }

                    case 5 -> {
                        System.out.println("\n --- SISTEM PEMINJAMAN (ASOSIASI) ---");
                        System.out.print("Masukkan NPM peminjam: ");
                        String inputNPM = scanner.nextLine();

                        Anggota peminjam = perpusUnila.getAnggota(inputNPM);

                        if (peminjam == null) {
                            System.out.println("Gagal : Anggota belum terdaftar!");
                        } else if (perpusUnila.getJumlahKoleksi() == 0) {
                            System.out.println("Gagal : Belum ada koleksi yang bisa dipinjam!");
                        } else {
                            perpusUnila.lihatSemuaKoleksi();
                            System.out.println("Pilih Nomor Koleksi yang dapat dipinjam: ");
                            int noKoleksi = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noKoleksi >= 0 && noKoleksi < perpusUnila.getJumlahKoleksi()) {

                                Koleksi itemPinjam = perpusUnila.getKoleksi(noKoleksi);

                                TransaksiPeminjaman.prosesPinjam(peminjam, itemPinjam);
                            } else {
                                System.out.println("Nomor Koleksi tidak valid!");
                            }
                        }
                    }

                    case 6 -> {
                        perpusUnila.bacaLogTransaksi();
                    }
                    case 7 -> {
                        System.out.println("Menyimpan sesi ke database internal.....");
                        perpusUnila.simpanDataKeFile();
                        isRunning = false;
                    }
                    default ->
                        System.out.println("Pilihan tidak valid, silahkan masukkan angka 1-6.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SYSTEM]: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
