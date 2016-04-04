package Test;


import static org.junit.Assert.*;

import org.junit.Test;

import Buildings.Lumberer;
import Game.Island;

public class tIsland {
	Island island;
	private void setup(){
		island = new Island();
	}
	
	@Test
	public void test() {
		setup();
		island.addBuilding(new Lumberer(0, 0));
		assertEquals(1, island.getBuildings().size());
	}

}
