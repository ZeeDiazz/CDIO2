package main;

public class Program {
    public static void main(String[] args) {
        SixSidedDie d1 = new SixSidedDie();
        SixSidedDie d2 = new SixSidedDie();
        Game game = new Game(d1, d2);

        while (!game.someoneHasWon()) {
            game.playRound();
        }

        System.out.println("Congratulations " + game.getWinner() + " you won!");
        System.out.println("Better luck next time " + game.getLoser());
    }
}
