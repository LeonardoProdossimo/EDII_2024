package objeto;


public class Livro {
	public static String INSERT = "INSERT";
	public static String SELECT = "SELECT";
	public static String UPDATE = "UPDATE";
	public static String DELETE = "DELETE";
	
	private int idlivro;
	private String titulo;
	private String autor;
	private String anoPublicacao;
	
	public Livro(){
		idlivro = 0;
		titulo = "";
		autor = "";
		anoPublicacao = "";
	}

	public int getIdlivro() {
		return idlivro;
	}

	public void setIdlivro(int idlivro) {
		this.idlivro = idlivro;
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
}
