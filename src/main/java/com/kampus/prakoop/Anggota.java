/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class Anggota {

    private String nama;
    private String npm;

    public Anggota(String npm, String nama) {
        this.npm = npm;
        this.nama = nama;
    }

    public String getNpm() {
        return this.npm;
    }

    public String getNama() {
        return this.nama;
    }

}
