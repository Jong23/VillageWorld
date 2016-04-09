package Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import Buildings.Building;
import Enums.BuildingStatus;
import Enums.RessourceType;

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
	public ArrayList<Building> getBuildingsInConstruction(){
		return (ArrayList<Building>) buildings.stream()
				.filter(p -> p.getBuildingStatus().equals(BuildingStatus.INCONSTRUCTION))
				.collect(Collectors.toList());
	}
	public ArrayList<Building> getBuildingsFinished(){
		return (ArrayList<Building>) buildings.stream() 
				.filter(p -> p.getBuildingStatus().equals(BuildingStatus.FINISHED))
				.collect(Collectors.toList());
	}
	public ArrayList<TransportTask> getTransportsToCreateBuilding(){
		ArrayList<TransportTask> returnList = new ArrayList<TransportTask>(); 
		ArrayList<Building> buildingsInConstruction = getBuildingsInConstruction();
		//every building that needs ressources for construction
		for (Building building : buildingsInConstruction) {
			HashMap<RessourceType,Integer> neededRessources = building.getStorage().getNeededRessourcesForConstruction();
			//all ressources that are needed
			for(Entry<RessourceType, Integer> neededRessource : neededRessources.entrySet()){
				HashMap<Building, Integer> buildingsWithRessource = getBuildingsWithRessource(neededRessource.getKey());
				//every Building that has those ressources available
				for(Entry<Building, Integer> buildingWithRessource : buildingsWithRessource.entrySet()){
					int transportableAmount;
					if(neededRessource.getValue()< buildingWithRessource.getValue()){
						transportableAmount = neededRessource.getValue();
					} else {
						transportableAmount = buildingWithRessource.getValue();
					}
					returnList.add(new TransportTask(buildingWithRessource.getKey(), building, neededRessource.getKey(), transportableAmount));
				}
			}
		}
		Collections.sort(returnList);
		return returnList;
	}

	
	public HashMap<Building, Integer> getBuildingsWithRessource(RessourceType type) {
		HashMap<Building, Integer> buildingsWithRessource = new HashMap<Building, Integer>();
		ArrayList<Building> buildingsFinished = getBuildingsFinished();
		for (Building building : buildingsFinished) {
			int amount;
			if((amount = building.getStorage().getAvailableAmountOfRessource(type))>0){
				buildingsWithRessource.put(building, amount);
			}
		}
		return buildingsWithRessource;
	}
}
