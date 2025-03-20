package lab2_ttt;

import java.rmi.Remote;
import java.rmi.RemoteException;

import lab2_ttt.Client;

public interface Server extends Remote{
    void test() throws RemoteException;
    String registerClient(Client client) throws RemoteException;
}
