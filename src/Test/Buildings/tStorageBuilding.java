package Test.Buildings;
import java.util.ArrayList;

import org.junit.Test;

import Buildings.Lumberer;
import Buildings.StorageBuilding;
import Enums.BuildingStatus;
import Enums.RessourceType;
import Game.Island;
import Game.TransportTask;
import static org.junit.Assert.*;

public class tStorageBuilding {


	@Test
	public void test() {
		Island island = new Island();
		StorageBuilding storageBuilding = new StorageBuilding(0, 0);
		island.addBuilding(storageBuilding);
		storageBuilding.setIsland(island);
		storageBuilding.finishConstruction();
		storageBuilding.getStorage().addRessource(RessourceType.WOOD, 100);
		storageBuilding.getStorage().addRessource(RessourceType.STONE, 100);
		storageBuilding.setWorkerSpeed(10);
		storageBuilding.addWorker();
		storageBuilding.addWorker();
		storageBuilding.startWork();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// No Exception for 3 seconds
			e.printStackTrace();
		}
		Lumberer lumberer = new Lumberer(0,0);
		island.addBuilding(lumberer);
		System.out.println("Lumberer added");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// No Exception for 3 seconds
			e.printStackTrace();
		}
		storageBuilding.stopWork();
		assertTrue(lumberer.getBuildingStatus() == BuildingStatus.FINISHED);
	}
}
