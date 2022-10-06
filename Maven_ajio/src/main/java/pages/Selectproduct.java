package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selectproduct {
	
	
	@FindBy(xpath="(//div[contains(@class,'item rilrtl-products')])")
	private WebElement find_item;
	
	@FindBy(xpath="(//div[@class='imgHolder'])[1]")
	private WebElement select_item;
	
	public Selectproduct (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//variable use
	public void clickOnfind_item()
	{
		find_item.click();
	}
	public void clickOnselect_item()
	{
		select_item.click();
	}
	
}
