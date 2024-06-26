package ca.bcit.comp2522.termproject.oishiiramen;

/**
 * Shoyu class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Shoyu extends Menu {
    /**
     * Material cost for Shoyu ramen.
     */
    public static final double COST_FOR_SHOYU = 4.50;

    /**
     * Default name for Shoyu ramen.
     */
    public static final String DEFAULT_NAME = "Shoyu ramen";

    /**
     * Constructs an object of Shoyu with a parameter.
     *
     * @param size as a RamenSize
     */
    public Shoyu(final RamenSize size) {
        super(size);
        this.name = DEFAULT_NAME;
    }

    /**
     * Returns a cost for a Shoyu ramen.
     *
     * @return COST_FOR_SHOYU as a double
     */
    public double getCostForRamen() {
        return COST_FOR_SHOYU;
    }
}
