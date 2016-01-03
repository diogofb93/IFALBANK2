/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bo;
import br.com.View.*;
import br.com.DAO.Conexao;
import br.com.DAO.UsuarioDAO;
import br.com.Modelo.ModelConta;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class LoginBO {
    Conexao conexao;
    public LoginBO(){
        this.conexao = new Conexao();
    }
    //VALIDAR
     public void validarLogin(String nUsuario, String senhaUsuario) throws SQLException {
         ModelConta mc= new ModelConta();
         UsuarioDAO usuarioDao = new UsuarioDAO();
        if (usuarioDao.isLoginValido(nUsuario, senhaUsuario) == true) {
            if(mc.getTipo().equalsIgnoreCase("gerente")){
                ViewTelaPrincipalGerente telaGerente = new ViewTelaPrincipalGerente();
                telaGerente.setVisible(true);
                
            }

            }
     }
}


