package main.java;

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
            cup.roll();
            int rollSum = cup.getSum();
            Field landedOn = game.getField(rollSum - 1);

            // Inform the player of the place they landed
            System.out.println("You rolled " + cup.toString());
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

    private static void showFieldInfo(Field field) {
        int moneyChange = field.getMoneyChange();
        String prompt = "You landed on " + field.getName();

        if (moneyChange > 0) {
            prompt += " and is paid " + field.getMoneyChange();
        }
        else if (moneyChange < 0) {
            prompt += " and have to pay " + Math.abs(field.getMoneyChange());
        }
        else {
            prompt += " and get some free rest";
        }
        System.out.println(prompt);
    }
}
