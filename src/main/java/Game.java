package main.java;

import java.util.Scanner;

public class Game {
    private Player[] players;
    private int currentPlayerIndex;
    private Field[] fields;
    private String getNamePrompt;

    private Player winner;
    private Player loser;

    public Game(String gameLanguage) {
        this.fields = new Field[12];
        setLanguage(gameLanguage);

        String playerNamePromptDesign = LanguageManager.getPrompt(PlayerUpdate.AskPlayerForName);
        String player1NamePrompt = LanguageManager.insertValuesInPrototype(playerNamePromptDesign, 1);
        String player2NamePrompt = LanguageManager.insertValuesInPrototype(playerNamePromptDesign, 2);

        this.players = new Player[2];
        this.players[0] = new Player(getPlayerName(player1NamePrompt, null), 1000);
        this.players[1] = new Player(getPlayerName(player2NamePrompt, null), 1000);

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
        if (currentlyPlaying.Account.getBalance() >= 1100) {
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

    public void setLanguage(String newLanguage) {
        LanguageManager.loadLanguage(newLanguage);
        String[] names = LanguageManager.getNames();
        int[] fieldMoneyChanges = {0, 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};
        Effect[] fieldEffects = {Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.Nothing, Effect.ExtraTurn, Effect.Nothing, Effect.Nothing};
        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i] = new Field(names[i], fieldMoneyChanges[i], fieldEffects[i]);
        }
    }
}
