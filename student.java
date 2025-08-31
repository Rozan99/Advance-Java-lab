
import java.util.*;

public class student {

    int id;
    String name;
    int age;
    String email;

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {

        student student1 = new student();
        student1.id = 101;
        student1.name = "Rojan";
        student1.age = 16;
        student1.email = "rojan@gmail.com";

        System.out.println("Student 1 Details:");
        student1.display();

    }
}

