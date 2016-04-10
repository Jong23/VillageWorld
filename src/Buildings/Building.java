package Buildings;

import Enums.BuildingStatus;
import Enums.BuildingType;
import Enums.RessourceType;
import Game.Island;
import Game.Storage;

public abstract class Building{
	int width;
	int height;
	int x;
	int y;
	protected Storage storage;
	protected BuildingStatus status;
	private BuildingType type;
	private Island island;
	public Island getIsland() {
		return island;
	}
	public void setIsland(Island island) {
		this.island = island;
	}
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
		Storage storage = new Storage(0, type.getNeededRessources(), type.getAmountOfRessources());
		storage.setBuilding(this);
		return storage;
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
	public void finishConstruction() {
		status = BuildingStatus.FINISHED;
		
		if(type.getStorageSize()>0){
			if(type.getProducedRessource() == null){
				storage = new Storage(type.getStorageSize());
			} else {
				storage = new Storage(type.getStorageSize(), type.getProducedRessource());
			}
			storage.setBuilding(this);
		}else {
			storage = null;
		}
		
	}

	
	
}
