package test.java;

import main.java.SixSidedDie;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SixSidedDieTest {
    @org.junit.jupiter.api.Test
    void roll_canProduceDifferentResult() {
        SixSidedDie die = new SixSidedDie();
        int initial = die.getFace();

        assertTimeout(Duration.ofSeconds(1), () -> {
            die.roll();
            int newValue = die.getFace();

            assertNotEquals(initial, newValue);
        });
    }

    @org.junit.jupiter.api.Test
    void roll_isFair() {
        SixSidedDie die = new SixSidedDie();
        ArrayList<Integer> valuesRolled = new ArrayList<>();
        int rollCount = 10000;

        for (int i = 0; i < rollCount; i++) {
            valuesRolled.add(die.getFace());
            die.roll();
        }

        double sumOfRolls = valuesRolled.stream().mapToDouble(a -> a).sum();
        double average = sumOfRolls / rollCount;
        assertEquals(3.5, average, 0.1);
    }
}