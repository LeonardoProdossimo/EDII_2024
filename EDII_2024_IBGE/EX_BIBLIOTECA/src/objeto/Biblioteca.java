package objeto;

import objetoServicos.LivroDAO;

public class Biblioteca {
	
	
	public Biblioteca() {
		
	}
	
	public void insereLivro(Livro livro) {
		new LivroDAO(livro, Livro.INSERT);
	}
	
	public void buscaLivro(Livro livro) {
		new LivroDAO(livro, Livro.SELECT);
	}
	
	public void removeLivro(Livro livro) {
		new LivroDAO(livro, Livro.DELETE);
	}
}

