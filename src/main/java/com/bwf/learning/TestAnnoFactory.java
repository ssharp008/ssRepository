package com.bwf.learning;

import java.lang.reflect.Proxy;

public class TestAnnoFactory {
 public static ITestAnno build() {
	ITestAnno ta = (ITestAnno)Proxy.newProxyInstance(
			ITestAnno.class.getClassLoader(),
			new Class[]{ITestAnno.class},
			new TestAnnoInvocationHandler());
	return ta;
}
}
