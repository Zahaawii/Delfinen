package UserInterface;
import java.util.Scanner;

public class ConsoleOperators {

    static Scanner scanner = new Scanner(System.in);
    private static final String RED_ITALIC_TEXT = "\u001B[31m" + "\033[3m"; //ANSI escape kode
    private static final String RESET_TEXT = "\u001B[0m";

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

    public static boolean pressAnythingToContinue() {
     System.out.println("Press anything to continue, " + RED_ITALIC_TEXT + "'9' to go back" + RESET_TEXT + ".");
     String input = scanner.nextLine();

     clearConsole();
     return !input.equals("9"); //kør ovenover hvis ikke '9'
    }

    //Method to remove all previous steps to make the UI readable.
    public static void clearConsole() {
        for(int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    }

}
