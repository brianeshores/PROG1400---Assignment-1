//region IMPORT STATEMENTS
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
//endregion

public class Main {
    public static void main(String[] args) {
//region GLOBAL VARIABLE DECLARATION
        Scanner input = new Scanner(System.in);
        Random randomNum = new Random();
        int budget;
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
//FOR EACH TEAM, CREATE 3 PLAYERS AND SET INFO
        System.out.println("\nPLAYER ENTRY\n");
        System.out.println("=====================================================================================");
        for(Team team: teamList) {
            System.out.println("Enter Players for " + team.getName() + ":");
            for (int j = 0; j < 3; j++) {
                Player player = new Player();
//USER INPUT FOR PLAYER NAME
                System.out.println("Enter name for player #" + (j + 1) + ": ");
                String playerName = input.nextLine();
//CHECK TO SEE IF PLAYER NAME IS GREATER THAN 3
                while (playerName.length() < 3) {
                    System.out.println("Enter a name with at least 3 characters.");
                    playerName = input.nextLine();
                }
                player.setName(playerName);

//USER INPUT AND VALIDATION OF PLAYER STATS
                int goals;
                do {
                    try {
//USER INPUT FOR GOALS
                        System.out.println("Enter Number of Goals for " + player.getName() + ": ");
                        goals = input.nextInt();
//CHECK GOALS ARE 0 OR GREATER
                        if (goals < 0) System.out.println("Invalid input, please enter a positive number. ");
//CHECK GOALS FOR IMPROPER INPUT TYPE
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a positive number. ");
                        goals = -1;
                    }
                    input.nextLine();
                }
                while (goals < 0);
                player.setGoals(goals);

                int assists;
                do {
                    try {
//USER INPUT FOR ASSISTS
                        System.out.println("Enter Number of Assists for " + player.getName() + ": ");
                        assists = input.nextInt();
//CHECK GOALS ARE 0 OR GREATER
                        if (assists < 0) System.out.println("Invalid input, please enter a positive number. ");
//CHECK GOALS FOR IMPROPER INPUT TYPE
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a positive number. ");
                        assists = -1;
                    }
                    input.nextLine();
                } while (assists < 0);

                player.setAssists(assists);
                team.addPlayer(player);
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