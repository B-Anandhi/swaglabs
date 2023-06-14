package com.swaglab.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.actiondriver.*;

public class AccountSuccessPage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),\"Continue\")]")
	WebElement continu;
	
	public AccountSuccessPage()
	{
		PageFactory.initElements(getDriver(), this);
	
	}
	
	Action act=new Action();
	
	public ProductPage success()
	{
		act.getCurrentURL(getDriver());
		act.click(getDriver(), continu);
		return new ProductPage();
	}
	
			
			
			//https://automationexercise.com/account_created
	//https://automationexercise.com/delete_account
		
		

}
