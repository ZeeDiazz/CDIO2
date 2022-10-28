package main.java;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    private static Scanner in;
    static FieldText text = new FieldText();

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(System.in);

        SixSidedDie d1 = new SixSidedDie();
        SixSidedDie d2 = new SixSidedDie();

        DieCup cup = new DieCup(d1, d2);
        Game game = new Game();
        String[] pickLanguage = text.setPickLanguage("Dansk");

        while (!game.someoneHasWon()) {

            // Get the player whose turn it is
            Player currentlyPlaying = game.getPlayingPlayer();

            // Ask the player to roll the dice
            getPermissionToRoll(currentlyPlaying);

            // Get the result of the dice roll and the corresponding field
            cup.roll();
            int rollSum = cup.getSum();
            Field landedOn = game.getField(rollSum - 1);

            // Inform the player of the place they landed
            System.out.println(pickLanguage[2] + " " +  cup.toString());
            showFieldInfo(landedOn);

            currentlyPlaying.Account.updateBalance(landedOn.getMoneyChange());
            System.out.printf("You now have %d money\n\n", currentlyPlaying.Account.getBalance());

            if (landedOn.getEffect() == Effect.ExtraTurn) {
                System.out.println("You get an extra turn!");
            }
            else {
                // Tell the game, the player has ended their turn
                game.nextTurn();
            }
        }

        System.out.println("Congratulations " + game.getWinner().name + " you won!");
        System.out.println("Better luck next time " + game.getLoser().name);
    }

    private static void getPermissionToRoll(Player player) throws FileNotFoundException {
        String playerInput;
        String[] pickLanguage = text.setPickLanguage("Dansk");
        while (true) {
            System.out.println(player.name +" "+ pickLanguage[20]);
            playerInput = in.nextLine().toLowerCase();
            if (playerInput.equals("roll") || playerInput.equals("r")) {
                break;
            }
            System.out.println("Ready when you are!");
        }
    }

    private static void showFieldInfo(Field field) {
        System.out.printf("You landed on %s and is paid %d\n", field.getName(), field.getMoneyChange());
    }
}
