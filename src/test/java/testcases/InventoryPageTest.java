package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryPageTest extends Testbase{
	
	LoginPage login;
	InventoryPage invent;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		login = new LoginPage();
		invent = new InventoryPage();		
		login.verifyLoginToApplication();
	}
	
	@Test
	public void verifyBackpackLinkTest()
	{
	    String expUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
	    String actUrl = invent.verifyBackpackLink();
	    Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test
	public void verifyBackPackTextTest()
	{
		Boolean exp = true;
		Boolean act = invent.verifyBackPackText();
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void verifyBackPackThumbnailImgTest()
	{
		String expUrll = "https://www.saucedemo.com/inventory-item.html?id=4";
		String actUrll = invent.verifyBackPackThumbnailImg();
		Assert.assertEquals(expUrll, actUrll);
	}
	
	@Test
	public void verifyAddToCartBadgeCountTest()
	{
		String expCount = "1";
		String actCount = invent.verifyAddToCartBadgeCount();
		Assert.assertEquals(expCount, actCount);
	}
	
	@Test
	public void verifyCheckOutTest()
	{
		String expText = "Thank you for your order!";
		String actText = invent.verifyCheckOut();
		Assert.assertEquals(expText, actText);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	

}
