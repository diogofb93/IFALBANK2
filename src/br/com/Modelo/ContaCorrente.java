/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Modelo;

import br.com.AbriBandeja.WinmmAbrir;
import br.com.DAO.UsuarioDAO;
import br.com.util.exeptions.SaldoInsuficienteException;
import br.com.util.exeptions.ValorInvalidoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class ContaCorrente extends ModelSacarDepositar {

    private double novoSaldo;
    ModelConta mc = new ModelConta();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    public void depositar(double valorDeposito) {
        try {
            this.novoSaldo = mc.getSaldo() + valorDeposito;
            mc.setSaldo(this.novoSaldo);
            JOptionPane.showMessageDialog(null, "Depositado com sucesso\n Novo saldo: " + mc.getSaldo());
            usuarioDao.updateConta(mc);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }

    }

    public void sacar(double valorSaque) throws SaldoInsuficienteException {
        if (mc.getSaldo() >= valorSaque) {
            try {
                this.novoSaldo = mc.getSaldo() - valorSaque;
                mc.setSaldo(this.novoSaldo);
                usuarioDao.updateConta(mc);
              WinmmAbrir.Abrir();
                JOptionPane.showMessageDialog(null, "Sacado com sucesso retire seu dinheiro na bandeja de dvd \n Novo saldo: " + mc.getSaldo());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
            }
        }else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
        }
    }

    public void transferir(double valorTranferir) {
        if (mc.getSaldo() >= valorTranferir) {
            try {
                this.novoSaldo = mc.getSaldo() - valorTranferir;
                mc.setSaldo(this.novoSaldo);
                usuarioDao.transferir(mc);
                JOptionPane.showMessageDialog(null, "Transferido com sucesso\n Novo saldo: " + mc.getSaldo());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro "+ ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
        }
    }

}
