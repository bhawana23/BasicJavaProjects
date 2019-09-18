import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DatabaseMetaData;

import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DatabaseBrowser extends JFrame implements ActionListener  
{
   public static String database;
	// public static String database;
	JButton refreshlist,proceed;
    JComboBox combo;
	private Window frame;
	JPanel panel = new JPanel();

    public void gui1()
    {
    	super.setTitle("DATABASEBROWSER");
		super.setBounds(50,20,600,500);
		super.setResizable(!false);
	
    	String[] browser = {};
    	combo = new JComboBox(browser);
    	combo.setBounds(190, 30, 240, 25);
		super.add(combo);
		
		refreshlist = new JButton(" REFRESH LIST ");
		refreshlist.setBounds(210,150,140,25);
		super.add(refreshlist);
		refreshlist.addActionListener(this);
		
		proceed = new JButton(" PROCEED ");
		proceed.setBounds(210,200,140,25);
		super.add(proceed);
		proceed.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		//System.out.print("hi");
		if(ae.getSource() == refreshlist)
	    {
			//delete all the values of combobox
			int itemCount = combo.getItemCount();
		    for(int i = 0;i < itemCount;i++)
		    {
		        combo.removeItemAt(0);
		    }
			try
			{
			    String mysqlcommand = "show databases";
	            Class.forName("com.mysql.jdbc.Driver");
	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "98765");
	        	Statement stmt = con.createStatement();
	        	ResultSet rs = stmt.executeQuery(mysqlcommand);
	        	
	        	while(rs.next()) 
	        	{
	        		combo.addItem(rs.getString("Database"));
	        		System.out.println(rs.getString("Database"));
	        	}
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		if(ae.getSource() == proceed)
		{
			 //create a variable and get the selectected databse name from combobox
			 String  dbname = combo.getSelectedItem().toString();
			 System.out.println(dbname);
			 Selecteddb sdb = new Selecteddb();
			 sdb.gui2(dbname); //pass this vsaribale to function gui2
			 // + edit gui2 function to get string variable as parameter in Selecteddb class
			 
		}
	}
	
}

