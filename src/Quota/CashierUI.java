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

                System.out.println("Tast mellem 1-3 eller 9");
                userInput = 0;
            }
        } while (userInput < 1  || userInput > 3 && userInput != 9);

        return userInput;
    }

    // A user interface to display what options the cashier has
    public static void cashierUI(){

        boolean exit = false;
        while (!exit) {
            ConsoleOperators.displayInfo("Welcome to the Cashier menu");

            System.out.println("Tast 1 for at se udregnet kontingent for alle medlemmer \n" +
                    "Tast 2 for at se medlemmer i restance \n" +
                    "Tast 9 for at \033[31mgå tilbage til hovedmenu\033[0m");
            ConsoleOperators.printSeperator(30);

            int userInput = cashierInput();

            if (userInput == 1){
                System.out.println("Se kontingent");
               if (!ConsoleOperators.pressAnythingToContinue()) {
                   continue;
               }
                FileManager.saveQuota();
                System.out.println("Filen er gemt som Quota.txt");
            }

            else if (userInput == 2){
                System.out.println("Se restance");
                if (!ConsoleOperators.pressAnythingToContinue()) {
                    continue;
                }
                FileManager.saveRestance();
                System.out.println("Filen er gemt som Restance.txt");
            } else if (userInput == 9) {
                exit = true; //go back to UserMenu
            }
        }
    }
}
