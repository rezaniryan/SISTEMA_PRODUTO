package produto;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Estabelece a conexão com o banco de dados
        Connection conn = Conexao.getConexao();
        
        if (conn != null) {
            // Cria os objetos dos produtos
            ProdutoAlimenticio pa = new ProdutoAlimenticio("Frango", 7.00, 9.00, "2025-12-31", "Carboidratos");
            ProdutoVestuario pv = new ProdutoVestuario("Camiseta", 10.00, 15.00, "G", "Azul", "TackTell");

            try {
                // Salva os produtos no banco de dados
                pa.salvar(conn);
                pv.salvar(conn);
                
                // Exibe os lucros calculados
                System.out.println("Lucro do Produto Alimentício: " + pa.calcularLucro());
                System.out.println("Lucro do Produto de Vestuário: " + pv.calcularLucro());
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close(); // Fechar a conexão
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Erro ao conectar com o banco de dados.");
        }
    }
}
