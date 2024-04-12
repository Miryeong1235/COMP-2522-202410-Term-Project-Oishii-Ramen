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
    public static final double COST_FOR_MISO = 5.50;

    /**
     * Default name for Miso ramen.
     */
    public static final String DEFAULT_NAME = "Miso ramen";

    /**
     * Constructs an object of Miso with a parameter.
     *
     * @param size as a RamenSize
     */
    public Miso(final RamenSize size) {
        super(size);
        this.name = DEFAULT_NAME;
    }

    /**
     * Returns a cost for a Miso ramen.
     * @return COST_FOR_MISO as a double
     */
    public double getCostForRamen() {
        return COST_FOR_MISO;
    }
}
