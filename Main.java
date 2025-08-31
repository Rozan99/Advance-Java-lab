import java.util.*;

abstract class Employee {

    abstract void display();
}


class Engineer extends Employee {

    void display() {
        System.out.println("I work in trinity admin");
    }
}
class Accountant extends Employee {
    void display() {
        System.out.println("Creates an account clarification");
    }
}


public class Main {
    public static void main(String[] args) {

        Employee emp;
        emp = new Engineer();
        emp.display();
        emp = new Accountant();
        emp.display();
    }
}

