package com.swaglab.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.actiondriver.*;
public class LoginPage extends BaseClass{
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
    WebElement login;
	
	@FindBy(xpath="(//*[@name=\"email\"])[2]")
	WebElement signupemail;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath="//button[contains(text(),'Signup')]")
    WebElement signup;
	
	
	
 	public LoginPage()
 	{
 		PageFactory.initElements(getDriver(), this);
 	}
 	
 	Action action = new Action();
 	
 	public ProductPage login(String uname,String pa)
 	{
 		System.out.println("Inside loop");
 		action.explicitWait(getDriver(), email, 30);
 		action.type(email, uname);
 		action.type(password, pa);
 		action.click(getDriver(), login);
 		return new ProductPage();
 		
 	}
 	
 	
 
 	
 	
 	public InfoPage info(String email, String name1)
 	{
 		action.type(signupemail, email);
 		action.type(name, name1);
 		action.click(getDriver(),signup);
		return new InfoPage();
		
 		
 	}
}
 	
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		

