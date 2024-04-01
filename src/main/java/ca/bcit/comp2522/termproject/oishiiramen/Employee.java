package ca.bcit.comp2522.termproject.oishiiramen;

public class Employee {
    public final double LEVEL1_HOURLY_WAGE = 20; // do we need several levels?
    public final double LEVEL2_HOURLY_WAGE = 25;
    public final double LEVEL3_HOURLY_WAGE = 30;

    private int employeeID;
    private String name;
    private int level;
    private double hourlyWage;

    static int totalEmployeeNumber;

    public Employee(final String name, final int level) {
        this.name = name;
        this.level = level;
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
        this.name = name;
    }

    public void setLevel(int newLevel) {
        if (level >= 1 && level <= 3) {
            this.level = newLevel;
            if (this.level == 1) {
                this.hourlyWage = LEVEL1_HOURLY_WAGE;
            } else if (this.level == 2) {
                this.hourlyWage = LEVEL2_HOURLY_WAGE;
            } else {
                this.hourlyWage = LEVEL3_HOURLY_WAGE;
            }
        }
    }

}
