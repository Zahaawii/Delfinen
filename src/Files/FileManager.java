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



