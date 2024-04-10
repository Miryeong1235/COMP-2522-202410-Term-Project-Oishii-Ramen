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
    public void multiParamGuppyIsSetToCorrectValues() {
        assertEquals("Poecilia", testGuppy.getGenus());
        assertEquals("reticulata", testGuppy.getSpecies());
        assertEquals(1, testGuppy.getAgeInWeeks());
        assertTrue(testGuppy.getIsFemale());
        assertEquals(3, testGuppy.getGenerationNumber());
        assertTrue(testGuppy.getIsAlive());
        assertEquals(0.75, testGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Guppy first = new Guppy();
        int firstID = first.getIdentificationNumber() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Guppy fry = new Guppy("Poecilia",
                    "reticulata",
                    1,
                    true,
                    3,
                    0.75);
            assertEquals(firstID + i, fry.getIdentificationNumber());
        }
    }

    @Test
    public void genusAndSpeciesAreCorrectlyFormattedAndStored() {
        Guppy fry = new Guppy("  poECILIA    ",
                "  retICUlata   ",
                1,
                true,
                3,
                0.75);
        assertEquals("Poecilia", fry.getGenus());
        assertEquals("reticulata", fry.getSpecies());
    }

    @Test
    public void nullSpeciesThrowsIllegalArgumentException() {
        // check if default value is used when null
        assertThrows(IllegalArgumentException.class, () -> new Guppy("a", null, 0, true, 0 , 0.5));
    }

    @Test
    public void negativeAgeInWeeksBecomesZero() {
        // the level is not valid (0, 4)
        Guppy fry = new Guppy("a",
                "b",
                -1,
                true,
                0 ,
                0.5);
        assertEquals(0, fry.getAgeInWeeks());
    }



    public void setName(final String newName) {
        this.name = newName;
    }
    // null, valid, blank

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
    // valid value, 0, 4

    // toString test

}