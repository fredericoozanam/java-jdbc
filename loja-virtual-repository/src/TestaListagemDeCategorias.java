import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import dao.CategoriaDAO;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try (Connection connection = new ConnectionFactory().RecuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());

				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}

			});
		}
	}

}