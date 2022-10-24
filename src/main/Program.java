package main;

import java.util.Scanner;

public class Program {
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        SixSidedDie d1 = new SixSidedDie();
        SixSidedDie d2 = new SixSidedDie();
        DieCup cup = new DieCup(d1, d2);
        Game game = new Game();

        while (!game.someoneHasWon()) {
            // Get the player whose turn it is
            Player currentlyPlaying = game.getPlayingPlayer();

            // Ask the player to roll the dice
            getPermissionToRoll(currentlyPlaying);

            // Get the result of the dice roll and the corresponding field
            int rollSum = cup.getSum();
            Field landedOn = game.getField(rollSum);

            // Inform the player of the place they landed
            printFieldData(landedOn);

            // Tell the game, the player has ended their turn
            game.nextTurn();
        }

        System.out.println("Congratulations " + game.getWinner() + " you won!");
        System.out.println("Better luck next time " + game.getLoser());
    }

    private static void getPermissionToRoll(Player player) {
        String playerInput;
        while (true) {
            System.out.println(player.name + " type 'roll' (or 'r') to roll");
            playerInput = in.nextLine().toLowerCase();
            if (playerInput.equals("roll") || playerInput.equals("r")) {
                break;
            }
            System.out.println("Ready when you are!");
        }
    }

    private static void printFieldData(Field field) {
        // TODO: print name and maybe description of landed field, as well as the effect it has
    }
}
