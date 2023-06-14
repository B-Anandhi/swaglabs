package com.swaglab.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.actiondriver.*;
public class ProductPage extends BaseClass{
	

	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
    WebElement deleteacc;
	


	
	@FindBy(xpath="//a[contains (text(),'Products')]")
	WebElement Product;
	

	
	
	
	
	
	
 	public ProductPage()
 	{
 		PageFactory.initElements(getDriver(), this);
 	}
 	
 	Action action = new Action();
 	
 	public String ValidateUrl()
 	{
 		String url=action.getCurrentURL(getDriver());
 		return url;
 	}
 	
 	public AccountSuccessPage DeleteAcc()
 	{
 		action.click(getDriver(), deleteacc);
		return new AccountSuccessPage();
 	}
 	
 	
 	public SearchProductPage clickonProduct()
	{
		action.click(getDriver(), Product);
		return new SearchProductPage();
	}
 	
 	
 	
}
