/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class TransaksiPeminjaman {
    public static void prosesPinjam(Anggota anggota, Koleksi koleksi){
        System.out.println("\n --- Struk Transaksi ---");
        System.out.println("Peminjam        : " + anggota.getNama() + "  (" + anggota.getNpm() + ")");
        System.out.println("Item            : " + koleksi.getJudul());
        System.out.println("Status          : Berhasil dicatat sistem");
        
        koleksi.caraPinjam();
        if(koleksi instanceof DapatDipinjam){
            ((DapatDipinjam) koleksi).prosesPinjamFisik();
        }
        System.out.println("--------------------------");
    }
}
