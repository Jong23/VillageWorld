package Buildings;


import Enums.BuildingType;
import Enums.RessourceType;
import Game.Storage;

public class Lumberer extends ProducingBuilding {
	RessourceType type = RessourceType.WOOD;
	public Lumberer(int x, int y) {
		super(x,y,BuildingType.Lumberer);
	}

	@Override
	public void produce() {
		addRessource(type, 1);
	}

}
