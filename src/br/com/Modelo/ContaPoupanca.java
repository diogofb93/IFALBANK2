/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;
import br.com.util.exeptions.SaldoInsuficienteException;
/**
 *
 * @author Diogo
 */
public class ContaPoupanca extends ModelSacarDepositar{
    
      private double novoSaldo;
    ModelConta mc = new ModelConta();
    public void depositar(double valorDeposito) {
		this.novoSaldo=mc.getSaldo()+ (valorDeposito*1.5);
                mc.setSaldo(this.novoSaldo);

	}


	public void sacar(double valorSaque) throws SaldoInsuficienteException {
		if(saldo >= valorSaque) {
			saldo -= valorSaque;
		}
		else {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	}
    
}
