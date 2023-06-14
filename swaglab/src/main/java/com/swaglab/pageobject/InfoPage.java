package com.swaglab.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.actiondriver.*;

public class InfoPage extends BaseClass {

	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement gender;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement pass;
	
	@FindBy(xpath="//*[@id='days']")
	WebElement day;
	
	@FindBy(xpath="//*[@id='months']")
	WebElement month;
	
	@FindBy(xpath="//*[@id='years']")
	WebElement year;
	
	@FindBy(xpath="//*[@id='optin']")
	WebElement check;
	
	@FindBy(xpath="//*[@id='first_name']")
	WebElement first_name;
	
	@FindBy(xpath="//*[@id='last_name']")
	WebElement last_name;
	
	@FindBy(xpath="//*[@id='company']")
	WebElement company;
	
	@FindBy(xpath="//*[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//*[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//*[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//*[@id='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//*[@id='mobile_number']")
	WebElement number;
	
	@FindBy(xpath="//*[contains(text(),\"Create\")]")
	WebElement createacc;
	
	
	public InfoPage() {
	 PageFactory.initElements(getDriver(), this);	
	}
	
	Action action= new Action();
	
	public AccountSuccessPage signup(String password, String days, String mon, String yea, String first, String last,String addr,String com,String con,String stat,String cit, String pin,String num) throws InterruptedException
	{
		
		action.click(getDriver(),gender);
		action.click(getDriver(),pass);
		action.type(pass, password);
	    //action.click(driver, day);
	    action.selectByVisibleText(days, day);
	    Thread.sleep(2000);
	    action.selectByVisibleText(mon,month);
	    action.selectByVisibleText(yea, year);
	    action.click(getDriver(),check);
	    action.type(first_name, first);
	    action.type(last_name, last);
	    action.type(address, addr);
	    action.type(company,com);
	    action.selectByVisibleText(con, country);
	    action.type(state, stat);
	    action.type(city, cit);
	    action.type(zipcode, pin);
	    action.type(number, num);
	    //action.explicitWait(driver, createacc, 20);
	    action.click(getDriver(), createacc);
	    return new AccountSuccessPage();
	    	    
	
	}
	
}
