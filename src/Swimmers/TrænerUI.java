package Swimmers;

import UserInterface.UserMenu;
import members.CompetitionSwimmer;
import members.Members;
import members.MembersList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;

public class TrænerUI {
    private MembersList membersList;

    // Constructor
    public TrænerUI(MembersList membersList) {
        this.membersList = membersList;
    }

    // TrænerMenu
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Træner Menu:");
            System.out.println("**Vælg disciplin:**");
            System.out.println("'1' Butterfly \n'2' Crawl \n'3' Rygcrawl \n'4' Brystsvømning");
            System.out.println("'9' Tilbage til hovedmenu");

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
                    throw new IllegalArgumentException("Forkert input, Prøv igen!");
            }
        }
    }

    //Disciplin menu med valg af Junior eller Senior
    private void chooseDisciplin(String disciplin) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Vælg kategori: ");
            System.out.println("'1' Top 5 Junior svømmere \n'2' Top 5 Senior svømmere");
            System.out.println("'9' Tilbage til valg af disciplin");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayTop5Swimmers(disciplin, "Junior");
                    break;
                case 2:
                    displayTop5Swimmers(disciplin, "Senior");
                    break;
                case 9:
                    return; // go back to disciplin valg
                default:
                    throw new IllegalArgumentException("Forkert input, Prøv igen!");
            }
        }
    }

    /**
     *
     * Stjålet af AI:
     * stream = ændre processen til at sortere
     * .filter = ?
     * if statement =
     * .sorted , .limit, .collect
     *
     */
    private void displayTop5Swimmers(String disciplin, String category) {
        List<Members> filteredSwimmers = membersList.getMemberList().stream()
                .filter(member -> {
                    if (member instanceof CompetitionSwimmer) {
                        return ((CompetitionSwimmer) member).getDiscipline().equals(disciplin) &&
                                (category.equals("Junior") ? member.getAge() < 18 : member.getAge() >= 18);
                    }
                    return false;
                })
                .sorted((m1, m2) -> Double.compare(((CompetitionSwimmer) m1).getTime(), ((CompetitionSwimmer) m2).getTime()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 " + category + " svømmere i: " + disciplin + ":");
        for (int i = 0; i < filteredSwimmers.size(); i++) {
            System.out.println((i + 1) + ". " + filteredSwimmers.get(i).getName() + " " + filteredSwimmers.get(i).getLastname());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("'1' Gem liste \n'2' Print liste");
        int choice = sc.nextInt();

        if (choice == 1) {
            saveTopList(filteredSwimmers, category); // Den kører igennem saveTopList herunder og så fra FileManager
        } else if (choice == 2) {
            printTopList();
        } else {
            throw new IllegalArgumentException("Forkert input, Prøv igen!");
        }
    }

    /**
     * AI SLUTTER HER
     */

    private void printTopList() {
        // Logik?
        System.out.println("Listen er blevet printet ud.");
    }


    /**
     *
     * AI kode til saveTopList
     *
     */
    private void saveTopList(List<Members> top5Swimmers, String category) {
        String fileName = "Top5" + category + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Members swimmer : top5Swimmers) {
                writer.write(swimmer.getName() + " " + swimmer.getLastname() + " - " + ((CompetitionSwimmer) swimmer).getTime() + "\n");
            }
            System.out.println("Listen er gemt i " + fileName);
        } catch (IOException e) {
            System.out.println("Der opstod en fejl under gemning af listen: " + e.getMessage());
        }
    }
}