package Quota;

import members.Members;
import members.MembersList;

import java.util.ArrayList;

public class CalculateQuota {
    private static final double passivePrice = 500;
    private static final double juniorPrice = 1000;
    private static final double seniorPrice = 1600;


    public static ArrayList<Members> calculateQuota(){
        ArrayList<Members> calculatedQuotaList = MembersList.getMemberList();

        for (Members m : calculatedQuotaList){
            if (!m.getIsActive()){ // tjekker passiv medlemmer
                //500 kr.
                m.setQuota(passivePrice);
            } else if (m.getAge() < 18 && m.getIsActive()){ // tjekker junior aktiv medlemmer
                //1000kr.
                m.setQuota(juniorPrice);
            } else if (m.getAge() >= 18 && m.getIsActive()){ // tjekker senior aktiv medlemmer
                //1600kr.
                m.setQuota(seniorPrice);
            } else if (m.getAge() < 60){
                if (m.getIsActive()){
                    // 1600 / 25%
                    double price = seniorPrice - (seniorPrice*0.25);
                    m.setQuota(price);
                } else {
                    // 500 / 25%
                    double price = passivePrice - (passivePrice*0.25);
                    m.setQuota(price);
                }
            }
        }
        return calculatedQuotaList;
    }

    public static ArrayList<Members> getQuotaList(){
        ArrayList<Members> h1 = calculateQuota();
        return h1;
    }

    public static ArrayList<Members> getRestanceList(){
        ArrayList<Members> restanceList = new ArrayList<>();

        for (Members m : calculateQuota()){
            if (!m.getQuotaPayed()){
                restanceList.add(m);
            }
        }

        return restanceList;
    }

    public static ArrayList<Members> printRestanceList(){
        for (Members m : getRestanceList()){
            System.out.println("Mangler at betale " + m.getQuota() + "kr.: " + m);
        }
        return getRestanceList();
    }

    public static ArrayList<Members> printQuotaList(){
        for (Members m : calculateQuota()){
            System.out.println(m.getName() + " " + m.getLastname() + "\nKontingent " + m.getQuota());
        }
        return calculateQuota();
    }

}
