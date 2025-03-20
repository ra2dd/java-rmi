package lab2_ttt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lab2_ttt.models.TicTacToe;
import lab2_ttt.Server;
import lab2_ttt.Client;

public class ServerImpl extends UnicastRemoteObject implements Server {
    Client personX;
    Client personO;
    String X = "X";
    String O = "O";
    TicTacToe ttt;

    protected ServerImpl() throws RemoteException {
        super();
        this.ttt = new TicTacToe();
    }

    @Override
    public void test() {
        System.out.println("OK");
    }

    @Override
    public String registerClient(Client client) throws RemoteException {
        if (personX == null) {
            personX = client;
            System.out.println("Użytkownik z symbolem X dołączył.");
            return X;
        } else if (personO == null) {
            personO = client;
            String joinedMes = "Użytkownik z symbolem O dołączył.";
            System.out.println(joinedMes);
            personX.receiveMessage(joinedMes);
            return O;
        } else {
            System.out.println("Trzeci użytkownik próbował dołączyć.");
            return null;
        }
    }

    @Override
    public String getBoard() throws RemoteException {
        return this.ttt.getBoard();
    }

    @Override
    public String getMoves() throws RemoteException {
        return this.ttt.getAvailableActions();
    }

    @Override
    public String getTurn() throws RemoteException {
        return this.ttt.turn;
    }
}
