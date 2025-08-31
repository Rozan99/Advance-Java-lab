// Thread to print odd numbers from 1 to 100
class OddNumberThread extends Thread {
    public void run() {
        System.out.println("Odd Number Thread Started...");
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(2000); // Pause for 2 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Thread to print numbers from 100 to 500
class RangeThread extends Thread {
    public void run() {
        System.out.println("Range Thread Started...");
        for (int i = 100; i <= 500; i++) {
            System.out.println("Range: " + i);
            try {
                Thread.sleep(2000); // Pause for 2 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Main class to start threads
public class TwoThreadDemo {
    public static void main(String[] args) {
        // Create thread objects
        OddNumberThread t1 = new OddNumberThread();
        RangeThread t2 = new RangeThread();

        // Start both threads
        t1.start();
        t2.start();
    }
}
