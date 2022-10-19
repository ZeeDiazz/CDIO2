public class Game {
    private Player[] players;
    private int currentPlayerIndex;
    private DieCup cup;
    private Field[] fields;

    private Player winner;
    private Player loser;

    public Game(Die d1, Die d2) {
        this.players = new Player[2];
        this.players[0] = new Player(1);
        this.players[1] = new Player(2);

        this.cup = new DieCup(d1, d2);
        this.fields = new Field[12];
        this.currentPlayerIndex = 0;
    }

    public void playRound() {
        // TODO: place logic

        // Use bithacking to set the index to the next index
        this.currentPlayerIndex = (currentPlayerIndex + 1) & 1;
    }

    public boolean someoneHasWon() {
        return winner != null;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setNewLanguage(String newLanguage) {
        // TODO: implement this
    }
}
