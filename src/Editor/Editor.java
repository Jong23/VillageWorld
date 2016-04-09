package Editor;

import static helpers.Artist.drawQuadTex;
import static helpers.Artist.loadTexture;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import GUI.Map.TileGrid;
import GUI.Map.TileType;
import static helpers.Artist.*;

public class Editor {
	
	private TileGrid map;
	private Texture editorToolbarTexture;
	
	public Editor(){
		this.map = new TileGrid();
		this.editorToolbarTexture = loadTexture("EditorToolbar");
	}
	
	public void update(){
		map.draw();
		drawQuadTex(editorToolbarTexture, WIDTH-256, HEIGHT-128, 256, 128,0);
		//setTile();
	}
	
	public void setTile(){
		map.setTile((int) Math.floor(Mouse.getX()/32),(int)Math.floor((HEIGHT-Mouse.getY()-1)/32), TileType.Dirt);
	}

}
