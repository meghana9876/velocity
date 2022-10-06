package test;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import pages.Login1_JoinAjio;

public class VerifyHomeageANDSigninTab {
	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
	
		String Url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		System.out.println(Url);
		System.out.println(Title);
		
		if(Url.equals("https://www.ajio.com") && Title.equals("Online Shopping for Women, Men, Kids � Clothing, Footwear | AJIO"))
			System.out.println("url and title matches");
		else
			System.out.println("url and title dont matches");
		
		
		Login1_JoinAjio login1_JoinAjio=new Login1_JoinAjio(driver);
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
		
		if(Url.equals("https://www.ajio.com/help/termsAndCondition") && Title.equals("Terms & Conditions | Terms of Use | AJIO"))
			System.out.println("url and title matches");
		else
			System.out.println("url and title dont matches");
		
		driver.navigate().back();
		
		//driver.close();
		
		
		
		
		
		
		
		
		
	}

}
