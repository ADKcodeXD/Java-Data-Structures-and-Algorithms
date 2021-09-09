package com.adk.singleton.lanhan;


/**
 * 懒汉式，延迟创建实例对象
 * 只有调用方法才会创建对象
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(instance==null){
            return new Singleton();
        }else {
            return instance;
        }
    }
}
