package UserInterface;
import Quota.CashierUI;
import members.ManagementUI;
import Swimmers.CoachUI;

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

    private static void systemDisplayText() {
        ConsoleOperators.displayInfo("Velkommen til Delfinen!");
    }

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

    private static void showcaseMenu() {
        System.out.println("Hovedmenu, tryk:");
        ConsoleOperators.displayInfo("'1' for Ledelse  " +
                "\n'2' for Kassér" +
                "\n'3' for Træner");

    }
}