package Storages;

import Enums.RessourceType;

public class ProductionStorage extends Storage {

	//storage that produces one ressource
	public ProductionStorage(int size, RessourceType producedRessource){
		super(size);
		this.producedRessource = producedRessource;
		ressources.put(producedRessource, 0);
		reservedRessources.put(producedRessource, 0);
		comingRessources.put(producedRessource, 0);
	}

}
