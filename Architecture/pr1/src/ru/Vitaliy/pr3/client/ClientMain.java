package ru.Vitaliy.pr3.client;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 60000)) {
            ExecutorService pool = Executors.newFixedThreadPool(2);
            pool.execute(new ClientReceiver(socket));
            pool.execute(new ClientSender(socket));
            while (true) {

            }
        }
    }
}
