package com.supermkt.test.report;

import java.util.HashMap;

public abstract class Report {
	
	HashMap<String, String> resultsMap;

	public void generateReport() {
		//Code to retrieve data and place it in resultsMap
	}
	
	public abstract void convertToFormat(String formatType);
}