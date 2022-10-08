package ru.Vitaliy.pr2.client;

import ru.Vitaliy.pr2.server.Calculator;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            Calculator calculator = (Calculator) registry.lookup("Calculator");

            Scanner scanner = new Scanner(System.in);
            double[] input = new double[3];
            for (int i = 0; i < 3; i++) {
                input[i] = scanner.nextDouble();
            }

            calculator.calculate(input[0], input[1], input[2]).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
