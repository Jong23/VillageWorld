package Buildings;

import java.util.ArrayList;
import java.util.TimerTask;

import Enums.BuildingType;
import Game.TransportTask;
import Storages.StandardStorage;
import Storages.Storage;

public class StorageBuilding extends WorkingBuilding {
	int workerSpeed = 1;
	public int getWorkerSpeed() {
		return workerSpeed;
	}


	public void setWorkerSpeed(int workerSpeed) {
		this.workerSpeed = workerSpeed;
	}


	public StorageBuilding(int x, int y) {
		super(x, y, BuildingType.STORAGE);
	}

	
	@Override
	public void scheduleWork(){
		System.out.println("Search TransportTask");
		ArrayList<TransportTask> transportTasks = getIsland().getTransportsToCreateBuilding();
		if(transportTasks.size() == 0){
			idleWork();
			System.out.println("No TransportTask available");
			return;
		}
		TransportTask transportTask = transportTasks.get(0);
		transportTask.startTransport();
		long workStarted = clock.getTime();
		int transportTime = transportTask.getTransportTime() / workerSpeed;
		System.out.println("Duration of transport: " + transportTime);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				long transportedTime = clock.getTime()-workStarted;
				if(transportedTime > transportTime){
					transportTask.finishTransport();
					activeWorkers--;
					work();
					this.cancel();
				
				}
			}
		};
		activeWorkers++;
		timer.schedule(task, 0, (1000/workerSpeed));
	}
	@Override
	public void produce() {
		//not needed
	}


	@Override
	protected Storage getFinalStorage() {
		return new StandardStorage(100);
	}
}
