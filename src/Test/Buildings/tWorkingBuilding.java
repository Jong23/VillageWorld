package Test.Buildings;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl;

import Buildings.WorkingBuilding;
import Enums.BuildingStatus;
import Enums.BuildingType;
import Enums.RessourceType;
import Game.Storage;
import Test.TestHelper.TestBuilding;
import helpers.Clock;

public class tWorkingBuilding {

	@Test 
	public void test() {
		int productionTime = 199;
		BuildingType.LUMBERER.setBaseProductionTime(productionTime);
		TestBuilding building = new TestBuilding();
		//adding/removing workers
		assertEquals(0, building.getWorkerCount());
		building.setMaxWorkers(2);
		building.addWorker();
		assertEquals(1, building.getWorkerCount());
		building.addWorker();
		assertEquals(2, building.getWorkerCount());
		building.addWorker();
		assertEquals(2, building.getWorkerCount());
		building.removeWorker();
		assertEquals(1, building.getWorkerCount());
		building.removeWorker();
		assertEquals(0, building.getWorkerCount());
		building.removeWorker();
		assertEquals(0, building.getWorkerCount());

		
		// test working with 0 workers
		building.startWork();
		try {
			Thread.sleep(5*productionTime + 50);
			building.stopWork();
			assertEquals(0, building.getCounter()); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// test working with 1 workers
		building.addWorker();
		building.startWork();
		try {
			Thread.sleep(5*productionTime + 50);
			building.stopWork();
			assertEquals(5, building.getCounter()); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// test working with 2 workers
		building.resetCounter();
		building.addWorker();
		building.startWork();
		try {
			Thread.sleep(5*productionTime + 100);
			building.stopWork();
			assertEquals(10, building.getCounter()); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test starting work with adding worker
		building.removeWorker();
		building.removeWorker();
		assertEquals(0, building.getWorkerCount());
		building.resetCounter();
		assertEquals(0, building.getCounter()); 
		building.startWork();
		try {
			Thread.sleep(5*productionTime + 50);
			assertEquals(0, building.getCounter()); 
			building.addWorker();
			Thread.sleep(5*productionTime + 50);
			building.stopWork();
			assertEquals(5, building.getCounter()); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test with clock
		building = new TestBuilding();
		Clock.getInstance().setSpeed(2);
		building.addWorker();
		building.startWork();
		try {
			Thread.sleep(5*productionTime + 50);
			building.stopWork();
			assertEquals(10, building.getCounter()); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clock.getInstance().setSpeed(1);
	}

}
