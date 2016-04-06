package GUI;

import GUI.Map.TileGrid;

public class Editor {
	
	private TileGrid map;
	
	Editor(){
		this.map = new TileGrid();
	}
	
	public void update(){
		map.draw();
	}

}
