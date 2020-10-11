package ru.gb.javatwo.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocketThread extends Thread {

    private final int port;
    private final int timeout;

    private final ServerSocketThreadListener listener;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()), getName());

    public ServerSocketThread(ServerSocketThreadListener listener, String name, int port, int timeout) {
        super(name);
        this.port = port;
        this.timeout = timeout;
        this.listener = listener;
        start();
    }

    public Logger getLogger() {
        return logger;
    }

    @Override
    public void run() {
        logger.setLevel(Level.ALL);
        listener.onServerStart(this);
        logger.log(Level.INFO,"Servers started");
        try (ServerSocket server = new ServerSocket(port)) {
            server.setSoTimeout(timeout);
            listener.onServerSocketCreated(this, server);
            logger.log(Level.INFO,"Listening to port");
            while (!isInterrupted()) {
                Socket client;
                try {
                    client = server.accept(); // while (!clientConnected || !timeout) {}
                } catch (SocketTimeoutException e) {
                    listener.onServerTimeout(this, server);
                    continue;
                }
                listener.onSocketAccepted(this, server, client);
                logger.log(Level.INFO, "Client connected");
            }
        } catch (IOException e) {
            listener.onServerException(this, e);
            logger.log(Level.WARNING, "Server not started");
        } finally {
            listener.onServerStop(this);
            logger.log(Level.INFO, "Server shutdown");
        }
    }
}
