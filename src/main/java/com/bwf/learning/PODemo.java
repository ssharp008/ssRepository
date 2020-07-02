package com.bwf.learning;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bwf.utils.DriverUtils;

public class PODemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com");
			TestingLTPageIndex indexPage = PageFactory.initElements(driver, TestingLTPageIndex.class);
			indexPage.forum_1_link.click();
			Thread.sleep(2000);
			driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}
	}
}
