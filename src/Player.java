import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
//region PROPERTIES
    private String name;
    private int goals;
    private int assists;
//endregion

//region GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
//endregion

//region METHODS
    public void outputPlayerDetails(Player player) {
        System.out.printf("%-25s", player.getName());
        System.out.printf("    G -   " + player.getGoals() + "   A -  " + player.getAssists() + "  Total: " + totalPoints(this) + "\n");
    }

    public int totalPoints(Player player) {
        return player.goals + player.assists;
    }


    public void getPlayerInfo(Scanner input, Player player, Team team, int j) {
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

//endregion
}
