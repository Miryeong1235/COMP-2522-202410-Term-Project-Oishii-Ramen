package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.ArrayList;
import java.util.Random;

/**
 * Store class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Store {

    /**
     * Monthly Downtown rent.
     */
    public static final double DOWNTOWN_RENT = 10000.00;

    /**
     * Monthly Richmond rent.
     */
    public static final double RICHMOND_RENT = 9000.00;

    /**
     * Monthly Metrotown rent.
     */
    public static final double METROTOWN_RENT = 8000.00;

    /**
     * Lower bound of occupancy rate for Downtown.
     */
    public static final double OCCUPANCY_RATE_LOWER_DOWNTOWN = 0.8;

    /**
     * Upper bound of occupancy rate for Downtown.
     */
    public static final double OCCUPANCY_RATE_UPPER_DOWNTOWN = 1.4;

    /**
     * Lower bound of occupancy rate for Richmond.
     */
    public static final double OCCUPANCY_RATE_LOWER_RICHMOND = 0.7;

    /**
     * Upper bound of occupancy rate for Richmond.
     */
    public static final double OCCUPANCY_RATE_UPPER_RICHMOND = 1.3;

    /**
     * Lower bound of occupancy rate for Metrotown.
     */
    public static final double OCCUPANCY_RATE_LOWER_METROTOWN = 0.65;

    /**
     * Upper bound of occupancy rate for Metrotown.
     */
    public static final double OCCUPANCY_RATE_UPPER_METROTOWN = 1.2;
    /**
     * Minimum number of chair.
     */
    public static final int MINIMUM_NUMBER_OF_CHAIR = 5;

    /**
     * Maximum number of chair.
     */
    public static final int MAX_NUMBER_OF_CHAIR = 30;

    /**
     * Operation hours.
     */
    public static final int OPERATION_HOURS = 8;

    /**
     * Default store name.
     */
    public static final String DEFAULT_STORE_NAME = "Oishii ramen";

    /**
     * Default store owner name.
     */
    public static final String DEFAULT_OWNER_NAME = "Taisho";
    private String name;
    private final String ownerName;
    private String location;
    private final ArrayList<Employee> employees;
    private int numberOfChair;
    private double rent;
    private double occupancyRateLower;
    private double occupancyRateUpper;
    private final ArrayList<Menu> menu;

    private double accumulatedCost;
    private double accumulatedSales;

    private final Random random;

    /**
     * Constructs a Store object.
     *
     * @param name a String
     * @param ownerName a String
     * @param location a Location
     * @param numberOfChair an int
     * @throws IllegalArgumentException if the location is null
     */
    public Store(final String name, final String ownerName, final Location location, final int numberOfChair) {
        if (name == null || name.isBlank()) {
            this.name = DEFAULT_STORE_NAME;
        } else {
            this.name = name.strip().substring(0, 1).toUpperCase() + name.strip().substring(1).toLowerCase();
        }

        if (ownerName == null || ownerName.isBlank()) {
            this.ownerName = DEFAULT_OWNER_NAME;
        } else {
            this.ownerName = ownerName.strip().toLowerCase();
        }

        if (location == null) {
            throw new IllegalArgumentException("Invalid location value. Valid values are Downtown, Richmond, "
                    + "and Metrotown");
        }
        this.location = location.name();

        if (this.location.equals("Downtown")) {
            this.rent = DOWNTOWN_RENT;
            this.occupancyRateLower = OCCUPANCY_RATE_LOWER_DOWNTOWN;
            this.occupancyRateUpper = OCCUPANCY_RATE_UPPER_DOWNTOWN;
        } else if (this.location.equals("Richmond")) {
            this.rent = RICHMOND_RENT;
            this.occupancyRateLower = OCCUPANCY_RATE_LOWER_RICHMOND;
            this.occupancyRateUpper = OCCUPANCY_RATE_UPPER_RICHMOND;
        } else {
            this.rent = METROTOWN_RENT;
            this.occupancyRateLower = OCCUPANCY_RATE_LOWER_METROTOWN;
            this.occupancyRateUpper = OCCUPANCY_RATE_UPPER_METROTOWN;
        }

        if (numberOfChair < MINIMUM_NUMBER_OF_CHAIR) {
            this.numberOfChair = MINIMUM_NUMBER_OF_CHAIR;
        } else {
            this.numberOfChair = Math.min(numberOfChair, MAX_NUMBER_OF_CHAIR);
        }

        this.menu = new ArrayList<>();
        this.employees = new ArrayList<>();

        this.accumulatedCost = 0;
        this.accumulatedSales = 0;

        random = new Random();
    }

    /**
     * The Location enum represents the possible locations where a store can be situated.
     * It provides three options: Downtown, Richmond, and Metrotown.
     */
    public enum Location {
        Downtown,
        Richmond,
        Metrotown
    }

    /**
     * Returns the name of this store as a String.
     *
     * @return the name of this store as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the name of the store owner as a String.
     *
     * @return the name of the store owner as a String
     */
    public String getOwnerName() {
        return this.ownerName;
    }

    /**
     * Returns the location of the store as a Location.
     *
     * @return the location of the store as a Location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Returns the number of the chair in the store as an int.
     *
     * @return the number of the chair in the store as an int
     */
    public int getNumberOfChair() {
        return this.numberOfChair;
    }

    /**
     * Returns the rent of the store as a double.
     *
     * @return the rent of the store as a double
     */
    public double getRent() {
        return this.rent;
    }

    /**
     * Returns the list of employees working at the store as an ArrayList.
     *
     * @return the list of employees working at the store as an ArrayList
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Returns the list of menu of the store as an ArrayList.
     *
     * @return the list of menu of the store as an ArrayList
     */
    public ArrayList<Menu> getMenu() {
        return menu;
    }

    /**
     * Returns the accumulated cost of the store as a double.
     *
     * @return the accumulated cost of the store as a double
     */
    public double getAccumulatedCost() {
        return this.accumulatedCost;
    }

    /**
     * Returns the accumulated sales of the store as a double.
     *
     * @return the accumulated sales of the store as a double
     */
    public double getAccumulatedSales() {
        return this.accumulatedSales;
    }

    /**
     * Returns the accumulated revenue of the store as a double.
     *
     * @return the accumulated revenue of the store as a double
     */
    public double getAccumulatedRevenue() {
        return this.accumulatedSales - this.accumulatedCost;
    }

    /**
     * Sets the new store name if newName is valid.
     *
     * @param newName newName as a String
     */
    public void setName(final String newName) {
        if (newName != null && !newName.isBlank()) {
            this.name = newName.strip().substring(0, 1).toUpperCase()
                    + newName.strip().substring(1).toLowerCase();
        }
    }

    /**
     * Sets the new location if newLocation is valid.
     *
     * @param newLocation newLocation as a Location
     * @throws IllegalArgumentException if newLocation is null
     */
    public void setLocation(final Location newLocation) {
        if (newLocation == null) {
            throw new IllegalArgumentException("Invalid location value. Valid values are Downtown, Richmond, "
                    + "and Metrotown");
        }
        this.location = newLocation.name();

        // the rent will be changed as the location is changed
        if (this.location.equals("Downtown")) {
            this.rent = DOWNTOWN_RENT;
            this.occupancyRateLower = OCCUPANCY_RATE_LOWER_DOWNTOWN;
            this.occupancyRateUpper = OCCUPANCY_RATE_UPPER_DOWNTOWN;
        } else if (this.location.equals("Richmond")) {
            this.rent = RICHMOND_RENT;
            this.occupancyRateLower = OCCUPANCY_RATE_LOWER_RICHMOND;
            this.occupancyRateUpper = OCCUPANCY_RATE_UPPER_RICHMOND;
        } else {
            this.rent = METROTOWN_RENT;
            this.occupancyRateLower = OCCUPANCY_RATE_LOWER_METROTOWN;
            this.occupancyRateUpper = OCCUPANCY_RATE_UPPER_METROTOWN;
        }
    }

    /**
     * Sets the new number of chair if newNumberOfChair is valid.
     * Ensures that the new number of chair stays within the valid range.
     *
     * @param newNumberOfChair newNumberOfChair as an int
     */
    public void setNumberOfChair(final int newNumberOfChair) {
        if (newNumberOfChair < MINIMUM_NUMBER_OF_CHAIR) {
            this.numberOfChair = MINIMUM_NUMBER_OF_CHAIR;
        } else {
            this.numberOfChair = Math.min(newNumberOfChair, MAX_NUMBER_OF_CHAIR);
        }
    }

    /**
     * Adds a fish to the pool.
     *
     * @param newEmployee the employee to be added to the Store as an Employee.
     * @return True if the employee was added successfully, false if the input fish is null.
     */
    public boolean hireEmployee(final Employee newEmployee) {
        if (newEmployee == null) {
            return false;
        } else {
            employees.add(newEmployee);
            return true;
        }
    }

    /**
     * Removes employee from the Store.
     *
     * @param firedEmployee the employee to be removed from the Store as an Employee.
     * @return True if the employee was removed successfully, false if the input employee is null.
     */
    public boolean fireEmployee(final Employee firedEmployee) {
        if (firedEmployee != null) {
            for (Employee currentEmployee : employees) {
                if (currentEmployee.equals(firedEmployee)) {
                    employees.remove(currentEmployee);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Adds a menu to the Store.
     *
     * @param newMenu the menu to be added to the Store as a Menu.
     * @throws IllegalArgumentException if newMenu is null
     */
    public void addMenu(final Menu newMenu) {
        if (newMenu == null) {
            throw new IllegalArgumentException("Menu was not inputted.");
        } else {
            menu.add(newMenu);
        }
    }

    /**
     * Removes menu from the Menu.
     *
     * @param discontinueMenu the menu to be removed from the Store as a Menu.
     * @return True if the menu was removed successfully, false if the input menu is null.
     */
    public boolean removeMenu(final Menu discontinueMenu) {
        if (discontinueMenu != null) {
            for (Menu currentMenu : menu) {
                if (currentMenu.equals(discontinueMenu)) {
                    menu.remove(currentMenu);
                    return true;
                }
            }
        }
        return false;
    }
    private double calculateLabourCost(final int days) {

        double labourCost = 0.0;
        for (Employee employee : employees) {
            labourCost += employee.getHourlyWage() * OPERATION_HOURS * days;
        }
        return labourCost;
    }
    private double calculateRent(final int days) {
        double rentForDays = 0.0;
        final int daysPerMonth = 30;
        if (location.equals("Downtown")) {
            rentForDays += DOWNTOWN_RENT * days / daysPerMonth;
        } else if (location.equals("Richmond")) {
            rentForDays += RICHMOND_RENT * days / daysPerMonth;
        } else {
            rentForDays += METROTOWN_RENT * days / daysPerMonth;
        }
        return rentForDays;
    }

    private double setCustomerCoefficient(final double averagePrice) {
        double customerCoefficient = 1.0;
        final int expensiveAveragePrice = 30;
        final int moderateAveragePrice = 25;
        final double expensiveAveragePriceCoefficient = 0.7;
        final double moderateAveragePriceCoefficient = 0.8;
        if (averagePrice > expensiveAveragePrice) {
            customerCoefficient = expensiveAveragePriceCoefficient;
        } else if (averagePrice > moderateAveragePrice) {
            customerCoefficient = moderateAveragePriceCoefficient;
        }
        return customerCoefficient;
    }

    /**
     * Runs the business for the specified number of days.
     *
     * @param days the number of days the business will be run for
     * @return the profit of the store during the specified number of days as a double
     */
    public double runBusiness(final int days) {
        // calculate the sales and cost during the days
        double sales = 0.0;
        double cost = 0.0;

        // calculate labour cost and sum it up
        cost += calculateLabourCost(days);

        // calculate rent
        cost += calculateRent(days);

        // calculate sum of orderRate
        double orderRateSum = 0.0;
        double sumOfPrice = 0; // to get average to calculate coefficient
        for (Menu ramen: menu) {
            orderRateSum += 1 / ramen.getPrice();
            sumOfPrice += ramen.getPrice();
        }

        //　set coefficient based on Average price
        double averagePrice = sumOfPrice / menu.size();
        double customerCoefficient = setCustomerCoefficient(averagePrice);

        // calculate by days user want to run business for
        for (int i = 0; i < days; i++) {
            double occupancy = random.nextDouble(occupancyRateLower, occupancyRateUpper);
            // number of customers in a day
            int numberOfCustomers = (int) (occupancy * numberOfChair * OPERATION_HOURS * customerCoefficient);

            // Adjust the rate of order based on the average price
            // The rate for order for each ramen ＝ (1 / each menu's price) / orderRateSum
            for (Menu ramen: menu) {
                double orderRateForEachRamen = 1 / ramen.getPrice() / orderRateSum;
                sales += numberOfCustomers * ramen.getPrice() * orderRateForEachRamen;
                cost += numberOfCustomers * ramen.getMaterialCost() * orderRateForEachRamen;
            }
        }
        this.accumulatedCost += cost;
        this.accumulatedSales += sales;

        // return the profit, which is the difference of sales and cost
        return sales - cost;
    }
}
