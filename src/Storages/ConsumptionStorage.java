package Storages;

import java.util.ArrayList;
import java.util.Arrays;

import Enums.RessourceType;

public class ConsumptionStorage extends Storage {

	//storage that consumes some ressources
	public ConsumptionStorage(int size, RessourceType [] neededRessources){
		super(size);
		neededRessourcesForProduction = new ArrayList<RessourceType> (Arrays.asList(neededRessources));
		for (int i = 0; i < neededRessources.length; i++) {
			ressources.put(neededRessources[i], 0);
			comingRessources.put(neededRessources[i], 0);
			reservedRessources.put(neededRessources[i], 0);
		}
	}

}
