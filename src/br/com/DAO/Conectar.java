/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Diogo
 */
public class Conectar {
    public void getConectar()throws Exception {
        try{
		IConexao banco = new ConexaoMySQL();
		Connection conexao = null;
		conexao = banco.getConexao("jdbc:mysql", "127.0.0.1", "ifalbank","root", "");
                System.out.println("Conectado ao BD");
    }catch(SQLException e){
        System.out.println("Erro"+e.getMessage());
    }
    }
    
}


