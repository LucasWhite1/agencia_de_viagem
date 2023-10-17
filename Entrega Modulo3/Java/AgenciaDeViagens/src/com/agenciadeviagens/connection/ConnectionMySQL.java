package com.agenciadeviagens.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	    // URL de conexão com o banco de dados
	    private static final String URL = "jdbc:mysql://localhost:3306/bdagencia";
	    private static final String USUARIO = "root";
	    private static final String SENHA = "123321";
	    
	    public static Connection createConnectionMySQL() throws Exception{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
	    	
	    	return connection;
	    	
	    }
	    
	    public static void main (String[] args) throws Exception {
	    	// Recupera uma conexão com o banco de dados
	    	Connection con = createConnectionMySQL();
	    	
	    	// testa conexao
	    	if (con != null) {
	    		System.out.println(con + "\n\n Conexao obtida com sucesso");
	    	con.close();
	    	}
	    }
	    

}
