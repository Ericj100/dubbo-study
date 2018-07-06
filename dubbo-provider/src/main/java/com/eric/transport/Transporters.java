package com.eric.transport;

import com.eric.transport.netty.ChannelHandler;
import com.eric.transport.netty.NettyServer;

public class Transporters {

    //绑定，监听
    public static Server bind(String address, int port, ChannelHandler handler) throws Exception{
        Server server = new NettyServer(address,port,handler);
        return server;
    }
}
