package members;
import Files.FileManager;
import UserInterface.ConsoleOperators;

import java.util.Scanner;

public class ManagementUI {

    static Scanner scanner = new Scanner(System.in);
    static boolean isActive;
    static boolean isCompetitive;
    static boolean quotaPayed;
    static int id = 1;

    //User interface for the management to create, see or delete a member
    public static void managementUI() {

        ConsoleOperators.displayInfo("Welcome to the Management menu");

        System.out.println("Press 1 to create a member \nPress 2 to see all members \nPress 3 to delete all members");
        ConsoleOperators.printSeperator(30);

        int userInput = managementInput();

        if(userInput == 1) {
            System.out.println("Create a member");
            ConsoleOperators.pressAnythingToContinue();
            createMember();
        }

        if(userInput == 2) {
            System.out.println("See all members");
            ConsoleOperators.pressAnythingToContinue();
            seeAllMember();
        }

        if(userInput == 3) {
            System.out.println("Delete a member");
            ConsoleOperators.pressAnythingToContinue();
            deleteMember();
        }
    }

    //Instantiate a new member
    private static void createMember() {

        System.out.println("Enter member name");
        String name = scanner.next();
        ConsoleOperators.printSeperator(30);

        System.out.println("Enter member last name");
        String lastname = scanner.next();
        ConsoleOperators.printSeperator(30);

        System.out.println("Enter member age");
        int age = scanner.nextInt();
        ConsoleOperators.printSeperator(30);

        System.out.println("Is the user active? \nPress 'Y' for yes");
        String userActive = scanner.next();
        ConsoleOperators.printSeperator(30);

        if(userActive.equalsIgnoreCase("Y")) {
            isActive = true;
        } else {
            isActive = false;
        }

        System.out.println("Is the swimmer competitve? \nPress 'Y' for yes");
        String userCompetitive = scanner.next();

        if(userCompetitive.equalsIgnoreCase("Y")) {
            isCompetitive = true;
        } else {
            isCompetitive = false;
        }

//        System.out.println("Add user disciplin");
//        String disciplin = scanner.next();

        System.out.println("Has the user payed quota? Press 'Y' for yes");
        String payed = scanner.nextLine();
        ConsoleOperators.printSeperator(30);

        if(payed.equalsIgnoreCase("Y")) {
            quotaPayed = true;
        }

        Members m1 = new Members(id++,name, lastname, age, isActive, quotaPayed);
        ConsoleOperators.printSeperator(30);
        System.out.println("Member created: " + m1.toString());
        ConsoleOperators.printSeperator(30);

        FileManager.fileOperations();

    }

    //Delete an instantiated member
    private static void deleteMember() {
        System.out.println("To delete a member, enter their ID");
        int userDelete = scanner.nextInt();

        ConsoleOperators.printSeperator(30);
        if(MembersList.getMemberID(userDelete) != null) {

            System.out.println("You want to delete: " + MembersList.getMemberID(userDelete));
            ConsoleOperators.printSeperator(30);

            System.out.println("Press 'Y' to delete member");
            String deleteMemberChoice = scanner.next();

            if(deleteMemberChoice.equalsIgnoreCase("Y")) {
                MembersList.removeMember(userDelete);
                System.out.println("User deleted");
            } else {
                System.out.println("Member not deleted");
            }

        } else {
            System.out.println("Member does not exist");
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
                System.out.println("Tast mellem 1-3");
                userInput = 0;
            }
        } while (userInput < 0  || userInput > 3);
        return userInput;
    }

}
