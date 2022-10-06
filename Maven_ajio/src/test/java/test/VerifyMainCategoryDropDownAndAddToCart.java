package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Men_WomenDropDown_seeitems;
import pages.ProductDetailPage_AddtoBag;
import pages.Selectproduct;

public class VerifyMainCategoryDropDownAndAddToCart {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    
		
		Men_WomenDropDown_seeitems men_WomenDropDown_seeitems =new Men_WomenDropDown_seeitems(driver);
		men_WomenDropDown_seeitems.HoverMouseToMenTab();
		men_WomenDropDown_seeitems.clickOnmensJacketsAndCoats();
		men_WomenDropDown_seeitems.HoverMouseToWomenTab();
	    men_WomenDropDown_seeitems.clickOnWomensjeans_jeggings();
	    
	    String url=driver.getCurrentUrl();
	    System.out.println();
	    if(url.equals("https://www.ajio.com/c/830316001"))
	    {
	     System.out.println("test case pass");	
	    }
	    
	   Selectproduct selectproduct = new Selectproduct(driver);
	    selectproduct.clickOnfind_item();
	    selectproduct.clickOnselect_item();
	    
	    
	    ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(s.get(1));
		System.out.println(s.get(1));
		 String url1=driver.getCurrentUrl();
			String title1=driver.getTitle();
		    System.out.println(url1);
		    if(url1.equals("https://www.ajio.com/levis-skinny-fit-jeans-with-insert-pockets/p/469090435_blue") )
		    {
		     System.out.println("test case pass");	
		    }
		    else {
		    	System.out.println("test case fail");
		    }
		ProductDetailPage_AddtoBag productDetailPage_AddtoBag=new ProductDetailPage_AddtoBag(driver);
		productDetailPage_AddtoBag.productDetail_proceedToShipping();
		
		String url2=driver.getCurrentUrl();
		String title2=driver.getTitle();
	    if(url2.equals("https://www.ajio.com/cart") && title2.equals("Your Shopping Bag | AJIO"))
	    {
	     System.out.println("test case pass");	
	    }
	    else {
	    	System.out.println("test case fail");
	    }
	    productDetailPage_AddtoBag.getProductName();
	    productDetailPage_AddtoBag.myBagItems();
	    productDetailPage_AddtoBag.getOrderDetails();
	  
	   

     	/*ProductDetailPage_AddtoBag productDetailPage_AddtoBag=new ProductDetailPage_AddtoBag(driver);
		//productDetailPage_AddtoBag.ClickOnselectColour();
		
		productDetailPage_AddtoBag.ClickOnselectSize();
		productDetailPage_AddtoBag.clickOnpincodeButton();
		productDetailPage_AddtoBag.send_pincode();
		productDetailPage_AddtoBag.clickOnConfirmpincode();
		productDetailPage_AddtoBag.clickOnAddToBag();
		productDetailPage_AddtoBag.clickOnGoToBag();*/	

	}
}
