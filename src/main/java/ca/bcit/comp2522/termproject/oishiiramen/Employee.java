package ca.bcit.comp2522.termproject.oishiiramen;

import java.util.Objects;

/**
 * Employee class.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public class Employee {
    /**
     * Hourly wage of level 1 employee.
     */
    public static final double LEVEL1_HOURLY_WAGE = 20; // do we need several levels?
    /**
     * Hourly wage of level 2 employee.
     */
    public static final double LEVEL2_HOURLY_WAGE = 25;
    /**
     * Hourly wage of level 3 employee.
     */
    public static final double LEVEL3_HOURLY_WAGE = 30;
    /**
     * Maximum level for employee.
     */
    public static final int MAX_LEVEL = 3;
    /**
     * Minimum level for employee.
     */
    public static final int MIN_LEVEL = 1;

    private static int totalEmployeeNumber = 0;
    private final int employeeID;
    private String name;
    private int level;
    private double hourlyWage;


    /**
     * Constructs an Employee object.
     *
     * @param name a String
     * @param level an int
     */
    public Employee(final String name, final int level) {
        // error handling
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

    /**
     * Returns the employeeID of the employee as an int.
     *
     * @return the employeeID of the employee as an int
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Returns the name of the employee as a String.
     *
     * @return the name of the employee as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the level of the employee as an int.
     *
     * @return the level of the employee as an int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns the hourly wage of the employee as a double.
     *
     * @return the hourly wage of the employee as a double
     */
    public double getHourlyWage() {
        return hourlyWage;
    }

    /**
     * Returns the number of total employees as an int.
     *
     * @return the number of total employees as an int
     */
    public static int getTotalEmployeeNumber() {
        return totalEmployeeNumber;
    }

    /**
     * Sets the new employee name if newName is valid.
     *
     * @param newName newName as a String
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Sets the new employee level.
     *
     * @param newLevel newName as an int
     */
    public void setLevel(final int newLevel) {
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

    /**
     * Evaluates if some other object if "equal" to this one.
     *
     * @param o the reference object with which to compare
     * @return true if this object is equal to the o argument; false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return getEmployeeID() == employee.getEmployeeID() && getLevel() == employee.getLevel() && Double.compare(getHourlyWage(), employee.getHourlyWage()) == 0 && Objects.equals(getName(), employee.getName());
    }

    /**
     * Returns a hash code of this object.
     *
     * @return description as a String
     */
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getName(), getLevel(), getHourlyWage());
    }

    /**
     * Returns a String representation of this object.
     *
     * @return description as a String
     */
    @Override
    public String toString() {
        return "Employee{"
                + "employeeID=" + employeeID
                + ", name='" + name + '\''
                + ", level=" + level
                + ", hourlyWage=" + hourlyWage
                + '}';
    }
}
