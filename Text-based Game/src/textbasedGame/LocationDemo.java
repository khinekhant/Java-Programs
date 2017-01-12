package textbasedGame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.applet.*;
import java.util.*;

public class LocationDemo extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4508503050571013534L;
	Location currentLocation;
	String command;
	TextField commandInput;
	TextArea displayOutput;
	Button button;
	
	public LocationDemo() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void init(){
		super.init();
		
		setBackground(Color.white);
		setForeground(Color.black);
		
		Panel aPanel=new Panel();
		BorderLayout bLayout=new BorderLayout();
		aPanel.setLayout(bLayout);
		add(aPanel);
		
		commandInput=new TextField();
		displayOutput=new TextArea();
		button=new Button("go");
		
		Panel inputPanel=new Panel();
		inputPanel.add(commandInput);
		inputPanel.add(button);
		
		aPanel.add("North",displayOutput);
		aPanel.add("South", inputPanel);
		
		Location l1=new Location("Entrance to hall", 
				"You stand at the entrance of a long hallway. The hallway gets darker\nand darker, and you cannot see what lies beyond. To the east\nis an old oaken door, unlocked and beckonning");
		Location l2 = new Location ("End of hall", 
				"You have reached the end of a long dark hallway. You can\nsee nowhere to go but back");
		Location l3 = new Location ("Small study", 
				"This is a small and cluttered study, containing a desk covered with\npapers. Though they no doubt are of some importance,\nyou cannot read their writing");
		
		l1.addExit(new Exit(Exit.NORTH,l2));
		l1.addExit(new Exit(Exit.EAST,l3));
		l2.addExit(new Exit(Exit.SOUTH,l1));
		l3.addExit(new Exit(Exit.WEST,l1));
		
		currentLocation=l1;
		showLocation();
		//repaint();
	
	}

	private void showLocation() {
		// TODO Auto-generated method stub
		displayOutput.append("\n"+currentLocation.getRoomTitle()+"\n");
		displayOutput.append("\n");
		
		//Room description
		displayOutput.append(currentLocation.getRoomDescription());
		
		//show Available exits
		displayOutput.append("\nAvailable exits: \n");
		for(Enumeration<Exit> e=currentLocation.getExits().elements(); e.hasMoreElements();){
			Exit exit=(Exit) e.nextElement();
			displayOutput.append(exit+"\n");
		}
		
		
	}
	
	public boolean action(Event evt,Object focus){
		String command;
		
		if(evt.target instanceof Button){
			command=commandInput.getText();
			
			if(command.length()==0) return true;
			command=command.toUpperCase();
			
			for(Enumeration<Exit> e=currentLocation.getExits().elements();e.hasMoreElements();){
				Exit exit=(Exit) e.nextElement();
				
				if(exit.getDirectionName().compareTo(command)==0 || 
						exit.getShortDirectionName().compareTo(command)==0){
					currentLocation=exit.getLeadsTo();
					showLocation();
					//clear text area
					commandInput.setText(new String());
					return true;
				}
			}
			
			displayOutput.append("\nHuh?Invalid diection!\n");
			commandInput.setText(new String());
			return true;
		}else
			return false;
				
	
	}

}
