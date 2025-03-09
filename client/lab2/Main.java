package lab2;

import java.rmi.Naming;
import java.util.ArrayList;

import lab2.MyServerInt;
import lab2.models.Product;

public class Main {
    public static void main(String[] args) {
        String host = "<enter-server-ip>";

        try {
            MyServerInt remoteObject = (MyServerInt) Naming.lookup("//" + host + "/ABC");
            ArrayList<Product> products = remoteObject.getProducts();
            System.out.println(products);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
