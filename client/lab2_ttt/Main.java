package lab2_ttt;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

import lab2_ttt.Server;
import lab2_ttt.Client;

public class Main {
    public static void main(String[] args) throws Exception {
        String host = getHost();

        try {
            Server remoteObject = (Server) Naming.lookup("//" + host + "/ttt");

            ClientImpl personServer = new ClientImpl();
            String person = remoteObject.registerClient(personServer);
            if (person == null) {
                throw new Exception("Dwaj użytkownicy są już połączeni.");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Rozpoaczęto, jesteś osobą " + person + ".\n");
            
            while (true) {
                String message = scanner.nextLine();
                if (message == "exit" || message == "exit()") {
                    break;
                }
                // send move
            }
        
            scanner.close();

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
