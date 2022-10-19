public class Game {
    private Player p1;
    private Player p2;
    private DieCup cup;
    private Field[] fields;

    private Player winner;
    private Player loser;

    public Game(Die d1, Die d2) {
        p1 = new Player(1);
        p2 = new Player(2);

        this.cup = new DieCup(d1, d2);
        this.fields = new Field[12];
    }

    public void playRound() {
        // TODO: place logic
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
