/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogo
 */
public class Conexao {

    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/ifalbank";
    private String usuario = "root";
    private String senha = "";
    public Connection con;

    public void conectar() throws Exception {
        System.setProperty("jdbc.Driver", driver);
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso");
        } catch (SQLException ex) {
            throw new Exception("Erro ao conectar" + ex.getMessage());
        }
    }

    public void desconectar() {
        try {
            con.close();
            System.out.println("Desconectado");
        } catch (SQLException ex) {
            System.out.println("ERRO" + ex.getMessage());
        }
    }
}
