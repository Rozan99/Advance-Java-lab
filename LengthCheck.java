
import java.util.Scanner;


class InvalidLengthException extends Exception {

    InvalidLengthException(String message) {
        super(message);
    }
}


public class LengthCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        try {

            if (word.length() < 5) {

                throw new InvalidLengthException("Error: Input length is less than 5 characters!");
            } else {
                System.out.println("Valid input: " + word);
            }

        } catch (InvalidLengthException e) {
            System.out.println(e.getMessage());
        }
    }
}
