package com.eric.dubbo.consumer;

import com.eric.dubbo.proxy.DubboConsumerProxy;

public class DubboConsumer<T> {

    private String interfaceName;

    private Class<?> interfaceClass;

    private T ref;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
        setInterfaceName(interfaceClass == null ? (String) null : interfaceClass.getName());
    }

    public T getRef() {
        return ref;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }

    public T get(){
        ref = new DubboConsumerProxy(interfaceClass).getProxy();

        return ref;

    }
}
