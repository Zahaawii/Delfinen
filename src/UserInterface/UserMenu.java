package UserInterface;
import Quota.CashierUI;
import members.ManagementUI;
import Swimmers.TrænerUI;
import members.MembersList;

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
            MembersList membersList = new MembersList(); // Assuming you have a way to initialize this
            TrænerUI trænerUI = new TrænerUI(membersList);
            trænerUI.showMenu();
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
              System.out.println("You have to enter a number between 1-3");
              userChoice = 0;
          }
        } while (userChoice < 0 || userChoice > 3);

        return userChoice;
    }

    private static void showcaseMenu() {
        System.out.println("Dolphin menu");
        ConsoleOperators.displayInfo("Press 1 if you're Management " +
                "\nPress 2 if you're Cashier" +
                "\nPress 3 if you're Coach");

    }
}
