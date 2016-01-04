/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import br.com.DAO.UsuarioDAO;
import br.com.util.exeptions.SaldoInsuficienteException;
import br.com.util.exeptions.ValorInvalidoException;

/**
 *
 * @author Diogo
 */
public class ContaCorrente extends ModelSacarDepositar {
    private double novoSaldo;
    ModelConta mc = new ModelConta();
    public void depositar(double valorDeposito) {
		this.novoSaldo=mc.getSaldo()+ valorDeposito;
                mc.setSaldo(this.novoSaldo);

	}

    @Override
    public void sacar(double valorSaque) throws ValorInvalidoException, SaldoInsuficienteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
