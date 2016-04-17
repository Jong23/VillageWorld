package Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Buildings.Building;
import Enums.BuildingStatus;
import Enums.BuildingType;
import Enums.RessourceType;
import Storages.Storage;

public class Island {
	ArrayList<Building> constructionBuildings;
	ArrayList<Building> finishedBuildings;
	
	public Island() {
		constructionBuildings = new ArrayList<>();
		finishedBuildings = new ArrayList<>();
	}
	
	public ArrayList<Building> getBuildings(){
		ArrayList<Building> returnList = new ArrayList<>();
		returnList.addAll(finishedBuildings);
		returnList.addAll(constructionBuildings);
		return returnList;
	}
	public void addBuilding(Building b){
		constructionBuildings.add(b);
		b.setIsland(this);
	}
	public void finishBuilding(Building b){
		constructionBuildings.remove(b);
		finishedBuildings.add(b);
	}
	public ArrayList<Storage> getStorages(){
		ArrayList<Storage> storages = new ArrayList<Storage>();
		for (Iterator<Building> iterator = finishedBuildings.iterator(); iterator.hasNext();) {
			Building building = (Building) iterator.next();
			storages.add(building.getStorage());
		}
		return storages;
	}
	public ArrayList<Building> getBuildingsInConstruction(){
		return constructionBuildings;
	}
	public ArrayList<Building> getBuildingsFinished(){
//		return (ArrayList<Building>) finishedBuildings.stream() 
//				.filter(p -> p.getBuildingStatus().equals(BuildingStatus.FINISHED))
//				.collect(Collectors.toList());
		return finishedBuildings;
	}
	public ArrayList<TransportTask> getTransportsToCreateBuilding(int possibleAmount){
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
					TransportTask newTask;
					if(neededRessource.getValue()< buildingWithRessource.getValue()){
						transportableAmount = neededRessource.getValue();
					} else {
						transportableAmount = buildingWithRessource.getValue();
					}
					
					if(transportableAmount >= possibleAmount){
						newTask = new TransportTask(buildingWithRessource.getKey(), building, neededRessource.getKey(), possibleAmount);
						returnList.add(0, newTask);
						return returnList;
					} else {
						newTask = new TransportTask(buildingWithRessource.getKey(), building, neededRessource.getKey(), transportableAmount);
					}
					returnList.add(newTask);
				}
			}
		}
		Collections.sort(returnList);
		return returnList;
	}
	public ArrayList<TransportTask> getTransportsFromProductionBuildings(int possibleAmount, int threshhold){
		ArrayList<TransportTask> returnList = new ArrayList<TransportTask>(); 
		//every building that produces ressources
		for (Building productionBuilding : getProductionBuildings()) {
			if(productionBuilding.getStorage().getAvailableStorageForProducedRessource() <= threshhold &&
					productionBuilding.getStorage().getAmountOfProducedRessource() > 0 ){
				RessourceType producedRessource = productionBuilding.getStorage().getProducedRessource();
				int availableAmountForTransport = productionBuilding.getStorage().getAmountOfProducedRessource();
				if(availableAmountForTransport > possibleAmount){
					availableAmountForTransport = possibleAmount;
				}
				for (Building storageBuilding : getStorageBuildings()) {
					int spaceForRessource = storageBuilding.getStorage().getSpaceForRessource(producedRessource);
					TransportTask newTask = null;
					if(spaceForRessource >= availableAmountForTransport){
						newTask = new TransportTask(productionBuilding, storageBuilding, producedRessource, availableAmountForTransport);
						returnList.add(0, newTask);
						return returnList;
					} else if(spaceForRessource > 0){
						newTask = new TransportTask(productionBuilding, storageBuilding, producedRessource, spaceForRessource);
						returnList.add(newTask);
					}
				}
			}
		}
		Collections.sort(returnList);
		return returnList;
	}

	protected ArrayList<Building> getProductionBuildings() {
		ArrayList<Building> productionBuildings = (ArrayList<Building>) getBuildingsFinished().stream().
				filter(building -> building.getStorage().getProducedRessource() != null).collect(Collectors.toList());
		return productionBuildings;
	}

	protected ArrayList<Building> getStorageBuildings() {
		ArrayList<Building> storageBuildings = (ArrayList<Building>) getBuildingsFinished().stream().
				filter(building -> building.getType() == BuildingType.STORAGE).collect(Collectors.toList());
		return storageBuildings;
	}
	public TransportTask getTransportTask(int possibleAmount){
		int threshholdForProductionTransports = 1;
		ArrayList<TransportTask> tasks = getTransportsFromProductionBuildings(possibleAmount, threshholdForProductionTransports);
		if(tasks.size() > 0){
			return tasks.get(0);
		} else {
			tasks = getTransportsToCreateBuilding(possibleAmount);
			if(tasks.size() > 0){
				return tasks.get(0);
			} else {
				while(tasks.size() <= 0 && threshholdForProductionTransports <= 10){
					threshholdForProductionTransports++;
					tasks = getTransportsFromProductionBuildings(possibleAmount, threshholdForProductionTransports);
				}
				if(tasks.size()>0){
					return tasks.get(0);
				}
			}
		}
		return null;
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
