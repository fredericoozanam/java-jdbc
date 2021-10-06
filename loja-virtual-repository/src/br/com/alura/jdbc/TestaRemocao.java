package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.RecuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();

		// getUpdateCount() retorna uma variavel dizendo quantas linhas foram
		// modificadas
		Integer linhasModificadas = stm.getUpdateCount();

		System.out.println("Quantidade de linhas que foram modificada: " + linhasModificadas);
	}
}
