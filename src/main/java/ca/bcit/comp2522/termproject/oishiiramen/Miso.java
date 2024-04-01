package ca.bcit.comp2522.termproject.oishiiramen;

public class Miso extends Menu {
    public static final double COST_FOR_MISO = 4.50;
    public Miso(String size) {
        super(size);
    }

    public double getCostForRamen() {
        return COST_FOR_MISO;
    }
}
