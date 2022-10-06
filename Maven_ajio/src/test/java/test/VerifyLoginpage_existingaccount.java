package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.Login1_JoinAjio;
import pages.Login2_WelcomeToAjio;
import pages.LoginwithFacebookAccount;

public class VerifyLoginpage_existingaccount {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
	System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver= new ChromeDriver(options);
	driver.get("https://www.ajio.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
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
	ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
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
}