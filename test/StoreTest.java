import ca.bcit.comp2522.termproject.oishiiramen.Employee;
import ca.bcit.comp2522.termproject.oishiiramen.Store;
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


}
