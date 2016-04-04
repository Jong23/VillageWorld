package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Buildings.Lumberer;
import Enums.RessourceType;

public class tLumberer {

	@Test
	public void test() {
		Lumberer lumberer = new Lumberer(0, 0);
		RessourceType type = RessourceType.WOOD;
		
		//initial Storage
		assertEquals(0, lumberer.getStorage().getAmountOfRessource(type));
		//produce
		lumberer.produce();
		assertEquals(1, lumberer.getStorage().getAmountOfRessource(type));		
	}

}
