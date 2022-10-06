package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CreateNewAccountLogin3;
import pages.Login1_JoinAjio;
import pages.Login2_WelcomeToAjio;

public class VerifyCreateNewAccount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		
		Login1_JoinAjio login1_JoinAjio=new Login1_JoinAjio(driver);
		login1_JoinAjio.clickOnSignIn();
		
		Login2_WelcomeToAjio login2_WelcomeToAjio= new Login2_WelcomeToAjio(driver);
		login2_WelcomeToAjio.sendMobileno_email();
		login2_WelcomeToAjio.clickOnContinue();
		
		Thread.sleep(3000);
		CreateNewAccountLogin3 createNewAccountLogin3= new CreateNewAccountLogin3(driver);
		createNewAccountLogin3.select_gender();
		createNewAccountLogin3.send_Name();
		createNewAccountLogin3.send_mobileno();
		createNewAccountLogin3.send_password();
		createNewAccountLogin3.clickonterms_conditions();
		createNewAccountLogin3.click_otp();
		
	}
}
