package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class CartPage extends Testbase{
	
	// Object Repository
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueShoppingBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removeBtn;

	// Checkout Page
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstNameField;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastNameField;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCodeField;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;

	// Checkout Page: Overview
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	
	// Products Add to Cart Btn
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackAddCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightAddCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtAddCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketAddCartBtn;

	// CartPage Product Links
	@FindBy(xpath = "//div[@class='inventory_item_name']") private WebElement backPackProdLink;
	@FindBy(xpath = "//div[normalize-space()='Sauce Labs Bike Light']") private WebElement bikeLightLink;
	
	
    //////////////////////    OTHER    //////////////////////////////
	// Cart 
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
    @FindBy(xpath = "//select[@class='product_sort_container']") private WebElement cartDropdown;

	// Pricing Product
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]") private WebElement backPackPrice;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]") private WebElement bikeLightPrice;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]") private WebElement boltTshirtPrice;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]") private WebElement fleeceJacketPrice;

	
	public CartPage() 
	{
		PageFactory.initElements(driver, this); 
	} 
	
	
	// Methods
	public String verifyOrderPrice() 
	{
		backPackAddCartBtn.click();
//		String backPackPricee = backPackPrice.getText();
//		String totalPrice = backPackPricee.replace("Total: $", "").trim();
//		double actualTotalPrice = Double.parseDouble(totalPrice);
		

		cartIcon.click();
		checkoutBtn.click();
		
		firstNameField.sendKeys("Mayank"); 
		lastNameField.sendKeys("Sharma"); 
		postalCodeField.sendKeys("123123"); 
		
		continueBtn.click();
		
		String totalPriceCheckoutPage = (driver.findElement(By.xpath("//div[@class='summary_total_label']"))).getText();
		String finalPrice = totalPriceCheckoutPage.replace("Total: $", "").trim();  // To remove extra text use replace method
		return finalPrice;	
		 
	}

	public String verifyBackpacklink()
	{
		backPackAddCartBtn.click();
		cartIcon.click();
		backPackProdLink.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyBikeLightgLink()
	{
		backPackAddCartBtn.click();
		bikeLightAddCartBtn.click();
		cartIcon.click();
		bikeLightLink.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyContinueBtn()
	{
		cartIcon.click();
		continueShoppingBtn.click();
		return driver.getCurrentUrl();
	}

}










