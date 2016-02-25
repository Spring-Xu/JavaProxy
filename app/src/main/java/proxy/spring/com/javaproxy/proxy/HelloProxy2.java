package proxy.spring.com.javaproxy.proxy;


import proxy.spring.com.javaproxy.annotation.SerName;

public interface HelloProxy2 extends HelloProxy{

	@SerName("annotation:sayHello")
	public void sayHello(String what);

	@Override
	@SerName("annotation:sayHello2")
	public void sayHello2(String what);
}
