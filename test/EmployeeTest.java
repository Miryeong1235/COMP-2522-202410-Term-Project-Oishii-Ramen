import ca.bcit.comp2522.termproject.oishiiramen.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void zeroParamGuppyIsSetToCorrectValues() {
        Employee employee = new Employee("John", 2);
        assertEquals(1, employee.getEmployeeID());
        assertEquals("John", employee.getName());
        assertEquals(2, employee.getLevel());
        assertEquals(25.0, employee.getHourlyWage());
    }
}