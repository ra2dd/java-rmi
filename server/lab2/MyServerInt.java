package lab2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import lab2.MyServerInt;
import lab2.models.Product;

public interface MyServerInt extends Remote {
    ArrayList<Product> getProducts() throws RemoteException;
}
