package com.bwf.ecshop.tests;
import org.testng.annotations.Test;

import com.bwf.ecshop.data.TestDataFactory;
import com.bwf.ecshop.pages.IndexPage;
import com.bwf.ecshop.pages.UserPage;
import com.bwf.framework.utils.BaseTest;

public class LoginTest extends BaseTest{
   @Test(dataProviderClass=TestDataFactory.class,dataProvider="loginTestData")
   public void testLogin_success(String username,String password,String expectedText) {
	   //1.打开首页
	   driver.get("http://localhost/ecshop/");
	   //2.点击登录链接
	   IndexPage indexPage = new IndexPage(driver);
	   indexPage.click_login_link();
	   //3.填写用户名，密码
	   UserPage userPage = new UserPage(driver);
	   userPage.input_username(username);
	   userPage.input_password(password);
	   //4.点击立刻登录按钮
	   userPage.click_submit();
	   //5.判断是否登录成功
	   if(username.equals("")||password.equals("")) {
		   userPage.assert_alert_text(expectedText);
	   }else{
		   userPage.assert_result_text(expectedText);
	   }
   }
}
