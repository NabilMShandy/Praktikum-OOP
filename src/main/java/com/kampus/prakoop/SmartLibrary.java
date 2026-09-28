/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

import java.util.*;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class SmartLibrary {

//    Method 1
    public static void cariKoleksi(String judul, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari buku dengan judul: " + judul);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Koleksi tidak ditemukan");
        }
    }

//    Method 2, overloading dari method 1
    public static void cariKoleksi(int tahunTerbit, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari buku dengan tahun: " + tahunTerbit);

        boolean ditemukan = false;

        for (int i = 0; i < daftarKoleksi.length; i++) {
            if (daftarKoleksi[i].getTahunTerbit() == tahunTerbit) {
                System.out.println("Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Koleksi tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Koleksi[] daftarKoleksi = new Koleksi[10];

        int jumlahKoleksi = 0;
        boolean isRunning = true;

        System.out.println("...............................");
        System.out.println("Selamat Datang di Smart Library");
        System.out.println("...............................");

        while (isRunning) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah Koleksi");
            System.out.println("2. Lihat Daftar Koleksi");
            System.out.println("3. Mencari Koleksi (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-3): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahKoleksi < daftarKoleksi.length) {
                        System.out.println("--Pilih Jenis Koleksi --");
                        System.out.println("1. Buku Cetak Fisik");
                        System.out.println("2. E-Book Digital");
                        System.out.print("Pilihan (1/2): ");

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
                            daftarKoleksi[jumlahKoleksi] = new BukuCetak(judulBaru, pengarangBaru, tahunTerbitBaru, halaman);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran File (MB): ");
                            int ukuranFile = scanner.nextInt();
                            scanner.nextLine();
                            daftarKoleksi[jumlahKoleksi] = new EBook(judulBaru, pengarangBaru, tahunTerbitBaru, ukuranFile);
                        }
                        jumlahKoleksi++;
                        System.out.println("Koleksi baru ditambahkan!");

                    } else {
                        System.out.println("maaf, kapasitas rak buku penuh:");

                    }
                    break;

                case 2:
                    System.out.println("\n--- Daftar Koleksi Perpustakaan ---");
                    if (jumlahKoleksi == 0) {
                        System.out.println(" Belum Ada buku yang tersimpan.");

                    } else {

                        for (int i = 0; i < jumlahKoleksi; i++) {
                            System.out.printf((i + 1) + ". ");
                            daftarKoleksi[i].tampilkanInfo();
                            daftarKoleksi[i].caraPinjam();
                            System.out.println();
                        }
                        System.out.println("\nTotal Item Perpustakaan: " + Koleksi.totalKoleksiBerhasilDibuat);
                    }
                    System.out.println("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("\n -- Fitur Cari Koleksi -- ");
                    System.out.println("1. Cari berdasarkan judul");
                    System.out.println("2. Cari berdasarkan tahun terbit");
                    System.out.println("Pilih (1/2)");

                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.println("Masukkan judul: ");
                        String kataKunci = scanner.nextLine();
                        cariKoleksi(kataKunci, daftarKoleksi, jumlahKoleksi);

                    } else if (modeCari == 2) {
                        System.out.println("Masukkan tahun terbit: ");
                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();
                        cariKoleksi(angkaKunci, daftarKoleksi, jumlahKoleksi);
                    }

                case 4:
                    System.out.println("Terimakasih telah menggunakan smart library");
                    isRunning = false;
                    break;

                default:
                    System.out.println("pilihan tidak valid, silahkan masukan angka 1-3.");
                    break;
            }
        }
        scanner.close();
    }
}