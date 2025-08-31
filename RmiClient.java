import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RmiClient {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            PrimeCheck stub = (PrimeCheck) registry.lookup("PrimeService");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            boolean result = stub.isPrime(n);

            if (result)
                System.out.println(n + " is Prime.");
            else
                System.out.println(n + " is NOT Prime.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
