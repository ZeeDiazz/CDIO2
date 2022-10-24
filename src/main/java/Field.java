package main.java;

public class Field {
    private int moneyChange;
    private Effect effect;
    // private main.java.FieldText text; (not written yet)

    public Field(int moneyChange, Effect effect) {
        this.moneyChange = moneyChange;
        this.effect = effect;
    }

    public int getMoneyChange() {
        return moneyChange;
    }

    public Effect getEffect() {
        return effect;
    }
}
