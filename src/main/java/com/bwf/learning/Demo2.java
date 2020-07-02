package com.bwf.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.utils.DriverUtils;

public class Demo2 {
	public static void main(String[] args) {
		System.setProperty("bwf.test.browser", "firefox");
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.get("https://www.baidu.com");
			WebElement search_input = driver.findElement(By.id("kw"));
			search_input.sendKeys("test");
			Thread.sleep(2000);
		    driver.close();	
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}	    
	}

}
