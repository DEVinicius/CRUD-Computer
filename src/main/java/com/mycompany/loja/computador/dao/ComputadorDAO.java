/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.computador.dao;

import com.mycompany.loja.computador.models.Computador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius.oliveira
 */
public class ComputadorDAO implements IComputadorDAO {
    private List<Computador> computadores;
    private static ComputadorDAO instance;
    
    private int id = 1;
    
    private ComputadorDAO() {
        this.computadores = new ArrayList();
        
        Computador comp1 = new Computador("Intel i9", "Kingston 480");
        comp1.setId(1000);
        
        Computador comp2 = new Computador("Intel i9 7gen", "Kingston 1024");
        comp2.setId(999);
        
        this.computadores.add(comp1);
        this.computadores.add(comp2);
    }
    
    public static ComputadorDAO getInstance() {
        if(instance == null) {
            return new ComputadorDAO();
        }
        
        return instance;
    }
    
    @Override
    public Computador create(Computador computador) {
        this.computadores.add(computador);
        
        return computador;
    }

    @Override
    public List<Computador> findAll() {
        return this.computadores;
    }

    @Override
    public List<Computador> findByProcessador(String processador) {
        List<Computador> search = new ArrayList();
        
        for(Computador comp: this.computadores) {
            if(comp.getProcessador().contains(processador)) {
                search.add(comp);
            }
        }
        
        return search;
    }

    @Override
    public Computador findById(int id) {
        
        for(Computador comp: this.computadores) {
            if(comp.getId() == id) {
                return comp;
            }
        }
        return null;
    }

    @Override
    public Computador update(Computador computador) {
        Computador searchComputer = this.findById(computador.getId());
        
        searchComputer.setHd(computador.getHd());
        searchComputer.setProcessador(computador.getProcessador());
        
        int indexList = this.computadores.indexOf(computador);
        this.computadores.set(indexList, searchComputer);
        
        return searchComputer;
    }

    @Override
    public boolean delete(int id) {
        Computador searchComputer = this.findById(id);

        int indexList = this.computadores.indexOf(searchComputer);
        this.computadores.remove(indexList);
        
        return true;
    }
    
}
