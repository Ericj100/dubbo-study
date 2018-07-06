package com.eric.dubbo;

import com.eric.dubbo.consumer.DubboConsumer;
import com.eric.service.HelloWorldService;

public class DubboConsumerTest {

    public static void main(String[] args) {
        DubboConsumer<HelloWorldService> reference = new DubboConsumer<HelloWorldService>();
        reference.setInterfaceClass(HelloWorldService.class);

        HelloWorldService helloWorldService = reference.get();
        System.out.println(helloWorldService.sayHello("zhangsan"));
    }
}
