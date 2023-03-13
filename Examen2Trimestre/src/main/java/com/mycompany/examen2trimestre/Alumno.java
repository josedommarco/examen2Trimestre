/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen2trimestre;

/**
 *
 * @author josel
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private double ad;
    private double sge;
    private double di;
    private double pmdm;
    private double psp;
    private double eie;
    private double hlc;

    public Alumno(){
        
    }

    public Alumno(String nombre, String apellidos, double ad, double sge, double di, double pmdm, double psp, double eie, double hlc) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ad = ad;
        this.sge = sge;
        this.di = di;
        this.pmdm = pmdm;
        this.psp = psp;
        this.eie = eie;
        this.hlc = hlc;
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setAd(double ad) {
        this.ad = ad;
    }

    public void setSge(double sge) {
        this.sge = sge;
    }

    public void setDi(double di) {
        this.di = di;
    }

    public void setPmdm(double pmdm) {
        this.pmdm = pmdm;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public void setEie(double eie) {
        this.eie = eie;
    }

    public void setHlc(double hlc) {
        this.hlc = hlc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getAd() {
        return ad;
    }

    public double getSge() {
        return sge;
    }

    public double getDi() {
        return di;
    }

    public double getPmdm() {
        return pmdm;
    }

    public double getPsp() {
        return psp;
    }

    public double getEie() {
        return eie;
    }

    public double getHlc() {
        return hlc;
    }

   public double getMedia() {
    double[] notas = {ad, sge, di, pmdm, psp, eie, hlc};
    double suma = 0.0;
    int numAprobados = 0;
    int numSuspensos = 0;
    for (double nota : notas) {
        suma += nota;
        if (nota >= 5.0) {
            numAprobados++;
        } else {
            numSuspensos++;
        }
    }
    if (numSuspensos == 0) {
        return suma / notas.length;
    } else {
        return suma / (notas.length - numSuspensos);
    }
}


    public int getNumSuspensos() {
        double[] notas = {ad, sge, di, pmdm, psp, eie, hlc};
        int numSuspensos = 0;
        for (double nota : notas) {
            if (nota < 5.0) {
                numSuspensos++;
            }
        }
        return numSuspensos;
    }
    
   

}

