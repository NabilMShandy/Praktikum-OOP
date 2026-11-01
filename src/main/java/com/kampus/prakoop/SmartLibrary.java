/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 *
 * @author NABIL MUHAMMAD S
 */
// Class utama
public class SmartLibrary {

//    Method 1
    public static void cariKoleksi(String judul, ArrayList<Koleksi> daftarKoleksi) throws KoleksiTidakDitemukanException {
        System.out.println("Mencari buku dengan judul: " + judul);

        boolean ditemukan = false;

        for (int i = 0; i < daftarKoleksi.size(); i++) {
            if (daftarKoleksi.get(i).getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Ditemukan: ");
                daftarKoleksi.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new KoleksiTidakDitemukanException("Gagal : Koleksi dengan judul " + judul + " tidak terdaftar di sistem.");
        }
    }

    public static void simulasiPinjam(Koleksi item) {
        item.caraPinjam();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Koleksi> daftarKoleksi = new ArrayList<>();

        HashMap<String, String> dataAnggota = new HashMap<>();

        int jumlahKoleksi = 0;
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
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu 1-5 : ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:

                        System.out.println("--Pilih Jenis Koleksi --");
                        System.out.println("1. Buku Cetak Fisik");
                        System.out.println("2. E-Book Digital");
                        System.out.println("3. Majalah");
                        System.out.print("Pilihan (1-3): ");

                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Judul: ");
                        String judulBaru = scanner.nextLine();

                        System.out.print("Masukkan Pengarang: ");
                        String pengarangBaru = scanner.nextLine();

                        System.out.print("Masukkan Tahun Terbit: ");
                        int tahunTerbitBaru = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Halaman: ");
                            int halaman = scanner.nextInt();
                            scanner.nextLine();
                            daftarKoleksi.add(new BukuCetak(judulBaru, pengarangBaru, tahunTerbitBaru, halaman));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran File (MB): ");
                            int ukuranFile = scanner.nextInt();
                            scanner.nextLine();
                            daftarKoleksi.add(new EBook(judulBaru, pengarangBaru, tahunTerbitBaru, ukuranFile));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Edisi Majalah: ");
                            String edisiBaru = scanner.nextLine();
                            daftarKoleksi.add(new Majalah(judulBaru, pengarangBaru, tahunTerbitBaru, edisiBaru));
                        }

                        jumlahKoleksi++;
                        System.out.println("Koleksi baru ditambahkan!");

                        break;

                    case 2:
                        System.out.println("\n--- Daftar Koleksi Perpustakaan ---");
                        if (daftarKoleksi.isEmpty()) {
                            System.out.println(" Belum Ada buku yang tersimpan.");

                        } else {
                            for(int i = 0; i < daftarKoleksi.size(); i++){
                                System.out.print((i+1) + ". ");
                                daftarKoleksi.get(i).tampilkanInfo();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n -- Fitur Cari Koleksi -- ");
                        System.out.println("Masukkan judul: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            cariKoleksi(kataKunci, daftarKoleksi);
                        } catch (KoleksiTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }

                        break;

                    case 4:
                        System.out.println("\n-- Kelola Anggota (HashMap) --");
                        System.out.println("1. Tambah Anggota Baru");
                        System.out.println("2. Cari Anggota via NPM");
                        System.out.println("3. Tampilkan Semua Anggota");
                        System.out.print("Pilih: ");
                        int menuAnggota = scanner.nextInt();
                        scanner.nextLine();

                        if (menuAnggota == 1) {
                            System.out.print("Masukkan NPM (sebagai Key): ");
                            String NPM = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String nama = scanner.nextLine();

                            dataAnggota.put(NPM, nama);
                            System.out.println("Berhasil menambahkan anggota!)");
                            
                        } else if (menuAnggota == 2) {
                            System.out.print("Masukkan NPM yang dicari: ");
                            String searchNPM = scanner.nextLine();

                            if (dataAnggota.containsKey(searchNPM)) {
                                System.out.println("Ditemukan! Nama: " + dataAnggota.get(searchNPM));
                            } else {
                                System.out.println("Angota dengan NPM tersebut tidak terdaftar.");
                            }
                            
                        } else if (menuAnggota == 3) {
                            System.out.println("Total Anggota Terdaftar: " + dataAnggota.size());
                            for (String keyNPM : dataAnggota.keySet()) {
                                System.out.println("NPM: " + keyNPM + " | Nama: " + dataAnggota.get(keyNPM));
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Terima kasih telah menggunakan Smart Library");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");

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