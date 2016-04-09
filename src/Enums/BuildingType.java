package Enums;

public enum BuildingType {
	Lumberer (2,3, 5000,5,new RessourceType []{RessourceType.WOOD, RessourceType.STONE},new int [] {20,10});
	
	
	private int w,h;
	private int baseProductionTime, storageSize;
	private RessourceType[] neededRessources;
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
	BuildingType(int w, int h, int baseProductionTime, int storageSize, RessourceType[] neededRessources, int[] amountOfRessources){
		this.w = w;
		this.h = h;
		this.baseProductionTime = baseProductionTime;
		this.neededRessources = neededRessources;
		this.amountOfRessources = amountOfRessources;
		this.storageSize = storageSize;
	}
}
