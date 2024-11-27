package utility;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static String getData(String value) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Project_Swaglabs\\src\\main\\java\\config\\Data");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(value);
	
	}
	
	public static String getExcel(int rown, int coln) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Project_Swaglabs\\TestData\\DataSheet.xlsx");
	    Sheet Sheet1 = WorkbookFactory.create(file).getSheet("Sheet1");
	    String data = Sheet1.getRow(rown).getCell(coln).getStringCellValue();
	    return data;
		
	}
	
}










