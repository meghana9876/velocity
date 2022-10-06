package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searchfunctionality {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//variable declaration//
		@FindBy(xpath="//input[@placeholder='Search AJIO']")
		private WebElement search_bar;
	    
		@FindBy(xpath="//a[@class='search-suggestionList  ']")
		private WebElement search_result;
	    
		//@FindBy(xpath="(//a[@class='search-suggestionList '])[1]")
		//private WebElement searchResultList;
	    
		
		//variable initialization
		
		public Searchfunctionality (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver=driver;
			wait=new WebDriverWait(driver,20); 
		}
	 //variable use
		public void clickOnSearchbar()
		{
			wait.until(ExpectedConditions.visibilityOf(search_bar));
			search_bar.click();
			search_bar.sendKeys("shoes");
		}

		public void sendproductSearchbar()
		{
			search_result.click();
		}

		
		public boolean verifySearchbar()
		{
			wait.until(ExpectedConditions.visibilityOf(search_bar));
			boolean result=search_bar.isDisplayed();
			return result;

		}
	
//		public String selectSearchResultList()
//		{   wait.until(ExpectedConditions.visibilityOf(searchResultList));
//			searchResultList.click();
//			String result=searchResultList.getText();
//			return result;
//		}


}
