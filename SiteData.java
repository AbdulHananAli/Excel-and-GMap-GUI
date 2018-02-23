package project_Nestle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SiteData {

	String Data[];
	String Header[];
	@SuppressWarnings({ "deprecation", "resource" })
	public String[] getData(String code) throws IOException, URISyntaxException{
		InputStream file = new Source().getFile();
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet spreadsheet = workbook.getSheetAt(1);
		String value;
		XSSFRow row;
		
		 for (int rowIndex = 0; rowIndex <= spreadsheet.getLastRowNum(); rowIndex++) {
			 row = spreadsheet.getRow(rowIndex); 
		  	 Cell cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
		  	 cell.setCellType(Cell.CELL_TYPE_STRING);
		  	 value = cell.getStringCellValue();
		  	      
		  	 if(value.contentEquals(code)){
		  	    	int y =0;  Data=new String[row.getLastCellNum()];
		  	    	while (y <=row.getLastCellNum()-1){
				    	   Cell cell2 = row.getCell(y, Row.CREATE_NULL_AS_BLANK);
				    	   cell2.setCellType(Cell.CELL_TYPE_STRING);
				    	   Data[y]=cell2.getStringCellValue();
					       y++;
				       }
		  	      }
		 file.close();
		 }
		return Data;
	}
	
	@SuppressWarnings({ "unused", "deprecation", "resource" })
	public String[] getHeader () throws IOException, URISyntaxException{
		InputStream file = new Source().getFile();
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet spreadsheet = workbook.getSheetAt(2);
		String value;
		XSSFRow row;
		
		row = spreadsheet.getRow(0);
		int z =0;  Header=new String[row.getLastCellNum()];
		while (z <=row.getLastCellNum()-1){
	    	   Cell cell = row.getCell(z, Row.CREATE_NULL_AS_BLANK);	  
	    	   cell.setCellType(Cell.CELL_TYPE_STRING);
	    	   Header[z]=cell.getStringCellValue();
		       z++;
	       }
		file.close();
		return Header;
	}
}
