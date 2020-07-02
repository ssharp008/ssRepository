package com.bwf.ecshop.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * UserPage类用于定义user.php页面的元素和方法
 * @author lvsharp
 *
 */
public class UserPage {
	List<WebElement> reg_input_list = new ArrayList<>();
	private WebDriver driver;
	/**
	 * 用户名的输入框
	 */
    @FindBy(name="username")
    private WebElement username_input;
    /**
     * 密码的输入框
     */
    @FindBy(name="password")
    private WebElement password_input;
    /**
     * 立即登录按钮
     */
    @FindBy(name="submit")
    private WebElement submit_btn;
    /**
     * 提交登录后的提示信息
     */
    @FindBy(css="div.boxCenterList>div>p")
    private WebElement login_result_text;
    /**
     * 注册用户名输入框
     */
    @FindBy(id="username")
    private WebElement reg_username_input;
    /**
     * 注册email输入框
     */
    @FindBy(id="email")
    private WebElement reg_email_input;
    /**
     * 注册密码输入框
     */
    @FindBy(id="password1")
    private WebElement reg_password_input;
    /**
     * 注册确认密码输入框
     */
    @FindBy(id="conform_password")
    private WebElement reg_confirm_password_input;
    /**
     * 注册手机输入框
     * @param driver
     */
    @FindBy(id="extend_field5")
    private WebElement reg_cellphone_input;
    
    /**
     * 注册提交按钮
     */
    @FindBy(name="Submit")
    private WebElement reg_submit_btn;
    
    public UserPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    	reg_input_list.add(reg_username_input);
    	reg_input_list.add(reg_email_input);
    	reg_input_list.add(reg_password_input);
    	reg_input_list.add(reg_confirm_password_input);
    	reg_input_list.add(reg_cellphone_input);
    }
    /**
     * 在用户名输入框中输入指定的用户名字符串
     * @param username 指定输入的用户名字符串
     */
    public void input_username(String username) {
    	username_input.sendKeys(username);
    }
    /**
     * 在密码输入框中输入指定的密码字符串
     * @param password 指定输入的密码字符串
     */
    public void input_password(String password) {
    	password_input.sendKeys(password);
    }
    /**
     * 点击立刻提交按钮
     */
    public void click_submit() {
    	submit_btn.click();
    }
    /**
     * 点击立即注册按钮
     */
    public void click_reg_submit() {
    	reg_submit_btn.click();
    }
    /**
     * 检查点，断言是否显示指定的登录后的提示文本
     * @param expectedText 期望提示的文本
     */
    public void assert_result_text(String expectedText) {
    	String actualText = login_result_text.getText();
    	assertEquals(actualText,expectedText);
    }
    /**
     * 检查点，断言弹出的警告框上的文字是否和期望值匹配
     * @param expectedText 期望的文字
     */
    public void assert_alert_text(String expectedText) {
    	Alert alert = driver.switchTo().alert();
    	String actualText = alert.getText();
    	alert.accept();
    	assertTrue(actualText.contains(expectedText));
    }
    /**
     * 对注册信息框输入指定内容
     * @param index 第几个必填项，从1开始
     * @param content 填入的内容
     */
    public void input_reg_info(int index,String content) {
    	reg_input_list.get(index-1).sendKeys(content);
    }
    /**
     * 检查点，检查必填项是否符合要求
     * @param index 第几个必填项，从1开始
     * @param expectedText 提示的期望文本
     */
    public void assert_alert_tip(int index,String expectedText) {
    	String actual = reg_input_list.get(index-1).findElement(By.xpath("../span")).getText();
    	assertTrue(actual.contains(expectedText));
    }
    public void assert_input_tip(int index,String expectedText) {
    	List<WebElement> input_list = new ArrayList<>();
    	input_list.add(reg_username_input);
    	input_list.add(reg_email_input);
    	input_list.add(reg_password_input);
    	input_list.add(reg_confirm_password_input);
    	input_list.add(reg_cellphone_input);
    	String actual = input_list.get(index-1).findElement(By.xpath("../span")).getText();
    	assertTrue(actual.contains(expectedText));
    }
    
}
