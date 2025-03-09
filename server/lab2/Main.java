package lab1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import lab1.MyServerImpl;

public class Main {
    public static void main(String[] args) throws Exception{
        String host = initAndGetHost();
        int serverPort = 1099;

        try {
            // Uruchomienie rejestru na porcie
            LocateRegistry.createRegistry(serverPort);
            System.out.println("Rejest RMI uruchomiony na porcie " + serverPort);

            // Utworzenie obiektu serwera
            MyServerImpl server = new MyServerImpl();

            // Rejestracja obiektu w RMI
            Naming.rebind("rmi://" + host + "/ABC", server);
            System.out.println("Serwer RMI rozpoczął pracę na adresie " + host);
        } catch (RemoteException | MalformedURLException e) {
            System.err.println("Błąd podczas uruchamiania serwera RMI");
            e.printStackTrace();
        }
    }

    public static String initAndGetHost() throws Exception{
        System.out.println("Initializing server...");
        String hostEnvName = "RMI_SERVER_IP";
        String host = System.getenv(hostEnvName);
        if (host == null) {
            throw new Exception("Ustaw zmienną środowiskową " + hostEnvName + ", aby uruchomić program.");
        }
        System.setProperty("java.rmi.server.hostname", host);
        return host;
    }
}
