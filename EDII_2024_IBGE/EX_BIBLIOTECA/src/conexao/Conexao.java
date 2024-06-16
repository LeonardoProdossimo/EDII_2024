package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	private Connection con;
	private PreparedStatement p;
	private String url = "jdbc:mariadb://localhost:3306/projeto_alysson_biblioteca";
	private String user = "root";
	private String pwd = "Prodossimo1";
	
	public Conexao() {
		try {
			con = DriverManager.getConnection(url, user, pwd);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void desconecta() {
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String executaInsert(String sql, String[] param) {
	    try {
	        p = getCon().prepareStatement(sql);
	        for (int i = 0; i < param.length; i++) {
	        	p.setString(i+1, param[i]);
	        }
	        p.executeUpdate();
	    } catch (SQLException e) {
	        return "ERRO: " + e.getMessage();
	    }
		return "OK";
	}
	
	public String executaDelete(String sql, String[] param) {
	    try {
	        p = getCon().prepareStatement(sql);
	        for (int i = 0; i < param.length; i++) {
	        	p.setString(i+1, param[i]);
	        }
	        p.executeUpdate();
	    } catch (SQLException e) {
	        return "ERRO: " + e.getMessage();
	    }
		return "OK";
	}
	
	public ResultSet executaQuery(String sql, String[] param) {
		try {
			p = getCon().prepareStatement(sql);
			if(param != null ) {
				for (int i = 0; i < param.length; i++) {
		        	p.setString(i+1, param[i]);
		        }
			}
			return p.executeQuery();
		} catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public Connection getCon() {
		return con;
	}
}
