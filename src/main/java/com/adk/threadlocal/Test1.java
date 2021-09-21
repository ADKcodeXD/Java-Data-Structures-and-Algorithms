package com.adk.threadlocal;

public class Test1 {
    private String content;
    ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public String getContent() {
        String s = threadLocal.get();
        return s;
    }

    public void setContent(String content) {
//        this.content = content;
        threadLocal.set(content);
    }

    public Test1() {
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        for (int i=0;i<5;i++){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    test1.setContent("线程名:"+Thread.currentThread().getName());
                    System.out.println("==========================");
                    System.out.println(Thread.currentThread().getName()+":"+test1.getContent());
                }
            });
            thread.setName("线程"+i);
            thread.start();

        }

    }
}
