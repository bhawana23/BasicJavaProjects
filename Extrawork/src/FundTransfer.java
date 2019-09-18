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

public class FundTransfer extends JFrame implements ActionListener
{
	JButton dp,submit,clear,bb;
	JLabel san,ran,ft,selectedbank,selectbank,selectbank1,selectedbank1,amount;
	JTextField tsan,tran,tselectedbank,tselectbank,tselectbank1,tselectedbank1,tamount;
	JComboBox combobox,combobox1;
	String[] bank = {};
	
	public void executeUpdate(String sqlcommand) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","98765");
			Statement st = co.createStatement();
			st.executeUpdate(sqlcommand);
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet executeCommand(String sqlcommand)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","98765");
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery(sqlcommand);
			return rs;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public void initGUI5()
	{
		super.setTitle("FundTransfer");
		super.setBounds(50,30,1200,1000);
		super.setResizable(!false);
		ft = new JLabel();
		ft.setText("FUND TRANSFER");
		ft.setBounds(370,20,300,60);
		Font f = new Font("ariel",Font.BOLD,28);
		ft.setFont(f);
		super.add(ft);
		ft.setForeground(Color.blue);
	
		String[] bank = {"","SBI","KOTAK","HDFC","NAINITAL"};
		combobox = new JComboBox(bank);
		combobox.setBounds(680, 150, 200, 25);
		super.add(combobox);
		
		selectbank = new JLabel();
		selectbank.setText("SELECT   BANK");
		selectbank.setBounds(680,100,180,60);
		Font f0 = new Font("ariel",Font.BOLD,16);
		selectbank.setFont(f0);
		selectbank.setForeground(Color.black);
		super.add(selectbank);
		
		selectedbank = new JLabel();
		selectedbank.setText("Selected bank");
		selectedbank.setBounds(680, 190, 150, 25);
		Font f8 = new Font("ariel",Font.BOLD,16);
		selectedbank.setFont(f8);
		super.add(selectedbank);
		tselectedbank = new JTextField();
		tselectedbank.setBounds(790, 190, 100, 25);
		super.add(this.tselectedbank);
	    String str = (String)combobox.getSelectedItem();
		tselectedbank.setText(str);
		selectedbank.setForeground(Color.darkGray);
		selectedbank.setBackground(Color.white);
		
		
	    san = new JLabel();
		san.setText("sender's account number");
		san.setBounds(110, 165, 200, 25);
		Font f1 = new Font("ariel",Font.BOLD,16);
     	san.setFont(f1);
		super.add(san);
		tsan = new JTextField();
		tsan.setBounds(340, 165, 300, 25);
		super.add(tsan);
		san.setForeground(Color.darkGray);
	    san.setBackground(Color.white);
	   
	    ran = new JLabel();
	    ran.setText("receiver's account number");
	    ran.setBounds(110, 280, 260, 25);
		Font f3 = new Font("ariel",Font.BOLD,16);
		ran.setFont(f1);
		super.add(ran);
		tran = new JTextField();
		tran.setBounds(340, 280, 300, 25);
		super.add(tran);
		ran.setForeground(Color.darkGray);
		ran.setBackground(Color.white);
		tran.addActionListener(this);
		
		amount = new JLabel();
		amount.setText(" Amount ");
		amount.setBounds(110, 330, 260, 25);
		Font f4 = new Font("ariel",Font.BOLD,16);
		amount.setFont(f4);
		super.add(amount);
		tamount = new JTextField();
		tamount.setBounds(340, 330, 300, 25);
		super.add(tamount);
		amount.setForeground(Color.darkGray);
		amount.setBackground(Color.white);
		
		String[] bank1 = {"","SBI","KOTAK","HDFC","NAINITAL"};
		combobox1 = new JComboBox(bank);
		combobox1.setBounds(680, 270, 200, 25);
		super.add(combobox1);
		selectbank1 = new JLabel();
		selectbank1.setText("SELECT   BANK");
		selectbank1.setBounds(680,230,180,60);
		Font f2 = new Font("ariel",Font.BOLD,16);
		selectbank1.setFont(f2);
		selectbank1.setForeground(Color.black);
		super.add(selectbank1);
		
		selectedbank1 = new JLabel();
		selectedbank1.setText("Selected bank");
		selectedbank1.setBounds(680, 310, 150, 25);
		Font f9 = new Font("ariel",Font.BOLD,16);
		selectedbank1.setFont(f9);
		super.add(selectedbank1);
		tselectedbank1 = new JTextField();
		tselectedbank1.setBounds(790, 310, 100, 25);
		super.add(this.tselectedbank1);
	    //String str = (String)combobox.getSelectedItem();
		//tselectedbank1.setText(str);
		selectedbank1.setForeground(Color.darkGray);
		selectedbank1.setBackground(Color.white);
		

		submit = new JButton("Submit");
		submit.setBounds(350, 400, 90, 25);
		super.add(submit);
		submit.setForeground(Color.darkGray);
		submit.setBackground(Color.white);
		submit.addActionListener(this); 
		
		clear = new JButton("clear");
		clear.setBounds(450,400, 80, 25);
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
		tselectedbank1.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		//String str = (String)combobox1.getSelectedItem();
		//tselectedbank1.setText(str);
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
				 tsan.setText("");
				 tran.setText("");    
				 tsan.setEditable(true);
				 tran.setEditable(true);
				 tamount.setText("");
			}
			if(ae.getSource() == submit)
		    { 
				String bankName = combobox.getSelectedItem().toString();
				String amount = tamount.getText();
			    String accnum = tsan.getText();
			    if(accnum.isEmpty())
				{
			        JOptionPane.showMessageDialog(this, " Enter sender account number!");
					return;
				}
			    String accnum1 = tran.getText();
			    if(accnum1.isEmpty())
				{
			        JOptionPane.showMessageDialog(this, " Enter receiver account number!");
					return;
				}
			    String bankName1 = combobox.getSelectedItem().toString();
				if(tamount.getText().isEmpty())
				{
			        JOptionPane.showMessageDialog(this, " Enter amount !");
					return;
				}
				if(bankName1.isEmpty())
				{
					JOptionPane.showMessageDialog(this, " choose sender bank !");
					return;
				}
				String bankName2 = combobox1.getSelectedItem().toString();
				if(tamount.getText().isEmpty())
				{
			        JOptionPane.showMessageDialog(this, " Enter amount !");
					return;
				}
				if(bankName2.isEmpty())
				{
					JOptionPane.showMessageDialog(this, " choose receiver bank !");
					return;
				}
				
			    float amount1 = Float.parseFloat(tamount.getText());
			
				String sqlcommand1 = "select * from "
				    		+ bankName1
				    		+ " where accountno = "
				    		+ accnum;
				System.out.println(sqlcommand1);
				 
				ResultSet rs = executeCommand(sqlcommand1);
		        float sendersum = 0 ;  
			    while(rs.next())
			    {
			    	sendersum = rs.getFloat("ammount");
			        System.out.println(sendersum);
				}
			    
			    if(amount1 > sendersum)
			    {
			    	JOptionPane.showMessageDialog(this,"insuuficient amount !")	;
			    	return;
			    }
			    
			    float finalsum = (float) (sendersum - amount1);
			    float limit = 0;
			    switch(bankName)
			    {
			       case "SBI"  : limit = 1000;
			       	             break;
			       case "KOTAK" : limit = 1200;
			                      break;
			       case "HDFC" : limit = 2000;
			                     break;
			       case "NAINITAL" : limit = 5000;
			       					 break; 
			    }    
			    
			    if(finalsum <= limit)
			    {
			    	JOptionPane.showMessageDialog(this,"insuuficient amount !")	;
			    	return;
			    }
				
	    		//update bankName set ammount = '4' where accountno = 85";
	            String sqlcommand2 = "update "
				        		+ bankName1 
			             		+ " set ammount = '"
				        		+ finalsum
				        		+ "' where accountno = "
				        		+ accnum ;
                //execute the new query2
				System.out.println(sqlcommand2);
				executeUpdate(sqlcommand2);
		    
			    String sqlcommand3 = "select * from "
			    		      + bankName2
			    		      + " where accountno = "
			    		      + accnum1;
			    System.out.println(sqlcommand3);
		        ResultSet rs1 = executeCommand(sqlcommand3);
			  
	            float recsum = 0 ;  
		        while(rs1.next())
		        {
		        	recsum = rs1.getFloat("ammount");
		        	System.out.println(recsum);
		        }
			  
			    float finalsum1 = (float) (recsum + amount1);
    		    //update bankName set ammount = '4' where accountno = 85";
                String sqlcommand4 = "update "
			        			+ bankName2 
			        			+ " set ammount = '"
			        			+ finalsum1
			        			+ "' where accountno = "
			        			+ accnum1 ;

			    //execute the new query2
                
                System.out.println(sqlcommand4);
                executeUpdate(sqlcommand4);
                JOptionPane.showMessageDialog(this," done re");
				return;
                }
	       	
			
		} 
		catch (Exception e) 
		{
			System.out.println("error "+e);
		}
	}
}