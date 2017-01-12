package textbasedGame;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CreateGameWorld {
	
public static String filename="gameworld.dat";


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameWorld gameWorld=new GameWorld();
		
		Location l1=new Location("Bottom of the well",
				"You have reached the bottom of a deep and rather smelly well. "
				+ "Less than a foot of water remains, and it looks undrinkable.");
		Location l2 = new Location ("Courtyard", "At the centre of the courtyard is an old stone well. "
				+ "A strong and sturdy rope is attached to the well, and descends into the darkness. The only other items of interest is the farmhouse to the north, and a path to the east.");
		Location l3 = new Location ("Farmhouse entrance", 
				"The door to the farmhouse hangs crooked, and is slightly ajar. "
				+ "Obviously no-one has lived here for some time, and you can only guess at what lies within.");
		Location l4 = new Location ("Blood-stained room", 
				"Dried blood stains can be seen on the walls and stone floor of the farmhouse."
				+ " Whatever massacre occured here long ago, you can only guess. With the abscence of bodies, however, you may never know.");
		Location l5 = new Location ("Long windy path", "You are standing on a long, windy path, leading from the mountains in the far east, to a small farm that lies to the west.");
		Location l6 = new Location ("Base of the mountain", "At the base of the mountain is a path that leads westward beyond a large boulder. Climbing such a mountain would be difficult - if not impossible.");
		Location l7 = new Location ("Top of the mountain", "From this vantage point, you can see all that lies on the plains below. "
				+ "Large boulders dot the landscape, and just within view to the west you make out some sort of a building - "
				+ "though its details are too hard to make out from this distance.");
		
		
		Exit e1=new Exit(Exit.UP,l2);
		Exit e2 = new Exit ( Exit.DOWN, l1 );
		Exit e3 = new Exit ( Exit.NORTH, l3 );
		Exit e4 = new Exit ( Exit.SOUTH, l2 );
		Exit e5 = new Exit ( Exit.NORTH, l4 );
		Exit e6 = new Exit ( Exit.SOUTH, l3 );
		Exit e7 = new Exit ( Exit.EAST, l5 );
		Exit e8 = new Exit ( Exit.WEST, l2 );
		Exit e9 = new Exit ( Exit.EAST, l6 );
		Exit e10 = new Exit ( Exit.WEST, l5 );
		Exit e11 = new Exit ( Exit.UP, l7 );
		Exit e12 = new Exit ( Exit.DOWN, l6 );
		
		l1.addExit(e1);
		l2.addExit ( e2 );
		l2.addExit ( e3 );
		l2.addExit ( e7 );
		l3.addExit ( e4 );
		l3.addExit ( e5 );
		l4.addExit ( e6 );
		l5.addExit ( e8 );
		l5.addExit ( e9 );
		l6.addExit ( e10 );
		l6.addExit ( e11 );
		l7.addExit ( e12 );
		
		gameWorld.addLocation (l1);
		gameWorld.addLocation (l2);
		gameWorld.addLocation (l3);
	    gameWorld.addLocation (l4);
		gameWorld.addLocation (l5);
		gameWorld.addLocation (l6);
		gameWorld.addLocation (l7);
		gameWorld.addExit( e1 );
		gameWorld.addExit( e2 );
		gameWorld.addExit( e3 );
		gameWorld.addExit( e4 );
		gameWorld.addExit( e5 );
		gameWorld.addExit( e6 );
		
		gameWorld.setCurrentLocation(l2);
		
		try {
			FileOutputStream write=new FileOutputStream(filename);
			ObjectOutputStream writeObj=new ObjectOutputStream(write);
			writeObj.writeObject(gameWorld);
			writeObj.close();
			
			System.out.println("Game data is created as "+ filename);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enable to create game data");
		}

	}

}
