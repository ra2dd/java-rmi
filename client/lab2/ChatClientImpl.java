package lab2;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

import lab2.ChatClient;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClient{
    protected ChatClientImpl() throws RemoteException {}

    @Override
    public void receiveMessage(String message) throws RemoteException {
        System.out.println(message);
    }
}
