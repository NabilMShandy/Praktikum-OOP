/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.prakoop;

import java.io.Serializable;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class Anggota implements Serializable{
    private static final long serialVersionUID = 1L;

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
