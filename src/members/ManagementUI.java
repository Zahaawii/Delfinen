package members;
import Files.FileManager;
import UserInterface.ConsoleOperators;

import java.io.File;
import java.util.Scanner;

public class ManagementUI {

    private static final String CYAN_BOLD_TEXT = "\u001B[36m\u001B[1m"; //ANSI escape kode
    private static final String RESET_TEXT = "\u001B[0m";
    static Scanner scanner = new Scanner(System.in);
    static boolean isActive;
    static boolean isCompetitive;
    static boolean quotaPayed;
    static int id = 1;


    //User interface for the management to create, see or delete a member
    public static void managementUI() {
        boolean exit = false;
        while (!exit) {
            ConsoleOperators.displayInfo(CYAN_BOLD_TEXT + "\t\tLedelse Menu" + RESET_TEXT);

            System.out.println("Tryk '1' for at oprette et medlem \nTryk '2' for at se alle medlemmer \nTryk '3' for at slette et medlem \nTryk '9' for at \033[31mgå tilbage til hovedmenu\033[0m");
            ConsoleOperators.printSeperator(30);

            int userInput = managementInput();

            if (userInput == 1) {
                System.out.println("Oprette medlem...");
                if (!ConsoleOperators.pressAnythingToContinue()) {
                    continue;
                }
                createMember();
            } else if (userInput == 2) {
                System.out.println("Se alle medlemmer...");
                if (!ConsoleOperators.pressAnythingToContinue()) {
                    continue;
                }
                seeAllMember();
            } else if (userInput == 3) {
                System.out.println("Slet en medlem...");
                if (!ConsoleOperators.pressAnythingToContinue()) {
                    continue;
                }
                deleteMember();
            } else if (userInput == 9) {
                exit = true; // Go back to UserMenu
            }
        }
    }

    //Instantiate a new member
    private static void createMember() {
        String name = getInput("Indtast fornavn");
        String lastname = getInput("Indtast efternavn");
        int age = getAge();
        boolean isActive = getYesOrNo("Er brugeren aktiv? \nTryk 'Y' for ja");
        boolean quotaPayed = getYesOrNo("Har medlemmer betalt kontingent? Tryk 'Y' for ja");
        boolean isCompetitive = getYesOrNo("Er svømmer konkurrencedygtigt? Tryk 'Y' for ja");

        if(isCompetitive) {
            System.out.println("Indtast svømmerens disciplin: 'Butterfly' 'Crawl' 'Rygcrawl' 'Brystsvømning'");
            String discipline = scanner.next().toLowerCase();
            double time = getTime();
            isCompetitionSwimmer(name, lastname, age, isActive, isCompetitive, quotaPayed, discipline, time);
        } else {
            isSwimmer(name, lastname, age, isActive, quotaPayed);
        }
    }

    //Delete an instantiated member
    private static void deleteMember() {
        System.out.println("For at slette et medlem, indtast deres ID");
        int userDelete = scanner.nextInt();

        ConsoleOperators.printSeperator(30);
        if(MembersList.getMemberID(userDelete) != null) {

            System.out.println("Du vil slette: " + MembersList.getMemberID(userDelete));
            ConsoleOperators.printSeperator(30);

            System.out.println("Tryk 'Y' for at slette medlem");
            String deleteMemberChoice = scanner.next();

            if(deleteMemberChoice.equalsIgnoreCase("Y")) {
                MembersList.removeMember(userDelete);

                System.out.println("Medlem deleted");

            } else {
                System.out.println("Medlem ikke slettet");
            }

        } else {
            System.out.println("Medlem eksisterer ikke");
        }

        FileManager.fileOperations();


    }

    //See all instantiated members
    private static void seeAllMember() {
        MembersList.seeList();
    }

    //Error handling
    private static int managementInput() {
        int userInput;
        do{
            try {
                userInput = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Tast mellem 1-3 eller 9");
                userInput = 0;
            }

        } while (userInput < 1  || userInput > 3 && userInput != 9);

        return userInput;
    }

    //Instantiate a competition swimmer
    private static void isCompetitionSwimmer(String name, String lastname, int age, boolean isActive, boolean isCompetitive, boolean quotaPayed, String discipline, double time) {

        CompetitionSwimmer c1 = new CompetitionSwimmer(id++, name, lastname, age, isActive, isCompetitive, quotaPayed, discipline, time);
        ConsoleOperators.printSeperator(30);
        System.out.println("Member created: " + c1.toString());

        FileManager.fileOperations();
    }

    //Instantiate a regular member
    private static void isSwimmer(String name, String lastname, int age, boolean isActive, boolean quotaPayed) {

        Members m1 = new Members(id++,name, lastname, age, isActive, quotaPayed);
        ConsoleOperators.printSeperator(30);
        System.out.println("Member created: " + m1.toString());

        FileManager.fileOperations();

    }

    private static String getInput(String pormpt) {
        ConsoleOperators.printSeperator(30);
        System.out.println(pormpt);
        return scanner.next();
    }

    private static int getAge() {
        int age;
        do {
        System.out.println("Indtast en alder mellem 1-99");
        try {
            age = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            System.out.println("Forkert input! Tast mellem 1-99");
            age = 0;
        }
    } while (age <= 0 || age > 99);
        return age;
    }

    private static boolean getYesOrNo(String prompt) {
        ConsoleOperators.printSeperator(30);
        System.out.println(prompt);
        String input = scanner.next();
        return input.equalsIgnoreCase("Y");
    }

    private static double getTime() {
        double time;
        do {
           System.out.println("Indtast svømmerens bedste tid");

           try {
            time = Double.parseDouble(scanner.next());

            } catch (NumberFormatException e) {
               System.out.println("Forkert input! Tast en tid");
               time = 0;
           }
        } while (time <= 0.00 || time > 99.00);
        return time;
    }

}
