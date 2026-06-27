package services;

import model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberService {

    private final List<Member> members = new ArrayList<Member>();

    public void addMember(Member m){
        members.add(m);
    }

    public List<Member> getAllMembers(){
        return members;
    }

    public Member searchMemberById(String memberId){
        for (Member m : members){
            if (m.getId().equals(memberId)){
                return m;
            }
        }
        return null;
    }


    public boolean deleteMemberById(String memberId){

        Member member = searchMemberById(memberId);
        if (member == null){
            return false;
        }
        members.remove(member);
        return true;
    }

    public boolean existsMemberById(String memberId){
        Member member = searchMemberById(memberId);
        return member != null;
    }
}
