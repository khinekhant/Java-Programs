package javaassign;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;


public class orderstationary extends JFrame implements ActionListener
{
	JButton jbtk1, jbtk2, jbtk3, jbtk4, jbtk5, jbtk6;//Jbutton for kids 1-6
	JButton jbtO7, jbtO8, jbtO9, jbtO10, jbtO11, jbtO12;	//Jbutton for office 7-12
	JButton jbtP13,jbtP14,jbtP15,jbtP16,jbtP17,jbtP18;//Jbutton for Post card 13-18
	JButton jbBack,jbconfirmorder;
	JButton jbtPrice, jbtReset, jbtMore;
	
	JRadioButton jrbSmall, jrbLarge;
	JTextField jtfItem,jtfitems, jtfPrice, jtfSub, jtfTax, jtfTotal;
	JComboBox jcbquantity;
	JTextArea jtasummary,jtaItems;
	String[] items = new String[50];
	double[] cost = new double[50];
	double[] quantity = new double[50];
	double[] price2 = new double[50];
	int x=0, y=0, z=0;
	double subtotal=0, tax=0, total=0, price=0;
	String sizeConvert="";
	DecimalFormat df=new DecimalFormat("0.00");
 	//Main method
	public static void main(String[] args){
		orderstationary frame = new orderstationary();
		frame.pack();
		frame.setTitle("Ordering System");
		frame.setSize(1100, 650);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
 	
	//Constructor
	public orderstationary(){
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(3,1));
		cont.setBackground(Color.red);
	//-----------------------------------------------------------------------------------	
		JPanel p01 = new JPanel(new GridLayout(2,3));
		
		JPanel p001 = new JPanel(new GridLayout(2,3,1,1));
		p001.add(jbtk1 = new JButton("Activity Books : RM3.00"));
		p001.add(jbtk2 = new JButton("Name Poems : RM4.00"));
		p001.add(jbtk3 = new JButton("Sketch Books : RM5.00"));
		p001.add(jbtk4 = new JButton("Sticker Scenes : RM4.00"));
		p001.add(jbtk5 = new JButton("Story Books: RM4.50"));
		p001.add(jbtk6 = new JButton("Toys and Gifts: RM6.00"));
		p001.setBackground(Color.cyan);
		
		TitledBorder centerBorder = BorderFactory.createTitledBorder("For Kids Stationary");
    	centerBorder.setTitleJustification(TitledBorder.CENTER);
    	p001.setBorder(centerBorder);
   //-------------------------------------------------------------------------------------- 
    JPanel p0001 = new JPanel(new GridLayout(2,3,1,1));
		p0001.add(jbtO7  = new JButton("Account Books : RM4.00"));
		p0001.add(jbtO8  = new JButton("Calendars : RM3.00"));
		p0001.add(jbtO9  = new JButton("Desk Organize: RM5.00"));
		p0001.add(jbtO10 = new JButton("Tape : RM2.00"));
		p0001.add(jbtO11 = new JButton("Pins : RM1.00"));
		p0001.add(jbtO12 = new JButton("Small Notes: RM1.20"));
		p0001.setBackground(Color.cyan);
		
		TitledBorder centerBorderDrink = BorderFactory.createTitledBorder("For Office Stationary");
    	centerBorderDrink.setTitleJustification(TitledBorder.CENTER);
    	p0001.setBorder(centerBorderDrink);
    	
    	//--------------------------------------------------------------
    	
		JPanel p00001 = new JPanel(new GridLayout(2,3,1,1));
		p00001.add(jbtP13 = new JButton("Mother's Card : RM2.50"));
		p00001.add(jbtP14 = new JButton("Father's Card: RM3.00"));
		p00001.add(jbtP15 = new JButton("Thank you Card : RM4.50"));
		p00001.add(jbtP16 = new JButton("Valentine's Card : RM4.50"));
		p00001.add(jbtP17 = new JButton("Christmas Card : RM2.50"));
		p00001.add(jbtP18 = new JButton("Wedding Card : RM3.00"));
		p00001.setBackground(Color.cyan);
		
		TitledBorder centerBorderDessert = BorderFactory.createTitledBorder("Post Card Stationary");
    	centerBorderDessert.setTitleJustification(TitledBorder.CENTER);
    	p00001.setBorder(centerBorderDessert);
		p01.add(p001);
		p01.add(p0001);
	//---------------------------------------------------------------------------------------------	
		JPanel p011=new JPanel(new GridLayout(2,3,1,1));
		p011.add(new JLabel("Item	: "));
		p011.add(jtfItem = new JTextField(10));//item try catch
		
		p011.add(new JLabel("Quantity	:"));
		p011.add(jcbquantity = new JComboBox(new Object[]{"1","2","3","4","5","6","7","8","9","10"}));
		
		jtfItem.setEditable(false);
		p011.setBorder(new TitledBorder(""));
		p011.setBackground(Color.cyan);
		
		JPanel p012=new JPanel(new GridLayout(1,3,20,20));
		p012.setBackground(Color.cyan);
		p012.add(jrbSmall = new JRadioButton("Small Item"));
		jrbSmall.setBackground(Color.cyan);
		p012.add(jrbLarge = new JRadioButton("Large Item"));
		jrbLarge.setBackground(Color.cyan);
		p012.setBorder(new TitledBorder("Item Size"));
		
		//Set default size
		jrbSmall.setSelected(true);	
		ButtonGroup group = new ButtonGroup();
	    group.add(jrbSmall);
	    group.add(jrbLarge);  	
		JPanel p013=new JPanel(new GridLayout(2,1));
		p013.setBackground(Color.LIGHT_GRAY);
		p013.add(p012);
		p013.add(p011);
		JPanel p014=new JPanel(new GridLayout(2,1));
		p014.add(p013);
		JPanel p015=new JPanel(new GridLayout(1,2));
		p015.add(p01);
		p015.add(p014);
		cont.add(p015);
//---------------------------------------------------------------------------------------
		JPanel p02 = new JPanel(new GridLayout(4,3,3,3));
		p02.add(new JLabel(""));
		p02.add(new JLabel(""));
		p02.add(new JLabel(""));
		p02.add(new JLabel(""));
		p02.add(jbtMore = new JButton("Add More Items"));
			p02.add(new JLabel(""));
			p02.add(new JLabel(""));
	    p02.add(jbtReset = new JButton("Reset"));
	    p02.add(new JLabel(""));
	    p02.add(new JLabel(""));
		p02.setBackground(Color.LIGHT_GRAY);
		p02.add(jbtPrice = new JButton("Calculate Price RM"));
		JPanel PA=new JPanel(new GridLayout(2,1));//new BorderLayout(5,5)
		PA.add(p00001,BorderLayout.NORTH);
		PA.add(p02,BorderLayout.CENTER);
		JPanel p021 = new JPanel(new GridLayout(4,3));
	    p021.add(jtfPrice = new JTextField(10));
	    jtfPrice.setEditable(false);//User cannot edit content
		p021.add(new JLabel(""));
		p021.add(jtfSub = new JTextField(10));
		p021.add(new JLabel("SubTotal RM"));
		jtfSub.setEditable(false);
		p021.add(jtfTax = new JTextField(10));
		p021.add(new JLabel("Tax 5% RM"));
		jtfTax.setEditable(false);
		p021.add(jtfTotal = new JTextField(10));
		p021.add(new JLabel("Total RM"));
		jtfTotal.setEditable(false);
		p021.setBorder(new TitledBorder("Price Detail"));
		p021.setBackground(Color.LIGHT_GRAY);
			JPanel p03=new JPanel(new GridLayout(1,1,20,20));;
		JPanel p2=new JPanel(new GridLayout(1,2));
		p2.add(PA);
		p2.add(p03);
		cont.add(p2);
//------------------------------------------------------------------------------------
	
		
		p03.add(jtasummary = new JTextArea(10,10));//JScrollBar
		JScrollPane ScrollPaneSummary=new JScrollPane(jtasummary);
		p03.add(ScrollPaneSummary);
		jtasummary.setEditable(false);	
		TitledBorder centerBorderSummary = BorderFactory.createTitledBorder("Order Detail");
    	centerBorderSummary.setTitleJustification(TitledBorder.CENTER);
    	p03.setBorder(centerBorderSummary);
    	p03.setBackground(Color.YELLOW);    	
		JPanel p031=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p031.add(jbBack = new JButton("Back Main to Page"));//2nd row
		p031.add(jbconfirmorder=new JButton("Confirm Order"));//2nd row
		JPanel p3=new JPanel(new BorderLayout(7,5));
		p3.add(p021);
		p3.add(p031,BorderLayout.SOUTH);
		cont.add(p3);
//------------------------------------------------------------------------------------

		jbBack.addActionListener(this);
		jbconfirmorder.addActionListener(this);		
	 	jbtk1.addActionListener(this);
		jbtk2.addActionListener(this);
		jbtk3.addActionListener(this);
		jbtk4.addActionListener(this);
		jbtk5.addActionListener(this);
		jbtk6.addActionListener(this);
		jbtO7.addActionListener(this);
		jbtO8.addActionListener(this);
		jbtO9.addActionListener(this);
		jbtO10.addActionListener(this);
		jbtO11.addActionListener(this);
		jbtO12.addActionListener(this);
		jbtP13.addActionListener(this);
		jbtP14.addActionListener(this);
		jbtP15.addActionListener(this);
		jbtP16.addActionListener(this);
		jbtP17.addActionListener(this);
		jbtP18.addActionListener(this);
		jrbSmall.addActionListener(this);
		jrbLarge.addActionListener(this);
		jbtPrice.addActionListener(this);
		jcbquantity.addActionListener(this);
		jbtMore.addActionListener(this);
		jbtReset.addActionListener(this);
	}
	//------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
	if (e.getSource() == jbtReset){	//Cancel
		jtfItem.setText("");
		x=0;y=0;z=0;
		jcbquantity.setSelectedIndex(0);
		jtfPrice.setText(null);
		jtfSub.setText(null);
		jtfTax.setText(null);
		jtfTotal.setText(null);
		jtasummary.setText(null);
		subtotal=0;
		tax=0;
		total=0;
		price=0;
	}
	
