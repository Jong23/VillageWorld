package Test.TestHelper;

import Buildings.WorkingBuilding;
import Enums.BuildingStatus;
import Enums.BuildingType;

public class TestBuilding extends WorkingBuilding {
	int counter = 0;
	public TestBuilding() {
		super(0,0,BuildingType.LUMBERER);
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

	@Override
	protected void beforeWorkStarts() {
		//do nothing
	}
}
