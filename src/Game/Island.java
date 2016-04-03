package Game;
import java.util.ArrayList;

public class Island {
	ArrayList<Building> buildings;
	Storage storage;
	
	public Island() {
		buildings = new ArrayList<>();
		storage = new Storage();
	}
	
	public ArrayList<Building> getBuildings(){
		return buildings;
	}
	public void addBuilding(Building b){
		storage.addProducer(b);
		buildings.add(b);
	}
}
