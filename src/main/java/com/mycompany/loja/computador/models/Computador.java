/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.computador.models;

/**
 *
 * @author vinicius.oliveira
 */
public class Computador {
    public static String marca = "Vinicius Pereira de Oliveira";
    private int id;
    private String hd;
    private String processador;
    
    public Computador(String processador, String hd) {
        this.hd = hd;
        this.processador = processador;
    }
    
    public Computador(int id, String processador, String hd) {
        this.hd = hd;
        this.processador = processador;
        this.id = id;
    }
    
    public Computador() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }
    
    public String getMarca() {
        return Computador.marca;
    }
    
}
