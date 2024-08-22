package testcases;

import java.io.IOException;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Testbase;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryPageTest extends Testbase{
	
	LoginPage login;
	InventoryPage invent;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		invent = new InventoryPage();		
		login.verifyLoginToApplication();
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBackpackLinkTest()
	{
	    String expUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
	    String actUrl = invent.verifyBackpackLink();
	    Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBackPackTextTest()
	{
		Boolean exp = true;
		Boolean act = invent.verifyBackPackText();
		Assert.assertEquals(exp, act);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBackPackThumbnailImgTest()
	{
		String expUrll = "https://www.saucedemo.com/inventory-item.html?id=4";
		String actUrll = invent.verifyBackPackThumbnailImg();
		Assert.assertEquals(expUrll, actUrll);
	}
	
	@Test(priority = 1, enabled = true)
    public void verifyBackPackPriceTest()
    {
		Boolean actResult = invent.verifyBackPackPrice();
		Assert.assertEquals(true, actResult);
    }
	
	// BikeLight Product
	
	@Test(priority = 1, enabled = true)
	public void verifyBikeLightLinkTest()
	{
	    String expUrl = "https://www.saucedemo.com/inventory-item.html?id=0";
	    String actUrl = invent.verifyBikeLightLink();
	    Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBikeLightTextTest()
	{
		Boolean exp = true;
		Boolean act = invent.verifyBikeLightText();
		Assert.assertEquals(exp, act);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBikeLightThumbnailImgTest()
	{
		String expUrll = "https://www.saucedemo.com/inventory-item.html?id=0";
		String actUrll = invent.verifyBikeLightThumbnailImg();
		Assert.assertEquals(expUrll, actUrll);
	}
	
	
	@Test(priority = 1, enabled = true)
    public void verifyBikeLightPriceTest()
    {
		Boolean actResult = invent.verifyBikeLightPrice();
		Assert.assertEquals(true, actResult);
    }
	
	
	// 3. BoltTshirt Product
	
	@Test(priority = 1, enabled = true)
	public void verifyBoltTshirtLinkTest()
	{
	    String expUrl = "https://www.saucedemo.com/inventory-item.html?id=1";
	    String actUrl = invent.verifyBoltTshirtLink();
	    Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBoltTshirtTextTest()
	{
		Boolean exp = true;
		Boolean act = invent.verifyBikeLightText();
		Assert.assertEquals(exp, act);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyBoltTshirtThumbnailImgTest()
	{
		String expUrll = "https://www.saucedemo.com/inventory-item.html?id=1";
		String actUrll = invent.verifyBoltTshirtThumbnailImg();
		Assert.assertEquals(expUrll, actUrll);
	}
	
	
	@Test(priority = 1, enabled = true)
    public void verifyBoltTshirtPriceTest()
    {
		Boolean actResult = invent.verifyBikeLightPrice();
		Assert.assertEquals(true, actResult);
    }
	
	
	// 4. Fleece Jacket Product
	
	@Test(priority = 1, enabled = true)
	public void verifyFleeceJacketTest()
	{
	    String expUrl = "https://www.saucedemo.com/inventory-item.html?id=5";
	    String actUrl = invent.verifyFleeceJacketLink();
	    Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyFleeceJacketTextTest()
	{
		Boolean exp = true;
		Boolean act = invent.verifyFleeceJacketText();
		Assert.assertEquals(exp, act);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyFleeceJacketThumbnailImgTest()
	{
		String expUrll = "https://www.saucedemo.com/inventory-item.html?id=5";
		String actUrll = invent.verifyFleeceJacketThumbnailImg();
		Assert.assertEquals(expUrll, actUrll);
	}
	
	
	@Test(priority = 1, enabled = true)
    public void verifyFleeceJacketPriceTest()
    {
		Boolean actResult = invent.verifyFleeceJacketPrice();
		Assert.assertEquals(true, actResult);
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// Side Menu Test
	@Test
	public void verifyAboutMenuLinkTest() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		String expUrla = "https://saucelabs.com/";
		String actUrla = invent.verifyAboutMenuLink();
		sa.assertEquals(expUrla, actUrla);
	}
	
	@Test(enabled = true)
	public void verifylogoutLinkTest()
	{
		String expUrlc = "https://www.saucedemo.com/";
		String actUrlc = invent.verifylogoutLink();
		Assert.assertEquals(expUrlc, actUrlc);
	}
	
	@Test(enabled = true)
	public void verifyResetAppStateTest() throws InterruptedException
	{
		Boolean actState = invent.verifyResetAppState();
		Assert.assertEquals(false, actState,"Testcase failed as remove button is still displayed");
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test(priority = 1, enabled = true)
	public void verifyDropdownTest() throws InterruptedException
	{
		invent.verifyDropdown();
	}
	
	
	///////////////////////////////////////// Footer Section  /////////////////////////////////
	@Test(priority = 1, enabled = true)
	public void verifyTwitterLogoTest() throws InterruptedException
	{
		Boolean expUrl = invent.verifyTwitterLogo();
		Assert.assertEquals(true, expUrl);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyFacebookLogoTest()
	{
		Boolean actUrl = invent.verifyFacebookLogo();
		Assert.assertEquals(true, actUrl);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyLinkedInLogoTest() throws InterruptedException
	{
		Boolean actUrll = invent.verifyLinkedInLogo();
		Assert.assertEquals(true, actUrll);
	}
	
	@Test
	public void verifyFooterText()
	{
		Boolean actResult = invent.verifyFooterText();
		Assert.assertEquals(true, actResult);
	}
	
	
	@Test(enabled = false)
	public void verifyMouseMovementTest() throws InterruptedException
	{
		String expCount = "4";
		String actCount = invent.verifyMouseMovement();
		Assert.assertEquals(expCount, actCount);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	

}
