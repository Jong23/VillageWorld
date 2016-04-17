package Storages;

import java.util.ArrayList;
import java.util.Arrays;

import Enums.RessourceType;

public class ProductionConsumptionStorage extends Storage {

	// storage that consumes ressources and produces a ressource
	public ProductionConsumptionStorage(int size, RessourceType [] neededRessources, RessourceType producedRessource) {
		super(size);
		neededRessourcesForProduction = new ArrayList<RessourceType> (Arrays.asList(neededRessources));
		for (int i = 0; i < neededRessources.length; i++) {
			ressources.put(neededRessources[i], 0);
			comingRessources.put(neededRessources[i], 0);
		}
		ressources.put(producedRessource, 0);
		reservedRessources.put(producedRessource, 0);
	}

}
