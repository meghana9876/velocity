package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginwithFacebookAccount {
	
	private WebDriver driver;
	private Actions act;
	
	@FindBy(xpath="//span[text()='Facebook']")
	private WebElement login_Facebbok;
	
	@FindBy(xpath="//input[@autocomplete='username']")
	private WebElement username_emailid;
   
	@FindBy(xpath="//input[@type='password']")
	private WebElement enter_password;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement check_box;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement login;
	
	
	
	public LoginwithFacebookAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
	}
	
	//variable use
	
	public void ClickOnfacebook()
	{
		act.moveToElement(login_Facebbok).perform();
		login_Facebbok.click();
	}
	
	public void enter_email_username(String data)
	{
		username_emailid.sendKeys(data);
	}
	
	public void enter_password(String data)
	{
		enter_password.sendKeys(data);
	}

	public void ClickOnCheckbox()
	{
		check_box.click();;
	}
	
	public void ClickOnlogin()
	{
		login.click();
	}
}
