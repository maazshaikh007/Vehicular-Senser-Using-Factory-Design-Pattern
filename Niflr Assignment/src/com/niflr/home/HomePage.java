package com.niflr.home;

import com.niflr.analysis.FeatureAnalysis;
import com.niflr.analysis.PodCountFactory;
import com.niflr.analysis.PodCountHalfHour;
import com.niflr.feature.Features;
import com.niflr.parser.DataParser;
import com.niflr.util.Analysis;

public class HomePage {
	private DataParser dataParser;
	private Features features;
	
	public HomePage()
	{
		this.dataParser = new DataParser();
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomePage home=new HomePage();
		home.parseInfo();
		home.run();

	}


	private void run() {
		// TODO Auto-generated method stub
		PodCountFactory factory = new PodCountFactory();
		FeatureAnalysis f = factory.getFeatureAnalysis();
		f.calculateFeature(features);
		
		
	}





	private void parseInfo() {
		features=Analysis.Analyse(dataParser);
		System.out.println("Total Pod: "+features.getPod().size());
		//System.out.println(features.toString());
		
	}

	public DataParser getDataParser() {
		return dataParser;
	}

	public void setDataParser(DataParser dataParser) {
		this.dataParser = dataParser;
	}

}
