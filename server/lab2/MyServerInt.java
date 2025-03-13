package lab2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import lab2.MyServerInt;
import lab2.models.Product;
import lab2.ChatClient;

public interface MyServerInt extends Remote {
    ArrayList<Product> getProducts() throws RemoteException;

    void registerClient(ChatClient client) throws RemoteException;
    void sendMessage(String user, String message) throws RemoteException;
}
