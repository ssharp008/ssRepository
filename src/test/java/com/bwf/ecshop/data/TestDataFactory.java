package com.bwf.ecshop.data;

import org.testng.annotations.DataProvider;

import com.bwf.learning.ReadExcel;

public class TestDataFactory {
   @DataProvider(name="loginTestData")
   public static Object[][] getLoginTestData(){
	   /*return new Object[][] {
		   {"liudao001","123456","��¼�ɹ�"},
		   {"liudao001","111111","�û������������"},
		   {"liudao","111111","�û������������"},
		   {"","123456","�û�������Ϊ��"},
		   {"liudao","","��¼���벻��Ϊ��"}
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
