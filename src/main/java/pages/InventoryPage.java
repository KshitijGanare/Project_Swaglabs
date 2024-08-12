package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class InventoryPage extends Testbase{
	
	// Object Repository
	// 1. BackPack Product
	@FindBy(xpath = "//div[normalize-space()='Sauce Labs Backpack']") private WebElement backPackLink;
	@FindBy(xpath = "//div[normalize-space()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']") private WebElement backPackText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]") private WebElement backPackPrice;
	@FindBy(xpath = "//img[@alt='Sauce Labs Backpack']") private WebElement backPackThumbnailImg;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackAddCartBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removebackPackBtn;
	
	// Cart 
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;

	
	// Checkout Page
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
   
	// Detail Page
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postCode;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	
	
	// Finish Page
    @FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
    
    // Checkout Finish
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']") private WebElement thankyouMessage;


	// Initialization
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	
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
	
	public String verifyAddToCartBadgeCount()
	{
	    backPackAddCartBtn.click();
	    return cartCount.getText();
	}
	
	public String verifyCheckOut()
	{
		cartIcon.click();
		checkoutBtn.click();
		firstName.sendKeys("Virat");
		lastName.sendKeys("Kohli");
		postCode.sendKeys("111222");
		continueBtn.click();
		finishBtn.click();
		
		return thankyouMessage.getText();
				
	}
	
}














