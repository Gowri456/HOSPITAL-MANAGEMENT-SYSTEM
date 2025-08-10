package com.learnJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String URL= "jdbc:mysql://localhost:3306/JDBCMySQL";
		String Username="root";
		String Password ="HappyLearning";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println("In catch" + e.getMessage());
		 }
		try {
		    con = DriverManager.getConnection(URL, Username, Password);
		    stmt = con.createStatement();

		    stmt.execute("insert into Students values (3, 'Sangeetha', 'IT')");
		    stmt.execute("insert into Students values (4, 'Saina Nehwal', 'ECE')");
		    stmt.execute("insert into Students values (5, 'Sania Mirza', 'EEE')");
		    stmt.execute("insert into Students values (6, 'Sindhu', 'Mech')");

		    System.out.println("Successfully inserted");

		    // rs.close();
		    stmt.close();
		    con.close();

		} catch (SQLException e) {
		    System.out.println("In catch " + e.getMessage());
		}
		finally
	    {if(con!=null)
	    {
	    	try {
	    		//rs.close();
	    		stmt.close();
	    		con.close();
	    		System.out.println("Terminated Successfully");
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Oops ! some serious issue");
	    	}
	    }
	    }

	}

}
