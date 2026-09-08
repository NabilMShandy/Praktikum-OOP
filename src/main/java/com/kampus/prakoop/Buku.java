/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class Buku {

    private String judul;
    private String pengarang;
    private int tahunTerbit;

    public static int totalBukuBerhasilDibuat = 0;

    Buku(String judul, String pengarang, int tahun) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahun;
        totalBukuBerhasilDibuat++;
    }

//    Setter
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setTahun(int tahun) {
        if (tahunTerbit > 0) {
            this.tahunTerbit = tahun;
        }
        else{
            System.out.println("Tidak terbit tidak valid!");
        }

    }

//    Getter
    public String getJudul() {
        return this.judul;
    }

    public String getPengarang() {
        return this.pengarang;
    }

    public int getTahunTerbit() {
        return this.tahunTerbit;
    }

    public void tampilkanInfoBuku() {
        System.out.printf("Judul: %-20s Pengarang %-15s | Tahun: %d%n", this.judul, this.pengarang, this.tahunTerbit);
    }
}