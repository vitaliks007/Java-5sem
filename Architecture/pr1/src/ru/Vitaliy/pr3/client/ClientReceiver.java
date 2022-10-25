package ru.Vitaliy.pr3.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientReceiver implements Runnable{
    private final Socket socket;

    public ClientReceiver(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
