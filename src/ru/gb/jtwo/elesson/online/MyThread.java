package ru.gb.jtwo.elesson.online;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread started");
        for (long i = 0; i < 10_000_000_000L; i++) {
            long a = i * 1234;
        }
        System.out.println("Thread stopped");
    }
}
