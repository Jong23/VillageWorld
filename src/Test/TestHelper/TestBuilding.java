package Test.TestHelper;

import Buildings.Lumberer;
import Buildings.WorkingBuilding;
import Enums.BuildingStatus;
import Enums.BuildingType;
import Storages.Storage;

public class TestBuilding extends Lumberer {
	int counter = 0;
	public TestBuilding() {
		super(0,0);
		setBuildingStatus(BuildingStatus.FINISHED);
	}
	
	@Override
	public void produce() {
		counter ++;
	}
	public void resetCounter(){
		counter = 0;
	}

	public int getCounter() {
		return counter;
	}

}
