package main.java;

import java.util.Scanner;

public class Game {
    private Player[] players;
    private int currentPlayerIndex;
    private Field[] fields;

    private Player winner;
    private Player loser;

    public Game() {
        this.players = new Player[2];
        this.players[0] = new Player(getPlayerName("Player 1 enter your name:", null), 1000);
        this.players[1] = new Player(getPlayerName("Player 2 enter your name:", null), 1000);

        this.fields = new Field[12];

        setNewLanguage("en");
        this.currentPlayerIndex = 0;
    }

    private static String getPlayerName(String prompt, Scanner in) {
        if (in == null) {
            in = new Scanner(System.in);
        }

        System.out.println(prompt);
        String playerName = in.nextLine();
        return playerName;
    }

    public Field getField(int index) {
        return this.fields[index];
    }

    public Player getPlayingPlayer() {
        return this.players[currentPlayerIndex];
    }

    public void nextTurn() {
        Player currentlyPlaying = getPlayingPlayer();
        if (currentlyPlaying.Account.getBalance() >= 3000) {
            this.winner = currentlyPlaying;
        }

        // Use bithacking to set the index to the next index
        this.currentPlayerIndex = (currentPlayerIndex + 1) & 1;

        if (someoneHasWon()) {
            this.loser = getPlayingPlayer();
        }
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
        LanguageManager.loadLanguage(newLanguage);
        String[] names = LanguageManager.getNames();
        int[] fieldMoneyChanges = {0, 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};
        Effect[] fieldEffects = {Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.ExtraTurn, Effect.Nothing, Effect.Nothing};
        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i] = new Field(names[i], fieldMoneyChanges[i], fieldEffects[i]);
        }
        // TODO: implement this
    }
}
