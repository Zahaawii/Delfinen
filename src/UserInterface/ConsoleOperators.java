package UserInterface;
import java.util.Scanner;

public class ConsoleOperators {

    static Scanner scanner = new Scanner(System.in);

    //Method to display a seperator from previous command to display a readable UI
    public static void printSeperator(int n) {
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //Method to display a readable window
    public static void displayInfo(String prompt) {
        printSeperator(30);
        System.out.println(prompt);
        printSeperator(30);
    }

    //Method to make the user interact with the system before next step.
    public static void pressAnythingToContinue() {
     System.out.println("Press anything to continue");
     scanner.nextLine();
     clearConsole();
    }

    //Method to remove all previous steps to make the UI readable.
    public static void clearConsole() {
        for(int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    }

}
