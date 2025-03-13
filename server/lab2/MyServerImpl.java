package lab2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import lab2.MyServerInt;
import lab2.models.Product;
import lab2.ChatClient;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    ArrayList<Product> products;
    private List<ChatClient> clients;

    protected MyServerImpl() throws RemoteException {
        super();
        this.products = Product.createProducts();
        this.clients = new ArrayList<>();
    }

    @Override
    public ArrayList<Product> getProducts() throws RemoteException {
        return products;  
    }

    @Override
    public void registerClient(ChatClient client) throws RemoteException {
        this.clients.add(client);
        System.out.println("Nowy użytkownik dołączył do czatu.");
    }

    @Override
    public void sendMessage(String user, String message) throws RemoteException {
        String userAndMessage = user + ": " + message;
        System.out.println(userAndMessage);
        for (ChatClient client: clients) {
            client.receiveMessage(userAndMessage);
        }
    }
    
}
