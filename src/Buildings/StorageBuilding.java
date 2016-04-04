package Buildings;

import Game.Storage;

public class StorageBuilding extends Building {
	private static final int height = 4;
	private static final int width = 3;
	

	public StorageBuilding(int x, int y) {
		super(x, y, width, height, new Storage(100));
	}
	

}
