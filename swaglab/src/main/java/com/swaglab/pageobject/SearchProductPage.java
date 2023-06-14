package com.swaglab.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.swaglab.actiondriver.*;

import com.swaglab.baseclass.BaseClass;

public class SearchProductPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='submit_search']")
	WebElement submitbtn;
	
	@FindBy(xpath="//*[@id='search_product']")
	WebElement searchp;
	
	@FindBy(xpath="//a[contains(@href,'/15')]")
	WebElement product2;
	
	@FindBy(xpath="//a[contains(@href,'/11')]")
	WebElement product1;
	
	public SearchProductPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action=new Action();
	public boolean verifyresult(String text)
 	{
 		action.click(getDriver(), searchp);
 		action.type(searchp,text);
 		action.click(getDriver(), submitbtn);
 		
 		if(action.isDisplayed(getDriver(), product2)&& action.isDisplayed(getDriver(), product1))
 				return true;
 		else
 			return false;
 		 
 	}

}
