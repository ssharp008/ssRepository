package com.bwf.tests;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {
	@DataProvider(name="auth")
	public Object[][] getAuthData(){
		return new Object[][] {
			{"liudao","123456"},
			{"xuaiguo","456789"},
			{"luxg","233333"}
	};
	}
}
