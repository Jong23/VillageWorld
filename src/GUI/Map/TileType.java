package GUI.Map;

public enum TileType {

	Grass("GRASS", true), Dirt("DIRT", false), Water("WATER", false), Sand("SAND",false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
