package ca.bcit.comp2522.termproject.oishiiramen;

/**
 * Tonkotsu class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Tonkotsu extends Menu {
    public static final double COST_FOR_TONKOTSU = 5.00;
    public Tonkotsu(String size) {
        super(size);
    }

    public double getCostForRamen() {
        return COST_FOR_TONKOTSU;
    }

}
