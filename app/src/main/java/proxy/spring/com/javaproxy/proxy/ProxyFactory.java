package proxy.spring.com.javaproxy.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyFactory {
	
	@SuppressWarnings("unchecked")
	public <T extends ProxyInterface> T newProxyInstance(final Class<T> clazz) {
        final Map<Method, InvocationHandler> handlers = new HashMap<Method, InvocationHandler>();

        for (final Method method : clazz.getMethods()) {
            handlers.put(method, new HelloProxyHandler());
        }

        final HelloProxyExecute proxy = new HelloProxyExecute(handlers);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, proxy);
    }
}
