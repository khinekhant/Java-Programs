package caculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Caculator extends JFrame implements ActionListener {
	
	 JPanel[] rows=new JPanel[5];
     JButton[] buttons=new JButton[19];
     String[] buttonString={"7","8","9","+",
    		 "4", "5", "6", "-",
    		 "1", "2", "3", "*", 
    		 ".", "/", "C", "√",
    		 "+/-", "=", "0"};
     
     int[]diWidth={300,45,100,90};
     int[] diHeight={35,40};
     
     Dimension displayDimen=new Dimension(diWidth[0], diHeight[0]);
     Dimension rightColumnDimension = new Dimension(diWidth[2], diHeight[1]);
     Dimension regularButtDimension = new Dimension(diWidth[1], diHeight[1]);
     Dimension zeroButtDimension = new Dimension(diWidth[3], diHeight[1]);	
     
 	boolean[] operation=new boolean[4];
 	double[] temp={0,0};
 	JTextArea txtDisplay=new JTextArea(2,20);
 	Font font=new Font("Times new Roman", Font.BOLD|Font.ITALIC, 15);
 	
	public Caculator() {
		// TODO Auto-generated constructor stub
		super("K-Caculator");
		setDesign();
		setSize(380,250);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridLayout gridLayout=new GridLayout(5, 5);
		setLayout(gridLayout);
		
		for(int i=0;i<4;i++){
			operation[i]=false;
		}
		FlowLayout f1=new FlowLayout(FlowLayout.CENTER);
		FlowLayout f2=new FlowLayout(FlowLayout.CENTER,1,1);
		
		for(int i=0;i<5;i++){
			rows[i]=new JPanel();
		}
		rows[0].setLayout(f1);
		for(int i=1;i<rows.length;i++){
		rows[i].setLayout(f2);
		}
		
		for(int i=0;i<19;i++){
			buttons[i]=new JButton();
			buttons[i].setText(buttonString[i]);
			buttons[i].setFont(font);
			buttons[i].addActionListener(this);
		}
		
		txtDisplay.setEditable(false);
		txtDisplay.setFont(font);
		txtDisplay.setPreferredSize(displayDimen);
		
		for(int i=0;i<14;i++)
			buttons[i].setPreferredSize(regularButtDimension);
		for(int i=14;i<18;i++)
			buttons[i].setPreferredSize(rightColumnDimension);
		
		buttons[buttons.length-1].setPreferredSize(zeroButtDimension);
		//add display to row no1
		rows[0].add(txtDisplay);
		add(rows[0]);
		
		//add first 4 buttons and c to row no2
		for(int i=0;i<4;i++){
			rows[1].add(buttons[i]);
		}
		rows[1].add(buttons[14]);
		add(rows[1]);
		
		//add second 4 buttons and √ to row no3
		for(int i=4;i<8;i++){
			rows[2].add(buttons[i]);
		}
		rows[2].add(buttons[15]);
		add(rows[2]);
		
		//add third 4 buttons and +/- to row no4
		for(int i=8;i<12;i++){
			rows[3].add(buttons[i]);
		}
		rows[3].add(buttons[16]);
		add(rows[3]);
		
		//buttons[12]to[13] and buttons[17]to[18]
		rows[4].add(buttons[18]);
		for(int i=12;i<14;i++){
			rows[4].add(buttons[i]);
		}
		rows[4].add(buttons[17]);
		add(rows[4]);
		
		setVisible(true);
		
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        } 
		    }
		}catch(Exception e) {  

		        }
	}
	
	//for clear button
	public void clear(){
		try {
			txtDisplay.setText("");
			for(int i=0;i<4;i++){
				operation[i]=false;
			}
			for(int i=0;i<2;i++){
				temp[i]=0;
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//for square root button
	public void performSqrt() {
		try {
			double result=Math.sqrt(Double.parseDouble(txtDisplay.getText()));
			txtDisplay.setText(Double.toString(result));
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//for positive and negative button
	public void performPosiNega() {
		try{
	
		double value=Double.parseDouble(txtDisplay.getText());
		if(value!=0){
			value*=(-1);
			txtDisplay.setText(Double.toString(value));
		}
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//result method
	public void getResult(){
		double result=0;
		temp[1]=Double.parseDouble(txtDisplay.getText());
		String temp0=Double.toString(temp[0]);
		String temp1=Double.toString(temp[1]);
		
		try{
			if(temp0.contains("-")){
				String[] temp00=temp0.split("-", 2);
				temp[0]=Double.parseDouble(temp00[1])*-1;
			}
			
			if(temp1.contains("-")){
				String[] temp11=temp1.split("-",2);
				temp[1]=Double.parseDouble(temp11[1])*-1;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		try {
			if(operation[0]) result=temp[0]+temp[1];
			else if (operation[1]) result=temp[0]-temp[1];
			else if (operation[2]) result=temp[0]*temp[1];
			else if (operation[3]) result=temp[0]/temp[1];	
			
			txtDisplay.setText(Double.toString(result));
			
			for(int i=0;i<4;i++)
				operation[i]=false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==buttons[0]) txtDisplay.append("7");
		if(e.getSource()==buttons[1]) txtDisplay.append("8");
		if(e.getSource()==buttons[2]) txtDisplay.append("9");
		if(e.getSource()==buttons[3]) {
			temp[0]=Double.parseDouble(txtDisplay.getText());
			operation[0]=true;
		    txtDisplay.setText("");
		}
		if(e.getSource()==buttons[4]) txtDisplay.append("4");
		if(e.getSource()==buttons[5]) txtDisplay.append("5");
		if(e.getSource()==buttons[6]) txtDisplay.append("6");
		if(e.getSource()==buttons[7]) {
			temp[0]=Double.parseDouble(txtDisplay.getText());
			operation[1]=true;
			txtDisplay.setText("");
		}
		if(e.getSource()==buttons[8]) txtDisplay.append("1");
		if(e.getSource()==buttons[9]) txtDisplay.append("2");
		if(e.getSource()==buttons[10]) txtDisplay.append("3");
		if(e.getSource()==buttons[11]) {
			temp[0]=Double.parseDouble(txtDisplay.getText());
			operation[2]=true;
			txtDisplay.setText("");
		}
		if (e.getSource()==buttons[12]) txtDisplay.append(".");
		if(e.getSource()==buttons[13]) {
			temp[0]=Double.parseDouble(txtDisplay.getText());
			operation[3]=true;
			txtDisplay.setText("");
		}
		
		if(e.getSource()==buttons[14]) clear();
		if(e.getSource()==buttons[15]) performSqrt();
		if(e.getSource()==buttons[16]) performPosiNega();
		if(e.getSource()==buttons[17]) getResult();
		if(e.getSource()==buttons[18]) txtDisplay.append("0");
		 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Caculator compute=new Caculator();
     
    
 	
     }
	

}
