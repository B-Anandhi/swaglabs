package com.swaglab.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.pageobject.ContactPage;
import com.swaglab.pageobject.HomePage;
import com.swaglab.pageobject.LoginPage;

public class HomePageTest extends BaseClass{
	
	HomePage home;
	LoginPage login;
	ContactPage contact;
	
	
	@Test(groups={"Sanity","Regression"})
	public void HomePageTest()
	
	{
		home=new HomePage();
		String actualtitle=home.verifytitle();
		String expectedtitle="Automation Exercise";
		Assert.assertEquals(actualtitle,expectedtitle);
	}
	
	
	

	
	

}
