package com.adk.JUC;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;
import sun.security.pkcs11.wrapper.Constants;

import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "123456")
public class Async {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("future");
                Thread.sleep(1000);
                return 100;
            }
        });

        Thread t1=new Thread(futureTask,"sss");
        t1.start();

        System.out.println(futureTask.get());

    }
}
