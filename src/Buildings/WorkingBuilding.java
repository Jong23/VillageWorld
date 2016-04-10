package Buildings;

import java.util.Timer;
import java.util.TimerTask;

import Enums.BuildingStatus;
import Enums.BuildingType;
import Enums.RessourceType;
import Game.Storage;
import helpers.Clock;

public abstract class WorkingBuilding extends Building{
	static Timer timer = new Timer();
	protected int workers = 0; 
	protected int activeWorkers = 0;
	private int maxWorkers = 2;
	protected static Clock clock = Clock.getInstance();
	protected boolean isWorking = false;
	private int baseProductionTime;
	public WorkingBuilding(int x, int y, BuildingType type) {
		super(x, y, type);
		baseProductionTime = type.getBaseProductionTime();
	}
	protected void work(){
		if(isWorking && status == BuildingStatus.FINISHED){
			while(activeWorkers < workers){
				scheduleWork();
			}
		}
	}
	//default work for productionBuildings
	protected void scheduleWork() {
		TimerTask task = new TimerTask() {
			long workStarted = clock.getTime();
			int productionTime = getProductionTime();
			@Override
			public void run() {
				if(isWorking & (activeWorkers<= workers)){
					long producedTime = clock.getTime()-workStarted;
					if(producedTime > productionTime){
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
	protected void idleWork() {
		//No Tasks available; Idle for 2 seconds
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				activeWorkers--;
				work();
				this.cancel();
			}
		};
		activeWorkers++; 
		timer.schedule(task, 2000);
	}
	
	//interface
	public abstract void produce();
}
