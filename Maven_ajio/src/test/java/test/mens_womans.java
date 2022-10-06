
	package test;

	import java.util.ArrayList;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class mens_womans{
		public static void main(String[] args) throws InterruptedException {
			 System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
			 WebDriver driver=new ChromeDriver();
			 driver.get("https://www.ajio.com");
			 driver.manage().window().maximize();
			 Thread.sleep(2000);
			 
			 WebElement mens_option=driver.findElement(By.xpath("//a[@title='MEN']"));
			 System.out.println( mens_option.getText());
			 WebElement jackets=driver.findElement(By.xpath("//a[text()='Jackets & Coats']"));
			 System.out.println(jackets.getText());
			 Thread.sleep(2000);
			 Actions act=new Actions(driver);
			 act.moveToElement(mens_option).moveToElement(jackets).click().build().perform();
			 
			 
			 WebElement womans_option=driver.findElement(By.xpath("//a[text()='WOMEN']"));
			 WebElement winterwear=driver.findElement(By.xpath("(//span[text()='WINTERWEAR'])[2]"));
			 Thread.sleep(2000);
			 act.moveToElement(womans_option).moveToElement(winterwear).click().build().perform();
			 System.out.println(womans_option);	
			 System.out.println(winterwear);
			 
			 WebElement sweater=driver.findElement(By.xpath("//label[@for='Women - Sweaters & Sweatshirts']"));
			 act.moveToElement(sweater).click().build().perform();
			 Thread.sleep(3000);
			 System.out.println(sweater);
			
			 WebElement jacket1=driver.findElement(By.xpath("//div[@class='items']//img[1]"));
			 act.moveToElement(jacket1).click().build().perform();
			 Thread.sleep(3000);
			 
			
			 ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
			// driver.switchTo().window(addr.get(0));
			 driver.switchTo().window(addr.get(1));
			 
			 WebElement sel_color=driver.findElement(By.xpath("//div[@class='color-swatch selected']"));
			 act.moveToElement(sel_color).click().build().perform();
			 Thread.sleep(3000);
	         
			 WebElement size=driver.findElement(By.xpath("//span[text()='S']"));
			 act.moveToElement(size).click().build().perform();
			 Thread.sleep(3000);
			 
			 WebElement pincode=driver.findElement(By.xpath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']"));
			 act.moveToElement(pincode).click().build().perform();
			 Thread.sleep(3000);
		     
		     
		     WebElement enter_pinCode=driver.findElement(By.xpath("//input[@type='number']"));
		     act.moveToElement(enter_pinCode).click().sendKeys("411048").build().perform();
		     Thread.sleep(2000);
		    
		     WebElement click_pinCode=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		     act.moveToElement(click_pinCode).click().build().perform();
		     Thread.sleep(2000);
		   
		    WebElement add_to_bag=driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		    act.moveToElement(add_to_bag).click().build().perform();
		    Thread.sleep(3000);
		    
		    WebElement go_to_bag=driver.findElement(By.xpath("//span[text()='GO TO BAG']"));
		    act.moveToElement(go_to_bag).click().build().perform();
		    Thread.sleep(3000);
		    
	        
		    WebElement proceed_shipping=driver.findElement(By.xpath("//button[text()='Proceed to shipping']"));
		    proceed_shipping.click();
		    Thread.sleep(3000);
		    
		}
	}


