package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utils.Utility;
import browserSetup.Base;
import pages.CreateNewAccountLogin3;
import pages.Login1_JoinAjio;
import pages.Login2_WelcomeToAjio;
import pages.LoginwithFacebookAccount;
import pages.Men_WomenDropDown_seeitems;
import pages.ProductDetailPage_AddtoBag;
import pages.Searchfunctionality;
import pages.Selectproduct;

public class TestNG2 extends Base{

	private WebDriver driver;
	private Login1_JoinAjio login1_JoinAjio;
	private Login2_WelcomeToAjio login2_WelcomeToAjio;
	private CreateNewAccountLogin3 createNewAccountLogin3;
	private LoginwithFacebookAccount loginwithFacebookAccount;
	private ArrayList<String> addr;
	private SoftAssert soft;
	private Searchfunctionality searchfunctionality;
	private Selectproduct selectproduct;
	private ProductDetailPage_AddtoBag productDetailPage_AddtoBag;
	private Men_WomenDropDown_seeitems men_WomenDropDown_seeitems;
	private int testID;
	
	@Parameters("browser")
	
	
	@BeforeTest
//	public void launchbrowser(String browserName)
//	{
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		if(browserName.equals("Chrome"))
//		{
//		  System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
//		  driver= new ChromeDriver(options);
//		}
//		
//		if(browserName.equals("Edge"))
//		{
//			System.setProperty("webdriver.edge.driver", "C:\\automation\\msedgedriver.exe");
//			  driver= new EdgeDriver();
//		
//		}
//		

	public void launchbrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver=openEdgeBrowser();
		}
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
System.out.println("=======================================================================");
	}

	@BeforeClass
	public void createPOMobjects()
	{
		login1_JoinAjio=new Login1_JoinAjio(driver);
		login2_WelcomeToAjio= new Login2_WelcomeToAjio(driver);
		createNewAccountLogin3= new CreateNewAccountLogin3(driver);
		loginwithFacebookAccount=new LoginwithFacebookAccount(driver);
		
		//==================================================================//
		searchfunctionality= new Searchfunctionality(driver);
		selectproduct= new Selectproduct(driver);
		productDetailPage_AddtoBag=new ProductDetailPage_AddtoBag(driver);
		//===================================================================//
		men_WomenDropDown_seeitems =new Men_WomenDropDown_seeitems(driver);
		System.out.println("=======================================================================");
	}

	@BeforeMethod
	public void beforeMethod()
	{
		
		driver.get("https://www.ajio.com");
		
		soft= new SoftAssert();
	
	}
	
	@Test (priority=1)
	public void verifySearchFunctionality() throws InterruptedException
	{    testID=101;
		searchfunctionality.clickOnSearchbar();
		boolean result=searchfunctionality.verifySearchbar();
		
		 soft.assertEquals(result, true, "hidden elements not present");
		
		searchfunctionality.sendproductSearchbar();
 	
		selectproduct.clickOnfind_item();
		

	 //String result1= searchfunctionality.selectSearchResultList();
	     //System.out.println(result1);
		//driver.navigate().back();
		soft.assertAll();
	System.out.println("//test1===========================================================//");	
	}
	
	@Test(priority=2)
	public void verifyDropDowncategories()
	{
		testID=102;
		men_WomenDropDown_seeitems.HoverMouseToMenTab();
		men_WomenDropDown_seeitems.clickOnmensJacketsAndCoats();
		men_WomenDropDown_seeitems.HoverMouseToWomenTab();
	    men_WomenDropDown_seeitems.clickOnWomensjeans_jeggings();
	    
	    
	    String url=driver.getCurrentUrl();
	    soft.assertEquals(url, "https://www.ajio.com/c/830316001");
	    System.out.println();
	    
	    selectproduct = new Selectproduct(driver);
	    selectproduct.clickOnfind_item();
	    //selectproduct.clickOnselect_item();
	    System.out.println("test2=======================================================================");
		}

	
	@Test (priority=3)
	public void verifyproductDetailpage() throws InterruptedException, IOException
	{    testID=103;
		//selectproduct.clickOnselect_item();
 	    
 	   addr = new ArrayList<String>(driver.getWindowHandles());
 	   driver.switchTo().window(addr.get(2));
 	   System.out.println(addr.get(2));
 	  String url=driver.getCurrentUrl();
		String title=driver.getTitle();
 	   System.out.println(url);
 	  System.out.println(title);
 	  soft.assertEquals(url, "Buy Black Shoes for Boys by Puma Online | Ajio.com");
 	  soft.assertEquals(title, "https://www.ajio.com/puma-backcourt-mid-top-lace-up-casual-shoes/p/460771243_black");
 	    productDetailPage_AddtoBag.ClickOnselectColour();
 		
 		productDetailPage_AddtoBag.ClickOnselectSizeShoe();
 		productDetailPage_AddtoBag.clickOnpincodeButton();
 		productDetailPage_AddtoBag.send_pincode();
 		productDetailPage_AddtoBag.clickOnConfirmpincode();
 		productDetailPage_AddtoBag.clickOnAddToBag();
 		Thread.sleep(3000);
 		productDetailPage_AddtoBag.clickOnGoToBag();
 		//screenshot//
 		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 		File dest=new File("C:\\Users\\MB\\Desktop\\velocity\\screenshot\\ajio.jpg");
 	    FileHandler.copy(src,dest);
 	   System.out.println("test3=======================================================================");
	}
	
@Test(priority=4)
public void verifyproductdetailpage1() throws InterruptedException, IOException 
{      testID=104;
	   addr = new ArrayList<String>(driver.getWindowHandles());
	   driver.switchTo().window(addr.get(1));
	   System.out.println(addr.get(1));
   	
	   String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
	    System.out.println(url1);
	    System.out.println(title1);
	    soft.assertEquals(url1, "https://www.ajio.com/levis-skinny-fit-jeans-with-insert-pockets/p/469090435_blue");
	    soft.assertEquals(title1,"Buy Blue Jeans & Jeggings for Women by LEVIS Online | Ajio.com" );
	
     
	     productDetailPage_AddtoBag.ClickOnselectColour();
		
		productDetailPage_AddtoBag.ClickOnselectSizeJeans();
		//productDetailPage_AddtoBag.clickOnpincodeButton();
		//productDetailPage_AddtoBag.send_pincode();
		//productDetailPage_AddtoBag.clickOnConfirmpincode();
		productDetailPage_AddtoBag.clickOnAddToBag();
		Thread.sleep(5000);
		productDetailPage_AddtoBag.clickOnGoToBag();
		//screenshot//
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 		File dest=new File("C:\\Users\\MB\\Desktop\\velocity\\screenshot\\ajio1.jpg");
 	    FileHandler.copy(src,dest);
 	   System.out.println("test4=======================================================================");
}
    
    @AfterMethod
    	public void logout(ITestResult result) throws IOException
   	{
    	if(ITestResult.FAILURE==result.getStatus())
    	{
		Utility.captureScreenshot(driver,testID);
		System.out.println("logout");
    	}
    }
	
	@AfterClass
	public void removeObjects()
	{
		login1_JoinAjio=null;
		login2_WelcomeToAjio= null;
		createNewAccountLogin3= null;
		loginwithFacebookAccount=null;
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
}



