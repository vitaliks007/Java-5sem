package ru.Vitaliy.pr2.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain extends CalculatorImpl{
    public static void main(String[] args) {
        try {
            CalculatorImpl obj = new CalculatorImpl();
            Calculator calculator = (Calculator) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Calculator", calculator);
            System.err.println("Server ready");
        } catch (RemoteException | AlreadyBoundException e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
