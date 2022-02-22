package Pacote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    //Variáveis
    public Connection getConnection(){
        Connection conexao = null;
        try {
            String url = "jdbc:mysql://localhost:3306/cadastro?user=root&password=";
            conexao = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Conexão " + erro.getMessage());
        }
        return conexao;
    }
}
