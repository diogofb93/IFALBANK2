package br.com.DAO;

import br.com.Modelo.ModelConta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class UsuarioDAO {

    Conexao conexao;

    public UsuarioDAO() {
        this.conexao = new Conexao();
    }

    public void inserir(ModelConta mc) throws Exception {
        this.conexao.conectar();
        try {
            PreparedStatement ps = conexao.con.prepareStatement("INSERT INTO CLIENTE(NOME, SENHA, TIPO, SALDO, CPF) VALUES(?,?,?,?,?)");
            ps.setString(1, mc.getNome());
            ps.setString(2, mc.getSenha());
            ps.setString(3, mc.getTipo());
            ps.setDouble(4, mc.getSaldo());
            ps.setString(5, mc.getCPF());
            System.out.println("Inserido com sucesso");
            ps.execute();
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }

    }

    public void buscar(ModelConta mc) throws Exception {
        ResultSet rs;
        this.conexao.conectar();
        try {
            PreparedStatement ps = this.conexao.con.prepareStatement("SELECT ID_USUARIO,NOME,TIPO,SALDO,CPF FROM CLIENTE WHERE ID_USUARIO = ?");
            ps.setInt(1, mc.getBusca_usuario());
            rs = ps.executeQuery();
            boolean next = rs.next();
            mc.setBusca_usuario(rs.getInt("ID_USUARIO"));
            mc.setNomeBusca(rs.getString("NOME"));
            mc.setSaldoBusca(rs.getDouble("SALDO"));
            mc.setTipoBusca(rs.getString("TIPO"));
            mc.setCPFBusca(rs.getString("CPF"));

            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Erro " + ex.getMessage());
        }
    }

    public boolean isLoginValido(String id_Usuario, String senha) throws SQLException {
        ResultSet rs;
        Statement stm;

        try {
            this.conexao.conectar();
        } catch (Exception ex) {
            System.out.println("ERRO");
        }
        boolean isLoginValido = false;
        try {
            PreparedStatement ps = this.conexao.con.prepareStatement("SELECT ID_USUARIO,NOME,SENHA,TIPO,SALDO FROM CLIENTE WHERE ID_USUARIO = ? AND SENHA = ?");
            ps.setString(1, id_Usuario);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            boolean next = rs.next();
            ModelConta mc = new ModelConta();
            mc.setN_usuario(rs.getInt("ID_USUARIO"));
            mc.setNome(rs.getString("NOME"));
            mc.setSaldo(rs.getDouble("SALDO"));
            mc.setTipo(rs.getString("TIPO"));
            isLoginValido = true;
            return isLoginValido;
        } catch (SQLException e) {
            throw new SQLException("Erro ao checar dados!: " + e.getMessage());
        }
    }

    public void RetornaNumeroDaConta(ModelConta mc) throws Exception {
        ResultSet rs;
        this.conexao.conectar();

        try {
            PreparedStatement ps = this.conexao.con.prepareStatement("SELECT ID_USUARIO FROM CLIENTE WHERE CPF = ?");
            ps.setString(1, mc.getCPF());
            rs = ps.executeQuery();
            boolean next = rs.next();
            mc.setNova_conta(rs.getInt("ID_USUARIO"));
            System.out.println(mc.getNova_conta());
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Erro " + ex.getMessage());
        }
    }
    
    public void inserirTransacao(ModelConta mc) throws Exception {
        this.conexao.conectar();
        try {
            PreparedStatement ps = conexao.con.prepareStatement("INSERT INTO TRANSACAO(ID_USUARIO,TIPO,VALOR) VALUES(?,?,?)");
            ps.setInt(1, mc.getN_usuario());
            ps.setString(2, mc.getTipoDeTransacao());
            ps.setDouble(3, mc.getValorSacarDepositarTransferir());
            ps.execute();
            System.out.println("Inserido transacao");
            
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }

    }

    public void updateConta(ModelConta mc) throws Exception {
        this.conexao.conectar();

        PreparedStatement ps = this.conexao.con.prepareStatement("UPDATE cliente SET SALDO= ? WHERE ID_USUARIO = ?");
        ps.setDouble(1, mc.getSaldo());
        ps.setInt(2, mc.getN_usuario());
        inserirTransacao(mc);
        ps.executeUpdate();
        conexao.desconectar();
    }

    public void transferir(ModelConta mc) throws Exception {
        this.conexao.conectar();
        Double SaldoContaTransfere;
        //diminui
        try {
            SaldoContaTransfere = mc.getSaldoBusca() + mc.getValorTransfere();
            PreparedStatement ps = this.conexao.con.prepareStatement("UPDATE cliente SET SALDO= ? WHERE ID_USUARIO = ?");

            ps.setDouble(1, mc.getSaldo());
            ps.setInt(2, mc.getN_usuario());
            ps.executeUpdate();
            this.conexao.desconectar();
            //transfere
            this.conexao.conectar();
            PreparedStatement prepare = this.conexao.con.prepareStatement("UPDATE cliente SET SALDO= ? WHERE ID_USUARIO = ?");
            prepare.setDouble(1, SaldoContaTransfere);
            prepare.setInt(2, mc.getBusca_usuario());
            prepare.executeUpdate();
            inserirTransacao(mc);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
        this.conexao.desconectar();
    }
}
