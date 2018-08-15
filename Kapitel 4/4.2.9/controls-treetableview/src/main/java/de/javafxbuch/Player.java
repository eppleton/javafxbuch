package de.javafxbuch;

public class Player {

    String lastName;
    String firstName;
    int goals;

    public Player(String firstName, String lastName, int goals) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.goals = goals;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getGoals() {
        return goals;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
