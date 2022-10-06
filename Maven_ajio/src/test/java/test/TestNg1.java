package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Login1_JoinAjio;
import pages.LoginwithFacebookAccount;
import pages.Men_WomenDropDown_seeitems;
import pages.ProductDetailPage_AddtoBag;
import pages.Selectproduct;

public class TestNg1 {
	WebDriver driver;
	Selectproduct selectproduct;
	ArrayList<String> addr;
	Login1_JoinAjio login1_JoinAjio;
	LoginwithFacebookAccount loginwithFacebookAccount;
	Men_WomenDropDown_seeitems men_WomenDropDown_seeitems;
	
	@BeforeClass
	public void beforeclass()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		//driver.get("https://www.ajio.com");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("$$$ before class");
		
	}
	
	@BeforeMethod
	public void beforemethod() throws InterruptedException
	{
		System.out.println("$$$ before method");
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		System.out.println(driver.getTitle());
		String title= driver.getTitle();
		Thread.sleep(3000);
		String url= driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		if(title.equals("Online Shopping for Women, Men, Kids � Clothing, Footwear | AJIO") && url.equals("https://www.ajio.com/"))
		{
			System.out.println("pass");
		}
		else 
		{
			System.out.println("fail");
		}
		
	}
	
	@Test (priority=3)
	public void test() throws InterruptedException
	{
		Login1_JoinAjio login1_JoinAjio=new Login1_JoinAjio(driver);
		login1_JoinAjio.clickOnSignIn();
		
		 Thread.sleep(2000);
		
	     LoginwithFacebookAccount loginwithFacebookAccount=new LoginwithFacebookAccount(driver);
	     loginwithFacebookAccount.ClickOnfacebook();
	     Thread.sleep(3000); 
		String title=driver.getTitle();
		String url= driver.getCurrentUrl();
		System.out.println("tilte="+title );
		System.out.println("URL="+url );
		
		if(title.equals("Online Shopping for Women, Men, Kids -Clothing, Footwear | AJIO") && url.equals("https://www.ajio.com/"))
		{
			System.out.println("test case pass");
		}
		else 
		{
			System.out.println("test case fail");
		}
		addr=new ArrayList<String>(driver.getWindowHandles()); 
		driver.switchTo().window(addr.get(0));
	    System.out.println(driver.getCurrentUrl());
	    driver.switchTo().window(addr.get(3));
	    System.out.println(driver.getCurrentUrl());
	     Thread.sleep(3000);
		//loginwithFacebookAccount.enter_email_username();
		//loginwithFacebookAccount.enter_password();
		loginwithFacebookAccount.ClickOnCheckbox();
		loginwithFacebookAccount.ClickOnlogin();
		driver.switchTo().window(addr.get(1));
	}

	//verify that select product from drop down sub category and select it
	@Test (priority=1)
	public void test1() throws InterruptedException 
	{
		men_WomenDropDown_seeitems =new Men_WomenDropDown_seeitems(driver);
		// driver.navigate().refresh();
		 //   Thread.sleep(3000);
		men_WomenDropDown_seeitems.HoverMouseToMenTab();
		men_WomenDropDown_seeitems.clickOnmensJacketsAndCoats();
		men_WomenDropDown_seeitems.HoverMouseToWomenTab();
	    men_WomenDropDown_seeitems.clickOnWomensjeans_jeggings();
	    
	    String url=driver.getCurrentUrl();
	    System.out.println();
	    if(url.equals("https://www.ajio.com/c/830316001"))
	    {
	     System.out.println("test1 case pass");	
	    }
	    selectproduct = new Selectproduct(driver);
	    selectproduct.clickOnfind_item();
	    selectproduct.clickOnselect_item();
	   
	}
	    //verify product detail page
	   @Test(priority=2)
	   public void test2()
	   {
		   addr = new ArrayList<String>(driver.getWindowHandles());
		   driver.switchTo().window(addr.get(1));
		   System.out.println(addr.get(1));
		   String url1=driver.getCurrentUrl();
		   //String title1=driver.getTitle();
		   System.out.println(url1);
		    if(url1.equals("https://www.ajio.com/levis-skinny-fit-jeans-with-insert-pockets/p/469090435_blue") )
			    {
			     System.out.println("test case pass");	
			    }
			    else {
			    	System.out.println("test case fail");
			    }
			ProductDetailPage_AddtoBag productDetailPage_AddtoBag=new ProductDetailPage_AddtoBag(driver);
			productDetailPage_AddtoBag.productDetail_proceedToShipping();
			
			String url2=driver.getCurrentUrl();
			String title2=driver.getTitle();
		    if(url2.equals("https://www.ajio.com/cart") && title2.equals("Your Shopping Bag | AJIO"))
		    {
		     System.out.println("test case pass");	
		    }
		    else {
		    	System.out.println("test case fail");
		    }
		    productDetailPage_AddtoBag.getProductName();
		    productDetailPage_AddtoBag.myBagItems();
		    productDetailPage_AddtoBag.getOrderDetails();
		  

	}
	   
	   	   
	   
	@AfterClass
	public void afterclass()
	{
		System.out.println("after class");
	}
	@AfterMethod
	public void aftermethod()
	{
		//driver.close();
	}
}
