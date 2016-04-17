package Buildings;


import Enums.BuildingType;
import Enums.RessourceType;
import Storages.ProductionStorage;
import Storages.Storage;

public class Lumberer extends WorkingBuilding {
	RessourceType type = RessourceType.WOOD;
	public Lumberer(int x, int y) {
		super(x,y,BuildingType.LUMBERER);
	}

	@Override
	public void produce() {
		storage.addRessource(type, 1);
	}

	@Override
	protected Storage getFinalStorage() {
		return new ProductionStorage(5, type);
	}

}
