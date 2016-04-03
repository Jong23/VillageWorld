package Game;
import java.util.ArrayList;

public class Island {
	ArrayList<Building> buildings;
	
	public Island() {
		buildings = new ArrayList<>();
	}
	
	public ArrayList<Building> getBuildings(){
		return buildings;
	}
	public void addBuilding(Building b){
		buildings.add(b);
	}
}
