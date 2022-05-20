import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private int serverIsStopped = 0;//serverul este pornit
    private Socket socket = null;
    private List<Client> clientiAplicatie = new ArrayList<>();
    private List<ClientThread> clients = new ArrayList<>();
    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            int isLoggedIn = 0;

            while (!socket.isClosed()) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                if (serverIsStopped == 0) {
                    this.clients = NetworkServer.getClients();
                    clients.add(this);
                } else if (serverIsStopped == 1 && clients.size() == 0) {
                    this.socket.close();
                }
                String request = input.readLine();
                String response = null;
                String[] elements = null;
                String person = null;
                if (request != null) {
                    elements = request.split(" ");
                    request = elements[0];
                    if (elements.length > 1) {
                        person = elements[1];
                    }
                }
                System.out.println("Got from the client the request.. " + request);
                if (request.equals("stop")) {
                    response = "Server stopped";
                    out.println(response);
                    out.flush();
                    System.exit(1);
                    serverIsStopped = 1;
                    this.socket.close();

                } else if (request.equals("exit")) {

                    if (isLoggedIn != 0)
                        clientiAplicatie.get(isLoggedIn).setLogat(0);
                    response = "Server exited";
                    out.println(response);
                    out.flush();
                    System.exit(1);
                    this.socket.close();

                } else if (request.equals("login") && isLoggedIn == 0) {
                    for (int i = 0; i < clientiAplicatie.size(); i++) {
                        if (clientiAplicatie.get(i).getName().equals(person)) {
                            isLoggedIn = i;
                        }
                    }
                    if (isLoggedIn == 0) {
                        response = "The account you're trying to get into doesn't exists! Try register or verify the username";
                        out.println(response);
                        out.flush();
                    } else {

                        clientiAplicatie.get(isLoggedIn).setLogat(1);
                        response = "Congrats! You succesfully logged in!";
                        out.println(response);
                        out.flush();
                    }
                } else if (request.equals("login") && isLoggedIn != 0) {
                    response = "You already are connected to an account! Try another comand";
                    out.println(response);
                    out.flush();
                } else if (request.equals("register")) {
                    response = "Functionality for 'register' will be done soon..";
                    out.println(response);
                    out.flush();

                } else if (request.equals("message")) {
                    response = "Functionality for 'message' will be done soon..";
                    out.println(response);
                    out.flush();

                } else if (request.equals("friend")) {
                    response = "Functionality for 'friend' will be done soon..";
                    out.println(response);
                    out.flush();
                } else {
                    // daca primim alta comanda decat cele stabilite
                    response = "Server received an invalid command..";
                    out.println(response);
                    out.flush();
                    System.out.println(response);
                    this.socket.close();
                }
            }
        } catch (IOException exception) {
            System.out.println("ERROR, you've done something wrong: " + exception);
        }
    }
}
