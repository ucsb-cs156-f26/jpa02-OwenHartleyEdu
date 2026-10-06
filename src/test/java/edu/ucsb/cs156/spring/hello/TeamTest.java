package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test 
    public void toString_test() {
        assert(team.toString().equals("Team(name=" + team.name + ", members=" + team.members + ")"));
    }

    @Test
    public void hashCode_test() {
        assert(team.hashCode() == (team.name.hashCode() | team.members.hashCode()));
    }

    @Test 
    public void equals_test(){
        assert(team.equals(team));          // self
        assert(!team.equals(new Object())); // non-team object
        
        //other team of same name and members
        final String invalidName = "invalid_different_name_followed_by_keyboard_smash_kasfjlaskjflasfjlasjflakjskfjalfjawlfkjawfjawlkfjalwfkjaf";
        final ArrayList<String> altMemberList = new ArrayList<String>();
        altMemberList.add(invalidName);
        Team team2 = new Team();

        team2.setName(team.getName()); //right name, right members
        team2.setMembers(team.getMembers());
        assert(team.equals(team2)); 

        team2.setName(team.getName()); //right name, wrong members
        team2.setMembers(altMemberList);
        team2.members.add(invalidName);
        assert(! team.equals(team2));

        team2.setName(invalidName); //wrong name, right members
        team2.setMembers(team.getMembers());
        assert(! team.equals(team2));

        team2.setName(invalidName); //wrong name, wrong members
        team2.setMembers(altMemberList);;
        assert(! team.equals(team2));
    }
}
