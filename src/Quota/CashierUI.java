package Quota;

import Files.FileManager;
import UserInterface.ConsoleOperators;

import java.util.Scanner;

public class CashierUI {
    static Scanner scanner = new Scanner(System.in);

    //Error handling that makes the cashier only enter between 1 or 2 to go further.
    private static int cashierInput(){
        int userInput;
        do{
            System.out.println("Enter a number between 1-2");
            try {
                userInput = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("You have to enter a number between 1-2");
                userInput = -1;
            }
        } while (userInput <= 0|| userInput > 3);
        return userInput;
    }

    // A user interface to display what options the cashier has
    public static void cashierUI(){
        ConsoleOperators.displayInfo("Welcome to the Cashier menu");

        System.out.println("Tast 1 for at se udregnet kontingent for alle medlemmer \n" +
                "Tast 2 for at se medlemmer i restance");
        ConsoleOperators.printSeperator(30);

        int userInput = cashierInput();

        if (userInput == 1){
            System.out.println("Se kontingent");
            ConsoleOperators.pressAnythingToContinue();
            CalculateQuota.printQuotaList();
            FileManager.saveQuota();
            System.out.println("Filen er gemt som Quota.txt");
            ConsoleOperators.printSeperator(30);
        }

        if (userInput == 2){
            System.out.println("Se restance");
            ConsoleOperators.pressAnythingToContinue();
            CalculateQuota.printRestanceList();
            FileManager.saveRestance();
            System.out.println("Filen er gemt som Restance.txt");
            ConsoleOperators.printSeperator(30);
        }
    }
}
