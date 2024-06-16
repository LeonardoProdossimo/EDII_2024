package objetoServicos;

import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import objeto.Livro;

public class LivroDAO {
	Conexao con;
	private Livro livro;
	private String[] param;
	
	public LivroDAO(Livro livro, String metodo) {
		this.livro = livro;
		con = new Conexao();
		if(metodo.equals(Livro.INSERT)) {
			insereLivro();
		}else if(metodo.equals(Livro.SELECT)) {
			buscaLivro(livro.getIdlivro());
		}else if(metodo.equals(Livro.UPDATE)) {
			
		}else if(metodo.equals(Livro.DELETE)) {
			removeLivro();
		}
		con.desconecta();
	}
	
	private void insereLivro() {
		String sql = "INSERT INTO livro (titulo, autor, ano) "
				+ "	VALUES (?, ?, ?);";
		param = new String[3];
		param[0] = livro.getTitulo();
		param[1] = livro.getAutor();
		param[2] = livro.getAnoPublicacao();

		String retorno = con.executaInsert(sql, param);
		if(retorno.equalsIgnoreCase("OK")) {
			System.out.println("->->->->-> Inserido com sucesso! <-<-<-<-<-");
		}else {
			System.out.println("->->->->-> Falha ao inserir registro! <-<-<-<-<-");
		}
	}
	
	private void buscaLivro(int id) {
		try {
			String sql = "SELECT idlivro, titulo, autor, ano FROM livro ";
			if(livro.getIdlivro() > 0){
				sql += "WHERE idlivro = ? ;";
				param = new String[1];
				param[0] = String.valueOf(livro.getIdlivro());
			}
			ResultSet res = con.executaQuery(sql, param);
			if(!res.next()) {
				System.out.println("->->->->-> Livro(s) não enontrado(s)! <-<-<-<-<-");
			}
			do {
				System.out.println("ID: "+res.getInt("idlivro") + 
								"| Titulo: "+res.getString("titulo") +
								"| Autor: " + res.getString("autor") +
								"| Ano: "+res.getString("ano")+"\r\n");
			}
			while(res.next());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("->->->->-> Falha ao buscar livros! <-<-<-<-<-");
		}
	}
	
	private void removeLivro() {
		String sql = "DELETE FROM livro WHERE idlivro = ? ;";
		param = new String[1];
		param[0] = String.valueOf(livro.getIdlivro());
		
		String retorno = con.executaDelete(sql, param);
		if(retorno.equalsIgnoreCase("OK")) {
			System.out.println("->->->->-> Deletado com sucesso! <-<-<-<-<-");
		}else {
			System.out.println("->->->->-> Falha ao deletar registro! <-<-<-<-<-");
		}
	}
}
