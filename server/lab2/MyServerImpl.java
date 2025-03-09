package lab2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import lab2.MyServerInt;
import lab2.models.Product;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    ArrayList<Product> products;

    protected MyServerImpl() throws RemoteException {
        super();
        this.products = Product.createProducts();
    }

    public ArrayList<Product> getProducts() throws RemoteException {
        return products;  
    }
}
