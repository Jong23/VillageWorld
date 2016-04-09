package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Buildings.Building;
import Buildings.Lumberer;
import Enums.BuildingStatus;
import Enums.BuildingType;

public class tBuilding {

	@Test
	public void test() {
		Building building = new Lumberer(0, 0);
		assertEquals(BuildingStatus.INCONSTRUCTION, building.getBuildingStatus());
		
		for (int i = 0; i < BuildingType.LUMBERER.getNeededRessources().length; i++) {
			building.addRessource(BuildingType.LUMBERER.getNeededRessources()[i], BuildingType.LUMBERER.getAmountOfRessources()[i]);
		}
		
		assertEquals(BuildingStatus.FINISHED, building.getBuildingStatus());
	}

}
