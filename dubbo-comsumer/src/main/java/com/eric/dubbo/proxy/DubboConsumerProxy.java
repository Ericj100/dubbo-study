package com.eric.dubbo.proxy;

import com.eric.dubbo.support.Request;
import com.eric.dubbo.transporter.Transporters;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DubboConsumerProxy implements InvocationHandler {

    private Class<?> interfaces;

    public DubboConsumerProxy(Class<?> interfaces) {
        this.interfaces = interfaces;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces}, this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Request request = new Request();
        request.setInterfaceName(interfaces.getName());
        request.setMethodName(method.getName());
        request.setParameterTypes(method.getParameterTypes());
        request.setArgs(args);

        Object result = Transporters.connectAndExecute(request);
        return result;
    }
}
