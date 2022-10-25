package ru.Vitaliy.pr3.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class BroadcastSender implements Runnable {
    private final List<Socket> sockets;
    private final List<String> messages;

    public BroadcastSender(List<Socket> sockets, List<String> messages) {
        this.sockets = sockets;
        this.messages = messages;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                sockets.forEach(socket -> {
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        messages.forEach(out::println);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                messages.clear();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
