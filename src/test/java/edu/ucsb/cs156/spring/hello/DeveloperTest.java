package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // DONE: Replace Chris G. with your name as shown on the team spreadsheet
        assertEquals("Owen", Developer.getName());
    }
    
    @Test 
    public void getGithubId_returns_correct() {
        assertEquals("OwenHartleyEdu", Developer.getGithubId());
    }

    @Test
    public void getTeam_test(){
        ArrayList<String> memberNames = new ArrayList<String>(
            java.util.Arrays.asList(
            "ANDREW",
                "CHRISTIAN",
                "JONATHAN",
                "NATHAN",
                "OWEN",
                "YIFAN"
            )
        );
        memberNames.sort(null);

        Team team = Developer.getTeam();
        ArrayList<String> teamMembers = team.getMembers();
        teamMembers.sort(null);
        for (int i = 0; i < Math.max(teamMembers.size(), memberNames.size()); i++){
            if(i >= memberNames.size()){
                assert(false);
            }
            try {
                String correct = memberNames.get(i);
                String member = teamMembers.get(i);
                assert(correct.equals(member));
            } catch (IndexOutOfBoundsException e){
                assert(false);
            }

        }
    }
}
