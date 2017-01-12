package javaassign;

import java.io.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class readdata1 extends JFrame {	
	public readdata1(){
		JFrame frame = new JFrame("Loading all data from text file");
       	JTextArea textArea = new JTextArea();

        String text = "";
        try{
            FileReader fr = new FileReader("OutPut.txt");
            BufferedReader reader = new BufferedReader(fr);
            String textLine = "";
            while(textLine!=null){
                textLine = reader.readLine();
                text = text + textLine + "\n";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        textArea.setText(text);
        

       frame.add(new JScrollPane(textArea));
        frame.setSize(700, 400);
       frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);	
       
	}
	
    public static void main(String[] args){
		readdata1 frame = new readdata1();
		
		
    }
}
