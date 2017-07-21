package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HighlightList {

	ObservableList<Highlight> alHighlight = FXCollections.observableArrayList();
			

	public HighlightList(ObservableList<Highlight> alHighlight) {
		super();
		this.alHighlight = alHighlight;
	}

	public HighlightList() {
		super();
	}

	public ObservableList<Highlight> getAlHighlight() {
		return alHighlight;
	}

	public void setAlHighlight(ObservableList<Highlight> alHighlight) {
		this.alHighlight = alHighlight;
	}

	public void setHighlight(Highlight highlight) {
		
		alHighlight.add(highlight);
		
	}

	public int getSize() {
	
		return alHighlight.size();
	}
	
	


}
