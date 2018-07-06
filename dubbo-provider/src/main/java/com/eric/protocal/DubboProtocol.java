package com.eric.protocal;

import com.eric.transport.Server;
import com.eric.transport.Transporters;
import com.eric.transport.netty.ChannelHandler;
import com.eric.transport.netty.NettyServiceHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DubboProtocol implements Protocol {

    private Map<String, Class<?>> exportedServices = new ConcurrentHashMap<String, Class<?>>();

    private Map<String, Server> serverMap = new ConcurrentHashMap<String, Server>();

    private static Protocol dubboProtocol = new DubboProtocol();

    public static Protocol getDubboProtocol(){
        return dubboProtocol;
    }

    @Override
    public void export(String interfaceName, Class<?> impl) throws Exception {
        String key = interfaceName;
        exportedServices.put(key, impl);
        openServer();
        System.out.println("DubboProtocol中：" + exportedServices.size());

    }

    private void openServer() throws Exception{
        String address = "127.0.0.1";
        int port = 3347;

        String key = address + ":" + port;

        Server server = serverMap.get(key);
        if(server == null){
            serverMap.put(key, createServer(address, port));
        }
    }

    private Server createServer(String address, int port) throws Exception{
        ChannelHandler handler = new NettyServiceHandler(exportedServices);
        Server server = Transporters.bind(address, port, handler);
        System.out.println("DubboProtocol创建完server后：" + exportedServices.size());
        return server;
    }
}
