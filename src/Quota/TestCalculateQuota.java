//package Quota;
//
//import members.Members;
//import members.MembersList;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.util.ArrayList;
//
//public class TestCalculateQuota {
//
//    private ArrayList<Members> membersList;
//
//    @Test
//    public void testCalculateQouta(){
//        membersList = new ArrayList<>();
//        //membersList.clear();
//
//        //Opretter test objekter
//        membersList.add(new Members(0, "Long", "L", 17, true, true));       //Junior aktiv,,, 1000kr
//        membersList.add(new Members(1, "Zahaa", "Z", 30, true, true));      //Senior aktiv,,, 1600kr
//        membersList.add(new Members(2, "Daniel", "D", 20, false, true));    //Passive,,,,,,,,  500kr
//        membersList.add(new Members(3, "Alexander", "A", 61, true, true));  //Pensionist aktiv 1200kr
//        membersList.add(new Members(4, "Shahrez", "S", 80, false, true));   //Pensionist passiv 375kr
//
//        //Kalder metoden for at få listen af medlemmer med beregnet kontingent.
//        ArrayList<Members> result = CalculateQuota.calculateQuota();
//
//        //Tester at arrayListe ikke er tomt
//        Assert.assertTrue(!result.isEmpty());
//
//
//        //Test units af hvert objekt
//        Assert.assertEquals(1000, result.get(0).getQuota(), 0.01);  //Junior aktiv,,, 1000kr
//        Assert.assertEquals(1600, result.get(1).getQuota(), 0.01);  //Senior aktiv,,, 1600kr
//        Assert.assertEquals(500, result.get(2).getQuota(), 0.01);   //Passive,,,,,,,,  500kr
//        Assert.assertEquals(1200, result.get(3).getQuota(), 0.01);  //Pensionist aktiv 1200kr
//        Assert.assertEquals(375, result.get(4).getQuota(), 0.01);   //Pensionist passiv 375kr
//    }
//}
