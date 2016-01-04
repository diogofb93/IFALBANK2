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
    	public void depositar(double valorDeposito) {
		this.saldo += (valorDeposito*1.5);
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
