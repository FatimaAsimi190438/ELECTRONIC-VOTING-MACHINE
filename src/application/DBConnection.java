package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.TextField;

public class DBConnection {
	{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("\nDriver Loaded Successfully!");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/evm","root","tiger1234"); 
		System.out.println("Connection Established!");
		String sql = "INSERT into Candidates (C_Name,C_Age,C_Nationality,C_phoneNo) VALUES (?, ?, ?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
			
	}catch(Exception e)
	{
		System.out.println(e);
	}
}

	public boolean validate(TextField name, TextField age, TextField nationality, TextField phoneno) {
		// TODO Auto-generated method stub
		return false;
	}
}

