package objeto;


public class Livro {
	private static int id = 0;
	private String titulo;
	private String autor;
	private String anoPublicacao;
	
	public Livro(){
		setId(id += 1);
		titulo = "";
		autor = "";
		anoPublicacao = "";
	}

	public int getId() {
		return id;
	}

	public static void setId(int id) {
		Livro.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo.toUpperCase();
		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public String toString() {
		return "Id: "+this.getId() 
		+ " |Titulo: "+this.getTitulo()
		+" |Autor: "+this.getAutor()
		+" |Ano: "+this.getAnoPublicacao();
	}
}
