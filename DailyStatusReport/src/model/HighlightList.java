package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HighlightList {

	ObservableList<String> alHighlight = FXCollections.observableArrayList();
			

	public HighlightList(ObservableList<String> alHighlight) {
		super();
		this.alHighlight = alHighlight;
	}

	public HighlightList() {
		super();
	}

	public ObservableList<String> getAlHighlight() {
		return alHighlight;
	}

	public void setAlHighlight(ObservableList<String> alHighlight) {
		this.alHighlight = alHighlight;
	}

	public void setHighlight(String highlight) {
		
		alHighlight.add(highlight);
		
	}

	public int getSize() {
	
		return alHighlight.size();
	}
	
	


}
