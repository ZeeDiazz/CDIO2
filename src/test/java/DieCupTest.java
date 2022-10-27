package test.java;

import main.java.DieCup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieCupTest {

    @Test
    void roll_rollsBothDice() {
        TestDie d1 = new TestDie(4, 5, 6);
        TestDie d2 = new TestDie(1, 2, 3);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(4, cup.getValueOfDie1());
        assertEquals(1, cup.getValueOfDie2());
        cup.roll();
        assertEquals(5, cup.getValueOfDie1());
        assertEquals(2, cup.getValueOfDie2());
        cup.roll();
        assertEquals(6, cup.getValueOfDie1());
        assertEquals(3, cup.getValueOfDie2());
    }

    @Test
    void getSum_bothOneToSix() {
        TestDie d1 = new TestDie(2);
        TestDie d2 = new TestDie(4);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(6, cup.getSum());
    }

    @Test
    void getSum_bothHighValues() {
        TestDie d1 = new TestDie(55);
        TestDie d2 = new TestDie(49);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(104, cup.getSum());
    }

    @Test
    void getSum_bothNegativeValues() {
        TestDie d1 = new TestDie(-2);
        TestDie d2 = new TestDie(-8);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(-10, cup.getSum());
    }

    @Test
    void getSum_bothZero() {
        TestDie d1 = new TestDie(0);
        TestDie d2 = new TestDie(0);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(0, cup.getSum());
    }

    @Test
    void getSum_positiveAndNegativeValue() {
        TestDie d1 = new TestDie(5);
        TestDie d2 = new TestDie(-2);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(3, cup.getSum());
    }

    @Test
    void getSum_positiveAndZero() {
        TestDie d1 = new TestDie(3);
        TestDie d2 = new TestDie(0);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(3, cup.getSum());
    }

    @Test
    void getSum_negativeAndZero() {
        TestDie d1 = new TestDie(-4);
        TestDie d2 = new TestDie(0);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertEquals(-4, cup.getSum());
    }

        @Test
    void isPair_withActualPair() {
        TestDie d1 = new TestDie(1);
        TestDie d2 = new TestDie(1);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertTrue(cup.isPair());
    }

    @Test
    void isPair_withNotPair() {
        TestDie d1 = new TestDie(1);
        TestDie d2 = new TestDie(3);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertFalse(cup.isPair());
    }

    @Test
    void isPair_actualPairThenNoPair() {
        TestDie d1 = new TestDie(6, 6);
        TestDie d2 = new TestDie(6, 1);
        DieCup cup = new DieCup(d1, d2);

        cup.roll();
        assertTrue(cup.isPair());
        cup.roll();
        assertFalse(cup.isPair());
    }
}