package views;

import model.Member;
import utils.InputHelper;

import java.util.List;

public class MemberView {

    public void displayMenu() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("               MEMBER MANAGEMENT ");
        System.out.println("============================================================");
        System.out.println("1. Add Member");
        System.out.println("2. View Members");
        System.out.println("3. Search Member");
        System.out.println("4. Update Member");
        System.out.println("5. Delete Member");
        System.out.println("6. Back");
        System.out.println("------------------------------------------------------------");
    }

    //create new member via user input
    public Member inputMember(){

        String id = InputHelper.readString("Enter Member Id: ");
        String name = InputHelper.readString("Enter Member Name: ");
        String phone = InputHelper.readString("Enter Member Phone: ");
        String email = InputHelper.readString("Enter Member Email: ");
        return new Member(id,name,phone,email);
    }

    // to search member with id
    public String inputMemberId(){
        return InputHelper.readString("Enter Member Id: ");
    }

    public void displayAllMember(List<Member> allMembers) {

        printMemberHeader("MEMBER LISTS");
        for (Member m : allMembers){
            printMemberBody(m);
        }
    }

    public void displayMember(Member member) {
       printMemberHeader("MEMBER INFORMATION");
       printMemberBody(member);
    }
   public void inputUpdateMember(Member member) {

        //current member information
        printMemberHeader("CURRENT MEMBER INFORMATION");
        printMemberBody(member);

        System.out.println("Current Name: " + member.getName());
        String newName = InputHelper.readString("Enter new name (Press Enter to keep current): ");
        if (!newName.isBlank()){
            member.setName(newName);
        }

        System.out.println("Current Phone: " + member.getPhone());
        String newPhone = InputHelper.readString("Enter new phone (Press Enter to keep current): ");
        if (!newPhone.isBlank()){
            member.setPhone(newPhone);
        }

        System.out.println("Current Email: " + member.getEmail());
        String newEmail = InputHelper.readString("Enter new email (Press Enter to keep current): ");
        if (!newEmail.isBlank()){
            member.setEmail(newEmail);
        }
    }

    public int getUserChoice() {
        return InputHelper.readInt("Enter Your Choose:  ");
    }


    public void displayMessage(String message){
        System.out.println(message);
    }



    private void printMemberHeader(String title){
        System.out.println("==============================================================");
        System.out.printf("                    %s%n",title);
        System.out.println("==============================================================");
        System.out.println();

        //table header
        System.out.printf("%-8s %-13s %-15s %-25s%n",
                "ID",
                "NAME",
                "PHONE",
                "EMAIL"
        );
        System.out.println("---------------------------------------------------------------------");

    }

    private void printMemberBody(Member member){

        //table body
        System.out.printf("%-8s %-13s %-15s %-25s%n",
                member.getId(),
                member.getName(),
                member.getPhone(),
                member.getEmail()
        );

        System.out.println();

    }
}
