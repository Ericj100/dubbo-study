package com.eric.dubbo;

import com.eric.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        return "I have received your message : " + name;
    }
}
