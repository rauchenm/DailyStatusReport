package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {

	private File file;
	private String path = "D:\\Privat\\DSR_Reports.txt";
	private ReportList reportList;

	public ReportList readFile() {
		
		file = new File(path);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		while(line = reader.readLine() {
//		reader.read()
//		}
		
		return reportList;
		
	}

}
