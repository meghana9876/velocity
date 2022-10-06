package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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

public class TestNG1_homepage extends Base {
	private WebDriver driver;
	private Login1_JoinAjio login1_JoinAjio;
	private Login2_WelcomeToAjio login2_WelcomeToAjio;
	private CreateNewAccountLogin3 createNewAccountLogin3;
	private LoginwithFacebookAccount loginwithFacebookAccount;
	private ArrayList<String> addr;
	private SoftAssert soft;
	private String data;
	private int testID;
	@Parameters("browser")
	@BeforeTest
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

//	@BeforeTest
//	public void launchbrowser()
//	{
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
//		driver= new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
//
//	}
	
	
	@BeforeClass
	public void createPOMobjects()
	{
		login1_JoinAjio=new Login1_JoinAjio(driver);
		login2_WelcomeToAjio= new Login2_WelcomeToAjio(driver);
		createNewAccountLogin3= new CreateNewAccountLogin3(driver);
		loginwithFacebookAccount=new LoginwithFacebookAccount(driver);
	}

	@BeforeMethod
	public void beforeMethod()
	{
		
		driver.get("https://www.ajio.com");
		
		soft= new SoftAssert();
	}
	
	@Test (priority=1)
	public void VerifyHomepage()
	{
		testID=101;
		String Url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		System.out.println(Url);
		System.out.println(Title);
		
		Assert.assertEquals(Url, "https://www.ajio.com/");
		soft.assertEquals(Title, "Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO");
		
		// verify signin and close button are clickable//
		login1_JoinAjio.clickOnSignIn();// it should open new login page
		login1_JoinAjio.clickOnClose();  //it should close
		
		//verify floating tab
		
		login1_JoinAjio.clickOnFloatingTab();// it should open new tab
		login1_JoinAjio.clickOnClosefloatingTab();
		
		login1_JoinAjio.clickOnTermsAndConditionLink();
		String Url1=driver.getCurrentUrl();
		String Title1=driver.getTitle();
		System.out.println(Url1);
		System.out.println(Title1);
		
		Assert.assertEquals(Url1, "https://www.ajio.com/help/termsAndCondition");
		
		soft.assertEquals(Title1, "Terms & Conditions | Terms of Use | AJIO");

		driver.navigate().back();
		soft.assertAll();
	}
	
	@Test (priority=2)
	public void VerifyCreateNewAccount() throws EncryptedDocumentException, IOException
	{
		testID=102;
		login1_JoinAjio.clickOnSignIn();
		
		data=Utility.get_ExcelData("ajioLogin", 4, 0);
		System.out.println(data);
		login2_WelcomeToAjio.sendMobileno_email(data);
		
		login2_WelcomeToAjio.clickOnContinue();
		
		boolean result=createNewAccountLogin3.click_femaleGender();
		System.out.println(result);
		
		soft.assertEquals(result, false, "radio button is not selected");
		//soft.assertEquals(result, true, "radio button is already selected");
		
//		if(result)
//		{
//			System.out.println("radio button is already selected");
//		}
//		else
//		{
//			System.out.println("radio button is not selected");
//		}
		
		boolean result1=createNewAccountLogin3.clicksend_Name();
		System.out.println(result1);
		soft.assertEquals(result1, true, "name field not enable.. click it");
		
		String result2=createNewAccountLogin3.enterName_getattribute();
		System.out.println(result2);
		createNewAccountLogin3.select_gender();
		
		createNewAccountLogin3.send_Name();
		createNewAccountLogin3.send_mobileno();
		createNewAccountLogin3.send_password();
		createNewAccountLogin3.clickonterms_conditions();
		createNewAccountLogin3.click_otp();
		
		soft.assertAll();
	}
	@Test (priority=3)
	public void loginWithFacebookAccount() throws InterruptedException, IOException
	{
		testID=103;
		 login1_JoinAjio.clickOnSignIn();
	     
		
		loginwithFacebookAccount.ClickOnfacebook();
		Thread.sleep(3000);
		addr=new ArrayList<String>(driver.getWindowHandles()); 
		driver.switchTo().window(addr.get(0));
	    System.out.println(driver.getCurrentUrl());
	    driver.switchTo().window(addr.get(1));
	    System.out.println(driver.getCurrentUrl());
	    
	    data=Utility.get_ExcelData("ajioLogin", 3, 0);
	    System.out.println(data);
	    
		loginwithFacebookAccount.enter_email_username(data);
		data=Utility.get_ExcelData("ajioLogin", 3, 1);
	    System.out.println(data);
		loginwithFacebookAccount.enter_password(data);
		loginwithFacebookAccount.ClickOnCheckbox();
		loginwithFacebookAccount.ClickOnlogin();
		addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
		Thread.sleep(3000);
		login1_JoinAjio.clickOnlogoutTab();
		soft.assertAll();
	}
	@Test(priority=4)
	public void LoginWithExistingAccount() throws InterruptedException
	{   
		testID=104;
		Thread.sleep(3000);
		login1_JoinAjio.clickOnSignIn();
		login2_WelcomeToAjio.sendexistingAccountEmail();
		login2_WelcomeToAjio.clickOnContinue();
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
