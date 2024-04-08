package ca.bcit.comp2522.termproject.oishiiramen;

/**
 * Shio class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Shio extends Menu{
    public static final double COST_FOR_SHIO = 3.00;
    public Shio(String size) {
        super(size);
    }

    public double getCostForRamen() {
        return COST_FOR_SHIO;
    }
}
