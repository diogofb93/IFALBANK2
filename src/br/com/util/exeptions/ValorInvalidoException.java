/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util.exeptions;

/**
 *
 * @author Diogo
 */
public class ValorInvalidoException extends Exception {
    	public ValorInvalidoException(String mensagemErro) {
		super(mensagemErro);
	}
}
