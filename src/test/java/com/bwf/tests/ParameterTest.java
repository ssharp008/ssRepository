package com.bwf.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterTest {
	/**@DataProvider(name="auth")
	public Object[][] getAuthData(){
		return new Object[][] {
			{"liudao","123456"},
			{"xuaiguo","456789"},
			{"luxg","233333"}
	};
}**/
	//@Parameters({"username","password"})
	@Test(dataProvider="auth", dataProviderClass=DataProviderFactory.class)
	public void testp(String u,String p) {
		System.out.println("username:"+u+",password:"+p);
	}
}
