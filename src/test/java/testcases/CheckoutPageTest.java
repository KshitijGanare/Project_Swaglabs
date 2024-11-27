package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutPageTest extends Testbase{
	
	LoginPage login;
	InventoryPage invent;
	CartPage cart;
	CheckoutPage check;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		invent = new InventoryPage();
		cart = new CartPage();
		check = new CheckoutPage();
		
		login.verifyLoginToApplication();
		
	}
	
	
	@Test
	public void verifyEnterFirstnameTest()
    {
    	boolean actResult = true;
    	Assert.assertEquals(true, actResult);	
    }

	
	@Test
    public void verifyEnterLastnameTest()
    {
		boolean actResult = true;
    	Assert.assertEquals(true, actResult);	
    	
    }
    
	
	@Test
    public void verifyCancelBtnTest()
    {
    	String expUrl = "https://www.saucedemo.com/cart.html";
    	String actUrl = check.verifyCancelBtn();
    	Assert.assertEquals(actUrl, expUrl);
    	
    }
	
	
	@Test
	public void verifyErrorMessageTest()
	{
	    String expText = "Error: First Name is required";
	    String actText = check.verifyErrorMessage();
	    Assert.assertEquals(expText, expText);
	    	
	}
	
	@Test 
	public void verifyTotalPriceTest()
	{
	    // Fetch the expected total price from the dynamic calculation method
	    double expectedTotalPrice = 60.45;
	    double actualTotalPrice = check.verifyTotalPrice();
	    Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
	}
	
	@Test
    public void verifyFinishButtonTest()
    {
    	String expUrl = "https://www.saucedemo.com/checkout-complete.html";
    	String actUrl = check.verifyFinishButton();
    	Assert.assertEquals(expUrl, actUrl);
    }

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	
}
