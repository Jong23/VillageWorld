package Game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import Map.MapGui;

import static org.lwjgl.opengl.GL11.*;

public class Main {

	public Main(){
		MapGui map = new MapGui(50,50);
		
		Display.setTitle("VillageWorld");
		try {
			Display.setDisplayMode(new DisplayMode(1200, 1000));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 1200, 1000, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		while(!Display.isCloseRequested()){
			map.draw();
			Display.update();
			Display.sync(30);
		}
		Display.destroy();
	}
	public static void main(String[] args) {
		new Main();
	}

}
