import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;


            while (true) {

                System.out.print("You (Client): ");
                clientMsg = console.readLine();
                out.println(clientMsg);


                if (clientMsg.equalsIgnoreCase("byee")) {
                    System.out.println("You ended chat.");
                    break;
                }


                serverMsg = in.readLine();
                if (serverMsg == null) break;
                System.out.println("Server: " + serverMsg);


                if (serverMsg.equalsIgnoreCase("byee")) {
                    System.out.println("Server ended chat.");
                    break;
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
