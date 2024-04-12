import ca.bcit.comp2522.termproject.oishiiramen.Employee;
import ca.bcit.comp2522.termproject.oishiiramen.Menu;
import ca.bcit.comp2522.termproject.oishiiramen.Store;
import ca.bcit.comp2522.termproject.oishiiramen.Tonkotsu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


public class StoreTest {
    private Store testStore;

    @BeforeEach
    public void setUp() {
        testStore = new Store("Ichiban", "Taichi", Store.Location.Downtown, 10);
    }

    @Test
    public void containConstantCalledDOWNTOWN_RENT() {
        assertEquals(10000.00, Store.DOWNTOWN_RENT);
    }

    @Test
    public void containConstantCalledRICHMOND_RENT() {
        assertEquals(9000.00, Store.RICHMOND_RENT);
    }

    @Test
    public void containConstantCalledMETROTOWN_RENTT() {
        assertEquals(8000.00, Store.METROTOWN_RENT);
    }

    @Test
    public void containConstantCalledOCCUPANCY_RATE_LOWER_DOWNTOWN() {
        assertEquals(0.5, Store.OCCUPANCY_RATE_LOWER_DOWNTOWN);
    }
    @Test
    public void containConstantCalledOCCUPANCY_RATE_UPPER_DOWNTOWN() {
        assertEquals(1.0, Store.OCCUPANCY_RATE_UPPER_DOWNTOWN);
    }

    @Test
    public void containConstantCalledOCCUPANCY_RATE_LOWER_RICHMOND() {
        assertEquals(0.3, Store.OCCUPANCY_RATE_LOWER_RICHMOND);
    }
    @Test
    public void containConstantCalledOCCUPANCY_RATE_UPPER_RICHMOND() {
        assertEquals(1.0, Store.OCCUPANCY_RATE_UPPER_RICHMOND);
    }

    @Test
    public void containConstantCalledOCCUPANCY_RATE_LOWER_METROTOWN() {
        assertEquals(0.4, Store.OCCUPANCY_RATE_LOWER_METROTOWN);
    }
    @Test
    public void containConstantCalledOCCUPANCY_RATE_UPPER_METROTOWN() {
        assertEquals(1.0, Store.OCCUPANCY_RATE_UPPER_METROTOWN);
    }

    @Test
    public void containConstantCalledMINIMUM_NUMBER_OF_CHAIR() {
        assertEquals(5, Store.MINIMUM_NUMBER_OF_CHAIR);
    }

    @Test
    public void containConstantCalledMAX_NUMBER_OF_CHAIRR() {
        assertEquals(30, Store.MAX_NUMBER_OF_CHAIR);
    }

    @Test
    public void containConstantCalledOPERATION_HOURS() {
        assertEquals(8, Store.OPERATION_HOURS);
    }

    @Test
    public void containConstantCalledDEFAULT_STORE_NAME() {
        assertEquals("Oishii ramen", Store.DEFAULT_STORE_NAME);
    }

    @Test
    public void containConstantCalledDEFAULT_OWNER_NAME() {
        assertEquals("Taisho", Store.DEFAULT_OWNER_NAME);
    }

    @Test
    public void storeIsSetToCorrectValues() {
        assertEquals("Ichiban", testStore.getName());
        assertEquals("Taichi", testStore.getOwnerName());
        assertEquals(Store.Location.Downtown, testStore.getLocation());
        assertEquals(10000.00, testStore.getRent());
        assertEquals(10, testStore.getNumberOfChair());
        assertEquals(0, testStore.getAccumulatedCost());
        assertEquals(0, testStore.getAccumulatedSales());
    }

    @Test
    public void storeNameAndOwnerNameAreCorrectlyFormatted() {
        Store newStore = new Store("  ichiBanYa    ", "  rOkI    ", Store.Location.Downtown, 10);
        assertEquals("Ichibanya", newStore.getName());
        assertEquals("Roki", newStore.getOwnerName());
    }

    @Test
    public void nullStoreNameThrownThenDefaultValueIsUsed() {
        Store newStore = new Store(null, "a", Store.Location.Downtown, 10);
        assertEquals("Oishii ramen", newStore.getName());
    }

    @Test
    public void emptyStoreNameThrownThenDefaultValueIsUsed() {
        Store newStore = new Store(" ", "a", Store.Location.Downtown, 10);
        assertEquals("Oishii ramen", newStore.getName());
    }

    @Test
    public void nullOwnerNameThrownThenDefaultValueIsUsed() {
        Store newStore = new Store("a", null, Store.Location.Downtown, 10);
        assertEquals("Taisho", newStore.getOwnerName());
    }

