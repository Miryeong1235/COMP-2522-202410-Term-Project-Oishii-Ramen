package ca.bcit.comp2522.termproject.oishiiramen;

/**
 * Miso class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Miso extends Menu {
    /**
     * Material cost for Miso ramen.
     */
    public static final double COST_FOR_MISO = 4.50;

    /**
     * Constructs an object of Miso with a parameter.
     *
     * @param size as a String
     */
    public Miso(final String size) {
        super(size);
    }

    /**
     * Returns a cost for a Miso ramen.
     * @return COST_FOR_MISO as a double
     */
    public double getCostForRamen() {
        return COST_FOR_MISO;
    }
}
