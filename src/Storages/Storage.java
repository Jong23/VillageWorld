package Storages;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import Buildings.Building;
import Enums.BuildingStatus;
import Enums.RessourceType;

public abstract class Storage {
	protected int size; 
	protected HashMap<RessourceType, Integer> ressources;
	protected HashMap<RessourceType, Integer> reservedRessources;
	protected HashMap<RessourceType, Integer> comingRessources;
	protected ArrayList<RessourceType> neededRessourcesForProduction;
	protected RessourceType producedRessource;
	
	protected Building building;

	public RessourceType getProducedRessource() {
		return producedRessource;
	}
	public void setProducedRessource(RessourceType producedRessource) {
		this.producedRessource = producedRessource;
	}
	protected  Storage(int size) {
		neededRessourcesForProduction = new ArrayList<RessourceType>();
		ressources = new HashMap<>();
		comingRessources = new HashMap<>();
		reservedRessources = new HashMap<>();
		this.size = size;
	}
	public int getAmountOfRessource(RessourceType type){
		return ressources.get(type);
	}
	public void addRessource(RessourceType type, int amount){
		int currentAmount = ressources.get(type);
		ressources.put(type, currentAmount + amount);
		testBuildingFinished();
	}
	public void removeRessource(RessourceType type, int amount){
		addRessource(type, -amount);
	}
	public boolean isFull(){
		for(Entry<RessourceType, Integer> ressource : ressources.entrySet()){
			if(ressource.getValue() + comingRessources.get(ressource.getKey()) < size){
				return false;
			}
		}
		return true;
	}
	public HashMap<RessourceType, Integer> getNeededRessourcesForConstruction(){
		HashMap<RessourceType, Integer> neededRessources = new HashMap<RessourceType, Integer>();
		for(Entry<RessourceType, Integer> ressource : ressources.entrySet()){
			int neededAmount = ressource.getValue() + comingRessources.get(ressource.getKey());
			if(neededAmount < 0){
				neededRessources.put(ressource.getKey(), -neededAmount);
			}
		}
		return neededRessources;
	}
	public HashMap<RessourceType, Integer> getNeededRessourcesForProduction(){
		HashMap<RessourceType, Integer> neededRessources = new HashMap<RessourceType, Integer>();
		for(Entry<RessourceType, Integer> ressource : ressources.entrySet()){
//			if(ressource.getValue()<0){
//				neededRessources.put(ressource.getKey(), -ressource.getValue());
//			}
		}
		//empty Hashmap now
		return neededRessources;
	}
	public int getAvailableAmountOfRessource(RessourceType type) {
		if(neededRessourcesForProduction.contains(type)){
			return 0;
		}else if (producedRessource != null && producedRessource != type){
			return 0;
		} else {
			return ressources.get(type) - reservedRessources.get(type);
		}
	}
	public void reserveRessource(RessourceType type, int amount){
		int currentAmount = reservedRessources.get(type);
		reservedRessources.put(type, currentAmount + amount);
	}
	public void takeReservedRessource(RessourceType type, int amount){
		reservedRessources.put(type, reservedRessources.get(type) - amount);
		ressources.put(type, ressources.get(type) - amount);
	}
	
	public void reserveComingRessource(RessourceType type, int amount){
		int currentAmount = comingRessources.get(type);
		comingRessources.put(type, currentAmount + amount);
	}
	public void deliverComingRessource(RessourceType type, int amount){
		comingRessources.put(type, comingRessources.get(type) - amount);
		ressources.put(type, ressources.get(type) + amount);
		testBuildingFinished();
	}
	public int getSpaceForRessource(RessourceType type){
		return size - ressources.get(type) - comingRessources.get(type);
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	private void testBuildingFinished(){
		if(building != null && building.getBuildingStatus() == BuildingStatus.INCONSTRUCTION){
			for(Entry<RessourceType, Integer> ressource : ressources.entrySet()){
				if(ressource.getValue() < 0){
					return;
				}
			}
			building.finishConstruction();
		}
	}
	public int getAmountOfProducedRessource(){
		return getAmountOfRessource(producedRessource);
	}
	public int getAvailableStorageForProducedRessource(){
		return size-getAmountOfRessource(producedRessource);
	}
}
