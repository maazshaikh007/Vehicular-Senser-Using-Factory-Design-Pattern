package com.niflr.feature;

import java.util.ArrayList;
import java.util.List;

import com.niflr.drone.Pod;

public class Features {
	private List<Pod> pod=new ArrayList<>();

	public List<Pod> getPod() {
		return pod;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return pod.toString();
	}


}
