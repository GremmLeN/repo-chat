package ru.gb.javatwo.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocketThread extends Thread {

    private final int port;
    private final int timeout;

    private final ServerSocketThreadListener listener;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()), getName());
    ExecutorService executorService = Executors.newCachedThreadPool();

    public ServerSocketThread(ServerSocketThreadListener listener, String name, int port, int timeout) {
        super(name);
        this.port = port;
        this.timeout = timeout;
        this.listener = listener;
        start();
        ServerSocketThread serverSocketThread = this;

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                logger.setLevel(Level.ALL);
                listener.onServerStart(serverSocketThread);
                logger.log(Level.INFO, "Servers started");
                try (ServerSocket server = new ServerSocket(port)) {
                    server.setSoTimeout(timeout);
                    listener.onServerSocketCreated(serverSocketThread, server);
                    logger.log(Level.INFO, "Listening to port");
                    while (!isInterrupted()) {
                        Socket client;
                        try {
                            client = server.accept(); // while (!clientConnected || !timeout) {}
                        } catch (SocketTimeoutException e) {
                            listener.onServerTimeout(serverSocketThread, server);
                            continue;
                        }
                        listener.onSocketAccepted(serverSocketThread, server, client);
                        logger.log(Level.INFO, "Client connected");
                    }
                } catch (IOException e) {
                    listener.onServerException(serverSocketThread, e);
                    logger.log(Level.WARNING, "Server not started");
                } finally {
                    listener.onServerStop(serverSocketThread);
                    logger.log(Level.INFO, "Server shutdown");
                }
            }
        });

    }
}
