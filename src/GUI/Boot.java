package GUI;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static GUI.Artist.*;
import static org.lwjgl.opengl.GL11.*;

public class Boot {
	
	public Boot(){
		beginSession();
		

		
		while(!Display.isCloseRequested()){
			
			StateManager.update();
			Display.update();
			Display.sync(60);
			//player.setTile();
		}
	}

	public static void main(String[] args){
		new Boot();
	}
}
