import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
import javax.swing.JTextField;

	public  class CreatebankAccount extends JFrame implements ActionListener
	{
		JButton bca,bb,clear;
		JLabel name,emailid,phonenum,amount,accountnum,showbank,selectbank,selectedbank;
		JTextField tname,temailid,tphonenum,tamount,taccountnum,tselectedbank;
		String bankName;
		JComboBox combobox;
		
		public void initGUI2() 
		{   
			selectbank = new JLabel();
			selectbank.setText("SELECT  BANK");
			selectbank.setBounds(650,5,180,60);
			Font f10 = new Font("ariel",Font.BOLD,16);
			selectbank.setFont(f10);
			selectbank.setForeground(Color.black);
			super.add(selectbank);
			
			
			String[] bank = {"","SBI","KOTAK","HDFC","NAINITAL"};
			combobox = new JComboBox(bank);
			combobox.setBounds(650, 50, 240, 25);
			super.add(combobox);
		
			selectedbank=new JLabel();
			selectedbank.setText(" selected Bank :");
			selectedbank.setBounds(650, 100, 100, 40);
			super.add(selectedbank);
			tselectedbank=new JTextField();
			tselectedbank.setBounds(650, 130, 250, 40);
			super.add(tselectedbank);
			tselectedbank.setEditable(false);
			
			
			super.setTitle("CreateAccount");
			super.setBounds(50,20,1000,800);
			super.setResizable(!false);
		
			showbank = new JLabel();
			showbank.setText(this.bankName);
			showbank.setBounds(50, 40, 100, 25);
			Font f0 = new Font("ariel",Font.BOLD,16);
	     	showbank.setFont(f0);
	     	super.add(showbank);
			
	     	name = new JLabel();
	     	name.setText(" Name ");
	     	name.setBounds(110, 165, 150, 25);
			Font f1=new Font("ariel",Font.BOLD,16);
			name.setFont(f1);
			super.add(name);
			tname=new JTextField();
			tname.setBounds(340, 165, 300, 25);
			tname.setEditable(true);
			super.add(tname);
			
			emailid = new JLabel();
			emailid.setText(" Emailid ");
			emailid.setBounds(110, 200, 160, 25);
			Font f2=new Font("ariel",Font.BOLD,16);
			emailid.setFont(f2);
			super.add(emailid);
			temailid=new JTextField();
			temailid.setBounds(340, 200, 300, 25);
			super.add(temailid);
			temailid.setEditable(true);
			
			phonenum = new JLabel();
			phonenum.setText(" phone no.");
			phonenum.setBounds(110,240,160,25);
			Font f3 = new Font("ariel",Font.BOLD,16);
			phonenum.setFont(f3);
			super.add(phonenum);
			tphonenum = new JTextField();
			tphonenum.setBounds(340, 240, 300, 25);
			super.add(tphonenum);
			tphonenum.setEditable(true);
			
			amount = new JLabel();
			amount.setText(" Amount");
			amount.setBounds(110,280,160,25);
			Font f4 = new Font("ariel",Font.BOLD,16);
			amount.setFont(f4);
			super.add(amount);
			tamount = new JTextField();
			tamount.setBounds(340,280,300,25);
			tamount.setEditable(true);
			super.add(tamount);
			
			
			accountnum = new JLabel();
			accountnum.setText(" Account number");
			accountnum.setBounds(110,320,210,25);
			Font f5 = new Font("ariel",Font.BOLD,16);
			accountnum.setFont(f5);
			super.add(accountnum);
			taccountnum = new JTextField();
			taccountnum.setBounds(340,320,300,25);
			taccountnum.setEditable(true);
			super.add(taccountnum);
			//taccountnum.setText(String.valueOf(accountnum));	
			
			bca=new JButton("Create Account");
			bca.setBounds(740,400,130,25);
			super.add(bca);
			bca.addActionListener(this);
			
			clear=new JButton("Clear");
			clear.setBounds(740,450,100,25);
			super.add(clear);
			clear.addActionListener(this);
			
			bb=new JButton("Back");
			bb.setBounds(100,400,80,25);
			super.add(bb);
			bb.addActionListener(this);
			
			super.setLayout(null);
			super.setVisible(true);
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

		@Override
		public void actionPerformed(ActionEvent ae)
		{
			try 
			{
				
				if(ae.getSource() == bca)
				{			
					//initialising the values form the JFrame form
					int min = 100000;         //minimum account number
					int max = 200000;         //maximum account number
					String accountnum = String.valueOf(min +(int)(Math.random()*((max - min) + 1)));
					String amount = tamount.getText();
					String name = tname.getText();
					String emailid = temailid.getText();
					String phonenum = tphonenum.getText();
					String bankName = combobox.getSelectedItem().toString();
					
					//validating the data entered by user
					if(name.isEmpty())
					{
						JOptionPane.showMessageDialog(this, " Enter person Name!");
						return;
					}
					if(emailid.isEmpty())
					{
						JOptionPane.showMessageDialog(this, " Enter person Emailid!");
						return;
					}
					
					if(phonenum.isEmpty())
					{
						JOptionPane.showMessageDialog(this, " Enter person mobile no. !");
						return;
					}
					if(amount.isEmpty())
					{
						JOptionPane.showMessageDialog(this, " Enter amount !");
						return;
					}
					if(bankName.isEmpty())
				    {
				    	JOptionPane.showMessageDialog(this, " choose a bank!");
						return;
				    }
				
				    if((bankName.equals("SBI")) && (Integer.parseInt(amount))< 1000)
					{
							JOptionPane.showMessageDialog(this,"minimum amount needed is 1000 rs");
						    return;
					}
					else if((bankName.equals("KOTAK"))&&(Integer.parseInt(amount)<1200))
					{
							JOptionPane.showMessageDialog(this,"minimum amount needed is 1200 rs");
							return;
					}
					else if((bankName.equals("HDFC"))&&(Integer.parseInt(amount)<2000))
					{
							JOptionPane.showMessageDialog(this,"minimum amount needed is 2000 rs");
							return;
					}
					else if((bankName.equals("NAINITAL"))&&(Integer.parseInt(amount)<4000))
					{
							JOptionPane.showMessageDialog(this,"minimum amount needed is 5000 rs");
							return;
					}

					super.dispose();
					String sqlcommand = "insert into " + bankName  + " values('"
							+ name
							+ "','"
							+ emailid
							+ "','"
							+ phonenum
							+ "','"
							+ amount
							+ "','"
							+ accountnum
							+ "')";
				    System.out.println(sqlcommand);
				    runCommand(sqlcommand);
				    JOptionPane.showMessageDialog(this,"Account number " + String.valueOf(accountnum) + " created successfully!");
					
				    Bankgui ui1 = new Bankgui();
					ui1.initGUI();			    
				}	
				if(ae.getSource() == bb)
				{
					super.dispose();
					Bankgui ui1 = new Bankgui();
					ui1.initGUI();
				}
				if(ae.getSource() == clear)
				{
			         tname.setText("");
					 temailid.setText("");
					 tphonenum.setText("");
					 tamount.setText("");
					 taccountnum.setText("");
					 tname.setEditable(true);
					 temailid.setEditable(true);
					 tphonenum.setEditable(true);    
					 tamount.setEditable(true);
					 taccountnum.setEditable(true);
				}
			} 
			catch (Exception e) 
			{
				System.out.println("error "+e);
			}
			
		}
		
		
		public void runCommand(String sqlcommand)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","98765");
				Statement st = co.createStatement();
				st.executeUpdate(sqlcommand);
				co.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
