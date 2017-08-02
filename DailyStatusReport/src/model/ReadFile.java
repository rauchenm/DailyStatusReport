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

	private ReportList reportList = new ReportList();

	public ReportList readFile() {

		ObservableList<Highlight> hlList = FXCollections.observableArrayList();
		ObservableList<Issue> issList = FXCollections.observableArrayList();
		ObservableList<Userstory> usList = FXCollections.observableArrayList();

		fileUs = new File(pathUserStories);
		fileHighLight = new File(pathHighlights);
		fileIssues = new File(pathIssues);

		String line = "";
		String[] lineUs;
		String[] lineHl;
		String[] lineIss;

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
					us.setTcExePerc(Integer.valueOf(lineUs[11]));
					us.setComments(lineUs[12].trim());
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

		for (int i = 0; i < usList.size(); i++) {

			Report report = new Report();
			report.setHiglights(hlList);
			report.setIssues(issList);
			report.setReportID(usList.get(i).getReportId());
			report.setStories(usList);
			reportList.addReport(report);
		}

		return reportList;

	}

}
