package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class add_to_wishlist {
	
	@FindBy(xpath="//span[@class='pdp-wishlist-desktop-icon']")
	private WebElement add_to_wishlist;
    
	
	
	public add_to_wishlist (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//variable use
	public void find_shoe()
	{
		add_to_wishlist.click();
	}
	

    

}
