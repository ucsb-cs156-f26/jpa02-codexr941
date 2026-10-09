package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
    assertTrue(team.equals(team));
    } 

    @Test
    public void equals_false_different_team() {
        team.addMember("Paul");
        Team other1 = new Team("another-team");
        assertFalse(team.equals(other1));
    }

    @Test
    public void equals_false_different_team_member(){
        Team other2 = new Team("test-team"); 
        other2.addMember("Xianze");
        assertFalse(team.equals(other2));
    }

    @Test
    public void equals_false_different_type(){
        String s="Xianze";
        assertFalse(team.equals(s));
    }

    @Test
    public void equals_true_two_same_Team(){
        team.addMember("Xianze");
        Team other3 = new Team("test-team");
        other3.addMember("Xianze");
        assertTrue(team.equals(other3));
    }

    @Test 
    public void hashcode_equal_team_has_same_hash(){
        Team another=new Team("test-team");
        assertTrue(team.equals(another));
        assertTrue(team.hashCode()==another.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
    int result = team.hashCode();
    int expectedResult = -1226298695;

    assertEquals(expectedResult, result);
}



   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
