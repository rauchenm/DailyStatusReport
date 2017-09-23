package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReportList {
	
	private ObservableList<Report> reportsList = FXCollections.observableArrayList();
	
	public ReportList() {
		super();
	}
	
	public ReportList(ObservableList<Report> reportsList) {
		super();
		this.reportsList = reportsList;
	}

	public ObservableList<Report> getReportsList() {
		return reportsList;
	}

	public void setReportsList(ObservableList<Report> reportsList) {
		this.reportsList = reportsList;
	}

	public void addReport(Report report) {
		
		reportsList.add(report);
		
	}
	

	public ObservableList<String> getReportIdList(){
		ObservableList<String> reportIdList = FXCollections.observableArrayList();
		for (int j = 0; j < reportsList.size(); j++) {
			reportIdList.add(reportsList.get(j).getReportID());
		}
		return reportIdList;
		
	}
	
	public void removeReport(int index) {
		
		reportsList.remove(index);
		
	}

	public int getSize() {
		return reportsList.size();
	}
	
//	public String toString(int i) {
//		
//		String string = "Report ID: " + reportsList.get(i).getReportID() + 
//						", Stories: " + reportsList.get(i).getStories().get(i) +
//						", Highlights: " + reportsList.get(i).getHiglights().get(i) +
//						", Issues: " + reportsList.get(i).getIssues().get(i);;
//				
//		return string;		
//	}

}
