package UserInterface;
import Quota.CashierUI;
import members.ManagementUI;
import Swimmers.CoachUI;
import members.MembersList;

import java.text.BreakIterator;
import java.util.Scanner;

public class UserMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void ui() {
    systemDisplayText();
    while(true) { userUI(); }
    }

    private static void userUI() {
        showcaseMenu();
        int userInput = userChoice();

        if(userInput == 1) {
            System.out.println("You choose management");
            if (!ConsoleOperators.pressAnythingToContinue()){
                return;
            }
            ManagementUI.managementUI();
        }

        if(userInput == 2) {
            System.out.println("Kontingenter");
           if (!ConsoleOperators.pressAnythingToContinue()) {
               return;
           }
            CashierUI.cashierUI();
        }

        if(userInput == 3) {
            System.out.println("Svømmere");
            if (!ConsoleOperators.pressAnythingToContinue()){
                return;
            }
            CoachUI.coachUI();
        }
    }

    private static void systemDisplayText() {
        ConsoleOperators.displayInfo("Welcome to the Dolphin");
    }

    private static int userChoice() {
        int userChoice;

        do{
          try {
             userChoice = Integer.parseInt(scanner.nextLine());
          }   catch (Exception e) {
              userChoice = 0;
          }
            if (userChoice < 1 || (userChoice > 3 && userChoice != 9)) {
                ConsoleOperators.printSeperator(30);
                System.out.println("You have to enter a number between 1-3");
                ConsoleOperators.printSeperator(30);
            }
        } while (userChoice < 0 || userChoice > 3);

        return userChoice;
    }

    private static void showcaseMenu() {
        System.out.println("Dolphin menu");
        ConsoleOperators.displayInfo("Press 1 if you're Management " +
                "\nPress 2 to if you're Cashier" +
                "\nPress 3 to see Coach");

    }
}
