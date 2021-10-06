package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.RecuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		
		//Interface ResultSet pega o conteudo da tabela
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getNString("NOME");
			String descricao = rst.getNString("DESCRICAO");
			
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		
		connection.close();
	}

}
