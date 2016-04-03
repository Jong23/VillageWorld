package Game;

public enum BuildingType {
	LUMBERER(2,3), 
	FISHER(2,3);
	public int width;
	public int height;
	BuildingType(int width, int height){
		this.width = width;
		this.height = height;
	}
}
