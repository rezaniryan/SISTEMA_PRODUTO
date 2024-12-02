import package montadora;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	
public class Conexao {

	    // Método para obter a conexão com o banco de dados
	    public static Connection getConexao() {
	        try {
	            // Carrega o driver JDBC do MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // URL de conexão com o banco de dados
	            String url = "jdbc:mysql://localhost:3306/produto"; // Troque pelo seu banco
	            String usuario = "root"; // Troque pelo seu usuário
	            String senha = ""; // Troque pela sua senha

	            // Estabelecendo a conexão
	            return DriverManager.getConnection(url, usuario, senha);
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    // Método para inserir dados no banco de dados
	    public static void inserirDados(String sql) {
	        try (Connection conn = getConexao(); 
	             Statement stmt = conn.createStatement()) {

	            // Executa o comando SQL
	            stmt.executeUpdate(sql);
	            System.out.println("Dados inseridos com sucesso!");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


}
