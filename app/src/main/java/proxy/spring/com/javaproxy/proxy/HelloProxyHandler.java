package proxy.spring.com.javaproxy.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import proxy.spring.com.javaproxy.annotation.SerName;

public class HelloProxyHandler implements InvocationHandler{

	public HelloProxyHandler(){
		super();
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("method name:"+method.getName());
		if(args!=null&&args.length>0){
			for(Object obs:args){
				System.out.println("method args:"+obs);
			}
		}
		Object result = null;
		SerName serName = method.getAnnotation(SerName.class);
		if(serName!=null){
			System.out.println("SerName:"+serName.value());
		}else{
			System.out.println("SerName is not setted");
		}
		method.invoke(new HelloProxy2(){

			@Override
			public void sayHello(String what) {
				System.out.println("HelloProxy2 sayHello:"+what);
			}

			@Override
			public void sayHello2(String what) {
				System.out.println("HelloProxy2 sayHello2:"+what);
			}
			
		}, args);
		return result;
	}
}
