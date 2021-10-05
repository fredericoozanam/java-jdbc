import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.RecuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		//Interface ResultSet pega o conteudo da tabela
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getNString("NOME");
			System.out.println(nome);
			String descricao = rst.getNString("DESCRICAO");
			System.out.println(descricao);
		}
		
		connection.close();
	}

}
