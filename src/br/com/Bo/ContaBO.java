/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bo;

import br.com.util.exeptions.ValorInvalidoException;
import br.com.Modelo.ModelSacarDepositar;
import br.com.util.exeptions.SaldoInsuficienteException;
/**
 *
 * @author Diogo
 */
public class ContaBO {
    private ModelSacarDepositar msd;
    public ContaBO(ModelSacarDepositar msd) {
		this.msd = msd;
	}
    public void validarDeposito(double valorDeposito) throws ValorInvalidoException {
		if (valorDeposito > 0)
			msd.depositar(valorDeposito);
		else
			throw new ValorInvalidoException("Valor invalido!");
	}   
    public void validarSaque(double valorSaque) 
			throws ValorInvalidoException, SaldoInsuficienteException {
		if(valorSaque > 0)
			msd.sacar(valorSaque);
		else 
			System.out.println("Valor invalido");
	}
}
