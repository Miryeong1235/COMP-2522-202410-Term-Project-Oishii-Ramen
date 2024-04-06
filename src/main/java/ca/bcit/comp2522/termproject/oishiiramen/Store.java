package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.ArrayList;
import java.util.Random;

public class Store {
    public static final double EVENT_GOOD_POSSIBILITY = 0.05;
    public static final double EVENT_BAD_POSSIBILITY = 0.04;
    public static final double DOWNTOWN_RENT = 10000.00;
    public static final double RICHMOND_RENT = 9000.00;
    public static final double METROTOWN_RENT = 8000.00;
    public static final int MINIMUM_NUMBER_OF_CHAIR = 5;
    public static final int MAX_NUMBER_OF_CHAIR = 30;
    public static final int OPERATION_HOURS = 8;

    private double effectAmountGood;
    private double effectAmountBad;
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

    Random random;

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
            this.occupancyRateLower = 0.8;
            this.occupancyRateUpper = 1.4;
        } else if (this.location.equals("Richmond")) {
            this.rent = RICHMOND_RENT;
            this.occupancyRateLower = 0.7;
            this.occupancyRateUpper = 1.3;
        } else {
            this.rent = METROTOWN_RENT;
            this.occupancyRateLower = 0.65;
            this.occupancyRateUpper = 1.2;
        }

        if (numberOfChair < MINIMUM_NUMBER_OF_CHAIR) {
            this.numberOfChair = MINIMUM_NUMBER_OF_CHAIR;
        } else this.numberOfChair = Math.min(numberOfChair, MAX_NUMBER_OF_CHAIR);

        this.menu = new ArrayList<>();
        this.employees = new ArrayList<>();

        this.accumulatedCost = 0;
        this.accumulatedSales = 0;

        random = new Random();
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

    public double getAccumulatedCost() {
        return this.accumulatedCost;
    }

    public double getAccumulatedSales() {
        return this.accumulatedSales;
    }

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
            this.occupancyRateLower = 0.8;
            this.occupancyRateUpper = 1.4;
        } else if (this.location.equals("Richmond")) {
            this.rent = RICHMOND_RENT;
            this.occupancyRateLower = 0.7;
            this.occupancyRateUpper = 1.3;
        } else {
            this.rent = METROTOWN_RENT;
            this.occupancyRateLower = 0.65;
            this.occupancyRateUpper = 1.2;
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


    private double calculateLabourCost(int days) {
        // calculate labour cost and sum it up
        double labourCost = 0.0;
        for (Employee employee : employees) {
            labourCost += employee.getHourlyWage() * OPERATION_HOURS * days;
        }
        return labourCost;
    }

    public double runBusiness(int days) {
        // calculate the sales and cost during the days
        double sales = 0.0;
        double cost = 0.0;

        cost += calculateLabourCost(days);

        // calculate rent
        if (location.equals("Downtown")) {
            cost += DOWNTOWN_RENT * days / 30;
        } else if (location.equals("Richmond")) {
            cost += RICHMOND_RENT * days / 30;
        } else {
            cost += METROTOWN_RENT * days / 30;
        }

        // 頼まれやすさ = orderRate
        double orderRate = 0.0;
        int numberOfMenu = menu.size();
        double sumOfPrice = 0;
        for (Menu ramen: menu ) {
            orderRate += 1/ramen.getPrice();
            sumOfPrice+= ramen.getPrice();
        }
        double averagePrice = sumOfPrice/numberOfMenu;

        //　set coefficient based on Average price
        double customerCoefficient = 1.0;
        if (averagePrice > 30) {
            customerCoefficient = 0.7;
        } else if (averagePrice > 25) {
            customerCoefficient = 0.8;
        }

        // calculate by days user want to run business for
        for (int i = 0; i < days; i++) {
            double occupancy = random.nextDouble(occupancyRateLower, occupancyRateUpper);
            // number of customers in a day
            int numberOfCustomers = (int) (occupancy * numberOfChair * OPERATION_HOURS * customerCoefficient);

            // 商品の価格平均によって稼働率を調整する

            // 各商品の頼まれやすさの割合＝頼まれやすさ / 頼まれやすさの合計
            // 頼まれやすさの合計は、「1/各メニューの価格」　の総和

            for (Menu ramen: menu) {
                sales += numberOfCustomers * ramen.getPrice() * ( 1 / ramen.getPrice() / orderRate);
                cost += numberOfCustomers * ramen.getMaterialCost() * ( 1 / ramen.getPrice() / orderRate);
            }
        }

        this.accumulatedCost += cost;
        this.accumulatedSales += sales;
        return sales-cost;
    }
}
