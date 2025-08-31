import java.util.Scanner;

public class User {

    int id;
    String name;
    String address;


    void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Address: ");
        address = sc.nextLine();

    }

    void display() {
        System.out.println("\nUser Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }


    public static void main(String[] args) {

        User user1 = new User();
        user1.takeInput();
        user1.display();
    }
}
