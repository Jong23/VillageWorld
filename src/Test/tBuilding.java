package Test;

import org.junit.Test;

import Game.Building;
import Game.BuildingType;
import Game.Lumberer;

public class tBuilding {
	Building building;
	private void setup(){
		building = new Lumberer(5, 5);
	}
	@Test
	public void test() {
		setup();
		
		constructor();
		
		moveBuilding();
	}
	private void constructor() {
		assertEquals(BuildingType.LUMBERER.width, building.getWidth());
		assertEquals(BuildingType.LUMBERER.height, building.getHeight());
		assertEquals(5, building.getX());
		assertEquals(5, building.getY());
	}
	private void moveBuilding(){
		building.move(1, 2);
		assertEquals(1, building.getX());
		assertEquals(2, building.getY());
	}

}
