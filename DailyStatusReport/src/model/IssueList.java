package model;

import java.util.ArrayList;

public class IssueList {

	ArrayList<String> alIssue = new ArrayList<>();

	public IssueList(ArrayList<String> alIssue) {
		super();
		this.alIssue = alIssue;
	}

	public IssueList() {
		super();
	}

	public ArrayList<String> getAlIssue() {
		return alIssue;
	}

	public void setAlIssue(ArrayList<String> alIssue) {
		this.alIssue = alIssue;
	}

}
