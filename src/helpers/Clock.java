package helpers;

import java.util.Timer;
import java.util.TimerTask;

public class Clock {
	private static Clock clock;
	private Timer timer;
	private long gameTime;
	private int speed;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed > 0){
			this.speed = speed;
		}
	}
	public Clock() {
		speed = 1;
		gameTime = 0;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			private long lastTime = System.currentTimeMillis();
			@Override
			public void run() {
				long currentTime = System.currentTimeMillis();
				gameTime = gameTime + ((currentTime - lastTime)*speed);
				lastTime = currentTime;
			}
		}, 0, (500/speed));
		
	}
	public static Clock getInstance(){
		if(clock == null){
			clock = new Clock();
		}
		return clock;
	}
	public long getTime(){
		return gameTime;
	}
	

}
