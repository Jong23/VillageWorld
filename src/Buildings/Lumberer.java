package Buildings;

import java.util.Date;

import Enums.RessourceType;
import Game.Storage;

public class Lumberer extends ProducingBuilding {
	private static int baseProductionTime = 5000;
	public Lumberer(int x, int y) {
		super(x, y, 2, 3, RessourceType.WOOD, baseProductionTime, new Storage(5));
	}

	@Override
	public void produce() {
		storage.addRessource(type, 1);
	}

}
