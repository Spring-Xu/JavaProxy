package proxy.spring.com.javaproxy.proxy;


import proxy.spring.com.javaproxy.annotation.SerName;

public interface HelloProxy extends ProxyInterface {
	@SerName("annotation")
	public void sayHello2(String what);
}
