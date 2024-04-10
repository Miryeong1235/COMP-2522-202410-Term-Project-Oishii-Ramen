package ca.bcit.comp2522.termproject.oishiiramen;

/**
 * Shio class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Shio extends Menu {

    /**
     * Material cost for Shio ramen.
     */
    public static final double COST_FOR_SHIO = 4.00;

    /**
     * Constructs an object of Shio with a parameter.
     *
     * @param size as a String
     */
    public Shio(final RamenSize size) {
        super(size);
    }

    /**
     * Returns a cost for a Shio ramen.
     *
     * @return COST_FOR_SHIO as a double
     */
    public double getCostForRamen() {
        return COST_FOR_SHIO;
    }
}
