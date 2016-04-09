package Test;

import static org.junit.Assert.*;

import java.util.HashMap;

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
		assertEquals(5, storage.getAvailableAmountOfRessource(type));
		
		
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
		HashMap<RessourceType, Integer> neededRessources = storage.getNeededRessourcesForConstruction();
		assertEquals(1, neededRessources.size());
		assertEquals(new Integer(10), neededRessources.get(RessourceType.WOOD));
		
		//building that needs ressources for production
		storage = new Storage(5, new RessourceType [] {RessourceType.STONE}, RessourceType.WOOD);
		storage.addRessource(RessourceType.WOOD, 5);
		storage.addRessource(RessourceType.STONE, 5);
		assertEquals(5, storage.getAvailableAmountOfRessource(RessourceType.WOOD));
		assertEquals(0, storage.getAvailableAmountOfRessource(RessourceType.STONE));
	
	}

}
