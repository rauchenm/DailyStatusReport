package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Highlight;
import model.HighlightList;
import model.Issue;
import model.IssueList;
import model.ReadFile;
import model.ReadReport;
import model.Report;
import model.ReportList;
import model.Userstory;
import model.UserstoryList;

public class ReportControl implements Initializable {

	// Tab Automatic
	@FXML
	private ListView<String> lvReportIdAut;
	@FXML
	private ListView<Userstory> lvReadFile;
	@FXML
	private ListView<Issue> lvIssueAut;
	@FXML
	private ListView<Highlight> lvHighlightAut;
	@FXML
	private ChoiceBox<String> cbReports;
	@FXML
	private Button btShowReport;
	@FXML
	private Button btReadFile;

	// Tab Manual
	// Report Overview
	@FXML
	private Label lbReportId;
	@FXML
	private DatePicker dpReportDate;

	// Report Highlights
	@FXML
	private TextField tbHiglight;
	@FXML
	private ListView<Highlight> lvHighlights;
	@FXML
	private Button btAddHighlight;

	// Report Issues
	@FXML
	private TextField tbIssue;
	@FXML
	private ListView<Issue> lvIssues;
	@FXML
	private Button btAddIssue;

	// Report Userstories
	@FXML
	private ListView<Userstory> lvUserstories;

	@FXML
	private TextField tbUserstoryID;
	@FXML
	private ChoiceBox<String> cbEntity;
	@FXML
	private ChoiceBox<String> cbStatus;
	@FXML
	private TextField tbTotalTc;
	@FXML
	private TextField tbPass;
	@FXML
	private TextField tbFailed;
	@FXML
	private TextField tbBlocked;
	@FXML
	private TextField tbNoRun;
	@FXML
	private TextField tbDefer;
	@FXML
	private TextField tbExePerc;
	@FXML
	private TextField tbPassPerc;
	@FXML
	private TextField tbOutstandDef;
	@FXML
	private TextField tbComments;

	@FXML
	private Button btAddUserStoryInf;
	@FXML
	private Button btGenerateReport;
	
	// Tab Weekly Report
	@FXML
	private ListView<Userstory> lvWeeklyReport;
	@FXML
	private	ChoiceBox<String> cbEntitiyRep;
	@FXML
	private	DatePicker dpWeek;
	@FXML
	private Button	btReadReportData;
	

	UserstoryList userstoryList = new UserstoryList();
	IssueList issueList = new IssueList();
	HighlightList highlightList = new HighlightList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[] entities = {"COM", "GIP", "LIF", "CLA", "PoS", "INT"};
		cbStatus.setItems(FXCollections.observableArrayList("Not Started", "Scripting - InProgress", "BA Review",
				"Rework - In Progress", "Testing - In Progress", "Executed with Defects", "Exploratory / SME Testing",
				"Accepted"));

		cbEntity.setItems(FXCollections.observableArrayList(entities));
		
