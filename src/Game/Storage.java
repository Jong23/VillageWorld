package Game;


import java.util.HashMap;

import Enums.RessourceType;

public class Storage {
	int size; 
	HashMap<RessourceType, Integer> ressources;
	// Standard Storage, needs everything
	public Storage(int size){
		ressources = new HashMap<>();
		for (RessourceType ressourceType : RessourceType.values()) {
			ressources.put(ressourceType, 0);
		}
		this.size = size;
	}
	// returns only complete ressources
	public int getAmountOfRessource(RessourceType type){
		return (int)ressources.get(type).doubleValue();
	}
	public void addRessource(RessourceType type, int amount){
		int currentAmount = ressources.get(type);
		ressources.put(type, currentAmount + amount);
	}
	public void removeRessource(RessourceType type, int amount){
		addRessource(type, -amount);
	}
//	// Storage that needs 1 ressource (producing building)
//	public Storage(int size, RessourceType neededRessource) {
//		scheduler = new RessourceScheduler();
//	}
//	public void addProducer(Building b) {
//		scheduler.addProducer(b);
//		
//	}
}
