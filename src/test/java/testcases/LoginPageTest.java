package testcases;

import static org.testng.Assert.assertEquals; 

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Testbase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends Testbase{

	LoginPage login;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test(priority = 0)
	public void verifyTitleTest()
	{
		String expTitle = "Swag Labs";
		String actTitle = login.verifyTitle();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test(priority = 1)
	public void verifyUrlTest()
	{
		String expUrl = "https://www.saucedemo.com/";
		String actUrl = login.verifyUrl();
		Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test(priority = 2)
	public void verifyLoginToApplicationTest()
	{
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = login.verifyLoginToApplication();
		Assert.assertEquals(expUrl, actUrl);
	}

	// ============================ Data Provider ================================== //
	@DataProvider(name = "CredentialsSet1")
	public Object[][] dataset1()
	{
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
		};
	}
	
	@Test(dataProvider = "CredentialsSet1")
	public void verifyLoginMultiCredsTest(String username, String password) throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = login.verifyLoginMultiCreds(username, password);
		sa.assertEquals(expUrl, actUrl);
		sa.assertAll();
	}
	

	// ============================ Excel Data ================================== //
	@DataProvider(name = "ExcelData")
	public Object[][] excelData() throws EncryptedDocumentException, IOException
	{
		int row = 6;
		int col = 2;
		
		Object[][] data = new Object[row][col];  // Defined size of array
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				data[i][j] = ReadData.getExcel(i, j);   // Looping and adding data into array
			}
		}
		
		return data;
	}
	
	
	@Test(dataProvider = "ExcelData")
	public void verifyLoginMultiCredsTestExcel(String username, String password) throws IOException, InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = login.verifyLoginMultiCreds(username, password);
		sa.assertEquals(expUrl, actUrl);
		sa.assertAll();
	}
	
	// ===========================================================================  ==
	
	@AfterMethod
	public void tearDown(ITestResult itr) throws IOException
	{
		if(itr.FAILURE==itr.getStatus())
		{
		    Screenshot.getScreenshot(itr.getName());
		}		
		driver.close();
	}

}





