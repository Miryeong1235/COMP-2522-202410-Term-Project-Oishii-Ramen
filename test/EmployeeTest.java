import ca.bcit.comp2522.termproject.oishiiramen.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private Employee testEmployee;

    @BeforeEach
    public void setUp() {
        Employee.resetTotalEmployeeNumber();
        testEmployee = new Employee(  "Taro", 1);
    }

    @Test
    public void containConstantCalledLEVEL_1_HOURLY_WAGE() {
        assertEquals(20.0, Employee.LEVEL1_HOURLY_WAGE);
    }

    @Test
    public void containConstantCalledLEVEL_2_HOURLY_WAGE() {
        assertEquals(25.0, Employee.LEVEL2_HOURLY_WAGE);
    }

    @Test
    public void containConstantCalledLEVEL_3_HOURLY_WAGE() {
        assertEquals(30.0, Employee.LEVEL3_HOURLY_WAGE);
    }

    @Test
    public void containConstantCalledMAX_LEVEL() {
        assertEquals(3, Employee.MAX_LEVEL);
    }

    @Test
    public void containConstantCalledMIN_LEVEL() {
        assertEquals(1, Employee.MIN_LEVEL);
    }

    @Test
    public void containConstantCalledDEFAULT_EMPLOYEE_NAME() {
        assertEquals("Kenta", Employee.DEFAULT_EMPLOYEE_NAME);
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
    public void employeeNameIsCorrectlyFormatted() {
        Employee newEmployee = new Employee("  jiRo    ", 2);
        assertEquals("Jiro", newEmployee.getName());
    }

    @Test
    public void nullNameThrownThenDefaultValueIsUsed() {
        Employee nullNameEmployee = new Employee(null, 2);
        assertEquals("Kenta", nullNameEmployee.getName());
    }

    @Test
    public void employeeLevelIsCorrectlySetIfItIsTooHigh() {
        Employee newEmployee = new Employee("Yusuke", 4);
        assertEquals(3, newEmployee.getLevel());
        assertEquals(30.0, newEmployee.getHourlyWage());
    }

    @Test
    public void employeeLevelIsCorrectlySetIfItIsTooLow() {
        Employee newEmployee = new Employee("Yusuke", 0);
        assertEquals(1, newEmployee.getLevel());
        assertEquals(20.0, newEmployee.getHourlyWage());
    }

    @Test
    public void testSetNameValid() {
        testEmployee.setName("Gojiro");
        assertEquals("Gojiro", testEmployee.getName());
    }
    @Test
    public void testSetNameNull() {
        testEmployee.setName(null);
        assertEquals("Taro", testEmployee.getName());
    }

    @Test
    public void testSetNameBlank() {
        testEmployee.setName("  ");
        assertEquals("Taro", testEmployee.getName());
    }

    @Test
    public void testSetLevelValid() {
        testEmployee.setLevel(3);
        assertEquals(3, testEmployee.getLevel());
        assertEquals(30.0, testEmployee.getHourlyWage());
    }

    @Test
    public void testSetLevelTooHigh() {
        testEmployee.setLevel(5);
        assertEquals(3, testEmployee.getLevel());
        assertEquals(30.0, testEmployee.getHourlyWage());
    }

    @Test
    public void testSetLevelTooLow() {
        testEmployee.setLevel(0);
        assertEquals(1, testEmployee.getLevel());
        assertEquals(20.0, testEmployee.getHourlyWage());
    }

    @Test
    public void testToString() {
        Employee newEmployee = new Employee("Sakura", 1);
        final int numberAlreadyCreated = Employee.getTotalEmployeeNumber();
        final String expected = "Employee{"
                + "employeeID=" + numberAlreadyCreated
                + ", name='Sakura'"
                + ", level=1"
                + ", hourlyWage=20.0}";
        final String actual = newEmployee.toString();
        assertEquals(expected, actual);
    }

}