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
import Game.TransportTask;

public class tIsland {
	Island island;
	StorageBuilding storageBuilding;
	Lumberer lumberer;
	private void setup(){
		island = new Island();
		storageBuilding = new StorageBuilding(0, 0);
		island.addBuilding(storageBuilding);
		storageBuilding.finishConstruction();
		storageBuilding.getStorage().addRessource(RessourceType.WOOD, 100);
		storageBuilding.getStorage().addRessource(RessourceType.STONE, 100);
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
		ArrayList<TransportTask> transportTasksForConstruction = island.getTransportsToCreateBuilding(100);
		// Stone to lumberer from Storage
		// WOOD to lumberer from Storage
		// WOOD to lumberer from finishedLumberer
		assertEquals(3, transportTasksForConstruction.size());
		assertTrue(transportTasksForConstruction.get(0).getAmount()>=transportTasksForConstruction.get(1).getAmount());
		assertTrue(transportTasksForConstruction.get(1).getAmount()>=transportTasksForConstruction.get(2).getAmount());
		assertSame(storageBuilding, transportTasksForConstruction.get(0).getFrom());
		assertSame(lumbererInConstruction, transportTasksForConstruction.get(0).getTo());
		
		//transportTasks to that building with max capacity 15
		transportTasksForConstruction = island.getTransportsToCreateBuilding(15);
		// Stone to lumberer from Storage (10)
		// WOOD to lumberer from Storage (20)
		// WOOD to lumberer from finishedLumberer (1)
		assertTrue(transportTasksForConstruction.get(0).getAmount() == 15);
		assertSame(storageBuilding, transportTasksForConstruction.get(0).getFrom());
		assertSame(lumbererInConstruction, transportTasksForConstruction.get(0).getTo());
		
		
		//finishedLumberer has 1 Wood and 4 Space left for Wood
		storageBuilding.getStorage().removeRessource(RessourceType.WOOD, 20);
		ArrayList<TransportTask> transportsFromProduction = island.getTransportsFromProductionBuildings(5, 1);
		assertEquals(0, transportsFromProduction.size());
		lumberer.produce();
		lumberer.produce();
		//lumberer has now 3 Wood
		transportsFromProduction = island.getTransportsFromProductionBuildings(5, 2);
		assertEquals(1, transportsFromProduction.size());
		TransportTask taskForProduction = transportsFromProduction.get(0);
		assertSame(storageBuilding, taskForProduction.getTo());
		assertSame(lumberer, taskForProduction.getFrom());
		assertEquals(3, taskForProduction.getAmount());
		
	}

}
