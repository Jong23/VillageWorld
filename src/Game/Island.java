package Game;
import java.util.ArrayList;
import java.util.Iterator;

import Buildings.Building;

public class Island {
	ArrayList<Building> buildings;
	
	public Island() {
		buildings = new ArrayList<>();
	}
	
	public ArrayList<Building> getBuildings(){
		return buildings;
	}
	public void addBuilding(Building b){
		buildings.add(b);
	}
	public ArrayList<Storage> getStorages(){
		ArrayList<Storage> storages = new ArrayList<Storage>();
		for (Iterator<Building> iterator = buildings.iterator(); iterator.hasNext();) {
			Building building = (Building) iterator.next();
			storages.add(building.getStorage());
		}
		return storages;
	}
}
