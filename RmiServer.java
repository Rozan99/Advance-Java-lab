import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    public static void main(String[] args) {
        try {
            PrimeCheckImpl primeObj = new PrimeCheckImpl();
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("PrimeService", primeObj);

            System.out.println("✅ Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
