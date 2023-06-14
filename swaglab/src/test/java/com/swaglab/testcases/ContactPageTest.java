package com.swaglab.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglab.baseclass.BaseClass;
import com.swaglab.pageobject.ContactPage;
import com.swaglab.pageobject.HomePage;

public class ContactPageTest extends BaseClass{
	
	HomePage home;
	ContactPage contact;

	
@Test(groups= {"Regression"})	
	
public void clickoncontactTest() throws InterruptedException
{   //contact=new ContactPage();
	home=new HomePage();
	contact=home.clickoncontact();
	boolean result = contact.verifyPage();
	Assert.assertTrue(result);	
	//contact=new ContactPage();
	home=contact.FillForm(prop.getProperty("myname"), prop.getProperty("emailid"), prop.getProperty("subjectline"), prop.getProperty("messages"));
	Assert.assertTrue(home.validateLogo(),"Logo is present");
	
	
}


	
	




}
