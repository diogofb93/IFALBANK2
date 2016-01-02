/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.Modelo.ModelConta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogo
 */
    public class UsuarioDAO {
        Conexao conexao;

        public UsuarioDAO() {
            this.conexao = new Conexao();
        }

    
    
    public void inserir(ModelConta mc) throws Exception {
        this.conexao.conectar();
        try {
            PreparedStatement ps = conexao.con.prepareStatement("INSERT INTO CLIENTE(NOME, SENHA, TIPO, SALDO) VALUES(?,?,?,?)");
            ps.setString(1, mc.getNome());
            ps.setString(2, mc.getSenha());
            ps.setString(3, mc.getTipo());
            ps.setString(4, mc.getSaldo());
            
            System.out.println("Inserido com sucesso");
            ps.execute();
            conexao.desconectar();
        } catch (SQLException ex) {
           System.out.println("Erro"+ex.getMessage());
        }
    }public void buscar (ModelConta mc) throws Exception{
            ResultSet rs;
        this.conexao.conectar();
        try {
            PreparedStatement ps = this.conexao.con.prepareStatement("SELECT ID_USUARIO,NOME,TIPO,SALDO FROM CLIENTE WHERE ID_USUARIO = ?");
            ps.setInt(1,mc.getBusca_usuario());
            rs = ps.executeQuery(); 
                boolean next = rs.next();
                mc.setN_usuario(rs.getInt("ID_USUARIO"));
                mc.setNome(rs.getString("NOME"));
                mc.setSaldo(rs.getString("SALDO"));
                mc.setTipo(rs.getString("TIPO"));
        	 
           conexao.desconectar();
        }catch(SQLException ex){
            System.out.println("Erro "+ex.getMessage());
        }                
    }
    
    public boolean isLoginValido(String id_Usuario, String senha) throws SQLException{
        ResultSet rs;
        Statement stm;
        
        try {
            this.conexao.conectar();
        } catch (Exception ex) {
           System.out.println("ERRO");
        }
        boolean isLoginValido = false;
        try{
         PreparedStatement ps = this.conexao.con.prepareStatement("SELECT ID_USUARIO,NOME,SENHA,TIPO,SALDO FROM CLIENTE WHERE ID_USUARIO = ? AND SENHA = ?");
          ps.setString(1,id_Usuario);
          ps.setString(2, senha);
          rs = ps.executeQuery();
          boolean next = rs.next();
          ModelConta mc= new ModelConta();
           mc.setN_usuario(rs.getInt("ID_USUARIO"));
           mc.setNome(rs.getString("NOME"));
           mc.setSaldo(rs.getString("SALDO"));
           mc.setTipo(rs.getString("TIPO"));
           isLoginValido= true;         
          return isLoginValido;
    }catch (SQLException e){
        throw new SQLException("Erro ao checar dados!: "+e.getMessage());
    }   
    }
}
