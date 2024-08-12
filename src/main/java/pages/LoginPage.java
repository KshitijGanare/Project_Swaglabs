package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class LoginPage extends Testbase{

	// Object Repository
	@FindBy(xpath="//div[@class='login_logo']") private WebElement logo;
	@FindBy(xpath="//input[@id='user-name']") private WebElement username;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	@FindBy(xpath="//h4[normalize-space()='Accepted usernames are:']") private WebElement heading;

	// Initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	// Methods
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyLoginToApplication()
	{
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginBtn.click();
		
		return driver.getCurrentUrl();
	}
	
	public String verifyLoginToApplicationMultiCreds(String un, String pw) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}
}









