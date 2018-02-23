package project_Nestle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GMap_data {
	
	static double Lat[];
	static double Long[];
	static String Name[];
	
	//opens an excel sheet and reads the value from the 2nd col
	//stores them in an array and returns the array
	@SuppressWarnings({ "resource", "deprecation" })
	public double[] getLat() throws IOException, URISyntaxException{
		InputStream file = new Source().getFile();//gets the source i.e. file path
		XSSFWorkbook workbook = new XSSFWorkbook(file);//opens the excel file
		XSSFSheet spreadsheet = workbook.getSheetAt(3);//opens the relevant sheet
		XSSFRow row; //used to store the row
		Lat=new double[spreadsheet.getLastRowNum()+1];//used to store the excel data
		 for (int rowIndex = 0; rowIndex <= spreadsheet.getLastRowNum(); rowIndex++) {
			 row = spreadsheet.getRow(rowIndex);//stored row
		  	 Cell cell = row.getCell(1, Row.CREATE_NULL_AS_BLANK);//stores cell data from a specified col
		  	 cell.setCellType(Cell.CELL_TYPE_NUMERIC);//change data to numeric value
		  	 Lat[rowIndex] = cell.getNumericCellValue();//store value in array
		 }
		 file.close();//close file
		return Lat;//return array
	}
	
	//similar to the above method
	//opens an excel sheet and reads the value from the 3rd col
	//stores them in an array and returns the array
	@SuppressWarnings({ "resource", "deprecation" })
	public double[] getLong() throws IOException, URISyntaxException{
		
		InputStream file = new Source().getFile();
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet spreadsheet = workbook.getSheetAt(3);
		XSSFRow row;
		Long=new double[spreadsheet.getLastRowNum()+1];
		 for (int rowIndex = 0; rowIndex <= spreadsheet.getLastRowNum(); rowIndex++) {
			 row = spreadsheet.getRow(rowIndex); 
		  	 Cell cell = row.getCell(2, Row.CREATE_NULL_AS_BLANK);
		  	 cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		  	Long[rowIndex] = cell.getNumericCellValue();
		 }
		 file.close();
		return Long;
	}

	//similar to above method
	//opens a excel sheet and reads the value from the 1st col
	//stores them in an array and returns the array
	@SuppressWarnings({ "resource", "deprecation" })
	public String[] getTitle() throws IOException, URISyntaxException{
		InputStream file = new Source().getFile();
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet spreadsheet = workbook.getSheetAt(3);
		XSSFRow row;
		Name=new String[spreadsheet.getLastRowNum()+1];
		 for (int rowIndex = 0; rowIndex <= spreadsheet.getLastRowNum(); rowIndex++) {
			 row = spreadsheet.getRow(rowIndex); 
		  	 Cell cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
		  	 cell.setCellType(Cell.CELL_TYPE_STRING);
		  	 Name[rowIndex]=cell.getStringCellValue();
		 }
		 file.close();
		return Name;
	}
}
