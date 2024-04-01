package ca.bcit.comp2522.termproject.oishiiramen;

public class Shoyu extends Menu {
    public static final double COST_FOR_SHOYU = 3.50;
    public Shoyu(String size) {
        super(size);
    }

    public double getCostForRamen() {
        return COST_FOR_SHOYU;
    }
}

