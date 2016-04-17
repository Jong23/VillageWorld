package Game;

import java.util.ArrayList;

import Buildings.Lumberer;
import Buildings.StorageBuilding;
import Buildings.WorkingBuilding;
import Enums.BuildingStatus;
import Enums.RessourceType;
import Storages.Storage;

public class BuildingFactory {
	Island island;
	ArrayList<WorkingBuilding> buildings = new ArrayList<>(); 
	public BuildingFactory(Island island) {
		this.island = island;
	}
	public void buildFinishedStorage(){
		WorkingBuilding building = new StorageBuilding(0, 0);
		building.setIsland(island);
		building.finishConstruction();
		building.getStorage().addRessource(RessourceType.WOOD, 20);
		building.getStorage().addRessource(RessourceType.STONE, 100);
		building.addWorker();
		building.startWork();
		island.addBuilding(building);
		System.out.println("Storage build");
	}
	public void buildLumberer(){
		WorkingBuilding building = new Lumberer(0, 0);
		island.addBuilding(building);
		buildings.add(building);
		System.out.println("Start to build Lumberer");
	}
	public void addWorkers(){
		for (WorkingBuilding workingBuilding : buildings) {
			if(workingBuilding.getBuildingStatus()== BuildingStatus.FINISHED && workingBuilding.getWorkerCount() < 1){
				workingBuilding.addWorker();
				workingBuilding.startWork();
				System.out.println("Worker added and production started");
			}
		}
	}
	public void getAmountOfRessource(RessourceType type){
		int amount = 0;
		for (Storage storage : island.getStorages()) {
			amount += storage.getAvailableAmountOfRessource(type);
		}
		System.out.println("Amount of "+type+": "+amount);
	}

}
