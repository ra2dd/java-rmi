package lab2;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

import lab2.MyServerInt;
import lab2.models.Product;
import lab2.ChatClientImpl;

public class Main {
    public static void main(String[] args) throws Exception{
        String host = getHost();

        try {
            MyServerInt remoteObject = (MyServerInt) Naming.lookup("//" + host + "/ABC");
            ArrayList<Product> products = remoteObject.getProducts();
            System.out.println(products);

            ChatClientImpl chatServer = new ChatClientImpl();
            remoteObject.registerClient(chatServer);
            
            System.out.println("Podaj nazwę użytkownika: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            System.out.println("Rozpoaczęto czat, możesz pisać wiadomości.");
            
            while (true) {
                String message = scanner.nextLine();
                if (message == "exit" || message == "exit()") {
                    break;
                }
                remoteObject.sendMessage(username, message);
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
