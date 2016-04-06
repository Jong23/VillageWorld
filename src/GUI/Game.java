package GUI;

import static org.lwjgl.opengl.GL11.glOrtho;
import static GUI.UI.*;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.WIDTH;
import static helpers.Artist.drawQuadTex;

import org.lwjgl.input.Mouse;

import GUI.Map.TileGrid;

public class Game {

	private TileGrid map;
	
	Game(TileGrid map){
		this.map = map;
	}
	
	public void update(){
		map.draw();
	}
	

}
