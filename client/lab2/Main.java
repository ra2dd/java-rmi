package lab2;

import java.rmi.Naming;
import java.util.ArrayList;

import lab2.MyServerInt;
import lab2.models.Product;

public class Main {
    public static void main(String[] args) throws Exception{
        String host = getHost();

        try {
            MyServerInt remoteObject = (MyServerInt) Naming.lookup("//" + host + "/ABC");
            ArrayList<Product> products = remoteObject.getProducts();
            System.out.println(products);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getHost() throws Exception{
        String hostEnvName = "RMI_SERVER_IP";
        String host = System.getenv(hostEnvName);
        if (host == null) {
            throw new Exception("Ustaw zmienną środowiskową " + hostEnvName + ", aby uruchomić program.");
        }
        return host;
    }
}
