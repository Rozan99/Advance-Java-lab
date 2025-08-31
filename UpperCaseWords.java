import java.util.Scanner;

public class UpperCaseWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] words = new String[5];

        System.out.println("Enter 5 words:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Word " + (i + 1) + ": ");
            words[i] = sc.next();
        }

        System.out.println("\nWords in Uppercase:");
        for (int i = 0; i < 5; i++) {
            System.out.println(words[i].toUpperCase());
        }
    }
}


