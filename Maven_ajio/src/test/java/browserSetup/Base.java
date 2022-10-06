package browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Base {
	
	
	public static WebDriver openChromeBrowser()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver= new ChromeDriver(options);
		  return driver;
	}
	public static WebDriver openEdgeBrowser()
	{
		EdgeOptions options=new EdgeOptions();
		options.setCapability("--disable-notifications",true);
		
		System.setProperty("webdriver.edge.driver", "C:\\automation\\msedgedriver.exe");
		  WebDriver driver= new EdgeDriver(options);
		  return driver;
	}
}
