import java.util.*;

interface College {
    void collegeName();
}

interface Course {
    void courseName();
}

public class Colleges implements College, Course {


    public void collegeName() {
        System.out.println("College: Trinity International College");
    }

    public void courseName() {
        System.out.println("Course: BSC CSIT");
    }

    public static void main(String[] args) {

        Colleges c1 = new Colleges();
        c1.collegeName();
        c1.courseName();
    }
}
