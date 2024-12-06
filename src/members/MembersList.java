package members;

import java.util.ArrayList;

public class MembersList {
    static ArrayList <Members> memberList = new ArrayList<>();

    public void addMember (Members aMember){
        if(aMember != null){
            memberList.add(aMember);
            System.out.println("\nA member: " + aMember + " is added to the list of club members.");
        } else {
            System.out.println("Cannot add the member because the information is missing. Please ensure all details are provided");
        }
    }
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
        }
    }
}


