package com.eric.dubbo;

import com.eric.service.HelloWorldService;
import com.eric.service.HelloWorldService1;

public class ProviderTest {

    public static void main(String[] args) throws Exception {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();

        DubboProvider dubboProvider = new DubboProvider();
        dubboProvider.setPort(3347);
        dubboProvider.setRef(helloWorldService);
        dubboProvider.setInterfaceClass(HelloWorldService.class);

        dubboProvider.export();


    }
}
