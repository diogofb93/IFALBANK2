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
public interface IConexao {
	   Connection getConexao(String tipoBanco, String endereco, String nomeBanco,
			String nomeUsuario, String senha) throws SQLException;
}
