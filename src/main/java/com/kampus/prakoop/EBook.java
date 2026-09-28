/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class EBook extends Koleksi{
    private int ukuranFileMb;
    
    public EBook(String judul, String pengarang, int tahunTerbit, int ukuranFileMb){
        super(judul, pengarang, tahunTerbit);
        this.ukuranFileMb = ukuranFileMb;
    }
    @Override
    public void tampilkanInfo(){
        System.out.printf("[E-Book] Judul: %-15s | Pengarang: %-10s | Tahun: %d | Ukuran: %d MB%n",
        this.judul, this.pengarang, this.tahunTerbit, this.ukuranFileMb);
    }
    
    @Override
    public void caraPinjam(){
        System.out.println("Info Pinjam: E-Book dipinjam dengan cara di-download melalui aplikasi/situs web.");
    }
}