package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login1_JoinAjio
 {  
	private	WebDriver driver;
	private Actions act;
	private WebDriverWait wait;
	JavascriptExecutor js;
	//variable declaration//
	@FindBy(xpath="//span[text()='Sign In / Join AJIO']")
	private WebElement signin_button;
	
	@FindBy(xpath="//div[@class='ic-close-quickview']")
	private WebElement signinClose;
	
	@FindBy(xpath="//div[@class='ic-floating']")
	private WebElement floatingTab;
	
	@FindBy(xpath="//div[@class='ic-close-quickview']")
	private WebElement ClosefloatingTab;
	
	@FindBy(xpath="//a[text()='Terms & Conditions']")
	private WebElement termsAndConditionTab;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logout;
	
	
	//variable initialization
	
			public Login1_JoinAjio(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
				this.driver=driver;
				act=new Actions(driver);
				js= (JavascriptExecutor)driver;
				wait=new WebDriverWait(driver,20);
			}
			//variable use
			public void clickOnSignIn()
		    {
				signin_button.click();
		    }

			public void clickOnClose()
		    {
				signinClose.click();
		    }
			public void clickOnFloatingTab()
		    {
				floatingTab.click();
		    }
			public void clickOnClosefloatingTab()
		    {
				ClosefloatingTab.click();
				//act.moveToElement(ClosefloatingTab).click().build().perform();
		    }
			public void clickOnTermsAndConditionLink()
		    {
				js.executeScript("arguments[0].scrollIntoView(true)",termsAndConditionTab);
				termsAndConditionTab.click();
			}
			public void clickOnlogoutTab() throws InterruptedException
			
		    {
				//Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(logout));
				//act.moveToElement(logout).click().build().perform();
				logout.click();
		    }
			
}

