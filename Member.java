
//unchanged

import java.util.*;
public class Member {
    private int id;
    private String firstName, lastName, dateJoin;

    public Member(int id,String firstName,String lastName,String dateJoin){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateJoin = dateJoin;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public static Member findMember(ArrayList<Member> members, String firstName,String lastName){
        for(Member member: members)
        {
            if((member.getFirstName()==firstName) && (member.getLastName()==lastName))
            {
                return member;
            }
        }
        System.out.println("Member not found");
        return null;
    }
}
