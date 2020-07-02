package com.bwf.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * IndexPage�����ڶ���index.phpҳ���Ԫ�غͷ���
 * @author lvsharp
 *
 */
public class IndexPage {
	/**
	 * ��¼����
	 */
	@FindBy(linkText="���¼")
	private WebElement login_link;
    /**
     * ���ע������
     */
	@FindBy(linkText="���ע��")
	private WebElement register_link;
	/**
	 * ʹ��ҳ�湤�������Լ�
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * �������裬�����¼����
	 */
	public void click_login_link() {
		login_link.click();
	}
	/**
	 * �������裬������ע������
	 */
	public void click_register_link() {
		register_link.click();
	}
}
