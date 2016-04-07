package GUI;

import org.lwjgl.input.Mouse;

import GUI.Map.TileGrid;
import GUI.Map.TileType;
import helpers.Artist;

public class Editor {
	
	private TileGrid map;
	
	Editor(){
		this.map = new TileGrid();
	}
	
	public void update(){
		map.draw();
		setTile();
	}
	
	public void setTile(){
		map.setTile((int) Math.floor(Mouse.getX()/32),(int)Math.floor((Artist.HEIGHT-Mouse.getY()-1)/32), TileType.Dirt);
	}

}
