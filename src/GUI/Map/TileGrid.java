package GUI.Map;
import static helpers.Artist.*;

import Game.Constants;

public class TileGrid {

	public Tile[][] tiles;
	private int shiftX = 0;
	private int offsetY = 0;
	private int tilesize = 32;
	
	public TileGrid(int width, int height){
		tiles = new Tile[width][height];
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[i].length;j++){
				tiles[i][j] = new Tile(TileType.Grass);
			}
		}
	}
	public void draw(){
		int minusOffsetX = 0;
		int offsetX = shiftX;
		if(offsetX<0){
			minusOffsetX = -offsetX;
			offsetX = 0;
		}

		int amountOfXTiles = (1280/tilesize)-minusOffsetX;
		if(tiles.length<offsetX+amountOfXTiles){
//			int missingTilesRightSide = tiles.length-offsetX;
			amountOfXTiles = tiles.length-offsetX;
			drawBlackFramePart((amountOfXTiles)*tilesize,0,((1280/tilesize)-amountOfXTiles)*tilesize,960);
		}
		for(int i=0; i<amountOfXTiles; i++){
			for(int j=0; j<(960/tilesize);j++){
				Tile t = tiles[i+offsetX][j+offsetY];
				drawQuadTex(t.getTexture(),(i+minusOffsetX)*tilesize,j*tilesize,tilesize,tilesize,0);
			}
		}
		if(minusOffsetX>0){
			drawBlackFramePart(0,0,minusOffsetX*tilesize,960);
		}
	}
	
	public void setTile(int x, int y, TileType type) {
		//map.setTile((int) Math.floor(Mouse.getX()/32),(int)Math.floor((HEIGHT-Mouse.getY()-1)/32), type);
		if(((x/tilesize+shiftX)>=0) && ((x/tilesize+shiftX)<tiles.length)){
			tiles[x/tilesize+shiftX][y/tilesize+offsetY].setTexture(loadTexture(type.textureName));
		}
	}
	
	public void incrementShiftX() {
		if(shiftX<tiles.length-1){
			this.shiftX++;
		}
	}
	
	public void decrementShiftX() {
		if(shiftX>1-(1280/tilesize)){
			this.shiftX--;
		}
	}
	
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	
	public void zoomIn() {

		if(tilesize == 20){
			tilesize = 32;
		}
		if(tilesize == 10){
			tilesize = 20;
		}
		if(shiftX<1-(1280/tilesize)){
			this.shiftX = 1-(1280/tilesize);
		}
	}
	
	public void zoomOut() {

		if(tilesize == 20){
			tilesize = 10;
		}
		if(tilesize == 32){
			tilesize = 20;
		}

	}
	
}
