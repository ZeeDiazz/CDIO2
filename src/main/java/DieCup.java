package main.java;

public class DieCup {
    private Die d1;
    private Die d2;

    public DieCup(Die d1, Die d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public void roll() {
        d1.roll();
        d2.roll();
    }

    public int getValueOfDie1() {
        return d1.getFace();
    }
    public int getValueOfDie2() {
        return d2.getFace();
    }
    public int getSum() {
        return d1.getFace() + d2.getFace();
    }
    public boolean isPair() {
        return d1.getFace() == d2.getFace();
    }

    @Override
    public String toString() {
        return d1.toString() + " & " + d2.toString();
    }
}
