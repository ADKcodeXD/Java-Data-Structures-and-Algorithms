package com.adk.singleton.ehan;

/**
 * 使用静态代码块进行创建
 * 这三种模式都是不存在线程安全问题的
 * 类初始化时直接创建对象
 */
public class SingletonStatic {
    public static final SingletonStatic INSTANCE;
    static {
        INSTANCE=new SingletonStatic();
    }
    private SingletonStatic(){

    }
}
