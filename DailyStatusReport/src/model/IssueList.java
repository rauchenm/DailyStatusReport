package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IssueList {

	ObservableList<String> alIssue = FXCollections.observableArrayList();
	
	public IssueList() {
		super();
	}
	
	public IssueList(ObservableList<String> alIssue) {
		super();
		this.alIssue = alIssue;
	}

	public ObservableList<String> getAlIssue() {
		return alIssue;
	}

	public void setAlIssue(ObservableList<String> alIssue) {
		this.alIssue = alIssue;
	}

	public void setIssue(String issue) {
		
		alIssue.add(issue);
		
	}

	public int getSize() {
		
		return alIssue.size();
		
	}
	
	
}
