/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bo;

import br.com.util.exeptions.ValorInvalidoException;

/**
 *
 * @author Diogo
 */
public class ContaBO {
    public void validarDeposito(double valorDeposito) throws ValorInvalidoException {
		if (valorDeposito > 0)
			conta.depositar(valorDeposito);
		else
			throw new ValorInvalidoException("Valor invalido!");
	}
}
