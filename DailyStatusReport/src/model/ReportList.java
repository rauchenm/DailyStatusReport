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
	
	public void removeReport(int index) {
		
		reportsList.remove(index);
		
	}

	public int getSize() {
		return reportsList.size();
	}
	

}
