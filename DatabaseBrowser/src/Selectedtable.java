import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Selectedtable extends JFrame implements ActionListener
{
	
	JTable table;
	JScrollPane jp;
	DefaultTableModel dtm;
	JButton back;
	public void gui3(JTable table) 
	{
        super.setTitle(" TABLE ");
		super.setBounds(200, 50, 1000, 900);
		super.setResizable(false);
		
		table = new JTable(dtm);
		jp=new JScrollPane(table);
		jp.setBounds(100, 100, 900, 700);
		table.setRowHeight(50);
		super.add(jp);
		
		back=new JButton("Back");
		back.setBounds(850,615,100,40);
		super.add(back);
		back.addActionListener(this);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" ,"root", "98765");
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from " + Selecteddb.table);
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] columnname = new String[rsmd.getColumnCount()];
			
			c.close();

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
@Override
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == back)
		{
			Selecteddb st = new Selecteddb();
			String dbname = null;
			st.gui2(dbname);
			super.dispose();
			
		}
	}
}
