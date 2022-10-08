package ru.Vitaliy.pr1;

public class PrinterThread implements Runnable{
    private final String text;
    private final Object object;

    public PrinterThread(String text, Object object) {
        this.text = text;
        this.object = object;
    }

    @Override
    public synchronized void run() {
        synchronized (object) {
            for (int i = 0; i < 5; i++) {
                System.out.print(text + " ");
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}