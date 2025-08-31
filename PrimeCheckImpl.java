import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PrimeCheckImpl extends UnicastRemoteObject implements PrimeCheck {


    protected PrimeCheckImpl() throws RemoteException {
        super();
    }
    public boolean isPrime(int n) throws RemoteException {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
