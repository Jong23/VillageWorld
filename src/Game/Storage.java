package Game;


import java.util.HashMap;
import java.util.Map.Entry;

import Enums.RessourceType;

public class Storage {
	int size; 
	HashMap<RessourceType, Integer> ressources;
	// Standard Storage, needs everything
	public Storage(int size){
		initialize(size);
		for (RessourceType ressourceType : RessourceType.values()) {
			ressources.put(ressourceType, 0);
		}
	}
	public Storage(int size, RessourceType [] neeededRessources){
		initialize(size);
		for (int i = 0; i < neeededRessources.length; i++) {
			ressources.put(neeededRessources[i], 0);
		}
	}
	public Storage(int size, RessourceType [] neeededRessources, int [] amountOfRessource){
		initialize(size);
		for (int i = 0; i < neeededRessources.length; i++) {
			ressources.put(neeededRessources[i], -amountOfRessource[i]);
		}
	}
	private void initialize(int size) {
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
//	// Storage that needs 1 ressource (producing )
//	public Storage(int size, RessourceType neededRessource) {
//		scheduler = new RessourceScheduler();
//	}
//	public void addProducer( b) {
//		scheduler.addProducer(b);
//		
//	}
}
