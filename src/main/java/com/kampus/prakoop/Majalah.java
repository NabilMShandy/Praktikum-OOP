/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

/**
 *
 * @author R2-KD011
 */
public class Majalah extends Koleksi {

    String edisi;

    public Majalah(String judul, String pengarang, int tahunTerbit, String edisi) {
        super(judul, pengarang, tahunTerbit);
        this.edisi = edisi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("Judul: %-20s | Pengarang: %-15s | Tahun Terbit: %d | Edisi: %-15s", this.judul, this.pengarang, this.tahunTerbit, this.edisi);
    }

    @Override
    public void caraPinjam() {
        System.out.println("Barang dipinjam secara fisik ke meja administrasi.");
    }
}