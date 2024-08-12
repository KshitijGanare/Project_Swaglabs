package testcases;

import java.io.IOException;

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
import utility.Screenshot;

public class LoginPageTest extends Testbase{

	LoginPage login;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
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
	
	@DataProvider(name = "CredentialsSet1")
	public Object[][] dataset1()
	{
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
		};
	}
	
	@Test(dataProvider = "CredentialsSet1")
	public void loginWithMultiCreds(String username, String password) throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = login.verifyLoginToApplicationMultiCreds(username, password);
		sa.assertEquals(expUrl, actUrl);
		sa.assertAll();
	}
	
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
