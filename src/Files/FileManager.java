package Files;
import Quota.CalculateQuota;
import Swimmers.SwimmerUtils;
import members.CompetitionSwimmer;
import members.Members;
import members.MembersList;

import java.io.*;
import java.util.List;

public class FileManager {

    //Method to save all new users to a file members.txt
    public static void fileOperations(){
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter("Members.txt", true));
            for(Members m1 : MembersList.getMemberList()) {

            pw.newLine();
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveQuota() {
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter("Quota.txt", true));
            for(Members m1 : CalculateQuota.getQuotaList()) {
                pw.write(m1.getName() + " " + m1.getLastname() + " " + "\nKontingent " + m1.getQuota());
            }
            pw.newLine();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method to save all restance payments to a text file named restance.txt
    public static void saveRestance() {
        try {
            BufferedWriter pw = new BufferedWriter(new FileWriter("Restance.txt", true));
//            pw.write(String.valueOf(CalculateQuota.printRestanceList()));
            for(Members m1 : CalculateQuota.getRestanceList()) {
                pw.write("Mangler at betale " + m1.getQuota() + "kr.: " + m1);
            }
            pw.newLine();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    //gem top 5 svømmere
    public static void saveTopList(List<Members> top5Swimmers, String category) {
        String fileName = "Top5" + category + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName), true)) {
            pw.println(SwimmerUtils.printTopList(top5Swimmers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //print-ud top 5 svømmere
    public static void printTopList() {
        //god logik til at sende til local-printer
        System.out.println("Listen er blevet printet ud.");
    }
}




