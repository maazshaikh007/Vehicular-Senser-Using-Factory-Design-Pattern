package com.niflr.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataParser {
	public List<List<String>> data = new ArrayList<>();

	public DataParser()
	{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("E:\\myFile.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line1="", line2="";
		String line3="",line4="";

		try {
			while( (line1 = in.readLine()) != null 
			   && (line2 = in.readLine()) != null)
			{
			    if(line2.charAt(0)=='A')
			    {
			    	List<String> data1 = new ArrayList<>();
			    	data1.add(line1);
			    	data1.add(line2);
			    	data.add(data1);
			    }
			    else
			    {
			    	if(line2.charAt(0)!='B')
			    	{
			    		throw new RuntimeException(" Data Incorrect ");
			    	}
			    	line3 = in.readLine();
			 	    line4 = in.readLine();
			    	{
			    		List<String> data1 = new ArrayList<>();
				    	data1.add(line1);
				    	data1.add(line2);
				    	data1.add(line3);
				    	data1.add(line4);
				    	data.add(data1);
			    	}
			    	
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data.toString();
	}

	public List<List<String>> getData() {
		return data;
	}
}
