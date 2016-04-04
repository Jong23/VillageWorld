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
			
		}

		TestBuilding building = new TestBuilding();
		building.startWork();
		try {
			Thread.sleep(10*productionTime + 10);
			building.stopWork();
			assertEquals(10, building.counter); //produce called 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
