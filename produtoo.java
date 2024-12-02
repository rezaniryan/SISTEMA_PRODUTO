package produto;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	// classe base do produto
	abstract class Produto {
	    protected String nome;
	    protected double precoCusto;
	    protected double precoVenda;

	    // construtor da base
	    public Produto(String nome, double precoCusto, double precoVenda) {
	        this.nome = nome;
	        this.precoCusto = precoCusto;
	        this.precoVenda = precoVenda;
	    }

	    // calcula o lucro 
	    public double calcularLucro() {
	        return precoVenda - precoCusto;
	    }

	    // metodos abstratos para manipulacao do banco de dados
	    public abstract void salvar(Connection conn) throws SQLException;
	    public abstract void deletar(Connection conn) throws SQLException;
	    public abstract void atualizar(Connection conn) throws SQLException;
	}

	// classe de herda o produto
	class ProdutoAlimenticio extends Produto {
	    private String dataValidade;
	    private String informacoesNutricionais;

	    // construtor da case produtoalimenticio
	    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String informacoesNutricionais) {
	        super(nome, precoCusto, precoVenda);
	        this.dataValidade = dataValidade;
	        this.informacoesNutricionais = informacoesNutricionais;
	    }

	    // salva o produto no banco de dados
	    @Override
	    public void salvar(Connection conn) throws SQLException {
	        String sql = "INSERT INTO produto_alimenticio (nome, preco_custo, preco_venda, data_validade, informacoes_nutricionais) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, nome);
	            stmt.setDouble(2, precoCusto);
	            stmt.setDouble(3, precoVenda);
	            stmt.setString(4, dataValidade);
	            stmt.setString(5, informacoesNutricionais);
	            stmt.executeUpdate();
	        }
	    }

	    // deleta o produto do banco de dados 
	    @Override
	    public void deletar(Connection conn) throws SQLException {
	        String sql = "DELETE FROM produto_alimenticio WHERE nome = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, nome);
	            stmt.executeUpdate();
	        }
	    }

	    // atualiza o produto no banco de dados 
	    @Override
	    public void atualizar(Connection conn) throws SQLException {
	        String sql = "UPDATE produto_alimenticio SET preco_custo = ?, preco_venda = ?, data_validade = ?, informacoes_nutricionais = ? WHERE nome = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setDouble(1, precoCusto);
	            stmt.setDouble(2, precoVenda);
	            stmt.setString(3, dataValidade);
	            stmt.setString(4, informacoesNutricionais);
	            stmt.setString(5, nome);
	            stmt.executeUpdate();
	        }
	    }
	}

	// classe produtovestuario que herda o produto
	class ProdutoVestuario extends Produto {
	    private String tamanho;
	    private String cor;
	    private String material;

	    // classe construtora
	    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
	        super(nome, precoCusto, precoVenda);
	        this.tamanho = tamanho;
	        this.cor = cor;
	        this.material = material;
	    }

	    // salva o produto no banco de dados
	    @Override
	    public void salvar(Connection conn) throws SQLException {
	        String sql = "INSERT INTO produto_vestuario (nome, preco_custo, preco_venda, tamanho, cor, material) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, nome);
	            stmt.setDouble(2, precoCusto);
	            stmt.setDouble(3, precoVenda);
	            stmt.setString(4, tamanho);
	            stmt.setString(5, cor);
	            stmt.setString(6, material);
	            stmt.executeUpdate();
	        }
	    }

	    // deleta o banco de dados
	    @Override
	    public void deletar(Connection conn) throws SQLException {
	        String sql = "DELETE FROM produto_vestuario WHERE nome = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, nome);
	            stmt.executeUpdate();
	        }
	    }

	    // atualiza o banco
	    @Override
	    public void atualizar(Connection conn) throws SQLException {
	        String sql = "UPDATE produto_vestuario SET preco_custo = ?, preco_venda = ?, tamanho = ?, cor = ?, material = ? WHERE nome = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setDouble(1, precoCusto);
	            stmt.setDouble(2, precoVenda);
	            stmt.setString(3, tamanho);
	            stmt.setString(4, cor);
	            stmt.setString(5, material);
	            stmt.setString(6, nome);
	            stmt.executeUpdate();
	        }
	    }
	}



