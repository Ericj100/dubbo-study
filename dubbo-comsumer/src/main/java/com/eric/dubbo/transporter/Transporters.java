package com.eric.dubbo.transporter;

import com.eric.dubbo.support.Request;
import com.eric.dubbo.transporter.netty.NettyClient;
import com.eric.dubbo.transporter.netty.NettyClientServiceHandler;

public class Transporters {

    public static Object connectAndExecute(Request request) throws Exception{
        NettyClientServiceHandler handler = new NettyClientServiceHandler();
        new NettyClient().connectAndExecute(request, handler);
        return handler.getResponse().getResult();
    }
}
