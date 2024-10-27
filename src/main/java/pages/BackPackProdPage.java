package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Testbase;

public class BackPackProdPage extends Testbase{
	
	// Object Repository
	@FindBy(xpath = "//div[@class='inventory_details_name large_size']") private WebElement backPackTitle;
	@FindBy(xpath = "//img[@alt='Sauce Labs Backpack']") private WebElement backPackThumbnail;
	@FindBy(xpath = "//div[@class='inventory_details_desc large_size']") private WebElement backPackDetais;
	@FindBy(xpath = "//div[@class='inventory_details_price']") private WebElement backPackPrice;
	
	@FindBy(xpath = "//div[@class='inventory_details_price']") private WebElement backPackAddCartButton;
	@FindBy(xpath = "//div[@class='inventory_details_price']") private WebElement backPackRemoveButton;
	@FindBy(xpath = "//div[@class='inventory_details_price']") private WebElement cartBadgeCount;
	
	@FindBy(xpath = "//div[@class='inventory_details_price']") private WebElement backToProductButton;

	// Initialization
	public BackPackProdPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	// Methods
	 public Boolean verifyBackPackTitle()
	 {
		 return backPackTitle.isDisplayed();  // True
	 }
	
	 public Boolean verifyBackPackThumbnailImg()
	 {
		 return backPackDetais.isDisplayed();
	 }
	 
	 public Boolean verifyBackPackDetails()
	 {
		 return backPackDetais.isDisplayed();
	 }
	 
	 public Boolean verifyBackPackPrice()
	 {
		 return backPackPrice.isDisplayed();
	 }
	 
	 public Boolean verifyBackPackPgAddCartButton()
	 {
		 backPackAddCartButton.click();
		 wait.until(ExpectedConditions.visibilityOf(cartBadgeCount)); 
		 
		try {
			return cartBadgeCount.isDisplayed();  // True == TC Passed  , We want this
		} catch (NoSuchElementException e) {
			return false; // False == TC Failed
		}
		 
	 }
	 
	 public Boolean verifyBackPackPgRemoveButton()
	 {
		 backPackRemoveButton.click();
		 wait.until(ExpectedConditions.visibilityOf(backPackRemoveButton));
		 
		 try {
			 return cartBadgeCount.isDisplayed();  
		 }catch (NoSuchElementException e) {
			return false;           // Want this
		}
	 }
	 
	 public String verifyBackToProductsButton() throws InterruptedException
	 {
		 backToProductButton.click();
		 wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
		 return driver.getCurrentUrl();
	 }

}









