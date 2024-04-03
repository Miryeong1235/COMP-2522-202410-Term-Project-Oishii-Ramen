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
    private final String ownerName;
    private String location;
    private final ArrayList<Employee> employees;
    private int numberOfChair;
    private double rent;
    private int occupancyRateLower;
    private int occupancyRateUpper;
    private final ArrayList<Menu> menu;

    private double accumulatedCost;
    private double accumulatedSales;


    public Store(final String name, final String ownerName, final Location location, final int numberOfChair) {
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

        if (location == null) {
            throw new IllegalArgumentException("Invalid location value. Valid values are Downtown, Richmond, " +
                    "and Metrotown");
        }
        this.location = location.name();

        if (this.location.equals("Downtown")) {
            this.rent = DOWNTOWN_RENT;
        } else if (this.location.equals("Richmond")) {
            this.rent = RICHMOND_RENT;
        } else {
            this.rent = METROTOWN_RENT;
        }

        if (numberOfChair < MINIMUM_NUMBER_OF_CHAIR) {
            this.numberOfChair = MINIMUM_NUMBER_OF_CHAIR;
        } else this.numberOfChair = Math.min(numberOfChair, MAX_NUMBER_OF_CHAIR);

        this.menu = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public enum Location {
        Downtown,
        Richmond,
        Metrotown
    }

    public String getName() {
        return this.name;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getLocation() {
        return this.location;
    }

    public int getNumberOfChair() {
        return this.numberOfChair;
    }

    public double getRent() {
        return this.rent;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

//    public void event() {
//        pass;
//    }

    public void setName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("The store name cannot be null.");
        } else {
            this.name = newName.strip().substring(0, 1).toUpperCase()
                    + newName.strip().substring(1).toLowerCase();
        }
    }

    public void setLocation(Location newLocation) {
        if (newLocation == null) {
            throw new IllegalArgumentException("Invalid location value. Valid values are Downtown, Richmond, " +
                    "and Metrotown");
        }
        this.location = newLocation.name();

        // the rent will be changed as the location is changed
        if (this.location.equals("Downtown")) {
            this.rent = DOWNTOWN_RENT;
        } else if (this.location.equals("Richmond")) {
            this.rent = RICHMOND_RENT;
        } else {
            this.rent = METROTOWN_RENT;
        }
    }

    public void setNumberOfChair(int newNumberOfChair) {
        if (newNumberOfChair < MINIMUM_NUMBER_OF_CHAIR) {
            this.numberOfChair = MINIMUM_NUMBER_OF_CHAIR;
        } else this.numberOfChair = Math.min(newNumberOfChair, MAX_NUMBER_OF_CHAIR);
    }

    public boolean hireEmployee(Employee newEmployee) {
        if (newEmployee == null) {
            return false;
        } else {
            employees.add(newEmployee);
            return true;
        }
    }

    public boolean fireEmployee(Employee firedEmployee) {
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

    public boolean addMenu(Menu newMenu) {
        if (newMenu == null) {
            return false;
        } else {
            menu.add(newMenu);
            return true;
        }
    }

    public boolean removeMenu(Menu discontinueMenu) {
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
}
