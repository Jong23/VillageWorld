package Buildings;

import java.util.Timer;
import java.util.TimerTask;

import Enums.RessourceType;
import Game.Storage;
import helpers.Clock;

public abstract class ProducingBuilding extends Building implements Producing{
	static Timer timer = new Timer();
	private int workers = 0; 
	private int activeWorkers = 0;
	private int maxWorkers = 1;
	private static Clock clock = Clock.getInstance();
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
			while(activeWorkers < workers){
				TimerTask task = new TimerTask() {
					long workStarted = clock.getTime();
					@Override
					public void run() {
						if(isWorking & (activeWorkers<= workers)){
							long producedTime = clock.getTime()-workStarted;
							if(producedTime > getProductionTime()){
								while(producedTime >= getProductionTime()){
									produce();
									producedTime = producedTime - getProductionTime();
								}
								activeWorkers--;
								work();
								this.cancel();
							
							}
						} else {
							activeWorkers--;
							this.cancel();
						}
					}
				};
				activeWorkers++;
				timer.scheduleAtFixedRate(task, 0, 1000);
			}
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
	public void setMaxWorkers(int maxWorkers) {
		this.maxWorkers = maxWorkers;
	}
	public int getWorkerCount() {
		return workers;
	}
	public void addWorker() {
		if(!(getWorkerCount()>= maxWorkers)){
			this.workers++;
		}
		work();
	}
	public void removeWorker(){
		if(getWorkerCount()>0){
			this.workers--;
		}
	}
}
