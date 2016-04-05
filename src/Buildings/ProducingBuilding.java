package Buildings;

import java.util.Timer;
import java.util.TimerTask;

import Enums.RessourceType;
import Game.Storage;

public abstract class ProducingBuilding extends Building implements Producing{
	static Timer timer = new Timer();
	private int workers = 0; 
	private int activeWorkers = 0;
	private int maxWorkers = 1;
	
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
					@Override
					public void run() {
						produce();
						activeWorkers--;
						work();
					}
				};
				timer.schedule(task, getProductionTime());
				activeWorkers++;
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
		if(isWorking){
			work();
		}
	}
	public void removeWorker(){
		if(getWorkerCount()>0){
			this.workers--;
		}
	}
}
