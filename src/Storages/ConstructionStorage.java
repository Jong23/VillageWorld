package Storages;

import Enums.RessourceType;

public class ConstructionStorage extends Storage{

	//storage for buildings in construction
	public ConstructionStorage(int size, RessourceType [] neededRessources, int [] amountOfRessource){
		super(size);
		for (int i = 0; i < neededRessources.length; i++) {
			ressources.put(neededRessources[i], -amountOfRessource[i]);
			comingRessources.put(neededRessources[i], 0);
		}
	}
}
