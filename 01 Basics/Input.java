import java.util.Scanner;

public class Input {
    public static void main(String args[]) {
        try (Scanner obj = new Scanner(System.in)) {
            System.out.println("Enter username");

            String name = obj.nextLine();
            System.out.println("Name is: " + name);
        }
    }
}
