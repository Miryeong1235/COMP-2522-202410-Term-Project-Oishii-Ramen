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
    public static final double COST_FOR_TONKOTSU = 5.50;

    /**
     * Default name for Tonkotsu ramen.
     */
    public static final String DEFAULT_NAME = "Tonkotsu ramen";

    /**
     * Constructs an object of Tonkotsu with a parameter.
     *
     * @param size as a RamenSize
     */
    public Tonkotsu(final RamenSize size) {
        super(size);
        this.name = DEFAULT_NAME;
    }

    /**
     * Returns a cost for the menu.
     *
     * @return costForRamen as a double
     */
    public double getCostForRamen() {
        return COST_FOR_TONKOTSU;
    }
}
