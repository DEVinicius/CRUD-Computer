/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.computador.services;

import com.mycompany.loja.computador.dao.ComputadorDAO;
import com.mycompany.loja.computador.dao.IComputadorDAO;
import com.mycompany.loja.computador.models.Computador;

/**
 *
 * @author vinicius.oliveira
 */
public class CreateComputerService {
    private IComputadorDAO computadorDAO;
    
    public CreateComputerService() {
        this.computadorDAO = ComputadorDAO.getInstance();
    }
    
    public Computador execute(String processador, String hd) {
        Computador computadorReq = new Computador(processador, hd);
        
        Computador computador = this.computadorDAO.create(computadorReq);
        
        return computador;
    }
}
