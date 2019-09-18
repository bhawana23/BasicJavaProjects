import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckBalance extends JFrame implements ActionListener
{
	JButton dp,submit,clear,bb;
	JLabel accountnum,ld,selectbank;
	JTextField tcn,taccountnum;
	JComboBox combobox;
	public void initGUI4()
	{
		String[] bank = {"","SBI","KOTAK","HDFC","NAINITAL"};
		combobox = new JComboBox(bank);
		combobox.setBounds(650, 50, 240, 25);
		super.add(combobox);
		
		super.setTitle("CheckBalance");
		super.setBounds(50,30,1000,900);
		super.setResizable(!false);

		selectbank = new JLabel();
		selectbank.setText("SELECT   BANK");
		selectbank.setBounds(650,5,180,60);
		Font f0 = new Font("ariel",Font.BOLD,16);
		selectbank.setFont(f0);
		selectbank.setForeground(Color.black);
		super.add(selectbank);
		
		ld=new JLabel();
		ld.setText("CHECK BALANCE");
		ld.setBounds(370,20,300,60);
		Font f=new Font("ariel",Font.BOLD,28);
		ld.setFont(f);
		super.add(ld);
		ld.setForeground(Color.blue);
	
		accountnum = new JLabel();
		accountnum.setText("Account Number");
		accountnum.setBounds(110, 165, 150, 25);
		Font f1=new Font("ariel",Font.BOLD,16);
		accountnum.setFont(f1);
		super.add(accountnum);
		taccountnum=new JTextField();
		taccountnum.setBounds(340, 165, 300, 25);
		super.add(taccountnum);
		accountnum.setForeground(Color.darkGray);
		accountnum.setBackground(Color.white);
		taccountnum.setEditable(true);

	    submit = new JButton("Submit");
	    submit.setBounds(350, 330, 90, 25);
		super.add(submit);
		submit.setForeground(Color.darkGray);
		submit.setBackground(Color.white);
		submit.addActionListener(this); 
		
		clear = new JButton("clear");
		clear.setBounds(450,330, 80, 25);
		super.add(clear);
		clear.setForeground(Color.darkGray);
		clear.setBackground(Color.white);
		clear.addActionListener(this);

		bb = new JButton("Back");
		bb.setBounds(100, 600, 80, 25);
		super.add(bb);
		bb.setForeground(Color.darkGray);
	    bb.setBackground(Color.white);
		bb.addActionListener(this);
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) 
	{
	    try 
	    {
			if(ae.getSource() == bb)
			{
		        super.dispose();
	     	    Bankgui ui2 = new Bankgui();
			    ui2.initGUI();
			}	
			if(ae.getSource() == clear)
	        {
	            taccountnum.setText("");
	            taccountnum.setEditable(true);
	        }
			if(ae.getSource() == submit)
		    {
			    String accnum = taccountnum.getText();
			    if(accnum.isEmpty())
				{
			        JOptionPane.showMessageDialog(this, " Enter person account number!");
					return;
				}
			   // taccountnum.setEditable(false);
				String bankName = combobox.getSelectedItem().toString();
//				if(tamount.getText().isEmpty())
//				{
//			        JOptionPane.showMessageDialog(this, " Enter amount !");
//					return;
//				}
			//	float amount = Float.parseFloat(tamount.getText());
				String query3 = "select * from "
				    		+ bankName
				    		+ " where accountno = "
				    		+ accnum;
				System.out.println(query3);
			    Class.forName("com.mysql.cj.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","98765");
				Statement st = co.createStatement();
				ResultSet rs = st.executeQuery(query3);
				  
		        float oldsum = 0 ;  
			    while(rs.next())
			    {
				    oldsum = rs.getFloat("ammount");
			        System.out.println(oldsum);
				 }
	    		        //update bankName set ammount = '4' where accountno = 85";
	            String query4 = "update "
				        		+ bankName 
			             		+ " set ammount = '"
				        		+ oldsum
				        		+ "' where accountno = "
				        		+ accnum ;

				    //execute the new query2
	            
				System.out.println(query4);
				Statement st1 = co.createStatement();
			    st.executeUpdate(query4);
				JOptionPane.showMessageDialog(this, "your balance is !"+oldsum);
				return;
		    }			
		} 
		catch (Exception e) 
		{
			System.out.println("error "+e);
		}
	}
}