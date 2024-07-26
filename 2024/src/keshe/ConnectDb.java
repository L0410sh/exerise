package keshe;

import java.sql.*;
public class ConnectDb {
	public static Connection connect()
	{
		 Connection con=null;
	      Statement sql; 
	      ResultSet rs;
	      try{ Class.forName("com.mysql.cj.jdbc.Driver"); 
	      }
	      catch(Exception e){
	    	  
	      }
	      
	     String uri = "jdbc:mysql://localhost:3306/lsh?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	  	

	      String user ="root";
	      String password ="root";
	      
	      
	      try{  
	         con = DriverManager.getConnection(uri,user,password); //���Ӵ���
	      }
	      catch(SQLException e){ }
	      return con;
	}

}
