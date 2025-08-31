import java.rmi.Remote;
import java.rmi.RemoteException;


public interface PrimeCheck extends Remote {
    boolean isPrime(int n) throws RemoteException;
}
