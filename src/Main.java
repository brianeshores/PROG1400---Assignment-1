//region IMPORT STATEMENTS
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
//endregion

public class Main {
    public static void main(String[] args) {
//region GLOBAL VARIABLE DECLARATION
        Scanner input = new Scanner(System.in);
        Random randomNum = new Random();
        float budget;
        ArrayList<Team> teamList = new ArrayList<>();
//endregion

//region GATHER AND SET TEAM AND PLAYER INFO
//TEAM INFO ENTRY
        System.out.println("FANTASY HOCKEY APPLICATION\n");
        System.out.println("TEAM ENTRY\n");
        System.out.println("=====================================================================================");
        for(int i = 0; i<3; i++) {
            budget = randomNum.nextInt(10001);
            Team team = new Team(budget);
//USER INPUT FOR TEAM NAME
            team.getTeamInfo(team, budget, input, teamList, i);
        }
//FOR EACH TEAM, CREATE 3 PLAYERS AND SET INFO
        System.out.println("\nPLAYER ENTRY\n");
        System.out.println("=====================================================================================");
        for(Team team: teamList) {
            System.out.println("Enter Players for " + team.getName() + ":");
            for (int j = 0; j < 3; j++) {
                Player player = new Player();
//USER INPUT FOR PLAYER NAME
                player.getPlayerInfo(input, player, team, j);
            }
        }
//endregion

//region SET TEAM STAT TOTALS AND RATING
        for (Team team : teamList) {
            team.setTotals(team);
            team.setRating(team);
        }
//endregion

//region PRINT TEAM REPORT
        System.out.println("REPORT: Stats Per Team");
        System.out.println("=======================================================================================");
        for(Team team : teamList) {
            team.outputTeamData(team);
        }
//endregion

//region PRINT PLAYER REPORT

        System.out.println("REPORT: Stats Per Player");
        System.out.println("=======================================================================================");
        for(Team team : teamList) {
            System.out.println("\n" +team.getName());
            System.out.println("=======================================================================================");
            for(Player player : team.getPlayerList()) {
                player.outputPlayerDetails(player);
            }
        }
//endregion
    }
}