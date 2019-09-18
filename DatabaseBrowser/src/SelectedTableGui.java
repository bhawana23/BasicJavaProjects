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

public class SelectedTableGui extends JFrame implements ActionListener
{
	
	JTable table;
	DefaultTableModel dtm;
	JScrollPane jp;
	JButton back;
	public void initGUI() 
	{
        super.setTitle("GUI ");
		super.setBounds(200, 50, 1000, 900);
		super.setResizable(false);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + DatabaseBrowser.database,
					"root", "98765");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("select * from " + Selecteddb.table);
			ResultSetMetaData rsmd = r.getMetaData();
			String[] colname = new String[rsmd.getColumnCount()];
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				colname[i - 1] = rsmd.getColumnName(i);
			dtm = new DefaultTableModel(colname, 0);
			while (r.next())
			{
				for (int i = 1; i <= rsmd.getColumnCount(); i++)
					colname[i - 1] = r.getString(i);
				dtm.addRow(colname);
			}
			c.close();

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		table = new JTable(dtm);
		jp=new JScrollPane(table);
		jp.setBounds(100, 100, 900, 700);
		table.setRowHeight(50);
		super.add(jp);
		
		back=new JButton("Back");
		back.setBounds(850,615,100,40);
		super.add(back);
		
		back.addActionListener(this);

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
			st.gui2();
			super.dispose();
			
		}
	}
}
