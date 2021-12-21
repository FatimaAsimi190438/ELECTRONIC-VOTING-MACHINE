package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class SampleController {
    @FXML
    private Button submit;
    @FXML
    private Button admin;
    @FXML
    private Button user;
    @FXML
    private TextField uname;
    @FXML
    private Button conti;
    @FXML
    private TextField upass;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;   
    @FXML
    private CheckBox PPP;
    @FXML
    private TextField age;
    @FXML
    private TextField name;
    @FXML
    private TextField nationality;
    @FXML
    private TextField phoneno;
    @FXML
    private Button save;
    @FXML
    private TextField lname;
    @FXML
    private TextField pname;
    @FXML
    private Button processinformation;
    @FXML
    private TextField symbol;
    @FXML
    private Button help;
    @FXML
    private Button vote;
    @FXML
    private Button backmenu;
    @FXML
    private Button plmn;
    @FXML
    private Button ppp;
    @FXML
    private Button pti;
    @FXML
    private TextField vcnic;
    @FXML
    private TextField vname;
    @FXML
    private Button done;
    @FXML
    private Button voter;
    @FXML
    void adminbutton(ActionEvent event) throws IOException {
    	Main m1=new Main();
    	m1.screen("Admin.fxml");
    }
    @FXML
     void userbutton(ActionEvent event) throws IOException {
    	Main m11=new Main();
    	m11.screen("UserMenu.fxml");
        }
    private void message(String title, String content) {
   	 Alert alert = new Alert(AlertType.INFORMATION);
   	 alert.setTitle(title);
			alert.setHeaderText(null);
			alert.setContentText(content);
        alert.showAndWait();
    }
    @FXML
      void submitbutton(ActionEvent event) throws IOException {
    	Main m =new Main();
    	m.screen("Adminmenu.fxml"); 
    	Window owner = submit.getScene().getWindow();

         System.out.println(uname.getText());
         System.out.println(upass.getText());
         
 		if(uname.getText().equals("Fatima") && upass.getText().equals("1234"))
 		{
 		   m.screen("Promptmessage.fxml");
 		}
 		if (uname.getText().isEmpty() && upass.getText().isEmpty())
 		{
 			String title ="No Username And Password!!";
 			String content ="Enter Username And Password!!";
            message(title,content); 			
 		}
 		if (uname.getText().isEmpty()) {
 			String title ="No Username !!";
 			String content ="Enter Username !!";
            message(title,content);
             return;
         }
         if (upass.getText().isEmpty()) {
        	 String title ="No Password!!";
  			String content ="EnterPassword!!";
             message(title,content);
         }
         String username = uname.getText();
         String password =upass.getText();
         }
    
	private void showAlert1(AlertType error, Window owner, String string, String string2) {
		// TODO Auto-generated method stub
	}
    @FXML
    void continuebutton(ActionEvent event) throws IOException {
    	Main m2=new Main();
    	m2.screen("Adminmenu.fxml");
    } 
    @FXML
    void candidatebutton(ActionEvent event) throws IOException {
    	Main m3=new Main();
    	m3.screen("candidate.fxml");
    }
    @FXML
    void displaybutton(ActionEvent event) {
    }
    @FXML
    void partbutton(ActionEvent event) throws IOException {
    	Main m5=new Main();
    	m5.screen("PoliticalParty.fxml");
    }
    @FXML
    void percentagebutton(ActionEvent event) {
    }
    @FXML
    void cage(ActionEvent event) {
    }
    @FXML
    void cname(ActionEvent event) {
    }
    @FXML
    void cnationality(ActionEvent event) {
    }
    @FXML
    void number(ActionEvent event) {
    }
    @FXML
    void savebutton(ActionEvent event) {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("\nDriver Loaded Successfully!");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/evm","root","tiger1234"); 
    		System.out.println("Connection Established!");
    		String sql = "INSERT into Candidates (C_Name,C_Age,C_Nationality,C_phoneNo) VALUES (?, ?, ?,?)";
    		PreparedStatement statement = con.prepareStatement(sql);
    		statement.setString(1,name.getText());
    		statement.setString(2,age.getText());
    		statement.setString(3,nationality.getText());
    		statement.setString(4,phoneno.getText());
    		
    		int rowsInserted = statement.executeUpdate();
    		if (rowsInserted > 0)
    		{
    			System.out.println("\nAccount Inserted Successfully !!!");
    		}
    		
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from Candidates");
    		
    		while (rs.next())
    		{
    			String name = rs.getString(1);
    			String age = rs.getString(2);
    			String nationality = rs.getString(3);
    			String phoneno = rs.getString(3);
    			System.out.println("\n" + name + "  " + age + "  " + nationality +" "+ phoneno);
    		}
    		
    		con.close();
    			
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	Main m4 =new Main();
    	Window owner = save.getScene().getWindow();
        System.out.println(name.getText());
        System.out.println(age.getText());
        System.out.println(nationality.getText());
        //System.out.println(age.getText());
        System.out.println(phoneno.getText());         
        if (name.getText().isEmpty() || age.getText().isEmpty() || nationality.getText().isEmpty() || phoneno.getText().isEmpty() )
		{
        	String title ="Error";
			String content ="Enter Correct Information!!";
			message(title,content);
		}
        String Name = name.getText();
        String Age = age.getText();
        String Nationality = nationality.getText();
        String PhoneNo = phoneno.getText();
        boolean flag;
			flag =validate(name,age,nationality,phoneno);
		if (!flag) {
            infoBox("Please enter full information", null, "Failed");
        }
    }
	private boolean validate(TextField name2, TextField age2, TextField nationality2, TextField phoneno2) {
		// TODO Auto-generated method stub
		return false;
	}
	private void infoBox(String string, Object object, String string2) {
		
	}
	@FXML
    void pinformationbutton(ActionEvent event) {
		try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("\nDriver Loaded Successfully!");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/evm","root","tiger1234"); 
    		System.out.println("Connection Established!");
    		String sql = "INSERT into politicalParty (PartyName,LeaderName) VALUES (?, ?)";
    		PreparedStatement statement = con.prepareStatement(sql);
    		statement.setString(1,pname.getText());
    		statement.setString(2,lname.getText());
    		int rowsInserted = statement.executeUpdate();
    		if (rowsInserted > 0)
    		{
    			System.out.println("\nParty Inserted Successfully !!!");
    		}
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from politicalParty");
    		while (rs.next())
    		{
    			String pname = rs.getString(1);
    			String lname = rs.getString(2);
    			System.out.println("\n" + pname + "  " + lname);
    		}
    		con.close();    			
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
         System.out.println(pname.getText());
        System.out.println(lname.getText());               
        if (pname.getText().isEmpty() || lname.getText().isEmpty())
		{
        	String title ="Error";
			String content ="Enter Correct Information!!";
			message(title,content);
		}
        boolean flag;
			flag =validate(pname,lname);
        if (!flag) {
            infoBox("Please enter full information", null, "Failed");
        } 
    }
    private boolean validate(TextField pname2, TextField lname2) {
		// TODO Auto-generated method stub
		return false;
	}
    @FXML
    void pnamet(ActionEvent event) {
    }
    @FXML
    void symbolt(ActionEvent event) {
    }
    @FXML
    void lnamet(ActionEvent event) {
    }
    @FXML
    void helpbutton(ActionEvent event) throws IOException {
    	Main m9=new Main();
    	m9.screen("Help.fxml");
    }
    @FXML
    void voteutton(ActionEvent event) throws IOException {
    	Main m12=new Main();
    	m12.screen("VoteScreen.fxml");
    }
    @FXML
    void backmenubutton(ActionEvent event) throws IOException {
    	Main m10=new Main();
    	m10.screen("UserMenu.fxml");
    }
    @FXML
    void PPPbutton(ActionEvent event) {
    }
    @FXML
    void donebutton(ActionEvent event) {    	
        if (vname.getText().isEmpty() || vcnic.getText().isEmpty())
		{
        	String title ="Error";
			String content ="Enter Complete Information!!";
			message(title,content);
		}
        else {

        	String title ="VOTED";
    		String content ="VOTE CASTED SUCCESSFULLY";
            message(title,content);
        }
        try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("\nDriver Loaded Successfully!");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/evm","root","tiger1234"); 
    		System.out.println("Connection Established!");
    		String sql = "INSERT into Voter (VoterName,VoterCNIC) VALUES (?, ?)";
    		PreparedStatement statement = con.prepareStatement(sql);
    		statement.setString(1,vname.getText());
    		statement.setString(2,vcnic.getText());
    		int rowsInserted = statement.executeUpdate();
    		if (rowsInserted > 0)
    		{
    			System.out.println("\nVoter Inserted Successfully !!!");
    		}
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from Voter");
    		while (rs.next())
    		{
    			String voname = rs.getString(1);
    			String vocnic = rs.getString(2);
    			System.out.println("\n" + voname + "  " + vocnic);
    		}
    		con.close();    			
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
         System.out.println(vname.getText());
        System.out.println(vcnic.getText());               
        
    }
    @FXML
    void plmnbutton(ActionEvent event) {
    }
    @FXML
    void ptibutton(ActionEvent event) {
    }
    @FXML
    void votercnic(ActionEvent event) {
    }
    @FXML
    void votername(ActionEvent event) {
    }
    @FXML
    void voterbutton(ActionEvent event) {
    	/*public boolean RetreiveVoterCredentials(Voter vobj, String CNIC) throws SQLException
    	{
    		System.out.println("DB here !!!");
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("Select * from Voter");
    		
    		while(rs.next())
    		{
    			vobj.setVoterName(rs.getString(1));
    			vobj.setVoterCNIC(rs.getString(2));
    			System.out.println(rs.getString(1) + "  " + rs.getString(2));
    		}
    		if (vobj.ValidateVoter(x, y))
    		{
    			return true; 
    		}
    		else
    			return false;
    	
    }*/
}
}


