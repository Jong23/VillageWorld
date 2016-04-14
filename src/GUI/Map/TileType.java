package GUI.Map;

public enum TileType {

	Grass("GRASS", true), Dirt("DIRT", false), Water("WATER", false), Sand("SAND",false), Tree("TREE", false),Mountain("MOUNTAIN", false), Nothing("NOTHING", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
