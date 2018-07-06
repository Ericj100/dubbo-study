# dubbo-study

写一个简单dubbo实现 

## dubbo-provider

服务提供者端，主要是暴露服务，处理消费者端请求等 

## dubbo-consumer

服务消费者端，主要作用是引用服务 

## dubbo-common

一些公用类 

## 目标

- 可以使用API和Spring两种方式启动
- 提供完整暴露服务和服务引用功能
- 提供多协议支持
- 实现注册中心支持
- 提供自定义编解码
- 使用Netty和Mina
- 提供对多种序列化的支持

## 已有实现

- 可以使用API启动
- 简单的暴露和服务引用
- 现使用TCP协议
- 使用Netty
- 使用Netty的编解码
- 使用Java序列化方式