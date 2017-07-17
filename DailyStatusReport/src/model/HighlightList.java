package model;

import java.util.ArrayList;

public class HighlightList {

	ArrayList<String> alHighlight = new ArrayList<>();

	public HighlightList(ArrayList<String> alHighlight) {
		super();
		this.alHighlight = alHighlight;
	}

	public HighlightList() {
		super();
	}

	public ArrayList<String> getAlHighlight() {
		return alHighlight;
	}

	public void setAlHighlight(ArrayList<String> alHighlight) {
		this.alHighlight = alHighlight;
	}

}
