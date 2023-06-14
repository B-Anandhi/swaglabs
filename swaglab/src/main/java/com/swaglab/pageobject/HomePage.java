package com.swaglab.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.actiondriver.*;

public class HomePage extends BaseClass {
Action action= new Action();
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Login;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[1]/div/a/img")
	WebElement Logo;
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement Contact;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickonlogin()
	{
		action.click(getDriver(), Login);
		return new LoginPage();
		
	}
	
	public boolean validateLogo()
	{
		return action.isDisplayed(getDriver(), Logo);
		
	}
	
	public ContactPage clickoncontact()
	{
		action.click(getDriver(), Contact);
        return new ContactPage();
	
	}
	
	public String verifytitle()
	{
		return getDriver().getTitle();
	}
	
	
}
