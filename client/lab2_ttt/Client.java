package lab2_ttt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
    void receiveMessage(String message) throws RemoteException;
    void getMove() throws RemoteException;
}
