package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login2_WelcomeToAjio {
	@FindBy(xpath="//input[@type='text']")
	private WebElement entermobileno_email;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement continue_button;

	//variable initialization
	
	public Login2_WelcomeToAjio(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
			
	public void sendexistingAccountEmail()
	{
		entermobileno_email.sendKeys("meghabhansali@gmail.com");
	}
	public void sendMobileno_email(String data)
    {
		entermobileno_email.sendKeys(data);//a.meghana@hotmail.com
    }
	public void clickOnContinue()
    {
		continue_button.click();
    }


}
