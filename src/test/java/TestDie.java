package test.java;

import main.java.Die;

public class TestDie extends Die {
    private int[] rolls;
    private int currentRoll;

    public TestDie(int... rolls) {
        this.rolls = rolls;
        this.currentRoll = 0;
    }

    @Override
    public void roll() {
        this.face = rolls[currentRoll++];
    }
}
