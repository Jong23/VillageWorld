package GUI.Map;
import static helpers.Artist.*;

import Game.Constants;

public class TileGrid {

	public Tile[][] tiles;
	private int offsetX = 0;
	private int offsetY = 0;
	private int zoom = 1;
	
	public TileGrid(int width, int height){
		tiles = new Tile[width][height];
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[i].length;j++){
				tiles[i][j] = new Tile(i*Constants.TILESIZE, j*Constants.TILESIZE,Constants.TILESIZE,Constants.TILESIZE,TileType.Grass);
			}
		}
	}
	public void draw(){
		System.out.println("draw()");
		System.out.println(offsetX);

		for(int i=0; i<(40*zoom); i++){
			for(int j=0; j<(30*zoom);j++){
				Tile t = tiles[i+offsetX][j+offsetY];
				drawQuadTex(t.getTexture(),i*32/zoom,j*32/zoom,t.getWidth()/zoom,t.getHeight()/zoom,0);
			}
		}
	}
	public void setTile(int x, int y, TileType type) {
		//map.setTile((int) Math.floor(Mouse.getX()/32),(int)Math.floor((HEIGHT-Mouse.getY()-1)/32), type);
		tiles[x/(32*zoom)+offsetX][y/(32*zoom)+offsetY].setTexture(loadTexture(type.textureName));
	}
	
	public void incrementOffsetX() {
		if(offsetX<tiles.length-40){
			this.offsetX++;
		}
	}
	
	public void decrementOffsetX() {
		if(offsetX>0){
			this.offsetX--;
		}
	}
	
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	
	public void incrementZoom() {
		if(zoom==2){
			zoom=4;
		}
		if(zoom==1){
			zoom=2;
		}
	}
	
	public void decrementZoom() {
		if(zoom==2){
			zoom=1;
		}
		if(zoom==4){
			zoom=2;
		}
	}	
}
