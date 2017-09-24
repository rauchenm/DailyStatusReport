package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReadFile {

	// Files aus denen eingelesen wird...
	private File fileUs;
	private File fileHighLight;
	private File fileIssues;

	// Pfade zu den Files
	// private String pathUserStories = "D:\\Privat\\DSR_Userstories.txt";
	// private String pathHighlights = "D:\\Privat\\DSR_highlights.txt";
	// private String pathIssues = "D:\\Privat\\DSR_Issues.txt";

	private String pathUserStories = "C:\\Users\\Markus\\Downloads\\DSR_Reports.txt";
	private String pathHighlights = "C:\\Users\\Markus\\Downloads\\DSR_Highlights.txt";
	private String pathIssues = "C:\\Users\\Markus\\Downloads\\DSR_Issues.txt";

	String[] lineUs;
	String[] lineHl;
	String[] lineIss;

	private ReportList reportList = new ReportList();

	public ReportList readFile() {

		ObservableList<Highlight> hlList = FXCollections.observableArrayList();
		ObservableList<Issue> issList = FXCollections.observableArrayList();
		ObservableList<Userstory> usList = FXCollections.observableArrayList();
		
		fileUs = new File(pathUserStories);
		fileHighLight = new File(pathHighlights);
		fileIssues = new File(pathIssues);

		String line = "";

		BufferedReader reader;

		// Read Userstoryies aus files
		try {
			reader = new BufferedReader(new FileReader(fileUs));
			while ((line = reader.readLine()) != null) {
				if (!line.contains("ID")) {				
					Userstory us = new Userstory();
					lineUs = line.split(";");
					us.setReportId(lineUs[1].trim());
					us.setUserStoryID(lineUs[2].trim());
					us.setEntity(lineUs[3].trim());
					us.setStatus(lineUs[4].trim());
					us.setTcTotal(Integer.valueOf(lineUs[5]));
					us.setTcPass(Integer.valueOf(lineUs[6]));
					us.setTcFail(Integer.valueOf(lineUs[7]));
					us.setTcBlocked(Integer.valueOf(lineUs[8]));
					us.setTcNoRun(Integer.valueOf(lineUs[9]));
					us.setTcDefer(Integer.valueOf(lineUs[10]));
					if(us.getTcTotal() > 0) {
					us.setTcExePerc(((us.getTcPass() + us.getTcFail()) / (double) us.getTcTotal()) * 100);
					us.setTcPassPerc((us.getTcPass() / (double) us.getTcTotal()) * 100);}
					else {
					us.setTcExePerc(Double.valueOf(lineUs[11]));
					us.setTcPassPerc(Double.valueOf(lineUs[12]));}
					if(lineUs.length < 12) {
					us.setDefects(lineUs[13]);
					us.setComments(lineUs[14].trim());}
					usList.add(us);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read Highlight aus files
		try {
			reader = new BufferedReader(new FileReader(fileHighLight));
			while ((line = reader.readLine()) != null) {
				Highlight hl = new Highlight();
				lineHl = line.split(";");
				if (!line.contains("ID")) {
					hl.setReportId(lineHl[1].trim());
					hl.setHighlight(lineHl[2].trim());
					hlList.add(hl);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read Issues aus files
		try {
			reader = new BufferedReader(new FileReader(fileIssues));
			while ((line = reader.readLine()) != null) {
				Issue iss = new Issue();
				lineIss = line.split(";");
				if (!line.contains("ID")) {
					iss.setReportId(lineIss[1].trim());
					iss.setIssue(lineIss[2].trim());
					issList.add(iss);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ObservableList<String> reportDates = FXCollections.observableArrayList();
	
		
		for (int i = 0; i < usList.size(); i++) {

			if (i == 0) {
				reportDates.add(usList.get(i).getReportId());
			}

			if (i >= 1 && !reportDates.get(reportDates.size() - 1).equals(usList.get(i).getReportId())) {
				reportDates.add(usList.get(i).getReportId());
			}
		}
		
		

		

		
		for (int i = 0; i < reportDates.size(); i++) {
			
			Report report = new Report();
			
			ObservableList<Userstory> stories = FXCollections.observableArrayList();
			ObservableList<Issue> issues = FXCollections.observableArrayList();
			ObservableList<Highlight> highlights = FXCollections.observableArrayList();
			
			report.setReportID(reportDates.get(i));
			
			for (int j = 0; j < usList.size(); j++) {

				Userstory us = new Userstory();

				if (report.getReportID().equals(usList.get(j).getReportId())) {
					us.setReportId(usList.get(j).getReportId());
					us.setUserStoryID(usList.get(j).getUserStoryID());
					us.setEntity(usList.get(j).getEntity());
					us.setStatus(usList.get(j).getStatus());
					us.setTcTotal(usList.get(j).getTcTotal());
					us.setTcPass(usList.get(j).getTcPass());
					us.setTcFail(usList.get(j).getTcFail());
					us.setTcBlocked(usList.get(j).getTcBlocked());
					us.setTcNoRun(usList.get(j).getTcNoRun());
					us.setTcDefer(usList.get(j).getTcDefer());
					us.setTcExePerc(usList.get(j).getTcExePerc());
					us.setTcPassPerc(usList.get(j).getTcPassPerc());
					us.setDefects(usList.get(j).getDefects());
					us.setComments(usList.get(j).getComments());
					stories.add(us);
				}
				report.setStories(stories);

			}

			for (int j = 0; j < hlList.size(); j++) {

				Highlight hl = new Highlight();

				if (report.getReportID().equals(hlList.get(j).getReportId())) {
					hl.setReportId(hlList.get(j).getReportId());
					hl.setHighlight(hlList.get(j).getHighlight());
					highlights.add(hl);
				}
				report.setHiglights(highlights);
			}

			for (int j = 0; j < issList.size(); j++) {

				Issue issue = new Issue();

				if (report.getReportID().equals(issList.get(j).getReportId())) {
					issue.setReportId(issList.get(j).getReportId());
					issue.setIssue(issList.get(j).getIssue());
					issues.add(issue);
				}
				report.setIssues(issues);
			}
			
			reportList.addReport(report);
		}

		return reportList;

	}

}
