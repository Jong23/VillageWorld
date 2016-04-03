package Game;

public abstract class Building implements Producing{
	int width;
	int height;
	int x;
	int y;
	public Building(int x, int y, int w, int h){
		width = w;
		height = h;
		this.x = x;
		this.y = y;
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
	
	
}
