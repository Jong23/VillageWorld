package Buildings;

import java.util.Timer;
import java.util.TimerTask;

import Enums.RessourceType;
import Game.Storage;

public abstract class ProducingBuilding extends Building implements Producing{
	static Timer timer = new Timer();
	
	private boolean isWorking = false;
	RessourceType type;
	private int baseProductionTime;
	public ProducingBuilding(int x, int y, int w, int h, RessourceType type, int baseProductionTime, Storage store) {
		super(x, y, w, h, store);
		this.type = type;
		this.baseProductionTime = baseProductionTime;
	}
	private void work(){
		if(isWorking){
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					produce();
					work();
				}
			};
			timer.schedule(task, getProductionTime());
		}
	}
	private int getProductionTime(){
		return baseProductionTime;
	}
	public void startWork(){
		if(!isWorking){
			isWorking = true;
			work();
		}
	}
	public void stopWork(){
		isWorking = false;
	}
}
