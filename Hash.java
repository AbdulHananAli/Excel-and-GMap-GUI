package project_Nestle;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hash {

	@SuppressWarnings({ "resource", "static-access", "deprecation" })
	public HashSet<String> getSet() throws IOException{

		InputStream file = new Source().getFile();
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheetAt(1);
				
		HashSet <String> set = new HashSet<>();

		for(int r=0; r<=sheet.getLastRowNum();r++){
			XSSFRow Row = sheet.getRow(r);
			for(int c=1; c<=4;c++){
				XSSFCell Cell = Row.getCell(c,Row.CREATE_NULL_AS_BLANK);
				String Value = Cell.getStringCellValue();
				if(Value.equals("")){
				}else{
					set.add(Value);
				}
			}
		}
		file.close();
		return set;
	}
}
