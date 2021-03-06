package model;

public class Userstory {
	
	private String reportId; 
	private String userStoryID;
	private String entity;
	private String status;
	private int tcTotal;
	private int tcPass;
	private int tcFail;
	private int tcBlocked;
	private int tcNoRun;
	private int tcDefer;
	private double tcExePerc;
	private double tcPassPerc;
	private String defects;
	private String comments;

	public Userstory(String reportId, String userStoryID, String entity, String status, int tcTotal, int tcPass, int tcFail,
			int tcBlocked, int tcNoRun, int tcDefer, double tcExePerc, double tcPassPerc, String defects,
			String comments) {
		super();
		this.reportId = reportId;
		this.userStoryID = userStoryID;
		this.entity = entity;
		this.status = status;
		this.tcTotal = tcTotal;
		this.tcPass = tcPass;
		this.tcFail = tcFail;
		this.tcBlocked = tcBlocked;
		this.tcNoRun = tcNoRun;
		this.tcDefer = tcDefer;
		this.tcExePerc = tcExePerc;
		this.tcPassPerc = tcPassPerc;
		this.defects = defects;
		this.comments = comments;
	}

	
	public Userstory() {
		super();
	}
	
	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	
	public String getUserStoryID() {
		return userStoryID;
	}

	public void setUserStoryID(String userStoryID) {
		this.userStoryID = userStoryID;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTcTotal() {
		return tcTotal;
	}

	public void setTcTotal(int tcTotal) {
		this.tcTotal = tcTotal;
	}

	public int getTcPass() {
		return tcPass;
	}

	public void setTcPass(int tcPass) {
		this.tcPass = tcPass;
	}

	public int getTcFail() {
		return tcFail;
	}

	public void setTcFail(int tcFail) {
		this.tcFail = tcFail;
	}

	public int getTcBlocked() {
		return tcBlocked;
	}

	public void setTcBlocked(int tcBlocked) {
		this.tcBlocked = tcBlocked;
	}

	public int getTcNoRun() {
		return tcNoRun;
	}

	public void setTcNoRun(int tcNoRun) {
		this.tcNoRun = tcNoRun;
	}

	public int getTcDefer() {
		return tcDefer;
	}

	public void setTcDefer(int tcDefer) {
		this.tcDefer = tcDefer;
	}

	public double getTcExePerc() {
		return tcExePerc;
	}

	public void setTcExePerc(double tcExePerc) {
		this.tcExePerc = tcExePerc;
	}

	public double getTcPassPerc() {
		return tcPassPerc;
	}

	public void setTcPassPerc(double tcPassPerc) {
		this.tcPassPerc = tcPassPerc;
	}

	public String getDefects() {
		return defects;
	}

	public void setDefects(String defects) {
		this.defects = defects;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String toString() {
		
		String string = 
				//"Report ID: " + getReportId() + ", " +
				 "US-ID: " + getUserStoryID() + " , "
				+ "Entity: " + getEntity()+ " , "
				+ "Status: " + getStatus() + " , "
				+ "TotalTC: " + getTcTotal() + " , "
				+ "Pass:" + getTcPass() + " , "		
				+ "Fail: " + getTcFail()+ " , "
				+ "Blocked:  " + getTcBlocked() + " , " 
				+ "No Run: " + getTcNoRun() + " , "
				+ "Defer: " + getTcDefer() + " , "
				+ "Perc Exe: " + getTcExePerc()+ " , "
				+ "Perc Pass: " + getTcPassPerc() + " , "
				+ "Outstanding Defects: " + getDefects()+ " , "
				+ "Comments: " + getComments();
		
		return string;
	}



}
