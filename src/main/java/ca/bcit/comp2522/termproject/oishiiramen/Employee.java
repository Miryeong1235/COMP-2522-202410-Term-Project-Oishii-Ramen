package ca.bcit.comp2522.termproject.oishiiramen;

public class Employee {
    public final double LEVEL1_HOURLY_WAGE = 20; // do we need several levels?
    public final double LEVEL2_HOURLY_WAGE = 25;
    public final double LEVEL3_HOURLY_WAGE = 30;
    public final int MAX_LEVEL = 3;
    public final int MIN_LEVEL = 1;

    private final int employeeID;
    private String name;
    private int level;
    private double hourlyWage;

    static int totalEmployeeNumber;

    public Employee(final String name, final int level) {
        this.name = name;
        this.level = level;
        if (this.level == 1) {
            this.hourlyWage = LEVEL1_HOURLY_WAGE;
        } else if (this.level == 2) {
            this.hourlyWage = LEVEL2_HOURLY_WAGE;
        } else {
            this.hourlyWage = LEVEL3_HOURLY_WAGE;
        }
        totalEmployeeNumber++;
        this.employeeID = totalEmployeeNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public static int getTotalEmployeeNumber() {
        return totalEmployeeNumber;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setLevel(int newLevel) {
        if (newLevel >= MIN_LEVEL && newLevel <= MAX_LEVEL) {
            this.level = newLevel;
        } else if (newLevel < MIN_LEVEL) {
            this.level = MIN_LEVEL;
        } else {
            this.level = MAX_LEVEL;
        }
        setHourlyWage();
    }

    private void setHourlyWage() {
        if (this.level == 1) {
            this.hourlyWage = LEVEL1_HOURLY_WAGE;
        } else if (this.level == 2) {
            this.hourlyWage = LEVEL2_HOURLY_WAGE;
        } else {
            this.hourlyWage = LEVEL3_HOURLY_WAGE;
        }
    }

}
