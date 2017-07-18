package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserstoryList {

	ObservableList<Userstory> alUserstory = FXCollections.observableArrayList();

	public UserstoryList() {
		super();
	}
	
	public UserstoryList(ObservableList<Userstory> alUserstory) {
		super();
		this.alUserstory = alUserstory;
	}

	public ObservableList<Userstory> getAlUserstory() {
		return alUserstory;
	}

	public void setAlUserstory(ObservableList<Userstory> alUserstory) {
		this.alUserstory = alUserstory;
	}

	public void add(Userstory us) {
		
		alUserstory.add(us);
		
	}
	
	public ObservableList<Userstory> getAllUserstories() {
		
		return alUserstory;
		
	}
	
	
	

}
