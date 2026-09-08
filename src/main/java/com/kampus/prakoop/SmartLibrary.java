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
    public static void cariBuku(String judul, Buku[] daftarBuku, int jumlahBuku){
        System.out.println("Mencari buku dengan judul: " + judul);
        
        boolean ditemukan = false;
        
        for(int i = 0; i < daftarBuku.length; i++){
            if(daftarBuku[i].getJudul().equalsIgnoreCase(judul)){
                System.out.println("Ditemukan: ");
                daftarBuku[i].tampilkanInfoBuku();
                ditemukan = true;
            }
        }
        
        if(!ditemukan){System.out.println("Buku tidak ditemukan");}
    }
    
//    Method 2, overloading dari method 1
    public static void cariBuku(int tahunTerbit, Buku[] daftarBuku, int jumlahBuku){
        System.out.println("Mencari buku dengan tahun: " + tahunTerbit);
        
        boolean ditemukan = false;
        
        for(int i = 0; i < daftarBuku.length; i++){
            if(daftarBuku[i].getTahunTerbit()== tahunTerbit){
                System.out.println("Ditemukan: ");
                daftarBuku[i].tampilkanInfoBuku();
                ditemukan = true;
            }
        }
        
        if(!ditemukan){System.out.println("Buku tidak ditemukan");}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buku[] daftarBuku = new Buku[10];

        int jumlahBuku = 0;
        boolean isRunning = true;

        System.out.println("......................");
        System.out.println("Selamat Datang di Smaert Library");
        System.out.println("......................");

        while (isRunning) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Mencari Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-3): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahBuku < daftarBuku.length) {
                        System.out.println("\n-- Form Tambah Buku --");

                        System.out.print(" Masukan Judul Buku Baru: ");
                        String judulBaru = scanner.nextLine();
                        
                        System.out.print(" Masukan Pengarang Buku Baru: ");
                        String pengarangBaru = scanner.nextLine();
                        
                        System.out.print(" Masukan Tahun Buku Baru: ");
                        int tahunBaru = scanner.nextInt();
                        
                        Buku bukuBaru = new Buku(judulBaru, pengarangBaru, tahunBaru);

                        daftarBuku[jumlahBuku] = bukuBaru;

                        jumlahBuku++;

                        System.out.println("sukses buku berhasil ditambahkan");
                    } else {
                        System.out.println("maaf, kapasitas rak buku penuh:");

                    }

                    break;

                case 2:
                    System.out.println("\n--- Daftar Buku Perpustakaan ---");
                    if (jumlahBuku == 0) {
                        System.out.println(" Belum Ada buku yang tersimpan.");

                    } else {

                        for (int i = 0; i < jumlahBuku; i++) {
                            System.out.printf((i + 1) + ". ");
               
                            daftarBuku[i].tampilkanInfoBuku();
                        }
                        System.out.println("\nTotal buku fisik yang terdaftar: " + Buku.totalBukuBerhasilDibuat);
                    }
                    break;
                 
                case 3:
                    System.out.println("\n -- Fitur Cari Buku");
                    System.out.println("1. Cari berdasarkan judul");
                    System.out.println("2. Cari berdasarkan tahun terbit");
                    System.out.println("Pilih (1/2)");
                    scanner.nextInt();
                    
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(modeCari == 1){
                        System.out.println("Masukkan judul: ");
                        String kataKunci = scanner.nextLine();
                        cariBuku(kataKunci, daftarBuku, jumlahBuku);
                        
                    }
                    else if(modeCari == 2){
                        System.out.println("Masukkan tahun terbit: ");
                        int angkaKunci = scanner.nextInt();
                        cariBuku(angkaKunci, daftarBuku, jumlahBuku);
                    }
                    scanner.nextLine();
                    
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