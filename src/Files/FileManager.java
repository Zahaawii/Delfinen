package Files;
import Quota.CalculateQuota;
import members.CompetitionSwimmer;
import members.Members;
import members.MembersList;

import java.io.*;
import java.util.List;

public class FileManager {

    public static void fileOperations(){
        try (PrintWriter pw = new PrintWriter(new FileWriter("Members.txt"), true)){

            for(Members m1 : MembersList.getMemberList()) {
            pw.println(m1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * AI kode til at gemme Top liste til træner
     * går den igennem og laver om efter weekend!
     *
     */
    public static void saveTopList(List<Members> top5Swimmers, String category) {
        String fileName = "Top5" + category + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Members swimmer : top5Swimmers) {
                if (swimmer instanceof CompetitionSwimmer) {
                    writer.write(swimmer.getName() + " " + swimmer.getLastname() + " - " + ((CompetitionSwimmer) swimmer).getTime() + "\n");
                }
            }
            System.out.println("Listen er gemt i " + fileName);
        } catch (IOException e) {
            System.out.println("Der opstod en fejl under gemning af listen: " + e.getMessage());
        }
    }

    /**
     * AI Slutter her *
     */


    public static void saveQuota() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Quota.txt"), true)){
            pw.println(CalculateQuota.printQuotaList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRestance() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Restance.txt"), true)){
            pw.println(CalculateQuota.printRestanceList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



