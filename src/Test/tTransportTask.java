package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import Enums.RessourceType;
import Game.TransportTask;
import Test.TestHelper.TestBuilding;

public class tTransportTask {
	@Test
	public void test() {
		RessourceType type = RessourceType.WOOD;
		TestBuilding from = new TestBuilding();
		from.finishConstruction();
		TestBuilding to = new TestBuilding();
		TransportTask task = new TransportTask(from, to, type, 5);
		assertSame(from, task.getFrom());
		assertSame(to, task.getTo());
		assertEquals(type, task.getRessource());
		assertEquals(5, task.getAmount());
		
		
		int neededWood = to.getStorage().getNeededRessourcesForConstruction().get(type);
		task.startTransport();
		assertEquals(-5, from.getStorage().getAvailableAmountOfRessource(type));
		assertEquals(new Integer(neededWood - 5), to.getStorage().getNeededRessourcesForConstruction().get(type));

		task.finishTransport();
		assertEquals(-5, from.getStorage().getAmountOfRessource(type));
		assertEquals(-(neededWood - 5), to.getStorage().getAmountOfRessource(type));
	}
}
