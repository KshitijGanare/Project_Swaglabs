package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	public static String getData(String value) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Project_Swaglabs\\TestData\\Data");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(value);
	
	}
}
