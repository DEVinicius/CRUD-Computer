/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.loja.computador.dao;

import com.mycompany.loja.computador.models.Computador;
import java.util.List;

/**
 *
 * @author vinicius.oliveira
 */
public interface IComputadorDAO {
    Computador create(Computador computador);
    List<Computador> findAll();
    List<Computador> findByProcessador(String processador);
    Computador findById(int id);
    Computador update(Computador computador);
    boolean delete(int id);
}
