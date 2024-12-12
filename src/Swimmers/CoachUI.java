package Swimmers;

import Files.FileManager;
import UserInterface.ConsoleOperators;
import UserInterface.UserMenu;
import members.Members;
import members.MembersList;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class CoachUI {
    private MembersList membersList;
    private static final Scanner sc = new Scanner(System.in);
    private static final String RED_TEXT = "\u001B[31m"; //ANSI escape kode
    private static final String RESET_TEXT = "\u001B[0m";
    private static final String ITALIC_TEXT = "\033[3m";


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
        boolean exit = false;

        while (!exit) {
            System.out.println("------------------------------" + "\n\tTræner Menu");

            ConsoleOperators.displayInfo("\tVælg disciplin:\n" +
                    "\n'1' Butterfly \n'2' Crawl \n'3' Rygcrawl \n'4' Brystsvømning" +
                    "\n'9'" + RED_TEXT + " Tilbage til hovedmenu" + RESET_TEXT);


            try {
                choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Indtast et nummer mellem 1-4 eller 9");
                choice = -1;
            }

            sc.nextLine(); //consume newline

            switch (choice) {
                case 1:
                    System.out.println("Butterfly");
                    if (!ConsoleOperators.pressAnythingToContinue()) break;
                    chooseDisciplin("Butterfly");
                    break;
                case 2:
                    System.out.println("Crawl");
                    if (!ConsoleOperators.pressAnythingToContinue()) break;
                    chooseDisciplin("Crawl");
                    break;
                case 3:
                    System.out.println("Rygcrawl");
                    if (!ConsoleOperators.pressAnythingToContinue()) break;
                    chooseDisciplin("Rygcrawl");
                    break;
                case 4:
                    System.out.println("Brystsvømning");
                    if (!ConsoleOperators.pressAnythingToContinue()) break;
                    chooseDisciplin("Brystsvømning");
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Forkert input, Prøv igen!");
            }
        }
    }

    //DisciplinMenu med valg af Junior eller Senior
    private void chooseDisciplin(String disciplin) {
        int choice;
        boolean exit = false;

        while (!exit) {
            ConsoleOperators.displayInfo("\tVælg kategori: \n" +
                    "\n'1' Top 5 Junior svømmere \n'2' Top 5 Senior svømmere" +
                    "\n'9'" + RED_TEXT + " Tilbage til valg af disciplin" + RESET_TEXT);

            try {
                choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Indtast et nummer mellem 1-2 eller 9");
                choice = -1;
            }


            switch (choice) {
                case 1:
                    System.out.println("Junior");
                    ConsoleOperators.pressAnythingToContinue();
                    handleTop5Swimmers(disciplin, "Junior");
                    break;
                case 2:
                    System.out.println("Senior");
                    ConsoleOperators.pressAnythingToContinue();
                    handleTop5Swimmers(disciplin, "Senior");
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Forkert input, Prøv igen!");
            }
        }
    }

    //kalder filterAndSortSwimmers metoden og printer/displayer top 5
    private void handleTop5Swimmers(String disciplin, String category) {
        List<Members> filteredSwimmers = SwimmerUtils.filterAndSortSwimmers(MembersList.getMemberList(), disciplin, category);
        SwimmerUtils.displayTop5Swimmers(filteredSwimmers, disciplin, category);

        //  gem eller print ui
        int choice;

        do {
            System.out.println("'1' Gem liste \n'2' Print liste");
            try {
                choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Indtast et nummer mellem 1-2 eller 9");
                choice = -1;
            }
        } while (choice < 1 || choice > 3 && choice != 9);


        if(choice == 1) {
            FileManager.saveTopList(filteredSwimmers, category);
            System.out.println("Listen er blevet gemt i " + ITALIC_TEXT + "root" + RESET_TEXT + " under:" + " Top5" + category + ".txt");
        } else if(choice == 2) {
            FileManager.printTopList();
        } else {
            System.out.println("Forket input, Prøv igen!");
        }
    }
}