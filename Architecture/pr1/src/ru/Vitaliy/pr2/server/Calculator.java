package ru.Vitaliy.pr2.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface Calculator extends Remote {
    Set<Double> calculate(double a, double b, double c) throws RemoteException;
}
