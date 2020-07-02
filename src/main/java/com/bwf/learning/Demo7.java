package com.bwf.learning;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bwf.utils.DriverUtils;

public class Demo7 {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://localhost:8082/table2.html");
			driver.findElement(By.id("a1")).click();
			WebDriverWait wait = (WebDriverWait)new WebDriverWait(driver,10L).withMessage("找了10s都没找到，sorry");
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
//			alert.sendKeys("123");
			alert.accept();
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}
	}
}
