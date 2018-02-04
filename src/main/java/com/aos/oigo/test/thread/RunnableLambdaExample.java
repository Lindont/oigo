package com.aos.oigo.test.thread;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": RunnableTest");

        //Lambda Expression
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
            System.out.println(Thread.currentThread().getName() + " is running");
        }, "LambdaThread").start();


        // Anonymous Runnable

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        };


        // Passing a Runnable when creating a new thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });


        // Lambda Runnable
        Runnable task3 = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
            System.out.println(Thread.currentThread().getName() + " is running");
        };


        Thread thread1 = new Thread(task1);

        thread1.start();
        thread2.start();

        new Thread(task3).start();

    }
}