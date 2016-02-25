package proxy.spring.com.javaproxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Proxy;

import proxy.spring.com.javaproxy.proxy.HelloProxy;
import proxy.spring.com.javaproxy.proxy.HelloProxy2;
import proxy.spring.com.javaproxy.proxy.HelloProxyHandler2;
import proxy.spring.com.javaproxy.proxy.ProxyFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test).setOnClickListener(this);
        tvLog = (TextView) findViewById(R.id.log);

    }

    @Override
    public void onClick(View v) {
        tvLog.setText("");
        //normal method to create proxy
        HelloProxy helloWorld = new HelloProxy() {
            @Override
            public void sayHello(String what) {
                tvLog.append("HelloProxy sayHello:" + what + "\n");
            }

            @Override
            public void sayHello2(String what) {
                tvLog.append("HelloProxy sayHello2:" + what);
            }

        };
        HelloProxyHandler2 handler = new HelloProxyHandler2(helloWorld);
        //create proxy
        HelloProxy proxy = (HelloProxy) Proxy.newProxyInstance(
                helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(),
                handler);
        proxy.sayHello("spring1");
        proxy.sayHello2("spring2");

        //create proxy by factory: discover impl
        HelloProxy2 proxy2 = new ProxyFactory().newProxyInstance(HelloProxy2.class);
        proxy2.sayHello2("spring3");
        proxy2.sayHello("spring4");
    }
}
