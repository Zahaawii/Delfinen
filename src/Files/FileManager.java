package Files;
import Quota.CalculateQuota;
import UserInterface.ConsoleOperators;
import members.CompetitionSwimmer;
import members.Members;
import members.MembersList;

import java.io.*;
import java.util.List;

public class FileManager {

    public static void fileOperations(){
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter("Members.txt", true));
            for(Members m1 : MembersList.getMemberList()) {
            pw.write(String.valueOf(m1));

            pw.newLine();
            }
            pw.close();
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
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter("Quota.txt", true));
            for(Members m1 : CalculateQuota.getQuotaList()) {
                pw.write(m1.getName() + " " + m1.getLastname() + "\nKontingent " + m1.getQuota());

            }
            pw.newLine();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRestance() {
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter("Restance.txt", true));
//            pw.write(String.valueOf(CalculateQuota.printRestanceList()));
            for(Members m1 : CalculateQuota.getRestanceList()) {
                pw.write("Mangler at betale " + m1.getQuota() + "kr.: " + m1);
                pw.write(System.lineSeparator());
            }
            pw.newLine();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}



