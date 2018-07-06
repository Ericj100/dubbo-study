package com.eric.transport.netty;

import com.eric.dubbo.support.Request;
import com.eric.dubbo.support.Response;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.Method;
import java.util.Map;

public class NettyServiceHandler  extends SimpleChannelInboundHandler implements ChannelHandler {

    private Map<String, Class<?>> exportedServices;

    public NettyServiceHandler(Map<String, Class<?>> exportedServices) {
        this.exportedServices = exportedServices;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        System.out.println("handler中exportedServices：" + exportedServices.size());
        Request request = (Request)object;

        String serviceName = request.getInterfaceName();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] args = request.getArgs();

        Class<?> serviceClass = exportedServices.get(serviceName);

        Method method = serviceClass.getMethod(methodName, parameterTypes);
        Object result = method.invoke(serviceClass.newInstance(), args);

        Response response = new Response();
        response.setResult(result);

        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);


    }
}
