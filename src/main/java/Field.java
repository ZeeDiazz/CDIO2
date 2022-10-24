package main.java;

public class Field {
    private String name;
    private int moneyChange;
    private Effect effect;
    // private main.java.FieldText text; (not written yet)

    public Field(String name, int moneyChange, Effect effect) {
        this.name = name;
        this.moneyChange = moneyChange;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public int getMoneyChange() {
        return moneyChange;
    }

    public Effect getEffect() {
        return effect;
    }
}
