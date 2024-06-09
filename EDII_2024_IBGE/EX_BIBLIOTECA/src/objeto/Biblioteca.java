package objeto;

import java.util.LinkedList;

public class Biblioteca {
	
	private LinkedList<Livro> listaLivros;
	
	public Biblioteca() {
		listaLivros = new LinkedList<Livro>();
	}
	
	public void insereLivro(Livro livro) {
		listaLivros.add(livro);
		System.out.println("->->->->-> Inserido com sucesso! <-<-<-<-<-");
	}
	
	public void buscasLivro(String id) {
		String retorno = "";
		for(Livro l : listaLivros) {
			if(String.valueOf(l.getId()).equalsIgnoreCase(id)) {
				retorno =  l.toString();
			}
		}
		if(retorno.isEmpty()) {
			System.out.println("->->->->-> Livro não encontrado! <-<-<-<-<-");
		}else {
			System.out.println(retorno);
		}
	}
	
	public void removeLivro(String id) {
		listaLivros.forEach(l -> {
			if(String.valueOf(l.getId()).equalsIgnoreCase(id)) {
				listaLivros.remove(l);
				System.out.println("->->->->-> Exluido com sucesso! <-<-<-<-<-");
			}else {
				System.out.println("->->->->-> Livro não encontrado! <-<-<-<-<-");
			}
		});
	}

	public void listaLivros(){
		if(listaLivros.size() == 0) {
			System.out.println("->->->->-> Não há livros nessa biblioteca! <-<-<-<-<-");
		}else {
			for(Livro l : listaLivros) {
				System.out.println(l.toString());
			}
		}
	}
}

