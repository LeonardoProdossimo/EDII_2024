package objetoServicos;

import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import objeto.Usuario;

public class UsuarioDAO {
	Conexao con;
	private Usuario usuario;
	private String[] param;
	
	public UsuarioDAO(Usuario usuario, String metodo) {
		this.usuario = usuario;
		con = new Conexao();
		if(metodo.equals(Usuario.INSERT)) {
			insereUsuario();
		}else if(metodo.equals(Usuario.SELECT)) {
			buscaUsuario(usuario.getIdusuario());
		}else if(metodo.equals(Usuario.UPDATE)) {
			
		}else if(metodo.equals(Usuario.DELETE)) {
			removeUsuario();
		}
		con.desconecta();
	}
	
	public void insereUsuario() {
		String sql = "INSERT INTO usuario (nome, email) "
				+ "	VALUES (?, ?)";
		param = new String[2];
		param[0] = usuario.getNome();
		param[1] = usuario.getEmail();;
		
		String retorno = con.executaInsert(sql, param);
		if(retorno.equalsIgnoreCase("OK")) {
			System.out.println("->->->->-> Inserido com sucesso! <-<-<-<-<-");
		}else {
			System.out.println("->->->->-> Falha ao inserir registro! <-<-<-<-<-");
		}
	}
	
	public void buscaUsuario(int id) {
		try {
			String sql = "SELECT idusuario, nome, email FROM usuario ";
			if(usuario.getIdusuario() > 0){
				sql += "WHERE idusuario = ? ;";
				param = new String[1];
				param[0] = String.valueOf(usuario.getIdusuario());
			}
			ResultSet res = con.executaQuery(sql, param);
			 if (!res.next()) {
		            System.out.println("->->->->-> Usuário(s) não encontrado(s)! <-<-<-<-<-");
		        } else {
		            do {
		                System.out.println("ID: " + res.getInt("idusuario") + 
		                                   " | Nome: " + res.getString("nome") + 
		                                   " | E-Mail: " + res.getString("email") + "\r\n");
		            } while (res.next());
		        }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("->->->->-> Falha ao buscar usuários! <-<-<-<-<-");
		}
	}
	
	private void removeUsuario() {
		String sql = "DELETE FROM usuario WHERE idusuario = ? ;";
		param = new String[1];
		param[0] = String.valueOf(usuario.getIdusuario());
		
		String retorno = con.executaDelete(sql, param);
		if(retorno.equalsIgnoreCase("OK")) {
			System.out.println("->->->->-> Deletado com sucesso! <-<-<-<-<-");
		}else {
			System.out.println("->->->->-> Falha ao deletar registro! <-<-<-<-<-");
		}
	}
}
