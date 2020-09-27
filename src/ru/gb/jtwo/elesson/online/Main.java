package ru.gb.jtwo.elesson.online;

public class Main {

    private static int a = 0;
    private static int b = 0;
    private static int c = 0;

    private final static Object monitor = new Object();

    private synchronized static void incAllVars() {
        for (int i = 0; i < 1000_000; i++) {
            a = a + 1;
            b = b + 1;
            c = c + 1;
        }
        String vars = String.format("a=%d, b=%d, c=%d", a, b, c);
        System.out.println(vars);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                incAllVars();
            }
        };
        new Thread(r, "Thread #0").start();
        new Thread(r, "Thread #1").start();
        new Thread(r, "Thread #2").start();
    }

    private static void joinExample() {
        MyThread m = new MyThread("My thread-x");
        m.start();
        // do something
        try {
            m.join(); // while (m.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main ends");
    }

    private static void threadingExample() {
        System.out.println("Hello from " + Thread.currentThread().getName());

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };
        new Thread(r).start();
    }
}
