import java.util.ArrayList;
import java.util.Scanner;

public class Team {
//region PROPERTIES
    private String name;
    private ArrayList<Player> playerList = new ArrayList<>();
    private int totalGoals;
    private int totalAssists;
    private int totalPoints;
    private String teamRating;
    private double budget;
//endregion

//region Constructor
    public Team(double budget) {
        this.budget=budget;
    }
//endregion

//region GETTERS AND SETTERS
    public String getTeamRating() {
        return teamRating;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

//endregion

//region METHODS
    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public void setTotals(Team team) {
        int totalPoints = 0;
        int totalGoals = 0;
        int totalAssists = 0;
        for (Player player : team.getPlayerList()) {
            totalGoals += player.getGoals();
            totalAssists += player.getAssists();
            totalPoints += (player.getGoals()+player.getAssists());
        }
        this.totalGoals=totalGoals;
        this.totalAssists=totalAssists;
        this.totalPoints=totalPoints;
    }

    public void setRating(Team team) {
        if(this.totalPoints>20) {
            this.teamRating="***";
        } else if(this.totalPoints>10) {
            this.teamRating="**";
        } else if(this.totalPoints>0){
            this.teamRating="*";
        } else {
            this.teamRating="";
        }
    }

    public void outputTeamData(Team team) {
        System.out.printf("%-25s", team.getName() + ":");
        System.out.println("   G - " + team.totalGoals + "  A - " + team.totalAssists + "  Total - " + team.totalPoints);
        System.out.print("Team Budget: $");
        System.out.printf("%.2f", team.getBudget());
        System.out.println(" \nTeam Rating: " + team.getTeamRating() + "\n");
    }

    public void getTeamInfo (Team team, float budget, Scanner input, ArrayList<Team> teamList, int i) {
        System.out.println("Enter name for team #" + (i + 1) + ": ");
        String teamName = input.nextLine();
//CHECK TO SEE IF TEAM NAME IS GREATER THAN 3
        while (teamName.length() < 3) {
            System.out.println("Enter a name with at least 3 characters.");
            teamName = input.nextLine();
        }

        team.setName(teamName);
        teamList.add(team);
    }
//endregion

}
