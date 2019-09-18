import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener
{
	JButton deposit,submit,clear,backb;
	JLabel accountnum,amount,ld,selectbank,selectedbank;
	JTextField taccountnum,tamount,tselectedbank;
	JCheckBox checkbox;	
	JComboBox combobox;
	
	public void initGUI3()
	{
		
		String[] bank = {"","SBI","KOTAK","HDFC","NAINITAL"};
		combobox = new JComboBox(bank);
		combobox.setBounds(650, 50, 240, 25);
		super.add(combobox);
		selectbank = new JLabel();
		selectbank.setText("SELECT   BANK");
		selectbank.setBounds(650,5,180,60);
		Font f0 = new Font("ariel",Font.BOLD,16);
		selectbank.setFont(f0);
		selectbank.setForeground(Color.black);
		super.add(selectbank);
		//combobox.getSelectedItem();
		
		selectedbank = new JLabel();
		selectedbank.setText("Selected bank");
		selectedbank.setBounds(650, 80, 150, 25);
		Font f8 = new Font("ariel",Font.BOLD,16);
		selectedbank.setFont(f8);
		super.add(selectedbank);
		tselectedbank = new JTextField();
		//tselectedbank = new JTextField(combobox.getSelectedItem);
		tselectedbank.setBounds(760, 80, 100, 25);
		super.add(tselectedbank);
		//tselectedbank.setText(combobox.getSelectedItem(bank));
		
	    //String str = (String)combobox.getSelectedItem();
		//tselectedbank.setText(str);
		selectedbank.setForeground(Color.darkGray);
		selectedbank.setBackground(Color.white);
		
		super.setTitle("Deposit");
		super.setBounds(50,20,1000,800);
		super.setResizable(!false);
		ld = new JLabel();
		ld.setText("DEPOSIT");
		ld.setBounds(370,20,170,60);
		Font f = new Font("ariel",Font.BOLD,28);
		ld.setFont(f);
		super.add(ld);
		ld.setForeground(Color.blue);
	
		accountnum = new JLabel();
		accountnum.setText("Account Number");
		accountnum.setBounds(110, 165, 150, 25);
		Font f1 = new Font("ariel",Font.BOLD,16);
		accountnum.setFont(f1);
		super.add(accountnum);
		taccountnum = new JTextField();
		taccountnum.setBounds(340, 165, 300, 25);
		super.add(taccountnum);
		accountnum.setForeground(Color.darkGray);
		accountnum.setBackground(Color.white);
		taccountnum.setEditable(true);

		
		amount = new JLabel();
		amount.setText("Amount");
		amount.setBounds(110, 220, 160, 25);
		Font f2=new Font("ariel",Font.BOLD,16);
		amount.setFont(f2);
		super.add(amount);
		tamount = new JTextField();
		tamount.setBounds(340, 220, 300, 25);
		amount.setForeground(Color.darkGray);
		amount.setBackground(Color.white);
		super.add(tamount);
		tamount.setEditable(true);

		
	    submit = new JButton("Submit");
	    submit.setBounds(400, 400, 90, 25);
		super.add(submit);
		submit.setForeground(Color.darkGray);
		submit.setBackground(Color.white);
		submit.addActionListener(this); 
		
		clear = new JButton("clear");
		clear.setBounds(495, 400, 80, 25);
		super.add(clear);
		clear.setForeground(Color.darkGray);
		clear.setBackground(Color.white);
		clear.addActionListener(this);

		backb = new JButton("Back");
		backb.setBounds(100, 600, 80, 25);
		super.add(backb);
		backb.setForeground(Color.darkGray);
		backb.setBackground(Color.white);
		backb.addActionListener(this);
		
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		try 
		{
			if(ae.getSource() == backb)
			{
		        super.dispose();
	     	    Bankgui ui2 = new Bankgui();
			    ui2.initGUI();
			}
			if(ae.getSource() == clear)
			{
				 tamount.setText("");
				 taccountnum.setText("");    
				 tamount.setEditable(true);
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
			    String bankName = combobox.getSelectedItem().toString();
			    if(bankName.isEmpty())
			    {
			    	JOptionPane.showMessageDialog(this, " choose a bank!");
					return;
			    }
			    
			    String amount1 = tamount.getText();
				if(amount1.isEmpty())
				{
					JOptionPane.showMessageDialog(this, " Enter amount !");
					return;
				}
				
				float amount = Float.parseFloat(tamount.getText());
			    String query1 = "select * from "
			    		+ bankName
			    		+ " where accountno = "
			    		+ accnum;
			    System.out.println(query1);
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","98765");
			    Statement st = co.createStatement();
			    ResultSet rs = st.executeQuery(query1);
			    
			    //create a new float varaible say oldsum and initialise oldsum variable with the amount we get from rs
			    float oldsum = 0 ;  
			    while(rs.next())
			    {
			        oldsum = rs.getFloat("ammount");
			        System.out.println(oldsum);
			    }
			    //create a new float variable say finalsum and add amount and oldsum
			    
    		     
			         int finalsum = (int) (amount + oldsum);
			    //create another string avraible query2 which updates the database record with new amount
    		        //update bankName set ammount = '4' where accountno = 85";
                    String query2 = "update "
			        		+ bankName 
		             		+ " set ammount = '"
			        		+ finalsum
			        		+ "' where accountno = "
			        		+ accnum ;

			    //execute the new query2
			        System.out.println(query2);
			        Statement st1 = co.createStatement();
				    st.executeUpdate(query2);
				    
		 }
     } 
		catch (Exception e) 
		{
			System.out.println("error "+e);
		}
	}
}