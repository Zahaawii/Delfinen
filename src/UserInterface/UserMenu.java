package UserInterface;
import Quota.CashierUI;
import members.ManagementUI;
import Swimmers.CoachUI;

import java.util.Scanner;

public class UserMenu {
    private static final String CYAN_BOLD_TEXT = "\u001B[36m\u001B[1m"; //ANSI escape kode
    private static final String RESET_TEXT = "\u001B[0m";

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
            System.out.println("Ledelse...");
            if (!ConsoleOperators.pressAnythingToContinue()) {
                return;
            }
            ManagementUI.managementUI();
        }

        else if(userInput == 2) {
            System.out.println("Kontingenter...");
            if (!ConsoleOperators.pressAnythingToContinue()) {
                return;
            }
            CashierUI.cashierUI();
        }

        else if(userInput == 3) {
            System.out.println("Svømmere...");
            if (!ConsoleOperators.pressAnythingToContinue()) {
                return;
            }
            CoachUI.coachUI();
        }
    }

    //Method to display the system menu.
    private static void systemDisplayText() {
        ConsoleOperators.displayInfo("Velkommen til Delfinen!");
    }

    //Error handling method to make user only enter a number between 1 and 3 to continue
    private static int userChoice() {
        int userChoice;

        do{

            try {
                userChoice = Integer.parseInt(scanner.nextLine());
            }   catch (Exception e) {
                System.out.println("Du skal indtaste et tal mellem 1-3");
                userChoice = 0;
            }

        } while (userChoice < 1 || userChoice > 3);

        return userChoice;
    }

    //Method to display the menu in a readable way.
    private static void showcaseMenu() {
        System.out.println(CYAN_BOLD_TEXT + "\t\tHovedmenu" + RESET_TEXT);
        ConsoleOperators.displayInfo("'1' for Ledelse  " +
                "\n'2' for Kassér" +
                "\n'3' for Træner");


    }
}