package GUI.Map;

import static helpers.Artist.*;

import java.io.Serializable;

import org.newdawn.slick.opengl.Texture;

public class Tile implements Serializable{
	private float x, y, width, height;
//	private Texture texture;
	private TileType type;
	
	public Tile(TileType type){
		this.type=type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Texture getTexture() {
		return loadTexture(type.textureName);
	}

	public TileType getType() {
		return this.type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
}
