import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bankgui extends JFrame implements ActionListener  
{
	JButton oa,dp,wthdrw,cb,fundt,da;
	JLabel lb;
	public void initGUI()
	{
		super.setBounds(100, 100, 600, 500);
		super.setResizable(false);
		
		lb=new JLabel();
		lb.setText("BANKING");
		lb.setBounds(200,10,130,60);
		Font f=new Font("ariel",Font.BOLD,28);
		lb.setFont(f);
		super.add(lb);
		lb.setForeground(Color.blue);
		//l.setBackground(Color.black);
		
		oa = new JButton("open account");
		oa.setBounds(200, 110, 130, 25);
		super.add(oa);
		oa.addActionListener(this);
		oa.setForeground(Color.darkGray);
	    oa.setBackground(Color.white);
		
		dp = new JButton("Deposit");
		dp.setBounds(200, 150, 130, 25);
		super.add(dp);
		dp.setForeground(Color.darkGray);
	    dp.setBackground(Color.white);
		dp.addActionListener(this);
		
		wthdrw = new JButton("Withdraw");
		wthdrw.setBounds(200, 190, 130, 25);
		super.add(wthdrw);
		wthdrw.setForeground(Color.darkGray);
	    wthdrw.setBackground(Color.white);
		wthdrw.addActionListener(this);
		
		cb = new JButton("Check Balance");
		cb.setBounds(200, 230, 130, 25);
		super.add(cb);
		cb.setForeground(Color.darkGray);
	    cb.setBackground(Color.white);
		cb.addActionListener(this);
		
		fundt = new JButton("Fund Transfer");
		fundt.setBounds(200, 270, 130, 25);
		super.add(fundt);
		fundt.setForeground(Color.darkGray);
	    fundt.setBackground(Color.white);
		fundt.addActionListener(this);
		
		da = new JButton("Deactivate Account");
		da.setBounds(190, 310, 170, 25);
		super.add(da);
		da.setForeground(Color.darkGray);
	    da.setBackground(Color.white);
		da.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		try 
		{
			if(ae.getSource() == oa)
			{
		        super.dispose();
	     	    CreatebankAccount ui2 = new  CreatebankAccount();
			    ui2.initGUI2();
			}
			if(ae.getSource() == dp)
			{
		        super.dispose();
	     	    Deposit ui2 = new Deposit();
			    ui2.initGUI3();
			}
			if(ae.getSource() == cb)
			{
		        super.dispose();
	     	    CheckBalance ui2 = new CheckBalance();
			    ui2.initGUI4();
			}
			
			if(ae.getSource() == fundt)
			{
		        super.dispose();
	     	    FundTransfer ui2 = new  FundTransfer ();
			    ui2.initGUI5();
			}
			if(ae.getSource() == wthdrw)
			{
		        super.dispose();
	     	    Withdraw ui2 = new   Withdraw ();
			    ui2.initGUI6();
			}
			if(ae.getSource() == da)
			{
		        super.dispose();
	     	    DeleteAccount ui2 = new DeleteAccount ();
			    ui2.initGUI7();
			}
		} 
		catch (Exception e) 
		{
			System.out.println("hello error "+e);
		}
	}
}