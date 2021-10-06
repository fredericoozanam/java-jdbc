import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 20; i ++) {
			connectionFactory.RecuperarConexao();
			System.out.println("Conexao de número: " + i);
		}
	}

}
