public class Athlete extends Person{
    // Instance variables
    private String sport;
    private int numWins;
    // Constructor
    public Athlete(String firstName, String lastName, String phoneNumber, String sport, int numWins) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
        this.numWins = numWins;
    }
    // Methods
    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public String toString() {
        return super.toString() + " Sport: " + sport + " Wins: " + numWins;
    }
}
