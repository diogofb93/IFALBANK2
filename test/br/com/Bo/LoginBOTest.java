/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bo;

import br.com.DAO.Conexao;
import java.sql.*;
import br.com.Bo.*;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertFalse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Melo
 */
public class LoginBOTest extends TestCase {

    Conexao conexao;

    @Test
    public void testValidarLoginValido() throws Exception {
        LoginBO login = new LoginBO();
        login.validarLogin("8", "1234");

    }
}
