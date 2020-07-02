package com.bwf.learning;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.utils.DriverUtils;

public class Demo5 {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://localhost:8082/table1.html");
			/**JavascriptExecutor jse = (JavascriptExecutor)driver;
			Thread.sleep(4000);
			List<WebElement> list = (List<WebElement>)jse.executeScript("return document.getElementsByTagName('tr');");
			System.out.println(list);**/
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/label")).click();
			//Thread.sleep(1000);
			Robot robot1 = new Robot ( );
			/**Robot robot2 = new Robot ( );
			Robot robot3 = new Robot ( );
			Robot robot4 = new Robot ( );
			Robot robot5 = new Robot ( );
			Robot robot6 = new Robot ( );
			Robot robot7 = new Robot ( );
			Robot robot8 = new Robot ( );
			Robot robot9 = new Robot ( );
	        Thread.sleep ( 1000 );
	        robot1.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot2.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot3.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot4.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot5.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot6.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot7.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot8.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );
	        robot9.keyPress(KeyEvent.VK_BACK_SPACE);
	        Thread.sleep ( 1000 );**/
			Thread.sleep(1000);
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/input")).click();
	        robot1.keyPress(KeyEvent.VK_1);
	        robot1.keyPress(KeyEvent.VK_2);
	        driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).click();
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtils.stopService();
		}
	}
}
