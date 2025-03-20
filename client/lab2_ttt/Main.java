package lab2_ttt;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import lab2_ttt.Server;
import lab2_ttt.Client;

public class Main {
    public static void main(String[] args) throws Exception {
        String host = getHost();
        String X = "X";
        String O = "O";

        try {
            Server remoteObject = (Server) Naming.lookup("//" + host + "/ttt");

            ClientImpl personServer = new ClientImpl();
            String person = remoteObject.registerClient(personServer);
            if (person == null) {
                throw new Exception("Dwaj użytkownicy są już połączeni.");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Rozpoaczęto, jesteś osobą " + person + ".\n");

            if (person.equals(X)) {
                System.out.print("Oczekiwanie na drugą osobę.");
                
                while (remoteObject.personOJoined() == false) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print(".");
                }
                System.out.println("\nDruga osoba dołączyła.");
            }
            
            while (remoteObject.checkEnd() == false) {
                System.out.println("Turn: " + remoteObject.getTurn());
                System.out.println(remoteObject.getBoard());

                if (remoteObject.getTurn().equals(person)) {
                    System.out.println(remoteObject.getMoves());
                    System.out.println("Enter move: ");

                    String moveInput = scanner.nextLine();
                    remoteObject.makeMove(moveInput);
                    System.out.print("\n");
                } else {

                    System.out.println("Waiting for other player move.");
                    while (remoteObject.getTurn().equals(person) == false) {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print(".");
                    }
                }
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
