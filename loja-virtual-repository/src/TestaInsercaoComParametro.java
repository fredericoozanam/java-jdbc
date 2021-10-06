import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.RecuperarConexao();
		connection.setAutoCommit(false);

		// PreparedStatemt que cuida da inser��o. SetString passa os parametros, index e
		// parametro
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		adicionarVariavel("SmartTV", "50 polegadas", stm);
		adicionarVariavel("Home Theater", "Onkyo 5.1 canais", stm);

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		/*
		 * if (nome.equals("Home Theater")) { throw new
		 * RuntimeException("N�o foi poss�vel adicionar o produto"); }
		 */
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		rst.close();
	}

}
