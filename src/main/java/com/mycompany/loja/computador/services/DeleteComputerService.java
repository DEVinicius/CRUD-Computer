/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.computador.services;

import com.mycompany.loja.computador.dao.ComputadorDAO;
import com.mycompany.loja.computador.dao.IComputadorDAO;

/**
 *
 * @author vinicius.oliveira
 */
public class DeleteComputerService {
    private IComputadorDAO computadorDAO;
    
    public DeleteComputerService() {
        this.computadorDAO = ComputadorDAO.getInstance();
    }
    
    public boolean execute(int id) {
        return this.computadorDAO.delete(id);
    }
}
