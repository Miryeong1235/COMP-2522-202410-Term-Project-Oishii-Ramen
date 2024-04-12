package ca.bcit.comp2522.termproject.oishiiramen;

/**
 * Employee management interface.
 *
 * @author Atsuko Uemura, Misuzu Taniguchi
 * @version 12-April-2024
 */
public interface EmployeeManagement {
    /**
     * Hires a employee.
     * @param newEmployee as an Employee object
     */
    void hireEmployee(Employee newEmployee);

    /**
     * Fires a employee.
     * @param someEmployee as an Employee object
     * @return true if the employee was fired.
     */
    boolean fireEmployee(Employee someEmployee);
}

