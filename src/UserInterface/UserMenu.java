package UserInterface;
import java.util.Scanner;

public class UserMenu {

    Scanner scanner = new Scanner(System.in);

    public void ui() {
    systemDisplayText();
    ConsoleOperators.pressAnythingToContinue();
    while(true) { userUI(); }
    }

    private void userUI() {
        showcaseMenu();
        int userInput = userChoice();

        if(userInput == 1) {
            System.out.println("Opret medlemmer");
            ConsoleOperators.pressAnythingToContinue();
        }

        if(userInput == 2) {
            System.out.println("Kontingenter");
            ConsoleOperators.pressAnythingToContinue();
        }

        if(userInput == 3) {
            System.out.println("Svømmere");
            ConsoleOperators.pressAnythingToContinue();
        }
    }

    private void systemDisplayText() {
        ConsoleOperators.displayInfo("Welcome to the Dolphin");
    }

    private int userChoice() {
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

    private void showcaseMenu() {
        System.out.println("Dolphin menu");
        ConsoleOperators.displayInfo("Press 1 to create members " +
                "\nPress 2 to see Payments" +
                "\nPress 3 to see swimmers");

    }
}
