import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;
import dao.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Produto comoda = new Produto("Hack", "Hack horizontal");

		try (Connection connection = new ConnectionFactory().RecuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			// Lista = persistenciaProduto.listar();
		}
	}

}
