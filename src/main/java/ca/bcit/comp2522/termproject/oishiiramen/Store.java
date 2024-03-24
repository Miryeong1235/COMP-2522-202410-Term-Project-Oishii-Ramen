package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.ArrayList;

public class Store {
    public static final double EVENT_GOOD_POSSIBILITY;
    public static final double EVENT_BAD_POSSIBILITY;
    public static final double DOWNTOWN_RENT;
    public static final double RICHMOND_RENT;
    public static final double METROTOWN_RENT;

    private double effectAmountGood;
    private double effectAmountBad;
    private String name;
    private String ownerName;
    private String location;
    private ArrayList<Employee> employees;
    private int numberOfChair;
    private double rent;
    private int occupancyRateLower;
    private int occupancyRateUpper;
    private ArrayList<Menu> menu;

    private double accumulatedCost;
    private double accumulatedSales;

    private Store(final String name, final String ownerName, final String location, final int numberOfChair) {

    }

}
