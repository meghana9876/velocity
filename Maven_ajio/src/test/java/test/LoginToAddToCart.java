package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToAddToCart {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.ajio.com/");      
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement SignIn=driver.findElement(By.xpath("//span[text()='Sign In / Join AJIO']"));
	    SignIn.click();
	    
	    WebElement facebook=driver.findElement(By.xpath("//span[text()='Facebook']"));
	    facebook.click();
	    Thread.sleep(2000);
		   
		   ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		   addr=new ArrayList<String>(driver.getWindowHandles()); 
		    driver.switchTo().window(addr.get(0));
		    System.out.println(driver.getCurrentUrl());
		    driver.switchTo().window(addr.get(1));
		    System.out.println(driver.getCurrentUrl());
		    
		    WebElement username1=driver.findElement(By.xpath("//input[@autocomplete='username']"));
		    username1.sendKeys("meghabhansali@gmail.com");
		    Thread.sleep(2000);
		    
		    WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		    password.sendKeys("velocity_123");
		    Thread.sleep(2000);
		   
		    WebElement check_box=driver.findElement(By.xpath("//input[@type='checkbox']"));
		    check_box.click();    
		    Thread.sleep(2000);
		    
		    WebElement log_in=driver.findElement(By.xpath("//input[@value='Log In']"));
		    log_in.click();
		    
//============================================================================================================================
		   
		  // WebDriverWait w=new WebDriverWait(driver,20);
		   //search=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search AJIO']")));
		  Thread.sleep(10000);  
		  driver.switchTo().window(addr.get(0));
		 
		  WebElement search1=driver.findElement(By.xpath("//input[@placeholder='Search AJIO']"));
		    act.moveToElement(search1).click();
		  Thread.sleep(2000);
		  String att_value=search1.getAttribute("placeholder");
		  if(att_value.equals("Search AJIO"))
		     {
		    	 System.out.println("match");
		     }
		  else
		     {
		    	 System.out.println("not match");
		     }
		     
		  search1.sendKeys("puma shoes");
		  Thread.sleep(3000);
		     
		    WebElement puma_shoe = driver.findElement(By.xpath("//span[text()='puma shoes for boys']"));
			//Thread.sleep(2000);
			puma_shoe.click();
				
		     //===============================================================================================================================
		     
		   //select a shoe, scroll down, come up find another shoe and add to wishlist=====
		     
		     	WebElement find_shoe = driver.findElement(By.xpath("(//div[contains(@class,'item rilrtl-products')])"));

				js.executeScript("arguments[0].scrollIntoView(true)", find_shoe);// script key
				Thread.sleep(2000);
				js.executeScript("scrollBy(0,500)");

				WebElement select_shoe = driver
						.findElement(By.xpath("//div[text()='Basket Classic One8 PS IDP Lace-Up Casual Shoes']"));
				select_shoe.click();
				Thread.sleep(6000);
//============================================================================================================//
				ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(s.get(1));
				Thread.sleep(2000);
		     		    
				//WebElement sel_color=driver.findElement(By.xpath("//div[@class='color-swatch selected']"));
				 //act.moveToElement(sel_color).click().build().perform();
				 //Thread.sleep(3000);
		         
				WebElement sel_size=driver.findElement(By.xpath("(//div[@class='oval size-variant-item size-instock '])[2]"));
				sel_size.click();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,300)");
			WebElement pinCode=driver.findElement(By.xpath("//span[contains(text(),'Enter Pin-code')]"));
			pinCode.click();
			Thread.sleep(2000);
			 
			WebElement enter_pinCode=driver.findElement(By.xpath("//input[@type='number']"));
			enter_pinCode.click();
			enter_pinCode.sendKeys("411048");
		     Thread.sleep(2000);
		    
		     WebElement confirm_pinCode=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		     confirm_pinCode.click();
		     Thread.sleep(2000);
		   
		    WebElement add_to_bag=driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		    add_to_bag.click();
		    Thread.sleep(5000);
		    
		    WebDriverWait wait=new WebDriverWait(driver,20);
		    WebElement go_to_bag=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='GO TO BAG']")));
		    go_to_bag.click();
		    Thread.sleep(2000);
		    
		    WebElement button_proceed = driver.findElement(By.xpath("//button[text()='Proceed to shipping']"));
			button_proceed.click();

		     System.out.println("end");
		     driver.close();
		     
		     }
}
