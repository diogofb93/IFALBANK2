/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import br.com.DAO.UsuarioDAO;
import br.com.util.exeptions.SaldoInsuficienteException;
import br.com.util.exeptions.ValorInvalidoException;
import javax.swing.JOptionPane;

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

    public void sacar(double valorSaque) throws SaldoInsuficienteException {
		if(mc.getSaldo() > valorSaque) {
                    
			this.novoSaldo =mc.getSaldo()- valorSaque;
                        mc.setSaldo(this.novoSaldo);
                        JOptionPane.showMessageDialog(null, "Saque feito com sucesso!");
		}
		else {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	}
    
}
