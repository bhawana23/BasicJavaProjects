
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Bankgui1 extends JFrame implements ActionListener 
{
	JButton s,n,k,h,bb;
	JLabel l;
	
	public void initGUI1()
	{
		super.setTitle("Selectgui");
		super.setBounds(50,20,1500,800);
		super.setResizable(!false);
		super.setBounds(100, 100, 600, 500);
		super.setResizable(false);
		super.setBackground(Color.green);
		
		l = new JLabel();
		l.setText("SELECT BANK");
		l.setBounds(220,30,200,40);
		Font f = new Font("ITALIC",Font.BOLD,20);
		l.setFont(f);
		super.add(l);
        l.setForeground(Color.blue);
		l.setBackground(Color.black);
		
		s = new JButton("SBI");
		s.setBounds(100, 130, 60, 25);
		super.add(s);
		Font f1 = new Font("ITALIC",Font.BOLD,12);
		s.setFont(f1);
		super.add(s);
		s.setForeground(Color.blue);
	    s.setBackground(Color.white);

		k = new JButton("KOTAK");
		k.setBounds(180, 130, 90, 25);
		super.add(k);
		Font f2 = new Font("ITALIC",Font.BOLD,14);
		k.setFont(f2);
		k.setForeground(Color.red);
	    k.setBackground(Color.white);
		

		h = new JButton("HDFC");
		h.setBounds(290, 130, 80, 25);
		super.add(h);
		Font f3 = new Font("ITALIC",Font.BOLD,14);
		h.setFont(f3);
		h.setForeground(Color.white);
	    h.setBackground(Color.blue);
		

		n = new JButton("NAINITAL");
		n.setBounds(390, 130, 100, 25);
		super.add(n);
		Font f4 = new Font("ITALIC",Font.BOLD,14);
		n.setFont(f4);
		n.setForeground(Color.red);
	    n.setBackground(Color.white);
		
		bb = new JButton("Back");
		bb.setBounds(100, 400, 80, 25);
		super.add(bb);
		bb.setForeground(Color.darkGray);
	    bb.setBackground(Color.white);
		
	    s.addActionListener(this);
		k.addActionListener(this);
		h.addActionListener(this);
		n.addActionListener(this);
		bb.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//	@Override
//	public void actionPerformed(ActionEvent ae) 
//	{
//		try 
//		{
//			if(ae.getSource() == s || ae.getSource() == n || ae.getSource() == h || ae.getSource() == k)
//			{   
//				//ae ---> jb ---> bankname
//				super.dispose();
//				CreatebankAccount ui1 = new CreatebankAccount();
//				JButton jb = (JButton)ae.getSource();    //type casting the ActionEvent object into JButton object
//				String bankName = jb.getText();
//				//System.out.print(bankName);
//				ui1.initGUI2(bankName);
//			}
//			
//			if(ae.getSource() == bb)
//			{
//		        super.dispose();
//	     	    Bankgui ui2 = new Bankgui();
//			    ui2.initGUI();
//			}		
//		} 
//		catch (Exception e) 
//		{
//			System.out.println("error "+e);
//		}
//	}
//}
