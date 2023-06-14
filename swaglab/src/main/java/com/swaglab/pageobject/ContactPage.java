package com.swaglab.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.actiondriver.*;
import com.swaglab.pageobject.*;
import org.openqa.selenium.JavascriptExecutor;

public class ContactPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath="//*[contains(text(), 'Get In Touch')]")
	WebElement getintouch;
	
	@FindBy(xpath="//*[@name='name']")
	WebElement names;

	@FindBy(xpath="//*[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//*[@name='subject']")
	WebElement subject;
	
	@FindBy(xpath="//*[@id='message']")
	WebElement message;
	
	@FindBy(xpath="//*[@name='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="//*[@class='status alert alert-success']")
	WebElement success;
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	WebElement Homepg;
	
	
    @FindBy(xpath="//*[@id='dismiss-button']/div/span")
    WebElement ads;
    
    
    
    @FindBy(xpath="//*[contains(@name,'aswift_4')]")
    WebElement fram;
    
    @FindBy(xpath="//*[contains(@name,'id')]")
    WebElement frams;
    
    @FindBy(xpath="//*[contains(@name,'upload_file')]")
    WebElement upload;
	
   public ContactPage() {
	   PageFactory.initElements(getDriver(),this);
	  
   }
   
   public boolean verifyPage()
   {
	   return action.isDisplayed(getDriver(),getintouch);
	   
   }
   
   
   
   public HomePage FillForm(String myname,String emailid, String subjectline, String messages) throws InterruptedException 
   {
	   //action.click(driver,names);
	   //action.JSClick(driver, names);
	   
	   action.type(names, myname);
	   action.type(email, emailid);
	   action.type(subject, subjectline);
	   action.type(message, messages);
	   action.type(upload,System.getProperty("user.dir")+"\\Logo\\hello.jpg");
	   
	   action.click(getDriver(), submitbtn);
	   action.Alert(getDriver());
	  
	   action.isDisplayed(getDriver(), success);
	   action.click(getDriver(), Homepg);
	   
	   if(action.isDisplayed(getDriver(), fram))
	   {
		   getDriver().switchTo().frame(fram).switchTo().frame(0);
		   action.click(getDriver(), ads);
	   } 
	  
	  
	   return new HomePage();

	   
   }
	
}
