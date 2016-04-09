package Test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

import Buildings.Building;
import Buildings.Lumberer;
import Buildings.StorageBuilding;
import Enums.BuildingType;
import Enums.RessourceType;
import Game.Island;
import Game.Storage;
import Game.TransportTask;

public class tIsland {
	Island island;
	StorageBuilding storageBuilding;
	Lumberer lumberer;
	private void setup(){
		island = new Island();
		storageBuilding = new StorageBuilding(0, 0);
		storageBuilding.finishConstruction();
		storageBuilding.addRessource(RessourceType.WOOD, 100);
		storageBuilding.addRessource(RessourceType.STONE, 100);
		island.addBuilding(storageBuilding);
		lumberer = new Lumberer(0, 0);
		island.addBuilding(lumberer);
		lumberer.finishConstruction();
		lumberer.produce(); //adds 1 WOOD
		
	}
	
	@Test
	public void test() {
		setup();
		
		//finished Buildings
		assertEquals(2, island.getBuildingsFinished().size());
		
		//total ressources
		HashMap<Building, Integer> buildingsWithWood = island.getBuildingsWithRessource(RessourceType.WOOD);
		assertEquals(2, buildingsWithWood.size());
		for(Entry<Building, Integer> entry : buildingsWithWood.entrySet()){
			if(entry.getKey().getType() == BuildingType.STORAGE){
				assertEquals(new Integer(100), entry.getValue());
			} else if (entry.getKey().getType() == BuildingType.LUMBERER){
				assertEquals(new Integer(1), entry.getValue());
			} else {
				assert(false);
			}
		}
		
		Lumberer lumbererInConstruction = new Lumberer(0, 0);
		island.addBuilding(lumbererInConstruction);
		assertEquals(3, island.getBuildings().size());
		
		//buildings In Construction
		ArrayList<Building> buildingsInConstruction = island.getBuildingsInConstruction();
		assertEquals(1, buildingsInConstruction.size());
		
		//transportTasks to that building
		ArrayList<TransportTask> transportTasksForConstruction = island.getTransportsToCreateBuilding();
		// Stone to lumberer from Storage
		// WOOD to lumberer from Storage
		// WOOD to lumberer from finishedLumberer
		assertEquals(3, transportTasksForConstruction.size());
		transportTasksForConstruction.get(0);
		assertTrue(transportTasksForConstruction.get(0).getAmount()>=transportTasksForConstruction.get(1).getAmount());
		assertTrue(transportTasksForConstruction.get(1).getAmount()>=transportTasksForConstruction.get(2).getAmount());
		assertSame(storageBuilding, transportTasksForConstruction.get(0).getFrom());
		assertSame(lumbererInConstruction, transportTasksForConstruction.get(0).getTo());
		
	}

}
