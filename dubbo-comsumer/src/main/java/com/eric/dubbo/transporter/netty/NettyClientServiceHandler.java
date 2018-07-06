package com.eric.dubbo.transporter.netty;

import com.eric.dubbo.support.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientServiceHandler extends SimpleChannelInboundHandler{

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        response = (Response) object;
    }
}
