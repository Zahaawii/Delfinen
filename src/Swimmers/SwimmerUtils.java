package Swimmers;

import members.CompetitionSwimmer;
import members.Members;


import java.util.List;
import java.util.stream.Collectors;

public class SwimmerUtils {

    /**
     * Filtrér medlemmer udfra competition + disciplin + age
     * siden sortér efter getTime()
     * limit til 5 pax
     *collect de oplysninger og sender toList()
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

    //viser top 5 svømmere + disciplin + kategori
    public static void displayTop5Swimmers(List<Members> filteredSwimmers, String discipline, String category) {
        System.out.println("Top 5 " + category + " svømmere i " + discipline + ":");
        for (int i = 0; i < filteredSwimmers.size(); i++) {
            System.out.println((i + 1) + ". " + filteredSwimmers.get(i).getName() + " " + filteredSwimmers.get(i).getLastname());
        }
    }

    //printer top 5 svømmere + deres tider
    public static List<Members> printTopList(List<Members> top5Swimmers) {
        for (Members swimmer : top5Swimmers) {
            System.out.println(swimmer.getName() + " " + swimmer.getLastname() + " - " + ((CompetitionSwimmer) swimmer).getTime());
        }
        return top5Swimmers;
    }

}
