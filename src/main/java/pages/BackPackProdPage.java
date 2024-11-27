package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
	
	@FindBy(xpath = "//button[@id='add-to-cart']") private WebElement backPackAddCartButton;
	@FindBy(xpath = "//button[@id='remove']") private WebElement backPackRemoveButton;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartBadgeCount;
	
	@FindBy(xpath = "//button[@id='back-to-products']") private WebElement backToProductButton;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;

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
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='shopping_cart_badge']"))); // Stop till element gets disappeared
	        return true; // Cart counter successfully removed		
	        } 
	        catch (NoSuchElementException e) {
			return false; // False == TC Failed
		}
		 
	 }
	 
	 public Boolean verifyBackPackPgRemoveButton() throws InterruptedException
	 {
		 backPackAddCartButton.click();
		 Thread.sleep(3000);
		 
		 backPackRemoveButton.click();
		 wait.until(ExpectedConditions.visibilityOf(backPackRemoveButton));
		 
		 cartIcon.click();
		 Thread.sleep(2000);
		 return (driver.findElement(By.xpath("//div[@class='inventory_item_name']")).isDisplayed());
		 
//		 try {
//			    return backPackAddCartButton.isDisplayed();
//			} catch (NoSuchElementException | StaleElementReferenceException e) {
//			    return false;
//			}
	 }
	 
	 public String verifyBackToProductsButton() throws InterruptedException
	 {
		 backToProductButton.click();
		 wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
		 return driver.getCurrentUrl();
	 }

}









