import java.util.ArrayList;

public class Team {
//region PROPERTIES
    private String name;
    private ArrayList<Player> playerList = new ArrayList<>();
    private int totalGoals;
    private int totalAssists;
    private int totalPoints;
    private String teamRating;
    private int budget;
//endregion

//region Constructor
    public Team(int budget) {
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

    public int getBudget() {
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
        System.out.println("Team Budget: " + team.getBudget());
        System.out.println("Team Rating: " + team.getTeamRating() + "\n");
    }
//endregion

}
