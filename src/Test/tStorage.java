package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Enums.RessourceType;
import Game.Storage;

public class tStorage {

	@Test
	public void test() {
		Storage storage = new Storage(100);
		RessourceType type = RessourceType.WOOD;
		//initial
		assertEquals(0, storage.getAmountOfRessource(type));
		
		//add
		storage.addRessource(type, 5);
		assertEquals(5, storage.getAmountOfRessource(type));
		
		
		//remove 
		storage.removeRessource(type, 3);
		assertEquals(2, storage.getAmountOfRessource(type));
		
		
		//isFull
		storage = new Storage(0);
		assertTrue(storage.isFull());
		
		storage = new Storage(5, new RessourceType [] {RessourceType.WOOD});
		assertFalse(storage.isFull());
		storage.addRessource(RessourceType.WOOD, 5);
		assertTrue(storage.isFull());
		
		// creation of Storage with needed ressources (construction)
		storage = new Storage(5, new RessourceType [] {RessourceType.WOOD}, new int []{10});
		assertEquals(-10, (storage.getAmountOfRessource(RessourceType.WOOD)));
	}

}
