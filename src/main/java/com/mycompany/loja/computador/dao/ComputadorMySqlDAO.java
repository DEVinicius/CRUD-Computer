/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.computador.dao;

import com.mycompany.loja.computador.models.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius.oliveira
 */
public class ComputadorMySqlDAO implements IComputadorDAO{
    
    private static ComputadorMySqlDAO instance;
    
    private String DRIVER="com.mysql.cj.jdbc.Driver";
    private String LOGIN="root";
    private String PASSWORD="";
    private String URL= "jdbc:mysql://localhost:3306/lojainformatica";
        
    private Connection conexao;
    
    private ComputadorMySqlDAO() throws Exception  {
        try {
            Class.forName(this.DRIVER);
            this.conexao = DriverManager.getConnection(this.URL, this.LOGIN, this.PASSWORD); 
        } catch(Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public static ComputadorMySqlDAO getInstance() throws Exception {
        if(instance == null ) {
            return new ComputadorMySqlDAO();
        }
        
        return instance;
    }

    @Override
    public Computador create(Computador computador) {
        try {
            PreparedStatement instrucaoSQL = conexao.prepareStatement("INSERT INTO computador (marca, processador, hd) VALUES(?, ?, ?)");
        
            instrucaoSQL.setString(1, computador.getMarca());
            instrucaoSQL.setString(2, computador.getProcessador());
            instrucaoSQL.setString(3, computador.getHd());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            return computador;
        } catch(Exception ex) {
            return null;
        }   
    }

    @Override
    public List<Computador> findAll() {
        List<Computador> search = new ArrayList();
        try {
            Statement instrucaoSQL = conexao.createStatement(); 
            ResultSet rs = instrucaoSQL.executeQuery("SELECT * FROM computador");
            
            if(rs == null) {
                throw new Exception("Falha Ao Realizar SELECT");
            }
                
            
            
            while(rs.next()) {
                Computador comp = new Computador(
                    rs.getInt("id"),
                    rs.getString("processador"),
                    rs.getString("hd")
                );
                
                search.add(comp);
            }
            
            return search;
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public List<Computador> findByProcessador(String processador) {
        List<Computador> search = new ArrayList();
        try {
            Statement instrucaoSQL = conexao.createStatement(); 
            ResultSet rs = instrucaoSQL.executeQuery("SELECT * FROM computador WHERE processador LIKE '%" + processador + "%'");
            
            if(rs == null) {
                throw new Exception("Falha Ao Realizar SELECT");
            }
            
            while(rs.next()) {
                Computador comp = new Computador(
                    rs.getInt("id"),
                    rs.getString("processador"),
                    rs.getString("hd")
                );
                
                search.add(comp);
            }
            
            return search;
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public Computador findById(int id) {
        try {
            Statement instrucaoSQL = conexao.createStatement(); 
            ResultSet rs = instrucaoSQL.executeQuery("SELECT * FROM computador WHERE id = " + id );
            
            if(rs == null) {
                throw new Exception("Falha Ao Realizar SELECT");
            }
            
            while(rs.next()) {
                Computador comp = new Computador(
                    rs.getInt("id"),
                    rs.getString("processador"),
                    rs.getString("hd")
                );
                
                return comp;
            }
            
            return null;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Computador update(Computador computador) {
        try {
            PreparedStatement instrucaoSQL = conexao.prepareStatement("UPDATE computador SET (marca, processador, hd) VALUES(?, ?, ?) WHERE id = ?");
        
            instrucaoSQL.setString(1, computador.getMarca());
            instrucaoSQL.setString(2, computador.getProcessador());
            instrucaoSQL.setString(3, computador.getHd());
            instrucaoSQL.setInt(4, computador.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            return computador;
        } catch(Exception ex) {
            return null;
        } 
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement instrucaoSQL = conexao.prepareStatement("DELETE FROM computador WHERE id = ?");
        
            instrucaoSQL.setInt(1, id);

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            return true;
        } catch(Exception ex) {
            return false;
        } 
    }
    
}
