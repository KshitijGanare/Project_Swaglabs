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
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		invent = new InventoryPage();
		cart = new CartPage();
		
		login.verifyLoginToApplication();
		
	}
	
	@Test 
	public void verifyOrderPriceTest() 
	{ 
		String expPrice = "32.39"; 
		String actPrice = cart.verifyOrderPrice(); 
		Assert.assertEquals(actPrice, expPrice); 
	} 
	
	
	@Test
	public void verifyBackpacklinkTest()
	{
		String expUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		String actUrl = cart.verifyBackpacklink();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	
	@Test
	public void verifyBikeLightLink()
	{
		String expUrl = "https://www.saucedemo.com/inventory-item.html?id=0";
		String actUrl = cart.verifyBikeLightgLink();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	
	@Test
	public void verifyContinueShoppingBtnTest()
	{
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = cart.verifyContinueBtn();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@AfterMethod
    public void tearDown()
    {
		driver.close();
    }
}
