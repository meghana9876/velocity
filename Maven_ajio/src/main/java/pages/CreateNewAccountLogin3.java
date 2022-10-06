package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountLogin3 {
	
	//variable declaration//
		@FindBy(xpath="//label[@class='gender-opt']")
		private WebElement select_gender;
	    
		@FindBy(xpath="(//input[@type='text'])[1]")
		private WebElement enter_name;
	    
		@FindBy(xpath="(//input[@type='text'])[2]")
		private WebElement enter_mobileno;
	    
		@FindBy(xpath="//input[@id='pwdInput']")
		private WebElement enter_password;
	    
		@FindBy(xpath="//input[@type='checkbox']")
		private WebElement terms_condition;
	    
		@FindBy(xpath="//input[@value='SEND OTP']")
		private WebElement Send_otp;
		
		@FindBy(xpath="//input[@id='gender1']")
		private WebElement Click_femaleGender;
		
		
		
		//variable initialization
		
		public CreateNewAccountLogin3(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//variable use-webelements actions
	    public void select_gender()
	    {
	    	select_gender.click();
	    }
	    
	     public boolean clicksend_Name()
	    {
	    	 boolean result=enter_name.isEnabled();
	    	 return result;
	    	
	    }
	     public String enterName_getattribute()
	     {
	    	 String result=enter_name.getAttribute("placeholder");
	    	 return result;
	     
	     }
	     public void send_Name()
	     {
	    	 enter_name.sendKeys("Anishaa Agrawal");	 
	     }
	     public void send_mobileno()
		 {
		   	enter_mobileno.sendKeys("9850789398");
	     }
	     
	     public void send_password()
		  {
	    	enter_password.sendKeys("velocity_123");
          }
	     
	    public void clickonterms_conditions()
	    {
	    	terms_condition.click();
	    }
	    
	    public void click_otp()
	    {
	    	Send_otp.click();
	    }
	    
	    public boolean click_femaleGender()
	    {
	    	boolean result=Click_femaleGender.isSelected();
	    	return result;
	    	
	    }
	    ////or////
	    
	    public void loginToApplication()
	    {
	    	select_gender.click();
	    	enter_name.sendKeys("Anishaa Agrawal");
	    	enter_mobileno.sendKeys("9850789399");
	    	enter_password.sendKeys("velocity_123");
	    	terms_condition.click();
	    	Send_otp.click();
	    	
	    }
	   
}
