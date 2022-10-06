package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Login1_JoinAjio;
import pages.Login2_WelcomeToAjio;

public class VerifyCreateAccountTab {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		
		//object of POM class//
		
		Login1_JoinAjio login1_JoinAjio=new Login1_JoinAjio(driver);
		login1_JoinAjio.clickOnSignIn();
		
		Login2_WelcomeToAjio login2_WelcomeToAjio= new Login2_WelcomeToAjio(driver);
		login2_WelcomeToAjio.sendMobileno_email();
		login2_WelcomeToAjio.clickOnContinue();
		
		
	}

}
