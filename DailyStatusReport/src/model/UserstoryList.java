package model;

import java.util.ArrayList;

public class UserstoryList {
	
	ArrayList<Userstory> alUserstory;

	public UserstoryList() {
		super();
	}
	
	public UserstoryList(ArrayList<Userstory> alUserstory) {
		super();
		this.alUserstory = alUserstory;
	}

	public ArrayList<Userstory> getAlUserstory() {
		return alUserstory;
	}

	public void setAlUserstory(ArrayList<Userstory> alUserstory) {
		this.alUserstory = alUserstory;
	}

	
	
}
