package Buildings;

import Enums.BuildingStatus;
import Enums.BuildingType;
import Enums.RessourceType;
import Game.Storage;

public abstract class Building{
	int width;
	int height;
	int x;
	int y;
	protected Storage storage;
	protected BuildingStatus status;
	BuildingType type;
	public BuildingType getType() {
		return type;
	}
	public Building(int x, int y, BuildingType type){
		width = type.getWidth();
		height = type.getHeight();
		this.x = x;
		this.y = y;
		this.type = type;
		this.storage = createConstructionStorage();
		status = BuildingStatus.INCONSTRUCTION;
	}
	private  Storage createConstructionStorage() {
		return new Storage(0, type.getNeededRessources(), type.getAmountOfRessources());
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
	public BuildingStatus getBuildingStatus(){
		return status;
	}
	public void setBuildingStatus(BuildingStatus status){
		this.status = status;
	}
	public void addRessource(RessourceType type, int amount){
		storage.addRessource(type, amount);
		if(status == BuildingStatus.INCONSTRUCTION && storage.isFull()){
			finishConstruction();
		}
	}
	public void finishConstruction() {
		status = BuildingStatus.FINISHED;
		
		if(type.getStorageSize()>0){
			storage = new Storage(type.getStorageSize());
		}else {
			storage = null;
		}
		
	}

	
	
}
