package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.BackPackProdPage;
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshot;

public class BackPackProductPageTest extends Testbase{
	
	LoginPage login;
	InventoryPage invent;
	BackPackProdPage backPack; 
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		invent = new InventoryPage();
		backPack = new BackPackProdPage();
		
		login.verifyLoginToApplication();
		invent.verifyBackpackLink();
	}
	
	
	@Test(priority = 4, enabled = true)
	public void verifyBackPackTitleTest()
	{
		Boolean act = backPack.verifyBackPackTitle();
        Assert.assertEquals(true, act);
	}
	
	@Test(priority = 3, enabled = true, groups = {"Sanity", "Regression"})
	public void verifyBackPackThumbnailImgTest()
	{
		Boolean act = backPack.verifyBackPackThumbnailImg();
		Assert.assertEquals(true, act);
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyBackPackDetailsTest()
	{
		Boolean act = backPack.verifyBackPackDetails();
		Assert.assertEquals(true, act);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBackPackPriceTest()
	{
		Boolean act = backPack.verifyBackPackPrice();
		Assert.assertEquals(true, act);
	}
	
	@Test(priority = 0, enabled = true, groups = {"Sanity", "Regression"})
	public void verifyBackPackPgAddCartButtonTest()
	{ 
		Boolean act = backPack.verifyBackPackPgAddCartButton();
		Assert.assertEquals(true, act);
	}
	
	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression"})
	public void verifyBackPackPgRemoveButtonTest() throws InterruptedException
	{
		Boolean act = backPack.verifyBackPackPgRemoveButton();
		Assert.assertEquals(true, act);
	}
	
	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression"})
	public void verifyBackToProductsButtonTest() throws InterruptedException
	{
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = backPack.verifyBackToProductsButton();
		Assert.assertEquals(expUrl, actUrl);
	}
	
	
	@AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult itr) throws IOException
    {
		if(itr.FAILURE == itr.getStatus())
		{
			Screenshot.getScreenshot(itr.getName());
		}
		driver.quit();
    }
	
}
