package GUI.Map;
import static helpers.Artist.*;

import Game.Constants;

public class TileGrid {

	public Tile[][] tiles;
	
	public TileGrid(){
		tiles = new Tile[40][30];
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[i].length;j++){
				tiles[i][j] = new Tile(i*Constants.TILESIZE, j*Constants.TILESIZE,Constants.TILESIZE,Constants.TILESIZE,TileType.Grass);
			}
		}
	}
	public void draw(){
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[i].length;j++){
				Tile t = tiles[i][j];
				drawQuadTex(t.getTexture(),t.getX(),t.getY(),t.getWidth(),t.getHeight(),0);
			}
		}
	}
	public void setTile(int x, int y, TileType type) {
		tiles[x][y].setTexture(loadTexture(type.textureName));
	}
}
