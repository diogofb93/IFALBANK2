/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diogo
 */
public class ConexaoMySQL implements IConexao{
    	static Connection conexao;
	
	@Override
	public synchronized Connection getConexao(String tipoBanco, String endereco, String nomeBanco,
			String nomeUsuario, String senha) throws SQLException {
		try {
    			if(conexao == null) 
				conexao = DriverManager.getConnection(tipoBanco+"://"+endereco+"/"+ nomeBanco, nomeUsuario, senha);
			return conexao;
		} catch(SQLException e) {
			throw new SQLException("Erro ao conectar com o banco de dados: "+e.getMessage());
		}
	}
        public void getDesconectar(){
                try {
                    conexao.close();
                    System.out.println("Desconectado com sucesso!");
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
}

