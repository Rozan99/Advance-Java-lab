import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");


            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;


            while (true) {

                clientMsg = in.readLine();
                if (clientMsg == null) break;
                System.out.println("Client: " + clientMsg);
                if (clientMsg.equalsIgnoreCase("byee")) {
                    System.out.println("Client ended chat.");
                    break;
                }
                System.out.print("You (Server): ");
                serverMsg = console.readLine();
                out.println(serverMsg);
                if (serverMsg.equalsIgnoreCase("byee")) {
                    System.out.println("You ended chat.");
                    break;
                }
            }

            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
