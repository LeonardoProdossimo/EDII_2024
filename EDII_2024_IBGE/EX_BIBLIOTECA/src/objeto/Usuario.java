package objeto;

import objetoServicos.UsuarioDAO;

public class Usuario {
	
	public static String INSERT = "INSERT";
	public static String SELECT = "SELECT";
	public static String UPDATE = "UPDATE";
	public static String DELETE = "DELETE";
	
	private int idusuario;
	private String nome;
	private String email;
	
	public Usuario(){
		
	}

	public void insereUsuario(Usuario usuario) {
		new UsuarioDAO(usuario, Usuario.INSERT);
	}
	
	public void buscaUsuario(Usuario usuario) {
		new UsuarioDAO(usuario, Usuario.SELECT);
	}
	
	public void removeUsuario(Usuario usuario) {
		new UsuarioDAO(usuario, Usuario.DELETE);
	}

	public void listaUsuarios(){
	}
	
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
