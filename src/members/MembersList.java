package members;

import UserInterface.ConsoleOperators;

import java.util.ArrayList;

public class MembersList {
    static ArrayList <Members> memberList = new ArrayList<>();

    //Method to search the member by ID and display it
    public static Members getMemberID(int id) {
        for(Members m : memberList) {
            if(m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    //Method to remove a member by ID
    public static boolean removeMember(int id) {
        Members m = getMemberID(id);
        if(m != null) {
            memberList.remove(m);
            return true;
        }
        return false;
    }

    //Method to make it possible to use the memberlist with the data that it stores
    public static ArrayList<Members> getMemberList(){
        return memberList;
    }

    //Method to see all data stored on the member list
    public static void seeList() {
        for(Members m : memberList) {
            System.out.println(m);
            ConsoleOperators.printSeperator(30);
        }
    }
}


