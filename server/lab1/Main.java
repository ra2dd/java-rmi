package lab1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import lab1.MyServerImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        int serverPort = 1099;
        try {
            // Uruchomienie rejestru na porcie
            LocateRegistry.createRegistry(serverPort);
            System.out.println("Rejest RMI uruchomiony na porcie " + serverPort);

            // Utworzenie obiektu serwera
            MyServerImpl server = new MyServerImpl();

            // Rejestracja obiektu w RMI
            Naming.rebind("rmi://localhost/ABC", server);
            System.out.println("Serwer RMI rozpoczął pracę.");
        } catch (RemoteException | MalformedURLException e) {
            System.err.println("Błąd podczas uruchamiania serwera RMI");
            e.printStackTrace();
        }
    }
}