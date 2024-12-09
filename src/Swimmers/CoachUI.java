package Swimmers;

import UserInterface.ConsoleOperators;
import UserInterface.UserMenu;
import members.Members;
import members.MembersList;

import java.util.List;
import java.util.Scanner;

public class CoachUI {
    private MembersList membersList;
    private static final Scanner sc = new Scanner(System.in);
    private static final String RED_TEXT = "\u001B[31m"; //ANSI escape kode
    private static final String RESET_TEXT = "\u001B[0m";


    // Constructor
    public CoachUI(MembersList membersList) {
        this.membersList = membersList;
    }

    //statisk metode til at kalle klassen fra userMenu
    public static void coachUI() {
        MembersList membersList = new MembersList();
        CoachUI coachUI = new CoachUI(membersList);
        coachUI.showMenu();
    }

    // TrænerMenu
    public void showMenu() {
        int choice;

        while (true) {
            System.out.println("------------------------------" + "\n\tTræner Menu");

            ConsoleOperators.displayInfo("\tVælg disciplin:\n" +
                    "\n'1' Butterfly \n'2' Crawl \n'3' Rygcrawl \n'4' Brystsvømning" +
                    "\n'" + RED_TEXT + "9" + RESET_TEXT +"'" + " Tilbage til hovedmenu");


            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    chooseDisciplin("Butterfly");
                    break;
                case 2:
                    chooseDisciplin("Crawl");
                    break;
                case 3:
                    chooseDisciplin("Rygcrawl");
                    break;
                case 4:
                    chooseDisciplin("Brystsvømning");
                    break;
                case 9:
                    UserMenu.ui();
                    return;
                default:
                    System.out.println("Forkert input, Prøv igen!");
            }
        }
    }

    //Disciplin menu med valg af Junior eller Senior
    private void chooseDisciplin(String disciplin) {
        int choice;

        while (true) {
            ConsoleOperators.displayInfo("\tVælg kategori: \n" +
                    "\n'1' Top 5 Junior svømmere \n'2' Top 5 Senior svømmere" +
                    RED_TEXT + "\n'9' Tilbage til valg af disciplin" + RESET_TEXT);

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    handleTop5Swimmers(disciplin, "Junior");
                    break;
                case 2:
                    handleTop5Swimmers(disciplin, "Senior");
                    break;
                case 9:
                    return; // go back to disciplin valg
                default:
                    System.out.println("Forkert input, Prøv igen!");
            }
        }
    }

    private void handleTop5Swimmers(String disciplin, String category) {
        List<Members> filteredSwimmers = SwimmerUtils.filterAndSortSwimmers(MembersList.getMemberList(), disciplin, category);
        SwimmerUtils.displayTop5Swimmers(filteredSwimmers, disciplin, category);

        System.out.println("'1' Gem liste \n'2' Print liste");
        int choice = sc.nextInt();

        if(choice == 1) {
            SwimmerUtils.saveTopList(filteredSwimmers, category);
        } else if(choice == 2) {
            SwimmerUtils.printTopList();
        } else {
            System.out.println("Forket input, Prøv igen!");
        }
    }
}