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
//endregion
}
