package com.bwf.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.utils.DriverUtils;

public class Demo3 {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.get("http://localhost:8082/table.html");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript(window.scrollTo(0,1000));
			/**
			 * driver.findElement(By.xpath("//table/tbody/tr[3]/td[4]/input")).click();
			 * price1 = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).getText());
			 * driver.findElement(By.xpath("//table/tbody/tr[4]/td[4]/input")).click();
			 * price2 = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]")).getText());
			 
			int price1,price2;
			price1 = choice(driver,1);
			price2 = choice(driver,3);	
			System.out.println("×Ü¼ÛÎª"+(price1+price2));*/
			driver.findElement(By.xpath("//table/tbody/tr[last()]/td[4]/input")).click();
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}
	}
	public static int choice(WebDriver driver,int index) {
		int price;
		WebElement check = driver.findElement(By.xpath("//table/tbody/tr["+(1+index)+"]/td[4]/input"));
		check.click();
		price = Integer.parseInt(check.findElement(By.xpath("../../td[3]")).getText());
		return price;
	}
}
