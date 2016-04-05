package GUI.Map;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import GUI.Player;

import static GUI.Artist.*;
import static org.lwjgl.opengl.GL11.*;

public class Boot {
	
	public Boot(){
		beginSession();
		
		TileGrid tileGrid = new TileGrid();
		Player player = new Player(tileGrid);
		
		while(!Display.isCloseRequested()){
			
			tileGrid.draw();
			
			Display.update();
			Display.sync(60);
			player.setTile();
		}
	}

	public static void main(String[] args){
		new Boot();
	}
}
