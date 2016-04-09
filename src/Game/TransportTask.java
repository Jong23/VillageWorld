package Game;

import Buildings.Building;
import Enums.RessourceType;

public class TransportTask implements Comparable<TransportTask>{
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
	@Override
	public String toString() {
		return "From "+from+", To "+to+", "+amount+" "+ressource+ "\n";
	}
	@Override
	public int compareTo(TransportTask o) {
		return Integer.compare(o.getAmount(), this.getAmount());
	}

}
