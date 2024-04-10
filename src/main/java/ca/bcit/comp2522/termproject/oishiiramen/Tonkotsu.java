package ca.bcit.comp2522.termproject.oishiiramen;

/**
 * Tonkotsu class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Tonkotsu extends Menu {
    /**
     * Material cost for Tonkotsu ramen.
     */
    public static final double COST_FOR_TONKOTSU = 5.00;

    /**
     * Constructs an object of Miso with a parameter.
     *
     * @param size as a String
     */
    public Tonkotsu(final RamenSize size) {
        super(size);
    }


    /**
     * Returns a cost for a Tonkotsu ramen.
     * @return COST_FOR_TONKOTSU as a double
     */
    public double getCostForRamen() {
        return COST_FOR_TONKOTSU;
    }
}
