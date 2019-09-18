import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainclassofBankgui
{
 
	public static void main(String[] args) 
	{
		Bankgui sg = new Bankgui();
        sg.initGUI();
	  
	
	{
		try
		{
		// load driver class in application
		    Class.forName("com.mysql.jdbc.Driver");
	
		// get object of connection
		   Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "98765");
		
		// get object of statement
		   Statement st = co.createStatement();
		//st.executeUpdate("create table sbi( Name varchar(100), Email varchar(100)PRIMARY KEY, phoneno varchar (40), amount int, accountno int)");
		//st.executeUpdate("create table kotak( Name varchar(100), Email varchar(100)PRIMARY KEY, phoneno varchar (40), amount int, accountno int)");
		//st.executeUpdate("create table HDFC( Name varchar(100), Email varchar(100)PRIMARY KEY, phoneno varchar (40), amount int, accountno int)");
		//st.executeUpdate("create table nainital( Name varchar(100), Email varchar(100)PRIMARY KEY, phoneno varchar (40), amount int, accountno int)");
		//st.executeUpdate("insert into sbi values('aman','20','mumbai')");
		   co.close();
		
		   System.out.println("OK");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
}
