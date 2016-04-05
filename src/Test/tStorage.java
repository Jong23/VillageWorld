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
		
	}

}
