/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;
import br.com.util.exeptions.ValorInvalidoException;
import br.com.util.exeptions.SaldoInsuficienteException;
/**
 *
 * @author Diogo
 */
public abstract class ModelSacarDepositar {
    protected ModelSacarDepositar msd;
    ModelConta mc = new ModelConta();
    protected double saldo;
    public abstract void depositar(double valorDeposito);
    public abstract void sacar(double valorSaque) throws ValorInvalidoException, SaldoInsuficienteException ;
    public double getSaldo() {
            saldo=mc.getSaldo();
		return this.saldo;
	}
    
}
