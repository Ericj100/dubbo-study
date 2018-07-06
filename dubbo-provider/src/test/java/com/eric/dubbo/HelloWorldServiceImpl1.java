package com.eric.dubbo;

import com.eric.service.HelloWorldService1;

public class HelloWorldServiceImpl1 implements HelloWorldService1 {
    @Override
    public String sayHello(String name) {
        return "I have received your message : " + name;
    }
}
