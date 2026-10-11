/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public abstract class Koleksi{
    protected String judul;
    protected String pengarang;
    protected int tahunTerbit;
    public static int totalKoleksiBerhasilDibuat = 0;
    
    public Koleksi(String judul, String pengarang, int tahunTerbit){
        setJudul(judul);
        setPengarang(pengarang);
        setTahunTerbit(tahunTerbit);
        totalKoleksiBerhasilDibuat++;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
     
    public String getJudul(){return this.judul;}
    public int getTahunTerbit(){return this.tahunTerbit;}
    
    public void tampilkanInfo(){
        System.out.printf("Judul: %-20s | Pengarang: %-15s | Tahun: %d%n", this.judul, this.pengarang, this.tahunTerbit);
    }
    
    public void caraPinjam(){
        System.out.println("Barang dipinjam secara fisik ke meja administrasi.");
    }
    
    public abstract void hitungDendaKeterlambatan();
}