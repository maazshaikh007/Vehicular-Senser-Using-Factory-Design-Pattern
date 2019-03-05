package com.niflr.util;

import java.util.List;

import com.niflr.drone.Pod;
import com.niflr.feature.Features;
import com.niflr.parser.DataParser;

public class Analysis {
	private static final String north="north";
	private static final String south="south";
	
	public static Features Analyse(DataParser p)
	{
		Features features = new Features();
		Double LastTime=(double) 0;
		int day=0;
		for( List<String> data : p.getData())
		{
			if(data.size() == 2)
			{
				
				String front=data.get(0).substring(1);
				if(Double.parseDouble(front)<LastTime)
					day++;
				//System.out.println(front);
				String back=data.get(1).substring(1);
			//	System.out.println(back);
				double time=((Double.parseDouble(back)-Double.parseDouble(front))/1000);
				double speed=(2.5/(time));
				//System.out.println(time);
				//System.out.println(speed);
				Pod pod = new Pod(north);
				pod.setSpeed(speed);
				pod.setDay(day);
				pod.setFrontTime(Double.parseDouble(front));
				pod.setBackTime(Double.parseDouble(back));
				features.getPod().add(pod);
				LastTime=Double.parseDouble(front);
				
			}
			else
			{
				String front=data.get(0).substring(1);
				if(Double.parseDouble(front)<LastTime)
					day++;
				String back=data.get(2).substring(1);
				double time=((Double.parseDouble(back)-Double.parseDouble(front))/1000);
				double speed=(int) (2.5/(time));
				//System.out.println(time);
				//System.out.println(speed);
				Pod pod = new Pod(south);
				pod.setSpeed(speed);
				pod.setDay(day);
				pod.setFrontTime(Double.parseDouble(front));
				pod.setBackTime(Double.parseDouble(back));
				features.getPod().add(pod);
				LastTime=Double.parseDouble(front);
			}
		}
		return features;
	}

}
