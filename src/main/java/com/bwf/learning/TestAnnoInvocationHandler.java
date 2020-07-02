package com.bwf.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestAnnoInvocationHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		ITestAnno ta = new TestAnno();
		RunTime rt = method.getAnnotation(RunTime.class);
		int count = rt.count();
		Object obj = null;
		for(int i = 0;i<count;i++) {
			System.out.println("----->开始代理执行第"+(i+1)+"次");
			obj = method.invoke(ta,args);
			System.out.println("----->结束代理执行第"+(i+1)+"次");
		}
		return obj;
}
}
