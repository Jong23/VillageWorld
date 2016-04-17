package Game;

import java.util.Scanner;

import Enums.RessourceType;

public class Main {

	public static void main(String[] args) {
		Island i = new Island();
		BuildingFactory factory = new BuildingFactory(i);
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
		while(nextLine != "Exit"){
			switch (nextLine) {
			case "fs":
				factory.buildFinishedStorage();
				break;
			case "l":
				factory.buildLumberer();
				break;
			case "w":
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "worker":
				factory.addWorkers();
				break;
			case "wood":
				factory.getAmountOfRessource(RessourceType.WOOD);
				break;
			case "stone":
				factory.getAmountOfRessource(RessourceType.STONE);
				break;
			case "finished":
				factory.getFinishedBuildings();
				break;
			default:
				break;
			}
			nextLine = scanner.nextLine();
		}
		System.exit(0);
	}

}
