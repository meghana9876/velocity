package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
   public class Men_WomenDropDown_seeitems
	{
	   private WebDriver driver;
	    private Actions act;
	    private WebDriverWait wait;
		
	@FindBy(xpath=("//a[@title='MEN']"))
	private WebElement men_option;
    
	@FindBy(xpath=("//a[text()='Jackets & Coats']"))
	private WebElement men_jacketAndCoats;
    
	@FindBy(xpath=("//a[text()='WOMEN']"))
	private WebElement women_option;
	
	@FindBy(xpath=("//a[@title='MEN']"))
	private WebElement mens_option;
	
	@FindBy(xpath=("(//a[@title='Jeans & Jeggings'])[1]"))
	private WebElement women_Jeans_Jeggings;
    
	public Men_WomenDropDown_seeitems(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act= new Actions(driver);
		wait= new WebDriverWait(driver,20);
	}
	//variable use
	public void HoverMouseToMenTab()
	{  
		wait.until(ExpectedConditions.visibilityOf(men_option));
        act.moveToElement(men_option).perform();
		//men_option.click();
	}
	public void clickOnmensJacketsAndCoats()
	{
		act.moveToElement(men_jacketAndCoats).click().build().perform();
	}
	public void HoverMouseToWomenTab()
	{ // mouse actions
		act.moveToElement(women_option).perform();
		//women_option.click();
	}
	public void clickOnWomensjeans_jeggings()
	{
		act.moveToElement(women_Jeans_Jeggings).click().build().perform();
		//women_sweaterAndSweatshirts.click();
	}

}
