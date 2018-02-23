package project_Nestle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Source {

	private static String path = System.getProperty("user.dir")+File.separator+"dataSheet.xlsx";
	public InputStream getFile() throws FileNotFoundException {
		InputStream input = new FileInputStream(path);
		return input;
	}
	public OutputStream giveFile() throws FileNotFoundException{
		OutputStream output = new FileOutputStream(path);
	return output;
	}
}
