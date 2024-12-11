package UserInterface;
import Quota.CashierUI;
import members.ManagementUI;
import Swimmers.CoachUI;
import members.MembersList;

import java.util.Scanner;

public class UserMenu {

    static Scanner scanner = new Scanner(System.in);

    //Method to combine all methods and start the program in an endless loop
    public static void ui() {
    systemDisplayText();
    while(true) { userUI(); }
    }

    //Method to make the user go to a menu which suits their position.
    private static void userUI() {
        showcaseMenu();
        int userInput = userChoice();

        if(userInput == 1) {
            System.out.println("You choose management");
            ConsoleOperators.pressAnythingToContinue();
            ManagementUI.managementUI();
        }

        if(userInput == 2) {
            System.out.println("Kontingenter");
            ConsoleOperators.pressAnythingToContinue();
            CashierUI.cashierUI();
        }

        if(userInput == 3) {
            System.out.println("Svømmere");
            ConsoleOperators.pressAnythingToContinue();
            CoachUI.coachUI();
        }
    }

    //Method to display the system menu.
    private static void systemDisplayText() {
        ConsoleOperators.displayInfo("Welcome to the Dolphin");
    }

    //Error handling method to make user only enter a number between 1 and 3 to continue
    private static int userChoice() {
        int userChoice;

        do{
            System.out.println("Enter a number between 1-3");
          try {
             userChoice = Integer.parseInt(scanner.nextLine());
          }   catch (Exception e) {
              System.out.println("You have to enter a number between 1-3");
              userChoice = -1;
          }
        } while (userChoice < 1 || userChoice > 3);

        return userChoice;
    }

    //Method to display the menu in a readable way.
    private static void showcaseMenu() {
        System.out.println("Dolphin menu");
        ConsoleOperators.displayInfo("Press 1 if you're Management " +
                "\nPress 2 if you're Cashier" +
                "\nPress 3 if you're Coach");

    }
}
