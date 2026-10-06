package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        // DONE: Change this to your name
        // You may use just the name that is used on the class team spreadsheet
        // i.e. your first name, or your first and initial of last name

        return "Owen";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        // DONE: Change this to your github id
        return "OwenHartleyEdu";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        // DONE: Change this to your team name
        Team team = new Team("Rogue One");

        team.addMember("ANDREW");
        team.addMember("CHRISTIAN");
        team.addMember("JONATHAN");
        team.addMember("NATHAN");
        team.addMember("OWEN");
        team.addMember("YIFAN");
        
        return team;
    }
}
