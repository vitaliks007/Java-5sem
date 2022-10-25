package ru.Vitaliy.pr3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
    private static final List<String> messages = new ArrayList<>();
    private static final List<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(60000)) {
            System.out.println("Сервер запущен...");
            ExecutorService pool = Executors.newFixedThreadPool(20);
            pool.execute(new BroadcastSender(sockets, messages));
            while (true) {
                pool.execute(new BroadcastReceiver(listener.accept(), messages, sockets));
            }
        }
    }
}
