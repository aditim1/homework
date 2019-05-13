package com.supermkt.test.report;

public class ReportImpl extends Report{

	@Override
	public void convertToFormat(String formatType) {
		switch (formatType) {
		case "html":
			generateHtmlReport();
			break;
		case "excel":
		//	generateExcelReport();
			break;

		default:
			break;
		}
	}

	public void generateHtmlReport() {
		//Code to convert resultsMap to an HTML report
		String pageTitle = resultsMap.get("title");
		System.out.println("<html><title> " + pageTitle+"</title></html>");
		// Code cont'd ....
	}

}
