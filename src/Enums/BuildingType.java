package Enums;

public enum BuildingType {
	Lumberer (2,3, 5000);
	private int w,h;
	private int baseProductionTime;
	public int getWidth(){
		return w;
	}
	public int getHeight(){
		return h;
	}
	public int getBaseProductionTime(){
		return baseProductionTime;
	}
	public void setBaseProductionTime(int time){
		//for tests
		baseProductionTime = time; 
	}
	BuildingType(int w, int h, int baseProductionTime){
		this.w = w;
		this.h = h;
		this.baseProductionTime = baseProductionTime;
	}
}
