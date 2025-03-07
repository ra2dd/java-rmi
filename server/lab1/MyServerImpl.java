package lab1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lab1.MyServerInt;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    int i = 0;

    protected MyServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String getDescription(String text) throws RemoteException {
        i++;
        System.out.println("MyServerImpl.getDescription: " + text + " " + i);
        return "getDescription: " + text + " " + i;
    }

    @Override
    public Float sum(Float amount1, Float amount2) throws RemoteException {
        return amount1 + amount2;
    }

    @Override
    public Float subtraction(Float amount1, Float amount2) throws RemoteException {
        return amount1 - amount2;
    }

    @Override
    public Float multiplication(Float amount1, Float amount2) throws RemoteException {
        return amount1 * amount2;
    }

    @Override
    public Float division(Float amount1, Float amount2) throws RemoteException {
        return amount1 / amount2;
    }
}
