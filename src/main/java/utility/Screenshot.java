package utility;

import java.io.File; 
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.Testbase;

public class Screenshot extends Testbase{
	
	public static String getDate()
	{
		 return new SimpleDateFormat("dd-MM-YYY ss-mm-HH").format(new Date());
	}
	
	public static void getScreenshot(String nameOfMethod) throws IOException
	{	
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File("C:\\Users\\Hp\\eclipse-workspace\\Project_Swaglabs\\Screenshots\\"+nameOfMethod+"---"+getDate()+".jpeg");
		 FileHandler.copy(source, dest);
	}

}







