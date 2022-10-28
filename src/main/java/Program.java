package main.java;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    private static Scanner in;


    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(System.in);

        SixSidedDie d1 = new SixSidedDie();
        SixSidedDie d2 = new SixSidedDie();

        DieCup cup = new DieCup(d1, d2);
        Game game = new Game("da");

        String landedOnPromptDesign = LanguageManager.getPrompt(PlayerUpdate.DiceResult);
        String newBalancePromptDesign = LanguageManager.getPrompt(PlayerUpdate.UpdatedBalance) + "\n";
        String extraTurnPrompt = LanguageManager.getPrompt(PlayerUpdate.ExtraTurn);

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
            System.out.println(LanguageManager.insertValuesInPrototype(landedOnPromptDesign, cup.getValueOfDie1(), cup.getValueOfDie2()));
            showFieldInfo(landedOn);

            currentlyPlaying.Account.updateBalance(landedOn.getMoneyChange());
            System.out.println(LanguageManager.insertValuesInPrototype(newBalancePromptDesign, currentlyPlaying.Account.getBalance()));

            if (landedOn.getEffect() == Effect.ExtraTurn) {
                System.out.println(extraTurnPrompt);
            }
            else {
                // Tell the game, the player has ended their turn
                game.nextTurn();
            }
        }

        String winnerMessageDesign = LanguageManager.getWinnerMessageDesign();
        String loserMessageDesign = LanguageManager.getLoserMessageDesign();

        System.out.println(LanguageManager.insertValuesInPrototype(winnerMessageDesign, game.getWinner().name));
        System.out.println(LanguageManager.insertValuesInPrototype(loserMessageDesign, game.getLoser().name));
    }

    private static void getPermissionToRoll(Player player) {
        String playerInput;

        String rollPromptDesign = LanguageManager.getPrompt(PlayerUpdate.ThrowDice);
        String rollPrompt = LanguageManager.insertValuesInPrototype(rollPromptDesign, "r");
        while (true) {
            System.out.println(rollPrompt);
            playerInput = in.nextLine().toLowerCase();
            if (playerInput.equals("r")) {
                break;
            }
            System.out.println("Not recognized");
        }
    }

    private static void showFieldInfo(Field field) {
        int moneyChange = field.getMoneyChange();

        String promptDesign;
        if (moneyChange > 0) {
            promptDesign = LanguageManager.getPrompt(PlayerUpdate.GetPaid);
        }
        else if (moneyChange < 0) {
            promptDesign = LanguageManager.getPrompt(PlayerUpdate.LoseMoney);
        }
        else {
            promptDesign = LanguageManager.getPrompt(PlayerUpdate.NoMoneyChange);
        }
        String prompt = LanguageManager.insertValuesInPrototype(promptDesign, field.getName(), Math.abs(moneyChange));
        System.out.println(prompt);
    }
}
