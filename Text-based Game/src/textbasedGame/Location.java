package textbasedGame;

import java.util.Vector;

public class Location {
private String roomTitle;
private String roomDescription;
private Vector<Exit> vecExits;


public Location(){
	roomTitle=new String();
	setRoomDescription(new String());
	vecExits=new Vector<Exit>();
}

public Location(String title){
	roomTitle=title;
	setRoomDescription(new String());
	vecExits=new Vector<Exit>();
}

public Location(String title,String description){
	roomTitle=title;
	roomDescription=description;
	vecExits=new Vector<Exit>();
}

public String getRoomTitle() {
	return roomTitle;
}
public void setRoomTitle(String roomTitle) {
	this.roomTitle = roomTitle;
}

public void addExit(Exit exit){
	vecExits.addElement(exit);
}

public void removeExit(Exit exit){
	if(vecExits.contains(exit)){
		vecExits.removeElement(exit);
	}
}

public Vector<Exit> getExits(){
	return (Vector<Exit>)vecExits.clone();
}

public String getRoomDescription() {
	return roomDescription;
}

public void setRoomDescription(String roomDescription) {
	this.roomDescription = roomDescription;
}

public String toString(){
	return roomTitle;
}

}
