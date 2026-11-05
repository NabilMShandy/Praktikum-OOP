/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class Perpustakaan {

    // Aggregation
    private String namaPerpustakaan;
    private RuangBaca ruangBacaUtama;
    private ArrayList<Koleksi> daftarKoleksi;
    private HashMap<String, Anggota> dataAnggota;

    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
        this.ruangBacaUtama = new RuangBaca("Ruang Baca Utama", 50);
        this.daftarKoleksi = new ArrayList<>();
        this.dataAnggota = new HashMap<>();
    }

    public void bukaPerpustakaan() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaPerpustakaan + " ***");
    }

    public void tambahKoleksi(Koleksi k) {
        daftarKoleksi.add(k);
        System.out.println("Sukses! Koleksi ditambahkan. Total Koleksi: " + daftarKoleksi.size());
    }

    public void tambahAnggota(Anggota a) {
        this.dataAnggota.put(a.getNpm(), a);
        System.out.println("Berhasil! Menambahkan Anggota!");
    }

    public void lihatSemuaKoleksi() {
        if (daftarKoleksi.isEmpty()) {
            System.out.println("Belum ada Koleksi yang tersimpan");
        } 
        else {
            for (int i = 0; i < daftarKoleksi.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftarKoleksi.get(i).tampilkanInfo();
            }
        }

    }

    //    Method 1
    public void cariKoleksi(String judul) throws KoleksiTidakDitemukanException {
        System.out.println("Mencari buku dengan judul: " + judul);

        boolean ditemukan = false;

        for (Koleksi k : daftarKoleksi) {
            if (k.getJudul().equalsIgnoreCase(judul)) {
                k.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new KoleksiTidakDitemukanException("Gagal : Koleksi dengan judul " + judul + " tidak terdaftar di sistem.");
        }
    }

    public void cariAnggota(String npm) {
        if (dataAnggota.containsKey(npm)) {
            System.out.println("Ditemukan! Nama: " + dataAnggota.get(npm).getNama());
        }
        else{
            System.out.println("Anggota dengan NPM tersebut tidak terdaftar.");
        }
    }
    
    public void lihatSemuaAnggota(){
        if(dataAnggota.isEmpty()){
            System.out.println("Anggota masih kosong!");
        }
        else{
            System.out.println("Total Anggota terdaftar: " + dataAnggota.size());
            for(Anggota a : dataAnggota.values()){
                System.out.println("NPM : " + a.getNpm() + " | Nama: " + a.getNama());
            }
        }
    }
    
    public Anggota getAnggota(String npm){
        return dataAnggota.get(npm);
    }
    
    public Koleksi getKoleksi(int index){
        return daftarKoleksi.get(index);
    }
    
    public int getJumlahKoleksi(){
        return daftarKoleksi.size();
    }
    
}
