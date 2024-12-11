package members;

import UserInterface.ConsoleOperators;

import java.util.ArrayList;

public class MembersList {
    static ArrayList <Members> memberList = new ArrayList<>();

    public static Members getMemberID(int id) {
        for(Members m : memberList) {
            if(m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public static boolean removeMember(int id) {
        Members m = getMemberID(id);
        if(m != null) {
            memberList.remove(m);
            return true;
        }
        return false;
    }

    public static ArrayList<Members> getMemberList(){
        return memberList;
    }

    public static void seeList() {
        for(Members m : memberList) {
            System.out.println(m);
            ConsoleOperators.printSeperator(30);
        }
    }
}


