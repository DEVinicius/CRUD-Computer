/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.computador.services;

import com.mycompany.loja.computador.dao.ComputadorDAO;
import com.mycompany.loja.computador.dao.ComputadorMySqlDAO;
import com.mycompany.loja.computador.dao.IComputadorDAO;
import com.mycompany.loja.computador.models.Computador;

/**
 *
 * @author vinicius.oliveira
 */
public class UpdateComputerService {
    private IComputadorDAO computadorDAO;
    
    public UpdateComputerService() throws Exception {
        this.computadorDAO = ComputadorMySqlDAO.getInstance();
    }
    
    public Computador execute(int id, String processador, String hd) {
        Computador computadorReq = new Computador(processador, hd);
        computadorReq.setId(id);
        
        Computador computador = this.computadorDAO.create(computadorReq);
        
        return computador;
    }
}
