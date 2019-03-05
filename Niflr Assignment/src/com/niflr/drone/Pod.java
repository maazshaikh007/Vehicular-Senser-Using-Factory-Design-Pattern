package com.niflr.drone;

public class Pod {
	private String direction;
	private double speed;
	private int day;
	Double frontTime;
	Double backTime;
	
	public Pod(String direction) {
		super();
		this.direction = direction;
		
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDay(int day)
	{
	  this.day=day;	
	}
	
	
	public void setFrontTime(Double frontTime) {
		this.frontTime = frontTime;
	}
	
	public void setBackTime(Double backTime) {
		this.backTime = backTime;
	}
	
	
	public String getDirection() {
		return direction;
	}

	public double getSpeed() {
		return speed;
	}

	public int getDay() {
		return day;
	}

	public Double getFrontTime() {
		return frontTime;
	}

	public Double getBackTime() {
		return backTime;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Direction: "+direction+" Speed: "+speed+" Day: "+day;
	}

	

}
