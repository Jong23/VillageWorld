package GUI;

import org.lwjgl.opengl.Display;
import static helpers.Artist.*;

public class Boot {
	
	public Boot(){
		beginSession();
		

		
		while(!Display.isCloseRequested()){
			
			StateManager.update();
			
			Display.update();
			Display.sync(60);
			//player.setTile();
		}
		Display.destroy();
	}

	public static void main(String[] args){
		new Boot();
	}
	
}
