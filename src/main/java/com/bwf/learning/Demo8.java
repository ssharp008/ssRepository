package com.bwf.learning;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bwf.utils.DriverUtils;

public class Demo8 {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://localhost:8082/table3.html");
			driver.switchTo().frame(driver.findElement(By.xpath("//p[@id='mid']/iframe[2]")));
			driver.findElement(By.id("kw")).sendKeys("123");
			driver.switchTo().defaultContent();
			driver.findElement(By.id("kg")).sendKeys("ddd");
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}
	}
}
