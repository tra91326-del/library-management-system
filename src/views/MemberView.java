package views;

import model.Member;
import utils.InputHelper;

import java.util.List;

public class MemberView {

    public void displayMenu() {
        System.out.println("=================================");
        System.out.println("   Member Management");
        System.out.println("=================================");
        System.out.println("1. Add Member");
        System.out.println("2. View Members");
        System.out.println("3. Search Member");
        System.out.println("4. Update Member");
        System.out.println("5. Delete Member");
        System.out.println("6. Back");
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
        for (Member m : allMembers){
            System.out.println(m);
        }
    }

    public void displayMember(Member member) {
        System.out.println(member);
    }

    public void displayMessage(String message){
        System.out.println(message);
    }

    public void inputUpdateMember(Member member) {

        //current book information
        System.out.println("Current Member Information");
        System.out.println(member);
        System.out.println("----------------------");

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
}
