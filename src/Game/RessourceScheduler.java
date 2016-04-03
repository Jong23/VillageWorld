package Game;

import java.util.Timer;
import java.util.TimerTask;

public class RessourceScheduler {
	Timer timer;
	public RessourceScheduler() {
		timer = new Timer();
	}
	public void addProducer(final Producing producer){
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				producer.produce();
			}
		};
		timer.scheduleAtFixedRate(task, Constants.SCHEDULEPERIOD, Constants.SCHEDULEPERIOD);
	}
}
