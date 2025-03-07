package lab1;

import java.rmi.Naming;
import lab1.MyServerInt;

public class Main {
    public static void main(String[] args) {
        String text = "Connection number:";

        try {
            MyServerInt remoteObject = (MyServerInt) Naming.lookup("//localhost/ABC");
            String result = remoteObject.getDescription(text);
            System.out.println("Odpowiedź z serwera: " + result);

            Float sum_result = remoteObject.sum(11.5f, 22f);
            System.out.println("Wynik dodawania: " + sum_result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
