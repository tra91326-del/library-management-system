package controller;

import model.Member;
import services.MemberService;
import views.MainMenuView;
import views.MemberView;

public class MemberController {

    private final MemberService memberService;
    private final MemberView memberView;


    public MemberController(){
        memberService = new MemberService();
        memberView = new MemberView();

    }

    public void start(){

        boolean back = false;

        while (!back){
            memberView.displayMenu();
            int choice = memberView.getUserChoice();

            switch (choice){

                case 1:
                    memberView.displayMessage("Add Member");
                    addMember();
                    break;
                case 2:
                    memberView.displayMessage("---------------------------");
                    memberView.displayMessage("2. View Members");
                    memberView.displayMessage("---------------------------");
                    viewAllMember();
                    break;
                case 3:
                    memberView.displayMessage("3. Search Member");
                    viewMemberById();
                    break;
                case 4:
                    memberView.displayMessage("4. Update Member");
                    updateMember();
                    break;
                case 5:
                    memberView.displayMessage("5. Delete Member");
                    deleteMember();
                    break;
                case 6:
                    back = true;
                    break;
                default: {
                    memberView.displayMessage( "Invalid Choice");
                }
            }

        }


    }

    private void deleteMember() {
        String memberId = memberView.inputMemberId();
        boolean deleted = memberService.deleteMemberById(memberId);
        if (deleted){
            memberView.displayMessage("Member Deleted Successfully");
            return;
        }
        memberView.displayMessage("No Found!!");
    }

    private void updateMember() {

        String memberId = memberView.inputMemberId();

        Member member = memberService.searchMemberById(memberId);
        if (member == null){
            memberView.displayMessage("No Member !!");
            return;
        }

        memberView.inputUpdateMember(member);
        memberView.displayMessage("Member Update successfully");
    }

    private void addMember() {
        Member member = memberView.inputMember();
        if (memberService.existsMemberById(member.getId())){
            memberView.displayMessage("Member already exists");
            return;
        }
        memberService.addMember(member);
        memberView.displayMessage("Member created successfully");
    }

    private void viewMemberById() {
        Member member = memberService.searchMemberById(memberView.inputMemberId());
        if (member == null){
            System.out.println("No Found");
            return;
        }
        memberView.displayMember(member);
    }

    private void viewAllMember() {
        var members = memberService.getAllMembers();
        if (members.isEmpty()){
            System.out.println("No Member!!");
            return;
        }
        memberView.displayAllMember(memberService.getAllMembers());

    }
}
