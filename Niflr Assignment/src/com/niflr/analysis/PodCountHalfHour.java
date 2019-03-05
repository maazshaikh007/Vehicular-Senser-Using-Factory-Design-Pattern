package com.niflr.analysis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import com.niflr.drone.Pod;
import com.niflr.feature.Features;

public class PodCountHalfHour extends FeatureAnalysis {
	private int northCount=0;
	private int southCount=0;
	private int totalCount=0;
	private int peakCount=0;
	
	private double sampleSize=60*24; //min
//	Map<Integer, List<Map<Integer, ArrayList<Pod>>> > dayMap = new HashMap<>();
	
	@Override
	public void calculateFeature(Features f) {
		// TODO Auto-generated method stub
		System.out.println();
		for( int i=0;i<sampleSize;i+=30)
		{
			double startTime=(i*60*1000);//ms
			double endTime=((i+30)*60*1000);//ms
			calculateVehicles(startTime,endTime,f,i);
			System.out.println();
		}
		System.out.println("Peak COunt: "+peakCount);

	}

	
	private void calculateVehicles(double startTime, double endTime, Features f,int sample) {
	northCount=0;
	southCount=0;
	totalCount=0;
	for(Pod p : f.getPod())
	{
		if(p.getFrontTime()>startTime && p.getFrontTime()<=endTime)
		{
			if(p.getDirection().equals("north"))
				northCount++;
			else
				southCount++;
		}
		
	}
	totalCount=northCount+southCount;
	if(totalCount>peakCount)
	{
		peakCount=totalCount;
	//	System.out.println("Peak Count Updated To: "+peakCount+" at sample : "+sample);
		
	}
	//System.out.println("Half Hour Sample Size For Interval : "+startTime+ "to "+ endTime);
	System.out.print(String.format("%02d:%02d:%02d", 
		    TimeUnit.MILLISECONDS.toHours((long) startTime),
		    TimeUnit.MILLISECONDS.toMinutes((long) startTime) - 
		    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours((long) startTime)),
		    TimeUnit.MILLISECONDS.toSeconds((long) startTime) - 
		    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));
	System.out.print("  To  ");
	System.out.print(String.format("%02d:%02d:%02d", 
		    TimeUnit.MILLISECONDS.toHours((long) endTime),
		    TimeUnit.MILLISECONDS.toMinutes((long) endTime) - 
		    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours((long) endTime)),
		    TimeUnit.MILLISECONDS.toSeconds((long) endTime) - 
		    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) endTime))));
	System.out.println();
	System.out.println("Total Count: " +totalCount);
	System.out.println("North Cars: "+northCount);
	System.out.println("South Cars"+southCount);
	//System.out.println("Peak Count"+peakCount);
	
	}

	public int getPeakCount() {
		return peakCount;
	}

	
	


}
