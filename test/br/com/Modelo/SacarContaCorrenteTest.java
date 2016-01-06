/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Diego Melo
 */
public class SacarContaCorrenteTest extends TestCase {

    private ModelSacarDepositar msd;
    ModelConta mc = new ModelConta();
    protected double saldo = 0;
    Double ValorfinalC = 100.00;

    @Test
    public void testSacarContaCorrente() throws Exception {
        try {
            msd = new ContaCorrente();
            mc.setN_usuario(8);
            msd.sacar(100);
            assertFalse("Teste de Sacar", ValorfinalC == mc.getSaldo());
        } catch (NullPointerException n) {
            throw new Exception("Erro ao depositar: " + n.getMessage());

        }
    }
}
