package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReadFile {

	//Files aus denen eingelesen wird...
	private File fileUs;
	private File fileHighLight;
	private File fileIssues;

	//Pfade zu den Files
	private String pathUserStories = "D:\\Privat\\DSR_Userstories.txt";
	private String pathHighlights = "D:\\Privat\\DSR_highlights.txt";
	private String pathIssues = "D:\\Privat\\DSR_Issues.txt";
	
	
	private ReportList reportList = new ReportList();
	private ObservableList<Userstory> olUserstory = FXCollections.observableArrayList();
	private ObservableList<Highlight> olHighlight = FXCollections.observableArrayList();
	private ObservableList<Issue> olIssue = FXCollections.observableArrayList();


	public ReportList readFile() {
		
		HighlightList hlList = new HighlightList();
		IssueList issList = new IssueList();
		UserstoryList usList = new UserstoryList();
		
		fileUs = new File(pathUserStories);
		fileHighLight = new File(pathHighlights);
		fileIssues = new File(pathIssues);
		
		String line = "";
		String[] lineUs;
		String[] lineHl;
		String[] lineIss;
		
		BufferedReader reader;
		
		//Read Userstoryies aus files
		try {
			reader = new BufferedReader(new FileReader(fileUs));
			 while ((line = reader.readLine()) != null) {
					Userstory us = new Userstory();
					lineUs = line.split(";");
					us.setReportId(lineUs[1].trim());
					us.setUserStoryID(lineUs[2].trim());
					us.setEntity(lineUs[3].trim());
					us.setStatus(lineUs[4].trim());
					us.setTcTotal(Integer.valueOf(lineUs[5].trim()));
					us.setTcPass(Integer.valueOf(lineUs[6].trim()));
					us.setTcFail(Integer.valueOf(lineUs[7].trim()));
					us.setTcBlocked(Integer.valueOf(lineUs[8].trim()));
					us.setTcNoRun(Integer.valueOf(lineUs[9].trim()));
					us.setTcDefer(Integer.valueOf(lineUs[10].trim()));
					us.setTcExePerc(Integer.valueOf(lineUs[11].trim()));
					us.setComments(lineUs[12].trim());
	                olUserstory.add(us);
			 }
			 usList.setAlUserstory(olUserstory);
			 reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Read Highlight aus files
		try {
			reader = new BufferedReader(new FileReader(fileHighLight));
			 while ((line = reader.readLine()) != null) {
					Highlight hl = new Highlight();
					lineHl = line.split(";");
					hl.setReportId(lineHl[1].trim());
					hl.setHighlight(lineHl[2].trim());
	                olHighlight.add(hl);
			 }
			 hlList.setAlHighlight(olHighlight);
			 reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Read Issues aus files
		try {
			reader = new BufferedReader(new FileReader(fileIssues));
			 while ((line = reader.readLine()) != null) {
					Issue iss = new Issue();
					lineIss = line.split(";");
					iss.setReportId(lineIss[1].trim());
					iss.setIssue(lineIss[2].trim());
	                olIssue.add(iss);          
			 }
			 issList.setAlIssue(olIssue);
			 reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		for (int i = 0; i < usList.getSize(); i++) {
			
			Report report = new Report();
			report.setHiglights(olHighlight);
			report.setIssues(olIssue);
			report.setReportID(usList.getAlUserstory().get(i).getReportId());
			report.setStories(olUserstory);
			reportList.addReport(report);
		}
		
		return reportList;
		
	}



}
