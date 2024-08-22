package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

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
}
