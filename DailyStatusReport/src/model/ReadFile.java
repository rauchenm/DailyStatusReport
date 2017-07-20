package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReadFile {

	private File file;
//	private String path1 = "D:\\Privat\\DSR_Reports.txt";
	private String path2 = "C:\\Users\\Markus\\Downloads\\DSR_Reports.txt";
	

	public ObservableList<Userstory> readFile() {
		
//		file = new File(path1);
		file = new File(path2);
		String line ="";
		
		BufferedReader reader;
		ObservableList<String> olReports = FXCollections.observableArrayList();

		try {
			reader = new BufferedReader(new FileReader(file));
			 while ((line = reader.readLine()) != null) {
					
	                olReports.add(line);
			 }
			 reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return makeReports(olReports);
		
	}


	private ObservableList<Userstory> makeReports(ObservableList<String> olReports) {
		
		String[] line = null;
		
		ObservableList<Userstory> usl = FXCollections.observableArrayList();
		
		for (int i = 1; i < olReports.size(); i++) {
			Userstory us = new Userstory();
			line = olReports.get(i).split(";");
			us.setReportId(line[1].trim());
			us.setUserStoryID(line[2].trim());
			us.setEntity(line[3].trim());
			us.setStatus(line[4].trim());
			us.setTcTotal(Integer.valueOf(line[5].trim()));
			us.setTcPass(Integer.valueOf(line[6].trim()));
			us.setTcFail(Integer.valueOf(line[7].trim()));
			us.setTcBlocked(Integer.valueOf(line[8].trim()));
			us.setTcNoRun(Integer.valueOf(line[9].trim()));
			us.setTcDefer(Integer.valueOf(line[10].trim()));
			us.setTcExePerc(Integer.valueOf(line[11].trim()));
			us.setComments(line[12].trim());
			usl.add(us);
			
		}
		
		
		return usl;
		
		
	}

}
