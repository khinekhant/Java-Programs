package textbasedGame;

import java.io.*;
import java.util.*;

public class GameWorld implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Vector<Location> locations;
	private Vector<Exit> exits;
	private Location currentLocation;
	
	//character width for description
	private int charWidth;
	
	transient private WidthLimitedOutputStream outputStream;
	
	public GameWorld(){
		locations=new Vector<Location>();
		exits=new Vector<Exit>();
		
		currentLocation=null;
		setOutputStream(System.out,80);
	}
	
	public GameWorld(int charWidth){
		this();
		this.charWidth=charWidth;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	//add new exit to gaming system
	public void addExit(Exit exit){
		if(! exits.contains(exit)) exits.addElement(exit);
	}
	
	public void addLocation(Location location){
		if(! locations.contains(location)) locations.addElement(location);
	}
	 
	public void showLocation(){
		outputStream.println(currentLocation.getRoomTitle());
		outputStream.println(currentLocation.getRoomDescription());
		outputStream.println();
		
		outputStream.println("Available exits: ");
		
		for(Enumeration<Exit> e=currentLocation.getExits().elements();e.hasMoreElements();){
			Exit exit=(Exit) e.nextElement();
			outputStream.println(exit.toString());
		}
	}
	
	
	public void setOutputStream(OutputStream out, int width) {
		// TODO Auto-generated method stub
		outputStream=new WidthLimitedOutputStream(out, width);
	}
	

}
