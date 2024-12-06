package Swimmers;

import members.CompetitionSwimmer;
import members.Members;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SwimmerUtils {

    /**
     *
     * Mr.CoPilot's magiske block
     * kigge bedre på:
     *.filter, .sorted, .collect => forstå logik
     *  så skrive hele texten om.
     */

    public static List<Members> filterAndSortSwimmers(List<Members> members, String discipline, String category) {
        return members.stream()
                .filter(member -> {
                    if (member instanceof CompetitionSwimmer) {
                        return ((CompetitionSwimmer) member).getDiscipline().equals(discipline) &&
                                (category.equals("Junior") ? member.getAge() < 18 : member.getAge() >= 18);
                    }
                    return false;
                })
                .sorted((m1, m2) -> Double.compare(((CompetitionSwimmer) m1).getTime(), ((CompetitionSwimmer) m2).getTime()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public static void displayTop5Swimmers(List<Members> filteredSwimmers, String discipline, String category) {
        System.out.println("Top 5 " + category + " svømmere i " + discipline + ":");
        for (int i = 0; i < filteredSwimmers.size(); i++) {
            System.out.println((i + 1) + ". " + filteredSwimmers.get(i).getName() + " " + filteredSwimmers.get(i).getLastname());
        }
    }

    public static void saveTopList(List<Members> top5Swimmers, String category) {
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

    public static void printTopList() {
        System.out.println("Listen er blevet printet ud.");
    }
}