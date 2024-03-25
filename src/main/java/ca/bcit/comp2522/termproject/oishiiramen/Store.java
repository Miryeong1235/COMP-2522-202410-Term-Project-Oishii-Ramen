package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.ArrayList;

public class Store {
    public static final double EVENT_GOOD_POSSIBILITY = 0.05;
    public static final double EVENT_BAD_POSSIBILITY = 0.04;
    public static final double DOWNTOWN_RENT = 10000.00;
    public static final double RICHMOND_RENT = 9000.00;
    public static final double METROTOWN_RENT = 8000.00;
    public static final int MINIMUM_NUMBER_OF_CHAIR = 5;
    public static final int MAX_NUMBER_OF_CHAIR = 30;

    private double effectAmountGood;
    private double effectAmountBad;
    private String name;
    private String ownerName;
    private String location;
//    private ArrayList<Employee> employees;
    private int numberOfChair;
    private double rent;
    private int occupancyRateLower;
    private int occupancyRateUpper;
    private ArrayList<Menu> menu;

    private double accumulatedCost;
    private double accumulatedSales;

    private Store(final String name, final String ownerName, final String location, final int numberOfChair) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The store name cannot be null.");
        } else {
            this.name = name.strip().substring(0, 1).toUpperCase()
                    + name.strip().substring(1).toLowerCase();
        }

        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("The owner name cannot be null.");
        } else {
            this.ownerName = ownerName.strip().toLowerCase();
        }

        this.location = location;

        if (numberOfChair < MINIMUM_NUMBER_OF_CHAIR) {
            this.numberOfChair = MINIMUM_NUMBER_OF_CHAIR;
        } else this.numberOfChair = Math.min(numberOfChair, MAX_NUMBER_OF_CHAIR);
    }

}
