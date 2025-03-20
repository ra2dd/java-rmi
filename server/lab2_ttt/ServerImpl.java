package lab2_ttt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lab2.ChatClient;
import lab2_ttt.Server;
import lab2_ttt.Client;

public class ServerImpl extends UnicastRemoteObject implements Server {
    Client personX;
    Client personO;
    String X = "X";
    String O = "O";

    protected ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public void test() {
        System.out.println("OK");
    }

    @Override
    public String registerClient(Client client) throws RemoteException {
        if (personX == null) {
            personX = client;
            System.out.println("Użytkownik z symbolem X dołączył.");
            return X;
        } else if (personO == null) {
            personO = client;
            System.out.println("Użytkownik z symbolem O dołączył.");
            return O;
        } else {
            System.out.println("Trzeci użytkownik próbował dołączyć.");
            return null;
        }
    }
}
