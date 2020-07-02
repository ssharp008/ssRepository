package com.bwf.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo2 {
	@BeforeClass
	public void beforeClassM() {
		System.out.println("------------Before Class TestDemo2-----");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("------------After Class TestDemo2-----");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("--------------Before Method in TestDemo1-----");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("--------------After Method in TestDemo1-----");
	}
    @Test(groups={"firstlevel"})
    public void myTest21Func() {
    	System.out.println("-------------->testMethod - myTest21Func");
    }
    @Test(groups={"secondlevel"})
    public void myTest22Func() {
    	System.out.println("-------------->testMethod - myTest22Func");
    }
}
