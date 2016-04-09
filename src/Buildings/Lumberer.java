package Buildings;


import Enums.BuildingType;
import Enums.RessourceType;
import Game.Storage;

public class Lumberer extends ProducingBuilding {
	RessourceType type = RessourceType.WOOD;
	public Lumberer(int x, int y) {
		super(x,y,BuildingType.Lumberer, new Storage(5));
	}

	@Override
	public void produce() {
		storage.addRessource(type, 1);
	}

}
