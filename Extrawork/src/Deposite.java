//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//public class Deposite extends JFrame implements ActionListener
//{
//	JButton dp,sb,cl,bb;
//	JLabel an,cn,ld;
//	JTextField tcn,tan;
//	
//	public void initGUI3()
//	{
//		super.setTitle("Deposit");
//		super.setBounds(50,20,1000,800);
//		super.setResizable(!false);
//		ld=new JLabel();
//		ld.setText("DEPOSITE");
//		ld.setBounds(370,20,170,60);
//		Font f=new Font("ariel",Font.BOLD,28);
//		ld.setFont(f);
//		super.add(ld);
//		ld.setForeground(Color.blue);
//	
//		cn=new JLabel();
//		cn.setText("Account Number");
//		cn.setBounds(110, 165, 150, 25);
//		Font f1=new Font("ariel",Font.BOLD,16);
//     	cn.setFont(f1);
//		super.add(cn);
//		tcn=new JTextField();
//		tcn.setBounds(340, 165, 300, 25);
//		super.add(tcn);
//		cn.setForeground(Color.darkGray);
//	    cn.setBackground(Color.white);
//		
//		an=new JLabel();
//		an.setText("Amount");
//		an.setBounds(110, 220, 160, 25);
//		Font f2=new Font("ariel",Font.BOLD,16);
//		an.setFont(f2);
//		super.add(an);
//		tan=new JTextField();
//		tan.setBounds(340, 220, 300, 25);
//		an.setForeground(Color.darkGray);
//	    an.setBackground(Color.white);
//		
//		sb = new JButton("Submit");
//		sb.setBounds(400, 400, 90, 25);
//		super.add(sb);
//		sb.setForeground(Color.darkGray);
//	    sb.setBackground(Color.white);
//		sb.addActionListener(this); 
//		
//		cl = new JButton("clear");
//		cl.setBounds(495, 400, 80, 25);
//		super.add(cl);
//		cl.setForeground(Color.darkGray);
//	    cl.setBackground(Color.white);
//		cl.addActionListener(this);
//
//		bb = new JButton("Back");
//		bb.setBounds(100, 600, 80, 25);
//		super.add(bb);
//		bb.setForeground(Color.darkGray);
//	    bb.setBackground(Color.white);
//		bb.addActionListener(this);
//		
//		super.add(tan);
//		super.setLayout(null);
//		super.setVisible(true);
//		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//	
////
////	public static void main(String[] args) 
////	{
////		Deposite sg = new Deposite();
////       sg.initGUI3();
////	}
//	public void actionPerformed(ActionEvent ae) 
//	{
//		try 
//		{
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