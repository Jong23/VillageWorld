package Storages;

import Enums.RessourceType;

public class StandardStorage extends Storage {
	//storage that stores every Ressource

	public StandardStorage(int size){
	super(size);
	for (RessourceType ressourceType : RessourceType.values()) {
		ressources.put(ressourceType, 0);
		comingRessources.put(ressourceType, 0);
		reservedRessources.put(ressourceType, 0);
	}
}
}
