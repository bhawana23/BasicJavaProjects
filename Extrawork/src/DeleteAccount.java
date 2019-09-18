import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteAccount extends JFrame implements ActionListener
{
	JButton dp,sb,cl,bb;
	JLabel an,ld,selectbank;
	JTextField tcn,tan;
	JComboBox combobox;
	
	public void initGUI7()
	{
		super.setTitle("DeactivateAccount");
		super.setBounds(50,30,900,800);
		super.setResizable(!false);
		ld=new JLabel();
		ld.setText("DEACTIVATE ACCOUNT");
		ld.setBounds(340,20,360,200);
		Font f=new Font("ariel",Font.BOLD,28);
		ld.setFont(f);
		super.add(ld);
		ld.setForeground(Color.blue);
	
		an=new JLabel();
		an.setText("Account Number");
		an.setBounds(110, 165, 150, 25);
		Font f1=new Font("ariel",Font.BOLD,16);
     	an.setFont(f1);
		super.add(an);
		tan=new JTextField();
		tan.setBounds(340, 165, 300, 25);
		super.add(tan);
		an.setForeground(Color.black);
	    an.setBackground(Color.white);
	    
	    selectbank = new JLabel();
		selectbank.setText("SELECT   BANK");
		selectbank.setBounds(110,180,180,60);
		Font f0 = new Font("ariel",Font.BOLD,16);
		selectbank.setFont(f0);
		selectbank.setForeground(Color.black);
		super.add(selectbank);

		String[] bank = {"","SBI","KOTAK","HDFC","NAINITAL"};
		combobox = new JComboBox(bank);
		combobox.setBounds(340, 200, 240, 25);
		super.add(combobox);
		

		sb = new JButton("Submit");
		sb.setBounds(350, 330, 90, 25);
		super.add(sb);
		sb.setForeground(Color.darkGray);
	    sb.setBackground(Color.white);
		sb.addActionListener(this); 
		
		cl = new JButton("clear");
		cl.setBounds(450,330, 80, 25);
		super.add(cl);
		cl.setForeground(Color.darkGray);
	    cl.setBackground(Color.white);
		cl.addActionListener(this);

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
		} 
		catch (Exception e) 
		{
			System.out.println("error "+e);
		}
	}
}