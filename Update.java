package project_Nestle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Update {

	@SuppressWarnings({ "deprecation", "resource" })
	public void Send(String NV[], String code) throws IOException, URISyntaxException {
		
		InputStream file = new Source().getFile();
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet spreadsheet = workbook.getSheetAt(1);
		String value;
		XSSFRow row;
		int C =0;
		for (int rowIndex = 0; rowIndex <= spreadsheet.getLastRowNum(); rowIndex++) {
			 row = spreadsheet.getRow(rowIndex); 
		  	 Cell cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
		  	 cell.setCellType(Cell.CELL_TYPE_STRING);
		  	 value = cell.getStringCellValue();     
		  	 if(value.contentEquals(code)){ 
		  		 for(int colIndex=0; colIndex<=row.getLastCellNum()-1; colIndex++){
		  			 Cell Cell = row.getCell(colIndex, Row.CREATE_NULL_AS_BLANK);
		  			 Cell.setCellValue(NV[C]);
		  			 C++;
		  		 }
			
		  	OutputStream fOP = new Source().giveFile();
		  	workbook.write(fOP);
			}
		 }
		
		file.close();
	}
}
