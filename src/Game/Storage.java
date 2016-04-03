package Game;

public class Storage {
	RessourceScheduler scheduler;
	public Storage() {
		scheduler = new RessourceScheduler();
	}
	public void addProducer(Building b) {
		scheduler.addProducer(b);
		
	}
}
