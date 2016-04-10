package Test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Enums.RessourceType;
import Game.Storage;

public class tStorage {
	Storage storage = new Storage(100);
	RessourceType type = RessourceType.WOOD;

	@Test
	public void test() {
		ressourceAddingRemoving();
		
		
		
		isFull();
		
		
		
		// creation of Storage with needed ressources (construction)
		storage = new Storage(5, new RessourceType [] {RessourceType.WOOD}, new int []{10});
		assertEquals(-10, (storage.getAmountOfRessource(RessourceType.WOOD)));
		HashMap<RessourceType, Integer> neededRessources = storage.getNeededRessourcesForConstruction();
		assertEquals(1, neededRessources.size());
		assertEquals(new Integer(10), neededRessources.get(RessourceType.WOOD));
		//deliver 2 wood
		storage.addRessource(type, 2);
		neededRessources = storage.getNeededRessourcesForConstruction();
		assertEquals(1, neededRessources.size());
		assertEquals(new Integer(8), neededRessources.get(RessourceType.WOOD));
		// sent 2 ressources (not yet delivered)
		storage.reserveComingRessource(type, 2);
		neededRessources = storage.getNeededRessourcesForConstruction();
		assertEquals(1, neededRessources.size());
		assertEquals(new Integer(6), neededRessources.get(RessourceType.WOOD));
		
		
		
		//building that needs ressources for production
		storage = new Storage(5, new RessourceType [] {RessourceType.STONE}, RessourceType.WOOD);
		storage.addRessource(RessourceType.WOOD, 5);
		storage.addRessource(RessourceType.STONE, 5);
		assertEquals(5, storage.getAvailableAmountOfRessource(RessourceType.WOOD));
		assertEquals(0, storage.getAvailableAmountOfRessource(RessourceType.STONE));
	
	}

	protected void ressourceAddingRemoving() {
		//initial
		assertEquals(0, storage.getAmountOfRessource(type));
		assertEquals(0, storage.getAvailableAmountOfRessource(type));
		assertEquals(100, storage.getSpaceForRessource(type));
		
		//add
		storage.addRessource(type, 5);
		assertEquals(5, storage.getAmountOfRessource(type));
		assertEquals(5, storage.getAvailableAmountOfRessource(type));
		assertEquals(95, storage.getSpaceForRessource(type));
		
		
		//remove 
		storage.removeRessource(type, 3);
		assertEquals(2, storage.getAmountOfRessource(type));
		assertEquals(2, storage.getAvailableAmountOfRessource(type));
		assertEquals(98, storage.getSpaceForRessource(type));
		
		//reserved Ressources
		storage.reserveRessource(type, 1);
		assertEquals(2, storage.getAmountOfRessource(type));
		assertEquals(1, storage.getAvailableAmountOfRessource(type));
		assertEquals(98, storage.getSpaceForRessource(type));
		
		//take reservedRessource
		storage.takeReservedRessource(type, 1);
		assertEquals(1, storage.getAmountOfRessource(type));
		assertEquals(1, storage.getAvailableAmountOfRessource(type));
		assertEquals(99, storage.getSpaceForRessource(type));
		
		
		//coming Ressources
		storage.reserveComingRessource(type, 4);
		assertEquals(1, storage.getAmountOfRessource(type));
		assertEquals(1, storage.getAvailableAmountOfRessource(type));
		assertEquals(95, storage.getSpaceForRessource(type));
		
		//deliver Ressource
		storage.deliverComingRessource(type, 4);
		assertEquals(5, storage.getAmountOfRessource(type));
		assertEquals(5, storage.getAvailableAmountOfRessource(type));
		assertEquals(95, storage.getSpaceForRessource(type));
	}

	protected void isFull() {
		storage = new Storage(0);
		assertTrue(storage.isFull());
		
		storage = new Storage(5, new RessourceType [] {RessourceType.WOOD});
		assertFalse(storage.isFull());
		storage.addRessource(RessourceType.WOOD, 5);
		assertTrue(storage.isFull());
		storage.removeRessource(type, 5);
		//full when ressources are coming
		assertFalse(storage.isFull());
		storage.reserveComingRessource(RessourceType.WOOD, 5);
		assertTrue(storage.isFull());
		//full when ressources are delivered
		storage.deliverComingRessource(type, 5);
		assertTrue(storage.isFull());
		
		storage = new Storage(5, RessourceType.WOOD);
		assertFalse(storage.isFull());
		storage.addRessource(type, 5);
		assertTrue(storage.isFull());
		//full when ressources are reserved
		storage.reserveRessource(type, 5);
		assertTrue(storage.isFull());
		//not full when reserved ressources are taken
		storage.takeReservedRessource(type, 5);
		assertFalse(storage.isFull());
	}

}
