package Buildings;

import Game.Storage;

public abstract class Building{
	int width;
	int height;
	int x;
	int y;
	Storage storage;
	public Building(int x, int y, int w, int h, Storage store){
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		this.storage = store;
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	
}
