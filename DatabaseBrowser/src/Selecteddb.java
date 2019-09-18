import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.directory.SearchResult;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Selecteddb extends JFrame implements ActionListener  
{
	JButton proceed,backb;
    JComboBox combo;
    JLabel selecteddb;
    String dbname;
   // String browser;
    public void gui2(String dbname)
    {
    	this.dbname = dbname;
    	super.setTitle(" SELECTEDDB ");
		super.setBounds(50,20,600,500);
		super.setResizable(!false);
		

		selecteddb = new JLabel();
		selecteddb.setText(" SELECTED DB :");
		selecteddb.setBounds(200,5,200,100);
		Font f=new Font("ariel",Font.BOLD,22);
		selecteddb.setFont(f);
		super.add( selecteddb);
		selecteddb.setForeground(Color.blue);
	
    	String[] browser = {};
    	combo = new JComboBox(browser);
    	combo.setBounds(210, 80, 240, 25);
		super.add(combo);
		
		backb = new JButton("Back");
		backb.setBounds(100,400,80,25);
		super.add(backb);
		backb.addActionListener(this);
	
		proceed = new JButton(" PROCEED ");
		proceed.setBounds(260,150,140,25);
		super.add(proceed);
		proceed.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try
		{
		    String s1 = "use "+ dbname;
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "98765");
        	Statement stmt = con.createStatement();
        	stmt.executeQuery(s1);
        	
        	String mysqlcommand2 = "show tables";
            Class.forName("com.mysql.jdbc.Driver");
        	ResultSet rs = stmt.executeQuery("Show tables");
        	while(rs.next()) 
            {
        		combo.addItem(rs.getString("Tables_in_"+dbname));
            }
            
		}
		
		catch(Exception e1)	
		{
			System.out.println(e1.toString());
		}
		
		
    }
    
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		    if(e.getSource() == backb)
		    {
			    super.dispose();
			    DatabaseBrowser ui1 = new DatabaseBrowser();
			    ui1.gui1();
		    }
	
		    if (e.getSource() == proceed)
		    {
		    	String table = combo.getSelectedItem().toString();
		    	Vector columnNames = new Vector();
		    	Vector data = new Vector();
		    	JPanel panel = new JPanel();
		    	try
		    	{ 
		    	    Class.forName("com.mysql.jdbc.Driver"); 
		    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname, "root", "98765");
		    	    String sql = "select * from "+table;
		    	    System.out.println(sql);
		    	    Statement st = con.createStatement();
		    	    ResultSet rs = st.executeQuery(sql);
		    	    
		    	    
		    	    ResultSetMetaData metaData = rs.getMetaData();   
		    	    int columns = metaData.getColumnCount();
		    	    for (int i = 1; i <= columns; i++) 
		    	    {
		                columnNames.addElement(metaData.getColumnName(i));
		                System.out.println(columnNames.get(i-1));
		            }
		    	    
		    	    
		    	    while(rs.next()) 
		    	    {
		                Vector row = new Vector(columns);
		                for (int i = 1; i <= columns; i++) 
		                {
		                   // row.addElement(((ResultSet) metaData).getObject(i));
		                    row.addElement(rs.getObject(i));
		                }    
						data.addElement(row);
						System.out.println(data);
		            }
		    	    
		    	    //Jtable jt = new Jtable(coloumns_name, 2D data matrix)
		    	    JTable jt = new JTable(data, columnNames);
		    	    TableColumn column;
		            for (int i = 0; i < jt.getColumnCount(); i++)
		            {
		                column = jt.getColumnModel().getColumn(i);
		                column.setMaxWidth(250);
		            }
		            JScrollPane scrollPane = new JScrollPane(jt);        
		            panel.add(scrollPane);               
		            JFrame frame = new JFrame();
		            frame.add(panel);         //adding panel to the frame
		            frame.setSize(600, 400); //setting frame size
		            frame.setVisible(true);  //setting visibility true    
		    	}
		    	catch(Exception ex) 
		    	{
		    		System.out.print(ex.toString());
		    	}
		    }
	}
}
	
	



