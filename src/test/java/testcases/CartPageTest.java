package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartPageTest extends Testbase{
	
	LoginPage login;
	InventoryPage invent;
	CartPage cart;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		invent = new InventoryPage();
		cart = new CartPage();
		
		login.verifyLoginToApplication();
		
	}
	
	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression"}) 
	public void verifyOrderPriceTest() 
	{ 
		String expPrice = "32.39"; 
		String actPrice = cart.verifyOrderPrice(); 
		Assert.assertEquals(actPrice, expPrice); 
	} 
	
	
	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression"})
	public void verifyBackpacklinkTest()
	{
		String expUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		String actUrl = cart.verifyBackpacklink();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	
	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression"})
	public void verifyBikeLightLink()
	{
		String expUrl = "https://www.saucedemo.com/inventory-item.html?id=0";
		String actUrl = cart.verifyBikeLightgLink();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	
	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression"})
	public void verifyContinueShoppingBtnTest()
	{
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = cart.verifyContinueBtn();
		Assert.assertEquals(actUrl, expUrl);
	}

	
	@AfterMethod(alwaysRun = true)
    public void tearDown()
    {
		driver.close();
    }
}
