package controller;

import model.Member;
import services.MemberService;
import views.MainMenuView;
import views.MemberView;

public class MemberController {

    private final MemberService memberService;
    private final MemberView memberView;


    public MemberController(MemberService memberService){
        this.memberService = memberService;
        memberView = new MemberView();

    }

    public void start(){

        boolean back = false;

        while (!back){
            memberView.displayMenu();
            int choice = memberView.getUserChoice();

            switch (choice){

                case 1:

                    addMember();
                    break;
                case 2:
                    viewAllMember();
                    break;
                case 3:
                    viewMemberById();
                    break;
                case 4:
                    updateMember();
                    break;
                case 5:
                   deleteMember();
                    break;
                case 6:
                    back = true;
                    break;
                default: {
                    System.out.println();
                    memberView.displayMessage( "INVALID CHOICE");
                }
            }

        }


    }

    private void deleteMember() {
        String memberId = memberView.inputMemberId();
        boolean deleted = memberService.deleteMemberById(memberId);
        if (deleted){
            System.out.println();
            memberView.displayMessage("MEMBER DELETED SUCCESSFULLY");
            return;
        }
        System.out.println();
        memberView.displayMessage("MEMBER NOT FOUND");
    }

    private void updateMember() {

        String memberId = memberView.inputMemberId();

        Member member = memberService.searchMemberById(memberId);
        if (member == null){
            System.out.println();
            memberView.displayMessage("MEMBER NOT FOUND");
            return;
        }

        memberView.inputUpdateMember(member);
        System.out.println();
        memberView.displayMessage("MEMBER UPDATE SUCCESSFULLY");
    }

    private void addMember() {
        Member member = memberView.inputMember();
        if (memberService.existsMemberById(member.getId())){
            System.out.println();
            memberView.displayMessage("MEMBER ALREADY EXISTS");
            return;
        }
        memberService.addMember(member);
        System.out.println();
        memberView.displayMessage("MEMBER CREATED SUCCESSFULLY");
    }

    private void viewMemberById() {
        Member member = memberService.searchMemberById(memberView.inputMemberId());
        if (member == null){
            System.out.println();
            System.out.println("MEMBER NOT FOUND");
            return;
        }
        memberView.displayMember(member);
    }

    private void viewAllMember() {
        var members = memberService.getAllMembers();
        if (members.isEmpty()){
            System.out.println();
            System.out.println("MEMBER NOT FOUND");
            return;
        }
        memberView.displayAllMember(memberService.getAllMembers());

    }
}