    @Test
    public void emptyOwnerNameThrownThenDefaultValueIsUsed() {
        Store newStore = new Store("a", "    ", Store.Location.Downtown, 10);
        assertEquals("Taisho", newStore.getOwnerName());
    }

    @Test
    public void lowNumberOfChairBecomesFive() {
        Store newStore = new Store("a", "b", Store.Location.Downtown, 4);
        assertEquals(5, newStore.getNumberOfChair());
    }

    @Test
    public void highNumberOfChairBecomesThirty() {
        Store newStore = new Store("a", "b", Store.Location.Downtown, 31);
        assertEquals(30, newStore.getNumberOfChair());
    }

    @Test
    public void testSetStoreNameValid() {
        testStore.setName("Hello world");
        assertEquals("Hello world", testStore.getName());
    }

    @Test
    public void testSetStoreNameNull() {
        testStore.setName(null);
        assertEquals("Ichiban", testStore.getName());
    }

    @Test
    public void testSetStoreNameBlank() {
        testStore.setName("    ");
        assertEquals("Ichiban", testStore.getName());
    }

    @Test
    public void testSetStoreLocationValid() {
        testStore.setLocation(Store.Location.Metrotown);
        assertEquals(Store.Location.Metrotown, testStore.getLocation());
        assertEquals(8000.00, testStore.getRent());
    }

    @Test
    public void testSetStoreLocationNullThenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> testStore.setLocation(null));
    }

    @Test
    public void testSetNumberOfChairValid() {
        testStore.setNumberOfChair(25);
        assertEquals(25, testStore.getNumberOfChair());
    }

    @Test
    public void testSetNumberOfChairTooLowBecomesMinimum() {
        testStore.setNumberOfChair(3);
        assertEquals(5, testStore.getNumberOfChair());
    }

    @Test
    public void testSetNumberOfChairTooHighBecomesMaximum() {
        testStore.setNumberOfChair(50);
        assertEquals(30, testStore.getNumberOfChair());
    }

    @Test
    public void testHireEmployeeCorrectly() {
        Employee newEmployee = new Employee("Toru", 2);
        testStore.hireEmployee(newEmployee);
        assertTrue(testStore.getEmployees().contains(newEmployee));
    }

    @Test
    public void testHireEmployeeWithNullThenNothingIsAdded() {
        testStore.hireEmployee(null);
        assertEquals(0, testStore.getEmployees().size());
    }

    @Test
    public void testFireEmployeeCorrectly() {
        Employee someEmployee = new Employee("Shota", 1);
        testStore.hireEmployee(someEmployee);
        assertTrue(testStore.fireEmployee(someEmployee));
    }

    @Test
    public void testAddMenuCorrectly() {
        Menu newMenu = new Tonkotsu(Menu.RamenSize.Medium);
        testStore.addMenu(newMenu);
        assertTrue(testStore.getMenu().contains(newMenu));
    }

    @Test
    public void testAddMenuWithNullThenNothingIsAdded() {
        testStore.addMenu(null);
        assertEquals(0, testStore.getEmployees().size());
    }

    @Test
    public void testRemoveMenuCorrectly() {
        Menu someMenu = new Tonkotsu(Menu.RamenSize.Medium);
        testStore.addMenu(someMenu);
        assertTrue(testStore.removeMenu(someMenu));
    }

    @Test
    public void testRunBusinessWIthValidDaysThenCostsAndSalesWillBeIncreased() {
        Menu someMenu = new Tonkotsu(Menu.RamenSize.Large);
        testStore.addMenu(someMenu);
        testStore.runBusiness(1);
        assertNotEquals(0, testStore.getAccumulatedCost());
        assertNotEquals(0, testStore.getAccumulatedSales());
    }

    @Test
    public void testRunBusinessForZeroDaysThenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> testStore.runBusiness(0));
    }



    @Test
    public void testToString() {
        Store newStore = new Store("Umai ramen", "Taiyo", Store.Location.Richmond, 15);
        final String expected = "Store{"
                + "name='Umai ramen'"
                + ", ownerName='Taiyo'"
                + ", location=" + "Richmond"
                + ", employees=[]"
                + ", numberOfChair=15"
                + ", rent=9000.0"
                + ", occupancyRateLower=0.3"
                + ", occupancyRateUpper=1.0"
                + ", menu=[]"
                + ", accumulatedCost=0.0"
                + ", accumulatedSales=0.0"
                + "}";
        final String actual = newStore.toString();
        assertEquals(expected, actual);
    }


}
