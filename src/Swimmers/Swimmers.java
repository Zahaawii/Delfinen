package Swimmers;
import members.MembersList;

public class Swimmers {
    private MembersList membersList;
    private TrænerUI trænerUI;

    public Swimmers(MembersList membersList){
        this.membersList = membersList;
        this.trænerUI = new TrænerUI(membersList);
    }

    public void start() {
        trænerUI.showMenu();
    }
}