		cbEntitiyRep.setItems(FXCollections.observableArrayList(entities));

	}

	@FXML
	private void addHighlight() {

		highlightList.setHighlight(new Highlight(lbReportId.getText(), tbHiglight.getText()));

		for (int i = 0; i < highlightList.getSize(); i++) {
			lvHighlights.setItems((highlightList.getAlHighlight()));
		}

		tbHiglight.clear();

	}

	@FXML
	private void addIssue() {

		issueList.setIssue(new Issue(lbReportId.getText(), tbIssue.getText()));

		for (int i = 0; i < issueList.getSize(); i++) {
			lvIssues.setItems((issueList.getAlIssue()));
		}

		tbIssue.clear();

	}

	@FXML
	private void generateReport() throws IOException {

		String reportName = "DSR-" + cbEntity.getSelectionModel().getSelectedItem() + "-" + dpReportDate.getValue();
		lbReportId.setText(reportName);

		Report report = new Report(lbReportId.getText(), highlightList.getAlHighlight(), issueList.getAlIssue(),
				userstoryList.getAlUserstory());

		System.out.println(report.toString());

		File file = new File("D:\\Privat\\" + reportName);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(report.toHttp());
		writer.close();
	}

	@FXML
	private void addUserstoryInf() {

		calculatePerc();

		Userstory us = new Userstory(lbReportId.getText(), tbUserstoryID.getText(),
				cbEntity.getSelectionModel().getSelectedItem(), cbStatus.getSelectionModel().getSelectedItem(),
				Integer.valueOf(tbTotalTc.getText()), Integer.valueOf(tbPass.getText()),
				Integer.valueOf(tbFailed.getText()), Integer.valueOf(tbBlocked.getText()),
				Integer.valueOf(tbNoRun.getText()), Integer.valueOf(tbDefer.getText()),
				Double.valueOf(tbExePerc.getText()), Double.valueOf(tbPassPerc.getText()), tbOutstandDef.getText(),
				tbComments.getText());

		userstoryList.add(us);
		System.out.println(userstoryList.getSize());

		lvUserstories.setItems(userstoryList.getAlUserstory());
		clearUserstoriesTextBoxes();

	}

	@FXML
	private void readFile() {

		ReadFile rf = new ReadFile();

		// reportList = rf.readFile();
		ReportList reportList = new ReportList();

		reportList = rf.readFile();
		
		
		
		for (int i = 0; i < reportList.getSize(); i++) {
			
			lvReportIdAut.setItems(reportList.getReportIdList());
		}

		checkReports(reportList);

	}

	private void calculatePerc() {

		int tcPass = Integer.valueOf(tbPass.getText());
		double tcTotal = Double.valueOf(tbTotalTc.getText());
		int tcFailed = Integer.valueOf(tbFailed.getText());
		double exePerc = 0.0;
		double passPerc = 0.0;

		exePerc = ((tcPass + tcFailed) / tcTotal) * 100;
		passPerc = (tcPass / tcTotal) * 100;

		tbExePerc.setText(String.valueOf(exePerc));
		tbPassPerc.setText(String.valueOf(passPerc));
	}

	private void clearUserstoriesTextBoxes() {

		tbUserstoryID.clear();
		// cbEntity.getSelectionModel().clearSelection();
		cbStatus.getSelectionModel().clearSelection();
		tbTotalTc.setText("0");
		tbPass.setText("0");
		tbFailed.setText("0");
		tbBlocked.setText("0");
		tbNoRun.setText("0");
		tbDefer.setText("0");
		tbExePerc.setText("0.0");
		tbPassPerc.setText("0.0");
		tbOutstandDef.clear();
		tbComments.clear();

	}

	private void checkReports(ReportList reportList) {

		ObservableList<String> olReports = FXCollections.observableArrayList();

		for (int j = 0; j < reportList.getSize(); j++) {

			if(j==0) 
			{olReports.add(reportList.getReportIdList().get(j));}
			
			if(j >=1 && !olReports.get(olReports.size()-1).equals(reportList.getReportIdList().get(j))){
				olReports.add(reportList.getReportIdList().get(j));}
			}	
	
		cbReports.setItems(olReports);
	}

	@FXML
	private void viewDetailsReport() {

		lvReportIdAut.setItems(null);
		lvReadFile.setItems(null);
		lvIssueAut.setItems(null);
		lvHighlights.setItems(null);
		String reportId = cbReports.getSelectionModel().getSelectedItem();

		ReadFile rf = new ReadFile();
		ReportList reportList = new ReportList();
		ObservableList<String> filteredListReport = FXCollections.observableArrayList();
		ObservableList<Userstory> filteredUserstories = FXCollections.observableArrayList();
		ObservableList<Highlight> filteredHighlights = FXCollections.observableArrayList();
		ObservableList<Issue> filteredIssuess = FXCollections.observableArrayList();

		reportList = rf.readFile();

		for (int i = 0; i < reportList.getSize(); i++) {
			
			if (reportId.equals(reportList.getReportsList().get(i).getReportID())) {
				filteredListReport.add(reportList.getReportsList().get(i).getReportID());
			} lvReportIdAut.setItems(filteredListReport);

			if (reportId.equals(reportList.getReportsList().get(i).getReportID())) {
				filteredUserstories.add(reportList.getReportsList().get(i).getStories().get(i));
			} lvReadFile.setItems(filteredUserstories);

			if (reportId.equals(reportList.getReportsList().get(i).getReportID())) {
				filteredHighlights.addAll(reportList.getReportsList().get(i).getHiglights().get(i));
			} lvHighlightAut.setItems(filteredHighlights);
			
			if (reportId.equals(reportList.getReportsList().get(i).getReportID())) {
				filteredIssuess.add(reportList.getReportsList().get(i).getIssues().get(i));
			} lvIssueAut.setItems(filteredIssuess);
			
		}
		


	}
	
	@FXML 
	private void readReportData() {
		
		ReadReport report = new ReadReport();
	
		LocalDate localDate = dpWeek.getValue(); // assuming we picked 18 September 2014
		int weekNumber = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		
		lvWeeklyReport.setItems(report.readReports(String.valueOf(dpWeek.getValue()), weekNumber));
		
	}

}
	


