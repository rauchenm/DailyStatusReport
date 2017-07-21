package model;

public class Highlight {

	private String reportId;
	private String highlight;
	
	public Highlight() {
		super();

	}	
	public Highlight(String reportId, String highlight) {
		super();
		this.reportId = reportId;
		this.highlight = highlight;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	
	
	
	
}
