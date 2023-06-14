package com.swaglab.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.swaglab.pageobject.*;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.utility.*;
public class LoginPageTest extends BaseClass {

	LoginPage login;
	ProductPage prod;
	HomePage home;
	InfoPage info;
	AccountSuccessPage act;
	
	
	
	
	@Test(groups= {"Sanity", "Regression"})
	public void logintest() throws InterruptedException
	{
		Log.startTestCase("logintest");
		home=new HomePage();
		login=home.clickonlogin();
		Log.info("User navigated to Login Page");
		prod=login.login(prop.getProperty("username"),prop.getProperty("password"));
		Log.info("Logging in with user name and password");
		Assert.assertEquals(prod.ValidateUrl(),prop.getProperty("url"));
		Log.endTestCase("Login Test Case completed");
		
	}
	
	
	@Test(dataProvider= "accountcreation", dataProviderClass=Excelutility.class, groups= {"Sanity"})
	
	public void Signuptest(String password,String day, String month, String year, String firstname, String lastname, String address, String company, String country, String state, String city, String zipcode, String mobilenumber) throws InterruptedException
	{
		home=new HomePage();
		login=home.clickonlogin();
		info=login.info(prop.getProperty("signupemail"),prop.getProperty("name"));
	    act=info.signup(password, day, month, year, firstname, lastname, address, company, country, state, city, zipcode, mobilenumber);
		prod=act.success();
	    act=prod.DeleteAcc();
	
		
	}
}
