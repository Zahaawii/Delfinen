package Quota;

import Files.FileManager;
import UserInterface.ConsoleOperators;

import java.util.Scanner;

public class CashierUI {
    static Scanner scanner = new Scanner(System.in);

    //Metode der tager input
    private static int cashierInput(){
        int userInput;
        do{
            try {
                userInput = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Tast mellem 1-3");
                userInput = 0;
            }
        } while (userInput < 1  || userInput > 3);
        return userInput;
    }

    public static void cashierUI(){
        ConsoleOperators.displayInfo("Welcome to the Cashier menu");

        System.out.println("Tast 1 for at se udregnet kontingent for alle medlemmer \n" +
                "Tast 2 for at se medlemmer i restance");
        ConsoleOperators.printSeperator(30);

        int userInput = cashierInput();

        if (userInput == 1){
            System.out.println("Se kontingent");
            ConsoleOperators.pressAnythingToContinue();
            FileManager.saveQuota();
            System.out.println("Filen er gemt som Quota.txt");
            ConsoleOperators.printSeperator(30);
        }

        if (userInput == 2){
            System.out.println("Se restance");
            ConsoleOperators.pressAnythingToContinue();
            FileManager.saveRestance();
            System.out.println("Filen er gemt som Restance.txt");
            ConsoleOperators.printSeperator(30);
        }
    }
}
