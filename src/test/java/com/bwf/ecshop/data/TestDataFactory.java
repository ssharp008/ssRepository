package com.bwf.ecshop.data;

import org.testng.annotations.DataProvider;

import com.bwf.learning.ReadExcel;

public class TestDataFactory {
   @DataProvider(name="loginTestData")
   public static Object[][] getLoginTestData(){
	   /*return new Object[][] {
		   {"liudao001","123456","登录成功"},
		   {"liudao001","111111","用户名或密码错误"},
		   {"liudao","111111","用户名或密码错误"},
		   {"","123456","用户名不能为空"},
		   {"liudao","","登录密码不能为空"}
	   };*/
	   return ReadExcel.getDataFromeExcel("loginTestData.xls", "Sheet1");
   }
   @DataProvider(name="registerTestData_tips")
   public static Object[][] getRegisterTestData_tips(){
	   Object[][] object = ReadExcel.getDataFromeExcel("registerTestData.xls", "Sheet1");
	   return object;   
   }
   @DataProvider(name="registerTestData_success")
   public static Object[][] getRegisterTestData_success(){
	   return ReadExcel.getDataFromeExcel("registerTestData.xls","Sheet2");
   }
}
