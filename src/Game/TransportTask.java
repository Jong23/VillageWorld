package Game;

import Buildings.Building;
import Enums.RessourceType;

public class TransportTask {
	private Building from, to;
	public Building getFrom() {
		return from;
	}
	public Building getTo() {
		return to;
	}
	public RessourceType getRessource() {
		return ressource;
	}
	public int getAmount() {
		return amount;
	}
	private RessourceType ressource;
	private int amount;
	public TransportTask(Building from, Building to, RessourceType ressource, int amount) {
		this.from = from;
		this.to = to;
		this.ressource = ressource;
		this.amount = amount;
	}

}
