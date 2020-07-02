package com.bwf.learning;

import java.lang.reflect.Proxy;

public class RunProxyDemo {
    public static void main(String[] args) {
    	ITestAnno ta = TestAnnoFactory.build();
    	ta.sayHi();
    }
}
