
import br.com.DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Test;
import junit.framework.TestCase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diogo.bento
 */
public class ConexaoTest extends TestCase {
    
    public void testDeveriaConectarSeUsuarioESenhaCorretos() throws Exception {
       try {
           Conexao conexao = new Conexao();
           conexao.conectar();
           
           assertNotNull(conexao.con);
       } catch(SQLException e) {
           throw new Exception("Erro ao conectar: "+e.getMessage());
       }
    }
}