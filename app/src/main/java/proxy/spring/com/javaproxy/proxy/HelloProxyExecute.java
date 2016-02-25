package proxy.spring.com.javaproxy.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class HelloProxyExecute implements InvocationHandler {
	Map<Method, InvocationHandler> handlers;
	public HelloProxyExecute(Map<Method, InvocationHandler> handlers){
		this.handlers = handlers;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		InvocationHandler hanlder = handlers.get(method);
		if(hanlder!=null){
			return hanlder.invoke(proxy, method, args);
		}else{
			System.out.println("HelloProxyExecute can not invoke");
		}
		return null;
	}

}
