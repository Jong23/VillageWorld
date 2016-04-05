package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl;

import Buildings.ProducingBuilding;
import Enums.RessourceType;
import Game.Storage;

public class tProducingBuilding {

	@Test
	public void test() {
		int productionTime = 100;
		class TestBuilding extends ProducingBuilding {
			int counter = 0;
			public TestBuilding() {
				super(0,0,0,0,null,productionTime,null);
			}
			
			@Override
			public void produce() {
				counter ++;
			}
			public void resetCounter(){
				counter = 0;
			}
			
		}
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
			Thread.sleep(10*productionTime - 20);
			building.stopWork();
			Thread.sleep(50);
			assertEquals(0, building.counter); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// test working with 1 workers
		building.addWorker();
		building.startWork();
		try {
			Thread.sleep(10*productionTime - 20);
			building.stopWork();
			Thread.sleep(50);
			assertEquals(10, building.counter); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// test working with 2 workers
		building.resetCounter();
		building.addWorker();
		building.startWork();
		try {
			Thread.sleep(10*productionTime - 20);
			building.stopWork();
			Thread.sleep(50);
			assertEquals(20, building.counter); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test starting work with adding worker
		building.removeWorker();
		building.removeWorker();
		assertEquals(0, building.getWorkerCount());
		building.resetCounter();
		building.startWork();
		try {
			Thread.sleep(10*productionTime + 10);
			building.addWorker();
			Thread.sleep(10*productionTime - 20);
			building.stopWork();
			Thread.sleep(50);
			assertEquals(10, building.counter); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
