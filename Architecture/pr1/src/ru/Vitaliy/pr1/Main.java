package ru.Vitaliy.pr1;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        PrinterThread pingPrinter = new PrinterThread("PING", object);
        PrinterThread pongPrinter = new PrinterThread("PONG", object);
        Thread pingThread = new Thread(pingPrinter);
        Thread pongThread = new Thread(pongPrinter);
        pingThread.start();
        pongThread.start();
    }
}