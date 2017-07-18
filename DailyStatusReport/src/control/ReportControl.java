package control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.HighlightList;
import model.IssueList;
import model.Report;
import model.Userstory;
import model.UserstoryList;

public class ReportControl implements Initializable {

	// Report Overview
	@FXML
	private Label lbReportId;
	@FXML
	private DatePicker dpReportDate;

	// Report Highlights
	@FXML
	private TextField tbHiglight;
	@FXML
	private ListView<String> lvHighlights;
	@FXML
	private Button btAddHighlight;
	
	// Report Issues
	@FXML
	private TextField tbIssue;
	@FXML
	private ListView<String> lvIssues;
	@FXML
	private Button btAddIssue;
	
	// Report Userstories
	@FXML
	private ListView<String> lvUserstories;
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

	UserstoryList userstoryList = new UserstoryList();
	IssueList issueList = new IssueList();
	HighlightList highlightList = new HighlightList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		cbStatus.setItems(FXCollections.observableArrayList("Not Started", "Scripting - InProgress", 
				"BA Review", "Rework - In Progress", 
				"Testing - In Progress", "Executed with Defects", 
				"Exporatory / SME Testing", "Accepted"));

		cbEntity.setItems(FXCollections.observableArrayList("COM", "GIP", "LIF", "CLA", "PoS", "INT"));
		lbReportId.setText(UUID.randomUUID().toString());
		

	}

	@FXML
	private void addHighlight() {

		highlightList.setHighlight(tbHiglight.getText());

		for (int i = 0; i < highlightList.getSize(); i++) {
			lvHighlights.setItems((highlightList.getAlHighlight()));
		}

		tbHiglight.clear();

	}

	@FXML
	private void addIssue() {

		issueList.setIssue(tbIssue.getText());

		for (int i = 0; i < issueList.getSize(); i++) {
			lvIssues.setItems((issueList.getAlIssue()));
		}

		tbIssue.clear();

	}

	@FXML
	private void generateReport() {

		Report report = new Report(
				dpReportDate.getValue(), 
				lbReportId.getText(), 
				highlightList.getAlHighlight(), 
				issueList.getAlIssue(), 
				userstoryList.getAlUserstoryStr());
		
		System.out.println(report.toString());
	}

	@FXML
	private void addUserstoryInf() {
			
		calculatePerc();
		
		 Userstory us = new Userstory(
				 tbUserstoryID.getText(),
				 cbEntity.getSelectionModel().getSelectedItem(),
				 cbStatus.getSelectionModel().getSelectedItem(),
				 Integer.valueOf(tbTotalTc.getText()),
				 Integer.valueOf(tbPass.getText()),
				 Integer.valueOf(tbFailed.getText()),
				 Integer.valueOf(tbBlocked.getText()),
				 Integer.valueOf(tbNoRun.getText()),
				 Integer.valueOf(tbDefer.getText()),
				 Double.valueOf(tbExePerc.getText()),
				 Double.valueOf(tbPassPerc.getText()),
				 tbOutstandDef.getText(),
				 tbComments.getText());
		 
		 userstoryList.add(us);

	lvUserstories.setItems(userstoryList.getAlUserstoryStr());
	clearUserstoriesTextBoxes();

	}

	private void calculatePerc() {
		
		int tcPass = Integer.valueOf(tbPass.getText());
		double tcTotal = Double.valueOf(tbTotalTc.getText());
		int tcFailed = Integer.valueOf(tbFailed.getText());
		double exePerc = 0.0;
		double passPerc = 0.0;
		
		exePerc = ((tcPass+tcFailed)/tcTotal)*100;
		passPerc= (tcPass/tcTotal)*100;

		tbExePerc.setText(String.valueOf(exePerc));
		tbPassPerc.setText(String.valueOf(passPerc));
	}

	private void clearUserstoriesTextBoxes() {
		
		tbUserstoryID.clear();
		cbEntity.getSelectionModel().clearSelection();
		cbStatus.getSelectionModel().clearSelection();
		tbTotalTc.setText("0");
		tbPass.setText("0");
		tbFailed.setText("0");
		tbBlocked.setText("0");;
		tbNoRun.setText("0");
		tbDefer.setText("0");
		tbExePerc.setText("0.0");
		tbPassPerc.setText("0.0");
		tbOutstandDef.clear();
		tbComments.clear();
			
	}


}
