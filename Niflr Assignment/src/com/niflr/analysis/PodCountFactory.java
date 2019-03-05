package com.niflr.analysis;

public class PodCountFactory {
	
	public FeatureAnalysis getFeatureAnalysis()
	{
		return new PodCountHalfHour();
	}

}
