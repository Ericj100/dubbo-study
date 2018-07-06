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


        HelloWorldService1 helloWorldService1 = new HelloWorldServiceImpl1();

        DubboProvider dubboProvider1 = new DubboProvider();
        dubboProvider1.setPort(3347);
        dubboProvider1.setRef(helloWorldService1);
        dubboProvider1.setInterfaceClass(HelloWorldService1.class);

        dubboProvider1.export();
    }
}
