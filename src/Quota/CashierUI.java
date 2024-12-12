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
            System.out.println("Tast et nummer mellem 1-2 eller 9");
            try {
                userInput = Integer.parseInt(scanner.next());
            } catch (Exception e) {

                System.out.println("Tast mellem 1-2 eller 9");
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
                ConsoleOperators.printSeperator(30);
               if (!ConsoleOperators.pressAnythingToContinue()) {
                   continue;
               }
               CalculateQuota.printQuotaList();
                FileManager.saveQuota();
                System.out.println("Filen er gemt som Quota.txt");
                ConsoleOperators.printSeperator(30);
            }

            else if (userInput == 2){
                System.out.println("Se restance");
                ConsoleOperators.printSeperator(30);
                if (!ConsoleOperators.pressAnythingToContinue()) {
                    continue;
                }
                CalculateQuota.printRestanceList();
                FileManager.saveRestance();
                System.out.println("Filen er gemt som Restance.txt");
                ConsoleOperators.printSeperator(30);
            } else if (userInput == 9) {
                exit = true; //go back to UserMenu
            }
        }
    }
}
