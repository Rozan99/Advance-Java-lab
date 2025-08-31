// Shared Bank class
class Bank {
    int balance = 1000;
    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw ₹" + amount);

        if (balance >= amount) {
            System.out.println("Withdrawal successful!");
            balance = balance - amount;
            System.out.println("Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }

        System.out.println("---------------------------------");
    }
}


class Customer extends Thread {
    Bank bank;
    int amount;

    Customer(Bank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    public void run() {
        bank.withdraw(amount);
    }
}

// Main class to start threads
public class Synchronization {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer c1 = new Customer(bank, 20000);
        Customer c2 = new Customer(bank, 500);

        c1.setName("Customer 1");
        c2.setName("Customer 2");
        c1.start();
        c2.start();
    }
}
