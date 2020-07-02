package com.bwf.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * IndexPage类用于定义index.php页面的元素和方法
 * @author lvsharp
 *
 */
public class IndexPage {
	/**
	 * 登录链接
	 */
	@FindBy(linkText="请登录")
	private WebElement login_link;
    /**
     * 免费注册链接
     */
	@FindBy(linkText="免费注册")
	private WebElement register_link;
	/**
	 * 使用页面工场构造自己
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * 操作步骤，点击登录链接
	 */
	public void click_login_link() {
		login_link.click();
	}
	/**
	 * 操作步骤，点击免费注册链接
	 */
	public void click_register_link() {
		register_link.click();
	}
}
