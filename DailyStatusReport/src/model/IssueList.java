package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IssueList {

	ObservableList<Issue> alIssue = FXCollections.observableArrayList();
	
	public IssueList() {
		super();
	}
	
	public IssueList(ObservableList<Issue> alIssue) {
		super();
		this.alIssue = alIssue;
	}

	public ObservableList<Issue> getAlIssue() {
		return alIssue;
	}

	public void setAlIssue(ObservableList<Issue> alIssue) {
		this.alIssue = alIssue;
	}

	public void setIssue(Issue issue) {
		
		alIssue.add(issue);
		
	}

	public int getSize() {
		
		return alIssue.size();
		
	}
	
	
}
