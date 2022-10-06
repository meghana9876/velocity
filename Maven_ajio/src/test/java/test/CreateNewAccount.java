
	package test;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class CreateNewAccount {
		public static void main(String[] args) throws InterruptedException {
		
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			
		
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement SignIn=driver.findElement(By.xpath("//span[text()='Sign In / Join AJIO']"));
	    SignIn.click();
	    Thread.sleep(2000);
	    WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
	    username.sendKeys("meghabhansali@gmail.com");
	    
	    
	    
	    WebElement continue1=driver.findElement(By.xpath("//input[@type='submit']"));
	    continue1.click();
	   Thread.sleep(8000);
	    WebElement gender_female=driver.findElement(By.xpath("//label[@class='gender-opt']"));
	    gender_female.click();
	    Thread.sleep(2000);
	     
	    WebElement name=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
	    name.sendKeys("velocity class");
	    
	    WebElement mobile_no=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	    mobile_no.sendKeys("9850789399");
	    
	    Thread.sleep(2000);
	    WebElement password=driver.findElement(By.xpath("//input[@id='pwdInput']"));
	    password.sendKeys("velocity_123");
	    
	    WebElement terms_condition=driver.findElement(By.xpath("//input[@type='checkbox']"));
	    terms_condition.click();
	    Thread.sleep(2000);
	     WebElement Send_OTP=driver.findElement(By.xpath("//input[@value='SEND OTP']"));
	    Send_OTP.click();
	     
	     //WebElement forgot_pw=driver.findElement(By.xpath("//div[text()='Forgot your password?']"));
	     //forgot_pw.click();
	     


	    
	     // WebElement email_username=driver.findElement(By.xpath("//input[@type='text']"));
	      //email_username.sendKeys("meghabhansali@gmail.com");
	      
	      
	      
	      //WebElement facebook=driver.findElement(By.xpath("//span[@class='fb-icon']"));
	      //facebook.click();
	     // WebElement email=driver.findElement(By.xpath("//input[@autocomplete='username']"));
	     // Thread.sleep(3000);
	      //email.sendKeys("meghabhansali@gmail.com");
	     /* WebElement search=driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
	  	search.sendKeys("watch");
	  	Thread.sleep(2000);
	  	WebElement search_men=driver.findElement(By.xpath("//span[text()='watches for men']"));
	  	search_men.click();*/
	  	  
	      //WebElement search1= driver.findElement(By.xpath("//input[@placeholder='Search AJIO']"));
	     //search1.sendKeys("tshirt");
		}
	

}
