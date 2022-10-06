package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Login1_JoinAjio;
import pages.LoginwithFacebookAccount;
import pages.ProductDetailPage_AddtoBag;
import pages.Searchfunctionality;
import pages.Selectproduct;

public class testNG {
	
	WebDriver driver;
	ArrayList<String> addr;
	WebDriverWait wait;
	Login1_JoinAjio login1_JoinAjio;
	LoginwithFacebookAccount loginwithFacebookAccount;
	Searchfunctionality searchfunctionality;
	Selectproduct selectproduct;
	ProductDetailPage_AddtoBag productDetailPage_AddtoBag;
	@BeforeClass
	public void beforeClass()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		System.out.println("$$$ before class");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("$$$ before method");
	}
     @Test (priority = 1)
    public void test() throws InterruptedException 
    {
    System.out.println("$$$ test");
    
     login1_JoinAjio=new Login1_JoinAjio(driver);
	 login1_JoinAjio.clickOnSignIn();
     
	loginwithFacebookAccount=new LoginwithFacebookAccount(driver);
	loginwithFacebookAccount.ClickOnfacebook();
	Thread.sleep(3000);
	addr=new ArrayList<String>(driver.getWindowHandles()); 
	driver.switchTo().window(addr.get(0));
    System.out.println(driver.getCurrentUrl());
    driver.switchTo().window(addr.get(1));
    System.out.println(driver.getCurrentUrl());
    
	
	//loginwithFacebookAccount.enter_email_username();
	//loginwithFacebookAccount.enter_password();
	loginwithFacebookAccount.ClickOnCheckbox();
	loginwithFacebookAccount.ClickOnlogin();
 
    }
     
     @Test (priority = 2)
     public void test1() throws InterruptedException
     {  
//    	searchfunctionality= new Searchfunctionality(driver);
//         Thread.sleep(5000);
//    	searchfunctionality.clickOnSearchbar();
// 	
// 		searchfunctionality.sendproductSearchbar();
// 		
// 		selectproduct= new Selectproduct(driver);
//    	
// 		selectproduct.clickOnfind_item();
 		
 		selectproduct.clickOnselect_item();
 	    
 	    addr = new ArrayList<String>(driver.getWindowHandles());
 		driver.switchTo().window(addr.get(1));
 		System.out.println(addr.get(1));
      	
 		
        productDetailPage_AddtoBag=new ProductDetailPage_AddtoBag(driver);
 		productDetailPage_AddtoBag.ClickOnselectColour();
 		
 		productDetailPage_AddtoBag.ClickOnselectSizeShoe();
 		productDetailPage_AddtoBag.clickOnpincodeButton();
 		productDetailPage_AddtoBag.send_pincode();
 		productDetailPage_AddtoBag.clickOnConfirmpincode();
 		productDetailPage_AddtoBag.clickOnAddToBag();
 		productDetailPage_AddtoBag.clickOnGoToBag();	

     }
     @AfterMethod
 	
 	public void aftermethod()
 	{
 		System.out.println("$$$ after method");
 	}
     @AfterClass
 	
 	public void afterClass()
 	{
    	 driver.close();
 		System.out.println("$$$ after class");
 	}
}
	

