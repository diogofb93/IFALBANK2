/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import junit.framework.TestCase;
import static junit.framework.TestCase.assertFalse;
import org.junit.Test;

/**
 *
 * @author Diego Melo
 */
public class DepositarContaPoupancaTest extends TestCase {

    private ModelSacarDepositar msd;
    ModelConta mc = new ModelConta();
    protected double saldo = 0;
    Double ValorfinalP = 150.00;

    @Test
    public void testDepositarContaCorrente() throws Exception {
        try {
            msd = new ContaPoupanca();
            mc.setN_usuario(7);
            msd.depositar(300);
            assertFalse("Teste de Deposito", ValorfinalP == mc.getSaldo());
        } catch (NullPointerException n) {
            throw new Exception("Erro ao depositar: " + n.getMessage());
        }

    }

}
