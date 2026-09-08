///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// */
//package com.kampus.prakoop;
//
//import java.util.*;
//
///**
// *
// * @author NABIL MUHAMMAD S
// */
//import java.util.Scanner;
//
//public class PrakOOP2Pribadi {
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        String[] buku = new String[10];
//        int jumlahBuku = 0;
//        boolean isRunning = true;
//        String namaBuku;
//        
//        System.out.println("---------------------------------");
//        System.out.println("-------- Smart Library ----------");
//        System.out.println("---------------------------------");
//
//        while (isRunning) {
//            System.out.println("Pilih Menu");
//            System.out.println("1. Tambah Buku Baru");
//            System.out.println("2. Lihat daftar buku");
//            System.out.println("3. Keluar program");
//
//            int pilihan = scan.nextInt();
//            scan.nextLine();
//            
//            switch (pilihan) {
//                case 1:
//                    if (jumlahBuku < buku.length) {
//                        System.out.print("Masukkan nama buku: ");
//                        namaBuku = scan.nextLine();
//                        buku[jumlahBuku] = namaBuku;
//                        jumlahBuku++;
//                        
//                    } else {
//                        System.out.println("Buku sudah penuh!");
//                    }                   
//                    break;
//
//                case 2:
//                    if (jumlahBuku > 0) {
//                        for (int i = 0; i < jumlahBuku; i++) {
//                            System.out.println("Daftar Buku");
//                            System.out.println((i+1) + ". " + " " + buku[i]);
//                        }
//                    } else {
//                        System.out.println("Daftar buku masing kosong!");
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Keluar dari program...");
//                    isRunning = false;
//                    break;
//
//                default:
//                    System.out.println("Invalid!");
//                    break;
//            }
//        }
//        scan.close();
//    }
//}