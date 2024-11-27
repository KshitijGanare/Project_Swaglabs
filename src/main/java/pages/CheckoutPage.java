package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class CheckoutPage extends Testbase{

	// Products add cart button
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackAddCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightAddCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtAddCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketAddCartBtn;	
	
	// Your Cart Page
    @FindBy(xpath = "//button[@id='checkout']") private WebElement CheckOutBtn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	
	////////////////////////////////// Your Information Page //////////////////////////////////
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCode;
	
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	
	// Error message
	@FindBy(xpath = "//h3[@data-test='error']") private WebElement errorMessage;
	
	////////////////////////////////// Checkout: Overview ///////////////////////////////////////
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	  
	   
	////////////////////////////////// Checkout Finish  //////////////////////////////////////
	@FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']") private WebElement thankyouMessage;


	    
	    
	    public CheckoutPage()
	    {
	    	PageFactory.initElements(driver, this);
	    }
	    
	    
	    // Methods
	    
	    //////////////// Your Information Page ///////////////////////
	    public boolean verifyEnterFirstname()
	    {
	    	backPackAddCartBtn.click();
	    	bikeLightAddCartBtn.click();
	    	cartIcon.click();
	    	CheckOutBtn.click();
	    	
	    	return firstName.isEnabled(); // true
	    	
	    }         

	    public boolean verifyEnterLastname()
	    {
	    	backPackAddCartBtn.click();
	    	bikeLightAddCartBtn.click();
	    	cartIcon.click();
	    	CheckOutBtn.click();
	    	
	    	return lastName.isEnabled();
	    	
	    }
	    
	    public String verifyCancelBtn()
	    {
	    	cartIcon.click();
	    	CheckOutBtn.click();
	    	cancelBtn.click();
	    	
	    	return driver.getCurrentUrl();
	    	
	    }
	    
	    public String verifyContinueBtn()
	    {
	    	firstName.sendKeys("Rohit");
	    	lastName.sendKeys("Sharma");
	    	postalCode.sendKeys("123123");
	    	continueBtn.click();
	    	
	    	return driver.getCurrentUrl();
	    }
	    
	    public String verifyErrorMessage()
	    {
	    	cartIcon.click();
	    	CheckOutBtn.click();
	    	continueBtn.click();
	    	
	    	return errorMessage.getText();
	    	
	    }
	    

        ////////////////////////////////// Checkout: Overview page ///////////////////////
	    public double verifyTotalPrice() {

	        // Add products
	        backPackAddCartBtn.click(); // price = 29.99
	        bikeLightAddCartBtn.click(); // price = 9.99
	        boltTshirtAddCartBtn.click();
	        
	        // Navigate to the checkout page
	        cartIcon.click(); // Click cart icon
	        CheckOutBtn.click(); // Click checkout
	        firstName.sendKeys("Test"); // Enter first name
	        lastName.sendKeys("User"); // Enter last name
	        postalCode.sendKeys("12345"); // Enter postal code
	        continueBtn.click(); // Click continue

	        // Overview Page
	        String productOnePriceText = (driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"))).getText().replace("$", "").trim();
	        String productTwoPriceText = (driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[2]"))).getText().replace("$", "").trim();
	        String productThreePriceText = (driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[3]"))).getText().replace("$", "").trim();
	        
	        // Parsing strings into double numbers
	        double productOnePrice = Double.parseDouble(productOnePriceText);
	        double productTwoPrice = Double.parseDouble(productTwoPriceText);
	        double productThreePrice = Double.parseDouble(productThreePriceText);
	        		
	        double expectedTotalPrice = (productOnePrice + productTwoPrice+ productThreePrice)*1.08;
	        double totalPriceRound = Math.round(expectedTotalPrice*100.0)/100.0;
	        // Return the calculated total price
	        return totalPriceRound;
	    
	    
	    }
	    
	    
	    public String verifyFinishButton()
	    {
	    	verifyTotalPrice();
	    	
	    	finishBtn.click();
	    	return driver.getCurrentUrl();
	    }
	    
	    
}











