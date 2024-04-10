import ca.bcit.comp2522.termproject.oishiiramen.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private Employee testEmployee;

    @BeforeEach
    public void setUp() {
        testEmployee = new Employee(  "Taro", 1);                ;
    }

    @Test
    public void containConstantCalledLEVEL_1_HOURLY_WAGE() {
        assertEquals(20, Employee.LEVEL1_HOURLY_WAGE);
    }

    @Test
    public void staticEmployeeCounterIsCorrectlyTrackingNumberOfEmployee() {
        final int numberAlreadyCreated = Employee.getTotalEmployeeNumber();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            new Employee("Hanako", 1);
        }
        assertEquals(numberAlreadyCreated + numberCreated, Employee.getTotalEmployeeNumber());
    }

    @Test
    public void employeeIsSetToCorrectValues() {
        assertEquals("Taro", testEmployee.getName());
        assertEquals(1, testEmployee.getLevel());
        assertEquals(20, testEmployee.getHourlyWage());
        assertEquals(1, testEmployee.getEmployeeID());
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Employee first = new Employee("Ichiro", 1);
        int firstID = first.getEmployeeID() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Employee employee = new Employee("Shohei", 3);
            assertEquals(firstID + i, employee.getEmployeeID());
        }
    }

    @Test
    public void genusAndSpeciesAreCorrectlyFormattedAndStored() {
        Employee newEmployee = new Employee("  jiro    ", 5
);
        assertEquals("Jiro", newEmployee.getName());
        assertEquals(3, newEmployee.getLevel());
    }

//    @Test
//    public void nullSpeciesThrowsIllegalArgumentException() {
//        // check if default value is used when null
//        assertThrows(IllegalArgumentException.class, () -> new Guppy("a", null, 0, true, 0 , 0.5));
//    }
//
//    @Test
//    public void negativeAgeInWeeksBecomesZero() {
//        // the level is not valid (0, 4)
//        Guppy fry = new Guppy("a",
//                "b",
//                -1,
//                true,
//                0 ,
//                0.5);
//        assertEquals(0, fry.getAgeInWeeks());
//    }
//
//
//
//    public void setName(final String newName) {
//        this.name = newName;
//    }
//    // null, valid, blank
//
//    public void setLevel(final int newLevel) {
//        if (newLevel >= MIN_LEVEL && newLevel <= MAX_LEVEL) {
//            this.level = newLevel;
//        } else if (newLevel < MIN_LEVEL) {
//            this.level = MIN_LEVEL;
//        } else {
//            this.level = MAX_LEVEL;
//        }
//        setHourlyWage();
//    }
//    // valid value, 0, 4
//
//    // toString test

}