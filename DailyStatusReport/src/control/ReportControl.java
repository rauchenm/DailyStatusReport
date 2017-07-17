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
import model.UserstoryList;

public class ReportControl implements Initializable{
	
	//Report Overview
	@FXML
	private Label lbReportId;
	@FXML
	private DatePicker dpReportDate;
	
	//Report Highlights
	@FXML
	private TextField tbHiglight;
	@FXML
	private ListView<String> lvHighlights;
	
	//Report Issues
	@FXML
	private TextField tbIssue;
	@FXML
	private ListView<String> lvIssues;
	
	// Report Userstories
	@FXML
	private ListView<String> lvUserstories;
	@FXML
	private Button btAddHighlight;
	@FXML
	private Button btAddIssue;
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
	private Button btAddUserStoryInf;
	
	@FXML
	private Button btGenerateReport;

	UserstoryList userstoryList  = new UserstoryList();
	IssueList issueList  = new IssueList();
	HighlightList highlightList = new HighlightList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	cbStatus.setItems(FXCollections.observableArrayList("Status", "Test"));
	cbEntity.setItems(FXCollections.observableArrayList("COM", "GIP","LIF", "CLA"));
	lbReportId.setText(UUID.randomUUID().toString());

	
	
	
	
	}
	
	@FXML
	private void addHighlight() {
		
		
	}
	
	@FXML
	private void addIssue() {
		
		
		
		
	}
	
	@FXML
	private void generateReport() {
		
		
		
		
	}
	@FXML
	private void addUserstoryInf() {
		
//		Userstory us = new Userstory(tbUserstoryID.getText(), cbEntity.getSelectionModel().getSelectedItem(), );
		
		
		
		
	}
	
	
}
