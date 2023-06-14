package com.swaglab.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.swaglab.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

//import com.swaglab.utility.ExtentManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
	
	@BeforeSuite(groups= {"Sanity","Regression"})
	public void loadConfig()
	{
		DOMConfigurator.configure("log4j.xml");
        ExtentManager.setExtent();

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	@BeforeMethod(groups= {"Sanity","Regression"})
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browsername=prop.getProperty("browser");
		if(browsername.contains("Chrome"))
			driver.set(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod(groups= {"Sanity","Regression"})
	public void exit()
	{
		getDriver().quit();
	}
	
	@AfterSuite(groups= {"Sanity","Regression"})
	public void closeextent()
	{
    ExtentManager.endReport();
	}
}
