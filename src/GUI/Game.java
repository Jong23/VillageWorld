package GUI;

import static GUI.Artist.drawQuadTex;
import GUI.Map.TileGrid;

public class Game {

	private TileGrid map;
	
	Game(TileGrid map){
		this.map = map;
	}
	
	public void update(){
		UI.zoom();
		map.draw();
	}
}
