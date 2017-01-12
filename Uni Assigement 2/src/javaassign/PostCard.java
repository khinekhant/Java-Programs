package javaassign;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class PostCard extends JFrame implements ActionListener
{
	private JButton jbtChoc1=new JButton("Mother's Day Card");
	private JButton jbtChoc2=new JButton("Father's Day Card");
	private JButton jbtChoc3=new JButton("Christmas Card");
	private JButton jbtChoc4=new JButton("Valentine's Day Card");
	private JButton jbtChoc5=new JButton("Thank you Card");
	private JButton jbtChoc6=new JButton("Wedding Card");
	private JButton jbtBack=new JButton("Back");
	private JButton jbtExit=new JButton("Exit");
	private JLabel LabelChoice=new JLabel("Have a look please for post card stationary....");
	private ImageIcon Image1=new ImageIcon("postcard/mother'sday.jpg");
	private ImageIcon Image2=new ImageIcon("postcard/father'sday.jpg");
	private ImageIcon Image3=new ImageIcon("postcard/christmas.jpg");
	private ImageIcon Image4=new ImageIcon("postcard/valentine'sday.jpg");
	private ImageIcon Image5=new ImageIcon("postcard/thankyou.jpg");
	private ImageIcon Image6=new ImageIcon("postcard/wedding.jpg");
	public PostCard()
	{
		Container cont=getContentPane();
		cont.setLayout(new BorderLayout(5,5));;
		cont.setBackground(Color.white);
		
		cont.add(LabelChoice,BorderLayout.NORTH);	
		JPanel pA=new JPanel(new GridLayout(2,3,5,5));
		   jbtChoc1.setIcon(Image1);
		   pA.add(jbtChoc1);
		   jbtChoc1.setVerticalTextPosition(AbstractButton.BOTTOM);
			jbtChoc1.setHorizontalTextPosition(AbstractButton.CENTER);

		   jbtChoc2.setIcon(Image2);
		   pA.add(jbtChoc2);
		   jbtChoc2.setVerticalTextPosition(AbstractButton.BOTTOM);
			jbtChoc2.setHorizontalTextPosition(AbstractButton.CENTER);
			
		   jbtChoc3.setIcon(Image3);
		   pA.add(jbtChoc3);
		   jbtChoc3.setVerticalTextPosition(AbstractButton.BOTTOM);
			jbtChoc3.setHorizontalTextPosition(AbstractButton.CENTER);
			
		   jbtChoc4.setIcon(Image4);
		   pA.add(jbtChoc4);
		   jbtChoc4.setVerticalTextPosition(AbstractButton.BOTTOM);
			jbtChoc4.setHorizontalTextPosition(AbstractButton.CENTER);
			
		   jbtChoc5.setIcon(Image5);
		   pA.add(jbtChoc5);
		   jbtChoc5.setVerticalTextPosition(AbstractButton.BOTTOM);
			jbtChoc5.setHorizontalTextPosition(AbstractButton.CENTER);
			
		   jbtChoc6.setIcon(Image6);
		   pA.add(jbtChoc6);
		   jbtChoc6.setVerticalTextPosition(AbstractButton.BOTTOM);
			jbtChoc6.setHorizontalTextPosition(AbstractButton.CENTER);
         cont.add(pA,BorderLayout.CENTER);
         
        JPanel pB=new JPanel(new FlowLayout(FlowLayout.CENTER));
        pB.setBackground(Color.YELLOW);
		pB.add(jbtBack);
		pB.add(jbtExit);
		cont.add(pB,BorderLayout.SOUTH);
	
		jbtChoc1.addActionListener(this);
		jbtChoc2.addActionListener(this);
		jbtChoc3.addActionListener(this);
		jbtChoc4.addActionListener(this);
		jbtChoc5.addActionListener(this);
		jbtChoc6.addActionListener(this);
		jbtBack.addActionListener(this);
		jbtExit.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent e)
	{
		
	if(e.getSource() ==jbtBack)
		{
		StartProgram frame = new StartProgram();
		frame.setTitle("Stationary Ordering System");
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		this.dispose();
		}
		if(e.getSource() ==jbtExit)
		{
			int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to exit?","Exit ",JOptionPane.YES_NO_OPTION);
		 	
		 		if(confirm==0)
		 			System.exit(0);
		}	
	}
	public static void main(String[] args)
	{
		PostCard frame = new PostCard();
		frame.setTitle("Post Card Stationary");
		frame.setSize(550,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}


