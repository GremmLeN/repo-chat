package ru.gb.jtwo.blesson.online;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    enum Enumeration {
        ONE, TWO, THREE, FOUR
    }

    static class Man implements Human {
        @Override
        public void talk() {
            System.out.println("talks stupid");
        }

        @Override
        public void walk() {
            System.out.println("walks on two legs");
        }

        @Override
        public void breathe() {

        }

        @Override
        public void look() {

        }
    }

    static class Minotaur implements Human, Bull {

        @Override
        public void voice() {
            System.out.println("moooo");
        }

        @Override
        public void talk() {
            System.out.println("go to my labyrinth");
        }

        @Override
        public void walk() {
            Human.super.walk();
        }

        @Override
        public void breathe() {

        }

        @Override
        public void look() {

        }
    }

    interface MouseListener {
        void mouseClick();
    }

    static abstract class MouseAdapter implements MouseListener {
        @Override public void mouseClick() { }
    }

    static void addMouseListener(MouseListener l) {

    }

    private static void interfacesExample() {
        class MyClass implements MouseListener {
            @Override
            public void mouseClick() {

            }
        }
        MyClass c = new MyClass();

        addMouseListener(c);
        addMouseListener(new MyClass());
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClick() {

            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClick() {

            }
        });
        addMouseListener( () -> {

                }
        );
    }

    private static int div(int a, int b) throws ArithmeticException {
        return a / b;
    }

    static String s = null;

    static class IOStream implements Closeable {

        IOStream() throws ClassNotFoundException {
            System.out.println("I found iostream");
            //throw new ClassNotFoundException("Cannot find IOStream");
        }

        void open() throws FileNotFoundException {
            System.out.println("here we open a file");
            FileNotFoundException ex = new FileNotFoundException("cannot open a file");
            //throw ex;
        }
        void write() throws SQLException {
            System.out.println("write entity to DataBase");
            throw new SQLException("write failed");
        }

        @Override
        public void close() throws IOException {
            System.out.println("I close my eyes");
            throw new IOException("something went wrong while closing");
        }
    }

    public static void main(String[] args) {
//        int a = 10;
//        int b = 0;
//        System.out.println(div(a, b));

//        int[] arr = new int[5];
//        arr[5] = 10;

//        s.equals(new String("Hello"));
        try (IOStream ios = new IOStream()) {
            ios.open();
            ios.write();
            // a lot of code
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End of main");
    }
}
