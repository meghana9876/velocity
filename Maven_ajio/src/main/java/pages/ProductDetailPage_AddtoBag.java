package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage_AddtoBag {

	//if color option is their//
	@FindBy(xpath="//div[@class='color-swatch selected']")
	private WebElement select_colour;
	  
   @FindBy(xpath="(//div[@data-index='1'])[3]")
   private WebElement select_size;
	
   @FindBy(xpath="(//div[@class='size-swatch'])[1]")
   private WebElement select_size_shoe;
  // (//div[@class='oval size-variant-item size-instock '])[2]
   
   @FindBy(xpath="(//div[@class='slick-slide slick-active size-swatch'])[3]")
   private WebElement select_size_jeans;
  

   @FindBy(xpath="//span[contains(text(),'Enter Pin-code')]")
	private WebElement add_pincode;
   
   @FindBy(xpath="//input[@type='number']")
	private WebElement enter_pincode;
  
   @FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement confirm_pincode;
  
   @FindBy(xpath="//span[text()='ADD TO BAG']")
  	private WebElement AddToBag;
    
   @FindBy(xpath="//span[text()='GO TO BAG']")
   private WebElement GoToBag;
   
   @FindBy(xpath="//div[@class='product-name']")
   private WebElement productName;
   
   @FindBy (xpath="//div[@class='mybag-section']")
	private WebElement myBag_itemsadded;
   
   @FindBy (xpath="//div[@class='order-summary-container']")
	private WebElement getTextofOrder;
    
   
 
   public ProductDetailPage_AddtoBag(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
  
   public void ClickOnselectColour()
   {
	   select_colour.click();   
   }
   public void ClickOnselectSizeShoe()
   {
	   select_size_shoe.click();   
   }
   
   public void ClickOnselectSizeJeans()
   {
	   select_size_jeans.click();   
   }
   
   
   public void ClickOnselectSizeClothes()
   {
	   select_size.click();   
   }
   public void clickOnpincodeButton()
   {
	   add_pincode.click();   
   }
   public void send_pincode()
   {
	   enter_pincode.sendKeys("411038");   
   }
   public void clickOnConfirmpincode()
   {
	   confirm_pincode.click();   
   }
   public void clickOnAddToBag()
   {	
	   AddToBag.click();   
   }
   public void clickOnGoToBag()
   {	
	   GoToBag.click();   
   }
   public void getProductName()
   {	
	   productName.click();
	   System.out.println(productName.getText()); 
   }

   public void myBagItems() 
   {
	   myBag_itemsadded.click();
		System.out.println(myBag_itemsadded.getText());
	}
   public void getOrderDetails () {
		getTextofOrder.click();
		System.out.println(getTextofOrder.getText());
	}

   
   public void productDetail_proceedToShipping()
   {
	  // select_colour.click();
	   select_size.click();
	   add_pincode.click();
	   enter_pincode.sendKeys("411038");
	   confirm_pincode.click();
	   AddToBag.click();
	   GoToBag.click();
   }
}