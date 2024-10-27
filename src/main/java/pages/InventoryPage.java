package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Testbase;
import utility.DropdownMenu;

public class InventoryPage extends Testbase{
	
	// Object Repository
	
	//////////////////////     PRODUCTS    //////////////////////////////
	// 1. BackPack Product
	@FindBy(xpath = "//div[normalize-space()='Sauce Labs Backpack']") private WebElement backPackLink;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[1]") private WebElement backPackText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]") private WebElement backPackPrice;
	@FindBy(xpath = "//img[@alt='Sauce Labs Backpack']") private WebElement backPackThumbnailImg;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackAddCartBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removebackPackBtn;
	
	
	// 2. Bike Light Product
	@FindBy(xpath = "//div[normalize-space()='Sauce Labs Bike Light']") private WebElement bikeLightLink;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[2]") private WebElement bikeLightText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]") private WebElement bikeLightPrice;
	@FindBy(xpath = "//img[@alt='Sauce Labs Bike Light']") private WebElement bikeLightThumbnailImg;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightAddCartBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLightBtn;
	
	// 3. Sauce Labs Bolt T-Shirt
	@FindBy(xpath = "//div[normalize-space()='Sauce Labs Bolt T-Shirt']") private WebElement boltTshirtLink;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[3]") private WebElement boltTshirtText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]") private WebElement boltTshirtPrice;
	@FindBy(xpath = "//img[@alt='Sauce Labs Bolt T-Shirt']") private WebElement boltTshirtThumbnailImg;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtAddCartBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtRemoveBtn;


	// 4. Sauce Labs Fleece Jacket
	@FindBy(xpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']") private WebElement fleeceJacketLink;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[4]") private WebElement fleeceJacketText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]") private WebElement fleeceJacketPrice;
	@FindBy(xpath = "//img[@alt='Sauce Labs Fleece Jacket']") private WebElement fleeceJacketThumbnailImg;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketAddCartBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement fleeceJacketRemoveBtn;
	
	
	// 5.Sauce Labs Onesie
	@FindBy(xpath = "//div[normalize-space()='Sauce Labs Onesie']") private WebElement onsieProductLink;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[5]") private WebElement onsieProductText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[2]/div[2]/div[1]") private WebElement onsieProductPrice;
	@FindBy(xpath = "//img[@alt='Sauce Labs Onesie']") private WebElement onsieProductThumbnailImg;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onsieProductAddCartBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement onsieProductRemoveBtn;
	
	
	
	// 6. Test.allTheThings() T-Shirt (Red)
	@FindBy(xpath = "//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']") private WebElement allTheThingsLink;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[6]") private WebElement allTheThingsLinkText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]") private WebElement allTheThingsPrice;
	@FindBy(xpath = "//img[@alt='Test.allTheThings() T-Shirt (Red)']") private WebElement allTheThingsThumbnailImg;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement allTheThingsAddCartBtn;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement allTheThingsRemoveBtn;
	
	////////////////////// HAMBURGER MENU  //////////////////////////
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement hamburgerBtn;
	@FindBy(xpath = "//a[@id='about_sidebar_link']") private WebElement aboutLink;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']") private WebElement logoutLink;
	@FindBy(xpath = "//a[@id='reset_sidebar_link']") private WebElement resetAppLink;
	@FindBy(xpath = "//button[@id='react-burger-cross-btn']") private WebElement menuCrossBtn;
	
	
    //////////////////////    OTHER    //////////////////////////////
	// Cart 
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
    @FindBy(xpath = "//select[@class='product_sort_container']") private WebElement cartDropdown;
	
    
    // Footer
    @FindBy(xpath="//a[normalize-space()='Twitter']") private WebElement twitterLogo;
    @FindBy(xpath="//li[@class='social_facebook']") private WebElement facebookLogo;
    @FindBy(xpath="//li[@class='social_linkedin']") private WebElement linkedInLogo;
    
    @FindBy(xpath="//div[@class='footer_copy']") private WebElement footerText; // Footer Tetxt


    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    
	// Initialization
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	
	// 1. Back Pack product
	public String verifyBackpackLink()
	{
		backPackLink.click();
		return driver.getCurrentUrl();
	}
	
	public Boolean verifyBackPackText()
	{
		return backPackText.isDisplayed();

	}
	
	public String verifyBackPackThumbnailImg()
	{
		backPackThumbnailImg.click();
		return driver.getCurrentUrl();
	}
	
	public Boolean verifyBackPackPrice()
	{
		return backPackPrice.isDisplayed();	
	}

	// 2. BikeLight Product
	
	public String verifyBikeLightLink()
	{
		bikeLightLink.click();
		return driver.getCurrentUrl();
	}
	
	public Boolean verifyBikeLightText()
	{
		return bikeLightText.isDisplayed();

	}
	
	public String verifyBikeLightThumbnailImg()
	{
		bikeLightThumbnailImg.click(); 
		return driver.getCurrentUrl();
	}
	
	public Boolean verifyBikeLightPrice()
	{
		return backPackPrice.isDisplayed();	
	}
	
	
	// 3. BoltTshirt Product
	
	public String verifyBoltTshirtLink()
	{
		boltTshirtLink.click();
		return driver.getCurrentUrl();
	}
	
	public Boolean verifyBoltTshirtText()
	{
		return boltTshirtText.isDisplayed();

	}
	
	public String verifyBoltTshirtThumbnailImg()
	{
		boltTshirtThumbnailImg.click(); 
		return driver.getCurrentUrl();
	}
	
	public Boolean verifyBoltTshirtPrice()
	{
		return boltTshirtPrice.isDisplayed();	
	}
	
	
	// 4. FleeceJacket Product
	
		public String verifyFleeceJacketLink()
		{
			fleeceJacketLink.click();
			return driver.getCurrentUrl();
		}
		
		public Boolean verifyFleeceJacketText()
		{
			return fleeceJacketText.isDisplayed();

		}
		
		public String verifyFleeceJacketThumbnailImg()
		{
			fleeceJacketThumbnailImg.click(); 
			return driver.getCurrentUrl();
		}
		
		public Boolean verifyFleeceJacketPrice()
		{
			return fleeceJacketPrice.isDisplayed();	
		}
		
	
	
	
	
	
	
	
	public void verifyDropdown() throws InterruptedException
	{
		DropdownMenu.selectByVisibleText(cartDropdown, "Name (A to Z)");
		Thread.sleep(2000);
		DropdownMenu.selectByVisibleText(cartDropdown, "Name (Z to A)");
		Thread.sleep(3000);
		
	}
	
	
	
	// Side Bar/Menu
	public String verifyAboutMenuLink() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		hamburgerBtn.click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(aboutLink));
		aboutLink.click();
		return driver.getCurrentUrl();
	}
	
	public String verifylogoutLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		hamburgerBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		logoutLink.click();
		
		return driver.getCurrentUrl();
		
	}
	
	public Boolean verifyResetAppState() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		backPackAddCartBtn.click();
		bikeLightAddCartBtn.click();
		fleeceJacketAddCartBtn.click();
		boltTshirtAddCartBtn.click();
		
		hamburgerBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(resetAppLink));
		resetAppLink.click();
		Thread.sleep(1500);
		
		try {
			return removebackPackBtn.isDisplayed();  // True if remove button is displayed
		} catch (NoSuchElementException nse) {
			return false;  // False if remove button not present, means tc passed
		}
		
	}
	
	public Boolean verifyMenuCrossButton() throws InterruptedException
	{
		hamburgerBtn.click();
		waits.until(ExpectedConditions.elementToBeClickable(menuCrossBtn));
		menuCrossBtn.click();
		Thread.sleep(2000);
		
		try {
			return aboutLink.isDisplayed();  // If True = TC failed
		} catch (NoSuchElementException e) {
		    return false; // If False - TC passed
		}	
		
	}
	
	
	// Footer 
	public Boolean verifyTwitterLogo() throws InterruptedException
	{			    
		return twitterLogo.isDisplayed();
	}
	
	public Boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	
	public Boolean verifyLinkedInLogo()
	{
		return linkedInLogo.isDisplayed();
	}
	
	public Boolean verifyFooterText()
	{
		try {
			return footerText.isDisplayed();   // True if displayed
		} catch (NoSuchElementException e) {
			return false;  // False if not displayed
		}
	}
	
	
	
// MOUSE MOVEMENT CLASS
	
	public String verifyMouseMovement() throws InterruptedException
	{
	     Actions ac = new Actions(driver);
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     wait.until(ExpectedConditions.elementToBeClickable(backPackAddCartBtn));
	     ac.moveToElement(backPackAddCartBtn).click().build().perform();
	     
	     wait.until(ExpectedConditions.elementToBeClickable(backPackAddCartBtn));
	     ac.moveToElement(bikeLightAddCartBtn).click().build().perform();;
	     
	     wait.until(ExpectedConditions.elementToBeClickable(boltTshirtAddCartBtn));
	     ac.moveToElement(boltTshirtAddCartBtn).click().build().perform();;
	    
	     wait.until(ExpectedConditions.elementToBeClickable(fleeceJacketAddCartBtn));
	     ac.moveToElement(fleeceJacketAddCartBtn).click().build().perform();;
	     
	     return cartCount.getText();
	     
	}
	

}














