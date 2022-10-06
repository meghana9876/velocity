package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ProductDetailPage_AddtoBag;
import pages.Searchfunctionality;
import pages.Selectproduct;

public class VerifySearchFunctionalityTillyouplaceorder {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Searchfunctionality searchfunctionality= new Searchfunctionality(driver);
		searchfunctionality.clickOnSearchbar();
		Thread.sleep(3000);
		searchfunctionality.sendproductSearchbar();
		
		Selectproduct selectproduct= new Selectproduct(driver);
		selectproduct.clickOnfind_item();

	    selectproduct.clickOnselect_item();
	    
	    ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(s.get(1));
		System.out.println(s.get(1));
     	
	    
     	ProductDetailPage_AddtoBag productDetailPage_AddtoBag=new ProductDetailPage_AddtoBag(driver);
		//productDetailPage_AddtoBag.ClickOnselectColour();
		
		productDetailPage_AddtoBag.ClickOnselectSizeShoe();
		productDetailPage_AddtoBag.clickOnpincodeButton();
		productDetailPage_AddtoBag.send_pincode();
		productDetailPage_AddtoBag.clickOnConfirmpincode();
		productDetailPage_AddtoBag.clickOnAddToBag();
		productDetailPage_AddtoBag.clickOnGoToBag();	
		
	}
}
