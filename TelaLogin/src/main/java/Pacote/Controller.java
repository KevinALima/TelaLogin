package Pacote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Controller {
    //Variáveis
    Connection conexao;
    
    //Métodos Públicos
    public ResultSet Login(Usuario usuario) {
       conexao = new Conexao().getConnection();
       try {
           String sql = "select * from usuario where email = ? and senha = ?";
           PreparedStatement preparaConexao = conexao.prepareStatement(sql);
           preparaConexao.setString(1, usuario.getEmail());
           preparaConexao.setString(2, usuario.getSenha());
           System.out.println(sql);
           ResultSet resultado = preparaConexao.executeQuery();
           return resultado;
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "Controller Login: " + erro);
           return null;
       }
    }
    
    public void Cadastro(Usuario usuario) {
       PreparedStatement preparaConexao;
       try {
           conexao = new Conexao().getConnection();
           String sql = "insert into usuario values ( ? , ? , ? )";
           preparaConexao = conexao.prepareStatement(sql);
           preparaConexao.setString(1, usuario.getNome());
           preparaConexao.setString(2, usuario.getEmail());
           preparaConexao.setString(3, usuario.getSenha());
           System.out.println(sql);
           preparaConexao.execute();
           preparaConexao.close();
           JOptionPane.showMessageDialog(null, "Cadastro concluído");
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "Controller Cadastro: " + erro);
       }
    }
}
