package com.swaglab.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.pageobject.HomePage;
import com.swaglab.pageobject.LoginPage;
import com.swaglab.pageobject.ProductPage;
import com.swaglab.pageobject.SearchProductPage;
import com.swaglab.utility.Log;

public class SearchProductPageTest extends BaseClass{
	LoginPage login;
	HomePage home;
	ProductPage prod;
	SearchProductPage search;
	
	@Test(groups= {"Sanity"})
	public void searchProductTest()
	{
		Log.startTestCase("searchProductTest");
		home=new HomePage();
		login=home.clickonlogin();
		prod=login.login(prop.getProperty("username"),prop.getProperty("password"));
		search=prod.clickonProduct();
		Boolean result=search.verifyresult("Printed");
		Assert.assertTrue(result);
		Log.endTestCase("Testcase Passed");
		
		
		
	}
	

	
}
