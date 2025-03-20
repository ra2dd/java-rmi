package lab2_ttt;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

import lab2_ttt.Client;

public class ClientImpl extends UnicastRemoteObject implements Client{
    protected ClientImpl() throws RemoteException {
        super();
    }

    public void getMove() throws RemoteException {

    }
}
