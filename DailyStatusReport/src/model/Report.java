package model;

import java.time.LocalDate;

import javafx.collections.ObservableList;

public class Report {

	private LocalDate reportDate;
	private String reportID;
	private ObservableList<String> higlights;
	private ObservableList<String> issues;
	private ObservableList<Userstory> stories;
	
	public Report(LocalDate reportDate, String reportID, ObservableList<String> higlights, ObservableList<String> issues,
			ObservableList<Userstory> stories) {
		super();
		this.reportDate = reportDate;
		this.reportID = reportID;
		this.higlights = higlights;
		this.issues = issues;
		this.stories = stories;
	}
	public LocalDate getReportDate() {
		return reportDate;
	}
	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportID() {
		return reportID;
	}
	public void setReportID(String reportID) {
		this.reportID = reportID;
	}
	public ObservableList<String> getHiglights() {
		return higlights;
	}
	public void setHiglights(ObservableList<String> higlights) {
		this.higlights = higlights;
	}
	public ObservableList<String> getIssues() {
		return issues;
	}
	public void setIssues(ObservableList<String> issues) {
		this.issues = issues;
	}
	public ObservableList<Userstory> getStories() {
		return stories;
	}
	public void setStories(ObservableList<Userstory> stories) {
		this.stories = stories;
	}
	
	public String toString(){
		
		String string = 
				"Report ID: " + reportID + "\n"
				+ "Date: " + getReportDate() + "\n"
				+ "Highlights: " + getHiglights() + "\n"
				+ "Issues: " + getIssues() + "\n"
				+ "Userstories:" + getStories();
		
		return string;
		
	}
	
	public String toHttp() {
		
		String string = 
				"Report ID: " + reportID + "\n"
				+ "Date: " + getReportDate() + "\n"
				+ "Highlights: " + getHiglights() + "\n"
				+ "Issues: " + getIssues() + "\n"
				+ "Userstories:" + getStories();
		
		return string;
		
		
	}
	
	
	
	
}
