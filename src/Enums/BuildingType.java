package Enums;

public enum BuildingType {
	LUMBERER (2,3,RessourceType.WOOD, 5000,5,new RessourceType []{RessourceType.WOOD, RessourceType.STONE}, new int [] {20,10}),
	STORAGE(4,3,null, 0,100,new RessourceType []{RessourceType.WOOD, RessourceType.STONE}, new int [] {20,40});
	
	
	BuildingType(int w, int h, RessourceType producedRessource, int baseProductionTime, int storageSize, RessourceType[] neededRessources, int[] amountOfRessources){
		this.w = w;
		this.h = h;
		this.baseProductionTime = baseProductionTime;
		this.neededRessources = neededRessources;
		this.amountOfRessources = amountOfRessources;
		this.storageSize = storageSize;
		this.producedRessource = producedRessource;
	}
	private int w,h;
	private int baseProductionTime, storageSize;
	private RessourceType[] neededRessources;
	private RessourceType producedRessource;
	public RessourceType getProducedRessource() {
		return producedRessource;
	}
	public void setProducedRessource(RessourceType producesRessource) {
		this.producedRessource = producesRessource;
	}
	public RessourceType[] getNeededRessources() {
		return neededRessources;
	}
	public int getStorageSize() {
		return storageSize;
	}
	public int[] getAmountOfRessources() {
		return amountOfRessources;
	}
	private int [] amountOfRessources;
	public int getWidth(){
		return w;
	}
	public int getHeight(){
		return h;
	}
	public int getBaseProductionTime(){
		return baseProductionTime;
	}
	public void setBaseProductionTime(int time){
		//for tests
		baseProductionTime = time; 
	}
}
