package Game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import Enums.RessourceType;

public class Storage {
	int size; 
	HashMap<RessourceType, Integer> ressources;
	ArrayList<RessourceType> neededRessourcesForProduction;
	//storage that stores every Ressource
	public Storage(int size){
		initialize(size);
		for (RessourceType ressourceType : RessourceType.values()) {
			ressources.put(ressourceType, 0);
		}
	}
	//storage that consumes some ressources
	public Storage(int size, RessourceType [] neededRessources){
		initialize(size);
		neededRessourcesForProduction = new ArrayList<RessourceType> (Arrays.asList(neededRessources));
		for (int i = 0; i < neededRessources.length; i++) {
			ressources.put(neededRessources[i], 0);
		}
	}
	// storage that consumes ressources and produces a ressource
	public Storage(int size, RessourceType [] neededRessources, RessourceType producedRessource){
		initialize(size);
		neededRessourcesForProduction = new ArrayList<RessourceType> (Arrays.asList(neededRessources));
		for (int i = 0; i < neededRessources.length; i++) {
			ressources.put(neededRessources[i], 0);
		}
		ressources.put(producedRessource, 0);
	}
	//storage for buildings in construction
	public Storage(int size, RessourceType [] neededRessources, int [] amountOfRessource){
		initialize(size);
		for (int i = 0; i < neededRessources.length; i++) {
			ressources.put(neededRessources[i], -amountOfRessource[i]);
		}
	}
	private void initialize(int size) {
		neededRessourcesForProduction = new ArrayList<RessourceType>();
		ressources = new HashMap<>();
		this.size = size;
	}
	// returns only complete ressources
	public int getAmountOfRessource(RessourceType type){
		return ressources.get(type);
	}
	public void addRessource(RessourceType type, int amount){
		int currentAmount = ressources.get(type);
		ressources.put(type, currentAmount + amount);
	}
	public void removeRessource(RessourceType type, int amount){
		addRessource(type, -amount);
	}
	public boolean isFull(){
		for(Entry<RessourceType, Integer> ressource : ressources.entrySet()){
			if(ressource.getValue()<size){
				return false;
			}
		}
		return true;
	}
	public HashMap<RessourceType, Integer> getNeededRessourcesForConstruction(){
		HashMap<RessourceType, Integer> neededRessources = new HashMap<RessourceType, Integer>();
		for(Entry<RessourceType, Integer> ressource : ressources.entrySet()){
			if(ressource.getValue()<0){
				neededRessources.put(ressource.getKey(), -ressource.getValue());
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
		}else{
			return getAmountOfRessource(type);
		}
	}
}
