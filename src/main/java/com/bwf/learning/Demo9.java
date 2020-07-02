package com.bwf.learning;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bwf.utils.DriverUtils;

public class Demo9 {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://www.baidu.com");
            driver.findElement(By.id("kw")).sendKeys("51testing");
            driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
			String baiduWindow = driver.getWindowHandle();
            driver.findElement(By.partialLinkText("²©Îª·å|51Testing")).click();
            Thread.sleep(2000);
            Set<String> handels = driver.getWindowHandles();
            System.out.println(handels.size());
            String testingWindow = "";
            for(String handel:handels) {
            	if(!handel.equals(baiduWindow)) {
            		testingWindow = handel;
            		break;
            	}
            }
            driver.switchTo().window(testingWindow);
			Thread.sleep(2000);
			driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}
	}
}
