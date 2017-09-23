package model;

public class Issue {
	
	private String reportId;
	private String issue;
	
	public Issue() {
		super();
	}
	
	public Issue(String reportId, String issue) {
		super();
		this.reportId = reportId;
		this.issue = issue;
	}
	
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	public String toString() {
		
		String string = "ReportId: " + reportId + ", Issue: " + issue + ";";
		
		return string;
	}
	

}
