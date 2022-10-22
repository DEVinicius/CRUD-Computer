/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.computador.services;

import com.mycompany.loja.computador.dao.ComputadorDAO;
import com.mycompany.loja.computador.dao.IComputadorDAO;
import com.mycompany.loja.computador.models.Computador;
import java.util.List;

/**
 *
 * @author vinicius.oliveira
 */
public class ListComputersByProcessadorService {
    private IComputadorDAO computadorDAO;
    
    public ListComputersByProcessadorService() {
        this.computadorDAO = ComputadorDAO.getInstance();
    }
    
    public List<Computador> execute(String processador) {
        return this.computadorDAO.findByProcessador(processador);
    }
}
