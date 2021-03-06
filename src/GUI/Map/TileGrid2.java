package GUI.Map;
import static helpers.Artist.*;

import java.io.Serializable;

import Game.Constants;

public class TileGrid2 implements Serializable {

	public Tile[][] tiles;
	private int offsetX = 0;
	private int offsetY = 0;
	private int tilesize = 16;
	private int width,height;
	private int zoom = 2;
	
	public TileGrid2(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new Tile[width+10][height+10];
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[i].length;j++){
				tiles[i][j] = new Tile(TileType.Water);
			}
		}
		//Top Nothing
		for(int i=0;i<tiles.length;i++){
			for(int j=0;j<=4;j++){
				tiles[i][j].setType(TileType.Nothing);
			}
		}
		//Left
		for(int i=0;i<tiles[0].length;i++){
			for(int j=0; j<=4;j++){
				tiles[j][i] = new Tile(TileType.Nothing);
			}
		}
		//Bot
		for(int i=0;i<tiles.length;i++){
			for(int j=height;j>=height-5;j--){
				tiles[i][j] = new Tile(TileType.Nothing);
			}
		}
		//Right
		for(int i=0;i<tiles[0].length;i++){
			for(int j=width; j>=width-5;j--){
				tiles[j][i] = new Tile(TileType.Nothing);
			}
		}
	}
	
	public void draw(){
		for(int i=0; i<width; i++){
			for(int j=0; j<height;j++){
				Tile t = tiles[i][j];
				drawQuadTex(t.getTexture(),(i-offsetX)*tilesize*zoom,(j-offsetY)*tilesize*zoom,tilesize*zoom,tilesize*zoom,0);
			}
		}
	}
	
	public void setTile(int x, int y, TileType type) {
		if(tiles[x/(tilesize*zoom)+offsetX][y/(tilesize*zoom)+offsetY].getType()!=TileType.Nothing){
			tiles[x/(tilesize*zoom)+offsetX][y/(tilesize*zoom)+offsetY].setType(type);
		}
	}
	
	public void incrementOffsetX() {
		if(this.offsetX<this.tiles.length-1280/this.tilesize/zoom-10){
			this.offsetX++;
		}
	}
	
	public void decrementOffsetX() {
		if(offsetX>0){
			this.offsetX--;
		}
	}
	
	public void incrementOffsetY() {
		if(this.offsetY<this.tiles[0].length-960/this.tilesize/zoom-10){
			this.offsetY++;
		}
	}
	
	public void decrementOffsetY() {
		if(offsetY>0){
			this.offsetY--;
		}
	}
	
	public void zoomIn() {
		if(this.zoom == 1){
			this.zoom = 2;		
		}
		else if(this.zoom == 2){
			this.zoom = 4;
		}
	}
	
	public void zoomOut() {
		if(this.zoom == 4){
			this.zoom = 2;
		}
		else if(this.zoom  == 2){
			this.zoom  = 1;
		}
	}
	
}
