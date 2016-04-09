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
		TestBuilding from = new TestBuilding();
		TestBuilding to = new TestBuilding();
		TransportTask task = new TransportTask(from, to, RessourceType.WOOD, 5);
		assertSame(from, task.getFrom());
		assertSame(to, task.getTo());
		assertEquals(RessourceType.WOOD, task.getRessource());
		assertEquals(5, task.getAmount());
	}
}
