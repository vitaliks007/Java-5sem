package ru.Vitaliy.pr2.server;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

public class CalculatorImpl implements Calculator{
    @Override
    public Set<Double> calculate(double a, double b, double c) throws RemoteException {
        double d = Math.sqrt(b*b - 4*a*c);
        Set<Double> result = new HashSet<>();

        if (d > 0) {
            result.add((-b + d)/(2*a));
            result.add((-b - d)/(2*a));
        } else if (d == 0) {
            result.add((-b)/(2*a));
        }
        return result;
    }
}
