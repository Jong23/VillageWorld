package GUI;
import org.lwjgl.input.Mouse;

import GUI.Map.TileGrid;
import GUI.Map.TileType;
import helpers.Artist;

public class Player {

	private TileGrid grid;
	
	public Player(TileGrid grid){
		this.grid=grid;
	
	}
	
	public void setTile(){
		grid.setTile((int) Math.floor(Mouse.getX()/32),(int)Math.floor((Artist.HEIGHT-Mouse.getY()-1)/32), TileType.Dirt);
	}
}
