package lab2_ttt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;

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

    @Override
    public boolean personOJoined() throws RemoteException {
        if (this.personO == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void makeMove(String move) throws RemoteException {
        List<Integer> moveParsed = Arrays.asList(
            Integer.parseInt(String.valueOf(move.charAt(0))), 
            Integer.parseInt(String.valueOf(move.charAt(1)))
        );

        if (this.ttt.makeMove(ttt.turn, moveParsed) == false) {
            String mes = "You provided wrong move try again.";
            if (this.ttt.turn.equals(X)) {
                this.personX.receiveMessage(mes);
            } else {
                this.personO.receiveMessage(mes);
            }
        }
    }

    @Override
    public boolean checkEnd() throws RemoteException {
        if (ttt.checkWinner() == ttt.X) {
            this.personX.receiveMessage(this.winMessage(this.X));
            this.personO.receiveMessage(this.endMessage());
            return true;
        } else if (ttt.checkWinner() == ttt.O) {
            this.personO.receiveMessage(this.winMessage(this.O));
            this.personX.receiveMessage(this.endMessage());
            return true;
        } else if (ttt.checkNoActions()) {
            this.personO.receiveMessage(this.endMessage());
            this.personX.receiveMessage(this.endMessage());
            return true;
        } else {
            return false;
        }
    }

    private String winMessage(String person) {
        return this.ttt.getBoard() + "\n" + person + " won!";
    }

    private String endMessage() {
        return this.ttt.getBoard() + "\n" + " end!";
    }
}
