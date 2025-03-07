package lab1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyServerInt extends Remote {
    String getDescription(String text) throws RemoteException;
    Float sum(Float amount1, Float amount2) throws RemoteException;
    Float subtraction(Float amount1, Float amount2) throws RemoteException;
    Float multiplication(Float amount1, Float amount2) throws RemoteException;
    Float division(Float amount1, Float amount2) throws RemoteException;
}
