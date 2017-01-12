package javaassign;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
public class StartProgram extends JFrame implements ActionListener {	
	private JButton jbtForkids =new JButton("For Kids");
	private JButton jbtForoffice =new JButton("For Office");
	private JButton jbtPostcard =new JButton("Post Card");
	private JButton jbtExit =new JButton("Exit");
	private JButton jborder =new JButton("Order");
	public StartProgram(){	
		Container cont=getContentPane();
		cont.setLayout(new BorderLayout());
		cont.setBackground(Color.cyan);
		ImageIcon restpic = new ImageIcon("p.jpg");
	   	JLabel jlbl = new JLabel(restpic,SwingConstants.CENTER);

		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1,5,10,10));
		p1.setBackground(Color.white);
		p1.add(jlbl, BorderLayout.NORTH);
		
		cont.add(p1,BorderLayout.NORTH);			
		
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout());
		p2.setBackground(Color.white);
		p2.add(jbtForkids);
		p2.add(jbtForoffice);
		p2.add(jbtPostcard);
		p2.add(jborder);
		//p2.add(rd);
		p2.add(jbtExit);
		
		Border lineborder = new LineBorder(Color.GREEN,2);
		cont.add(p2,BorderLayout.SOUTH);	
		
		jbtForkids.addActionListener(this);
		jbtForoffice.addActionListener(this);
		jbtPostcard.addActionListener(this);
		jbtExit.addActionListener(this);
		jborder.addActionListener(this);
			}

	public void actionPerformed(ActionEvent e){
	 	if (e.getSource() == jbtForkids){
		ForKids frame = new ForKids();
		frame.setTitle("For Kids Stationary");
		frame.setSize(750,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	 	}
	 	
	 	if (e.getSource() == jbtForoffice){
		foroffice frame = new foroffice();
		frame.setTitle("For Office Stationary");
		frame.setSize(550,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dispose();
	 	}
	 	if (e.getSource() == jbtPostcard){
		PostCard frame = new PostCard();
		frame.setTitle("Post Card Stationary");
		frame.setSize(550,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.dispose();
	 	}
		if(e.getSource()==jborder){
		orderstationary frame = new orderstationary();
		frame.pack();
		frame.setTitle("Ordering System");
		frame.setSize(1100, 650);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		this.dispose();
		}
		//if(e.getSource()==rd){
		//readdata1 frame = new readdata1();
		
		//}
		
	 	
	 	
		if (e.getSource() == jbtExit){
	 			int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to exit?","Exit ",JOptionPane.YES_NO_OPTION);
		 	
		 		if(confirm==0)
		 			System.exit(0);
	 	}
	}
	public static void main(String[] args)
	{
		StartProgram frame = new StartProgram();
		frame.setTitle("Welcome to Stationary Ordering System");
		frame.setSize(600,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		
	}
}
