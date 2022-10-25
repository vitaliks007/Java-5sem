package ru.Vitaliy.pr3.server;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class BroadcastReceiver implements Runnable {
    private final Socket socket;
    private final List<String> messages;
    private final List<Socket> sockets;

    public BroadcastReceiver(Socket socket, List<String> messages, List<Socket> sockets) {
        this.socket = socket;
        this.messages = messages;
        sockets.add(socket);
        this.sockets = sockets;
    }

    @Override
    public void run() {
        System.out.println("Подключение: " + socket);
        try {
            Scanner in = new Scanner(socket.getInputStream());
            while (in.hasNextLine()) {
                messages.add(in.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Ошибка:" + socket);
        } finally {
            try {
                socket.close();
                sockets.remove(socket);
            } catch (IOException ignored) {
            }
            System.out.println("Closed: " + socket);
        }
    }
}
