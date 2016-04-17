package Buildings;

import java.util.ArrayList;
import java.util.TimerTask;

import Enums.BuildingType;
import Game.TransportTask;
import Storages.StandardStorage;
import Storages.Storage;

public class StorageBuilding extends WorkingBuilding {
	int transportationAmount = 2;


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
		TransportTask transportTask = getIsland().getTransportTask(getTransportationAmount());
		if(transportTask == null ){
			System.out.println("idle");
			idleWork();
			return;
		}
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
		timer.schedule(task, 0, (1000/(workerSpeed)));
	}

	@Override
	public void produce() {
		//not needed
	}


	@Override
	protected Storage getFinalStorage() {
		return new StandardStorage(100);
	}
	public int getTransportationAmount() {
		return transportationAmount;
	}
	
	
	public void setTransportationAmount(int transportationAmount) {
		if(transportationAmount > 0){
			this.transportationAmount = transportationAmount;
		}
	}
}
