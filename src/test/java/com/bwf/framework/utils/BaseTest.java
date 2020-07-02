package com.bwf.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.bwf.utils.DriverUtils;

public class BaseTest {
	public WebDriver driver;
	   @AfterSuite
	   public void closeService() {
		   DriverUtils.stopService();
	   }
	   @BeforeMethod
	   public void initDriver() {
		   Config config = new Config("config.properties");
		   System.setProperty("bwf.test.browser", config.getConfig("bwf.test.browser"));
		   driver = DriverUtils.getDriver();
	   }
	   @AfterMethod
	   public void quitDriver() {
	       driver.quit();
	}
}
