package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.utils.DriverUtils;

public class TaobaoYHW {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.taobao.com/");
			WebElement div = driver.findElement(By.cssSelector(".layer.clearfix>div"));
			/**Point point = div.getLocation();
			System.out.println(point);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,point.y);**/
			ScrollToElement(driver,div);
			WebElement element = driver.findElement(By.id("dg-item-tl-0"));
			System.out.println(element.getText());
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}
	}
	public static void ScrollToElement(WebDriver driver,WebElement element) {
		Point point = element.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(arguments[0],arguments[1])",point.x,point.y);
	}
}