	if(e.getSource() ==jbBack)
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
//More if user want to add more item
		if(e.getSource()==jbtMore){
		jcbquantity.setSelectedIndex(0);
		jtfPrice.setText("");
		jtfItem.setText("");
		}
		
//-----------------------------------------------------------------For Kids Stationary			
if (e.getSource() == jbtk1){
		jtfItem.setText(("Activity Books"));
		items[x] = "Activity Books : RM3.00";
		cost[x]=3;
	}
	
if (e.getSource() == jbtk2){
		jtfItem.setText(("Name Poems"));
		items[x] = "Name Poems : RM4.00";
		cost[x]=4;
	}
	
if (e.getSource() == jbtk3){
		jtfItem.setText(("Sketch Books"));
		items[x] = "Sketch Books : RM5.00";
		cost[x]=5;
	}
if (e.getSource() == jbtk4){
		jtfItem.setText(("Sticker Scenes"));
		items[x] = "Sticker Scenes : RM4.00";
		cost[x]=4;
	}
	
if (e.getSource() == jbtk5){
		jtfItem.setText(("Story Books"));
		items[x] = "Story Books : RM4.50";
		cost[x]=4.5;
	}
	
if (e.getSource() == jbtk6){
		jtfItem.setText(("Toy and Gifts"));
		items[x] = "Toy and Gifts : RM6.00";
		cost[x]=6;
	}	
//-----------------------------------------------------------------For Office Stationary
if (e.getSource() == jbtO7){
		jtfItem.setText(("Accounting Books"));
		items[x] = "Accounting Books : RM4.00";
		cost[x]=4;
	}
	
if (e.getSource() == jbtO8){
		jtfItem.setText(("Calendar"));
		items[x] = "Calendar : RM3.00";
		cost[x]=3;
	}
	
if (e.getSource() == jbtO9){
		jtfItem.setText(("Desk Organization"));
		items[x] = "Desk Organization : RM5.00	";
		cost[x]=5;
	}
if (e.getSource() == jbtO10){
		jtfItem.setText(("Tape"));
		items[x] = "Tape : RM2.00";
		cost[x]=2;
	}
	
if (e.getSource() == jbtO11){
		jtfItem.setText(("Pins"));
		items[x] = "Pins : RM1.00	";
		cost[x]=1;
	}
	
if (e.getSource() == jbtO12){
		jtfItem.setText(("Small notes"));
		items[x] = "Small notes : RM1.20";
		cost[x]=1.2;
	}	
//----------------------------------------------------------------For Post Card Stationary
if (e.getSource() == jbtP13){
		jtfItem.setText(("Mother's Day Card"));
		items[x] = "Mother's Day Card : RM2.50	";
		cost[x]=2.5;
	}
	
if (e.getSource() == jbtP14){
		jtfItem.setText(("Father's Day Card"));
		items[x] = "Father's Day Card : RM3.00";
		cost[x]=3.0;
	}
	
if (e.getSource() == jbtP15){
		jtfItem.setText(("Thank you Card"));
		items[x] = "Thank you Card : RM4.50";
		cost[x]=4.5;
	}
if (e.getSource() == jbtP16){
		jtfItem.setText(("Valentine's Day Card"));
		items[x] = "Valentine's Day Card : RM4.5";
		cost[x]=4.5;
	}
	
if (e.getSource() == jbtP17){
		jtfItem.setText(("Christmas Card"));
		items[x] = "Christmas Card : RM2.50";
		cost[x]=2.5;
	}
	
if (e.getSource() == jbtP18){
		jtfItem.setText(("Wedding Card"));
		items[x] = "Wedding Card : RM3.00";
		cost[x]=3.0;
	}


//-----------------------------------------------------------------
	//To display the price for selected item
	if (e.getSource() == jbtPrice){
	
		if(jtfItem.getText().equalsIgnoreCase("")){	
			jtfItem.requestFocus();
			jtfPrice.setText(null);
			jtfSub.setText(null);
			jtfTax.setText(null);
			jtfTotal.setText(null);
			jtasummary.setText(null);
			subtotal=0;
			tax=0;
			total=0;
			price=0;
			JOptionPane.showMessageDialog(null,"Error, Please Enter Item First");//edit
		
		}else{
			calculateprice();
			 while(z<x)
				  {
				  	subtotal = subtotal + price2[z];
				  	z++;
				  }
				  
				  tax = subtotal * 0.05;
				  total = subtotal + tax;
				  
				  jtfSub.setText(String.valueOf(df.format(subtotal)));
				  jtfTax.setText(String.valueOf(df.format(tax)));
				  jtfTotal.setText(String.valueOf(df.format(total)));	
		}		
	}
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (e.getSource() == jbconfirmorder){//confirm order
		 			
		 			String all= jtasummary.getText();
		 			
		 			String sub=jtfSub.getText();
		 			String tax=jtfTax.getText();
				  	String total=jtfTotal.getText();
					JTextArea jtabill = new JTextArea(10,10);
					
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		            java.util.Date date = new java.util.Date();
		            String datetime = dateFormat.format(date);
		            
		            
				int confirm=JOptionPane.showConfirmDialog(null,"Date : "+datetime+
				"\nYour order is : "+"\n"+all+"\n\n\tYour total is : "+total+
				"\n\nConfirm Your Order ?","Confirm",JOptionPane.YES_NO_CANCEL_OPTION);

		 			if (JOptionPane.CANCEL_OPTION==confirm){
								orderstationary frame = new orderstationary();
								frame.pack();
								frame.setTitle("Ordering System");
								frame.setSize(1100, 650);
								frame.setVisible(true);
								frame.setResizable(false);
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame.setLocationRelativeTo(null);
		 			}
					else if(JOptionPane.NO_OPTION==confirm){
								orderstationary frame = new orderstationary();
								frame.setTitle("Ordering System ");
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame.setSize(1100,650);
								frame.setVisible(true);
								frame.setResizable(true);
								frame.setLocationRelativeTo(null);
								this.dispose();
		 			}
		 			else{

							try {// Save to data into folder customer				
				
									FileWriter FW = new FileWriter("OutPut.txt", true);
									PrintWriter PW = new PrintWriter(FW);
									PW.println("Date :"+datetime);
									PW.println("Your order is : "+"\n"+all);
									PW.println("subtotal is :"+sub);
									PW.println("tax 5% :"+tax);
									PW.println("total :"+total);
									PW.println("***********************");
									FW.close();
					
									JOptionPane.showMessageDialog(null, "Loading all data to text file...");
									JOptionPane.showMessageDialog(null, "Do you want to see all data that save in text file...");
									this.dispose();
									
									readdata1 frame = new readdata1();
									
		 			            }
								catch(IOException f){							
								}
						this.dispose();	
		 			}	
		 		}
			}
//Method to calculate price
public double calculate(double size){
		quantity[x] = Double.parseDouble((String)jcbquantity.getSelectedItem());  
		double price = quantity[x]*cost[x]*size;
		return price;
	}
public void calculateprice(){
	    double size = 1;

		if(jrbSmall.isSelected())
		{
			size=1;
		}
		else if(jrbLarge.isSelected())
		{
			size=2;
		}
		price = calculate(size);
		price2[x] = price;
		jtfPrice.setText(String.valueOf(price));
				
		if(size==1)
		{
			sizeConvert="Small : RM1.00 ";
		}	
		else if(size==2)
		{
			 sizeConvert="Large : RM2.00";
		}
			
		x++;
			
		while(y<x)
		{
		jtasummary.append("\n"+String.valueOf(items[y]+"\t  x  "+quantity[y]+"\tSize :"+sizeConvert+"\tRM  " + df.format(price2[y])));
		
		y++;
		}
    }


}

