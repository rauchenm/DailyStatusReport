package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserstoryList {

	private ObservableList<Userstory> alUserstory = FXCollections.observableArrayList();

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

//	public ObservableList<Userstory> getAlUserstoryStr() {
//		
//		
//		for (int i = 0; i < alUserstory.size(); i++) {
//			
//			alUserstoryStr.add(alUserstory.get(i).toString());
//			
//		}
//		 return alUserstoryStr;
//		
//	}

	public void setAlUserstory(ObservableList<Userstory> alUserstory) {
		this.alUserstory = alUserstory;
	}

	public void add(Userstory us) {
		
		alUserstory.add(us);
		
	}
	
	public int getSize(){
		
		return alUserstory.size();
		
	}

	
	
	

}
