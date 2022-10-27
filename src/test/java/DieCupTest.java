package test.java;

import main.java.DieCup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieCupTest {

    @Test
    void roll_rollsBothDice() {
        TestDie d1 = new TestDie(1, 2, 3, 4, 5, 6);
        TestDie d2 = new TestDie(1, 2, 3, 4, 5, 6);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(2, cup.getSum());
        cup.roll();
        assertEquals(4, cup.getSum());
        cup.roll();
        assertEquals(6, cup.getSum());
        cup.roll();
        assertEquals(8, cup.getSum());
        cup.roll();
        assertEquals(10, cup.getSum());
        cup.roll();
        assertEquals(12, cup.getSum());
    }

    @Test
    void getSum() {
        TestDie d1 = new TestDie(2, 4, 6, 95);
        TestDie d2 = new TestDie(4, 2, 6, -3);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(6, cup.getSum());
        cup.roll();
        assertEquals(6, cup.getSum());
        cup.roll();
        assertEquals(12, cup.getSum());
        cup.roll();
        assertEquals(92, cup.getSum());
    }

    @Test
    void isPair() {
    }
}