package com.eric.dubbo;

import com.eric.protocal.DubboProtocol;
import com.eric.protocal.Protocol;

public class DubboProvider<T> {

    //服务监听端口
    private int port = 3347;

    //服务提供接口Class
    private Class<?> interfaceClass;

    //接口名字
    private String interfaceName;

    //服务接口实现引用
    private T ref;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
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

    public void export() throws Exception {
        Protocol protocol = DubboProtocol.getDubboProtocol();
        protocol.export(interfaceName, ref.getClass());
    }
}
