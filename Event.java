package project_A;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

	
public class Event {
	
	@SuppressWarnings({ "deprecation", "resource", "unused" })
	public ObservableList<Table_data> eventAll() throws IOException, URISyntaxException{
		InputStream file = new Source().getFile();
		ObservableList<Table_data> All = FXCollections.observableArrayList();
		XSSFRow row;
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet spreadsheet = workbook.getSheetAt(1);
	    Iterator < Row > rowIterator = spreadsheet.iterator();
		   while (rowIterator.hasNext()){
		       row = (XSSFRow) rowIterator.next(); 
		       Iterator < Cell > cellIterator = row.cellIterator();
			   int x =0; String AR[]=new String[5];
		       while (x <=4){
		    	   Cell cell = row.getCell(x, Row.CREATE_NULL_AS_BLANK);	  
		    	   	 cell.setCellType(Cell.CELL_TYPE_STRING);
		    	   	 AR[x]=cell.getStringCellValue(); 
			         x++;
		       }
		   All.add(new Table_data(AR[0],AR[1],AR[2],AR[3],AR[4]));
		   }
		   file.close();
		return All;
	}
	
	@SuppressWarnings({ "resource", "unused", "deprecation" })
	public ObservableList<Table_data> eventSearch (String megaString, int x) throws IOException, URISyntaxException {
		  InputStream file = new Source().getFile();
		  ObservableList<Table_data> All = FXCollections.observableArrayList();
		  megaString = megaString.toUpperCase();
		  x = x-1;
		  XSSFRow row; 
		  String value;
		  XSSFWorkbook workbook = new XSSFWorkbook(file);
		  XSSFSheet spreadsheet = workbook.getSheetAt(1);
		  for (int rowIndex = 0; rowIndex <= spreadsheet.getLastRowNum(); rowIndex++) {
			  row = spreadsheet.getRow(rowIndex);
		  	  Cell cell = row.getCell(x, Row.CREATE_NULL_AS_BLANK);
		  	  cell.setCellType(Cell.CELL_TYPE_STRING);
		  	  value = cell.getStringCellValue();
		  	  value = value.toUpperCase();
		  	      if(value.contentEquals(megaString)){
		  	    	  Iterator < Cell > cellIterator = row.cellIterator();
		  	    	  int y =0; String AR[]=new String[5];
				      while (y <=4){
				    	   Cell cell2 = row.getCell(y, Row.CREATE_NULL_AS_BLANK);	  
				    	   	 cell2.setCellType(Cell.CELL_TYPE_STRING);
				    	   	 AR[y]=cell2.getStringCellValue(); 
					         y++;
				       }
				   All.add(new Table_data(AR[0],AR[1],AR[2],AR[3],AR[4]));
		  	      }
		  }
		  file.close();
		return All;
		}
}
