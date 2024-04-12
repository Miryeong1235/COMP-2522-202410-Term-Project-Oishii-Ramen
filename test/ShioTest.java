import ca.bcit.comp2522.termproject.oishiiramen.Shio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static ca.bcit.comp2522.termproject.oishiiramen.Menu.RamenSize;
import static org.junit.jupiter.api.Assertions.*;

class ShioTest {
    private Shio testShio;

    @BeforeEach
    public void setUp() {
        testShio = new Shio(RamenSize.Large);
    }

    @Test
    public void containConstantCalledCOST_FOR_CHASHU() {
        assertEquals(0.5, Shio.COST_FOR_CHASHU);
    }

    @Test
    public void containConstantCalledCOST_FOR_CORN() {
        assertEquals(0.1, Shio.COST_FOR_CORN);
    }

    @Test
    public void containConstantCalledCOST_FOR_TAMAGO() {
        assertEquals(0.3, Shio.COST_FOR_TAMAGO);
    }

    @Test
    public void containConstantCalledCOST_FOR_SEAWEED() {
        assertEquals(0.1, Shio.COST_FOR_SEAWEED);
    }

    @Test
    public void containConstantCalledLARGE_SIZE_COEFFICIENT() {
        assertEquals(1.3, Shio.LARGE_SIZE_COEFFICIENT);
    }


    @Test
    public void staticCounterIsCorrectlyTrackingGetNumberOfMenu() {
        final int numberAlreadyCreated = Shio.getNumberOfMenu();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            new Shio(RamenSize.Large);
        }
        assertEquals(numberAlreadyCreated + numberCreated, Shio.getNumberOfMenu());
    }

//    @Test
//    public void ShioIsSetToCorrectValues() {
//        assertEquals(Shio.COST_FOR_Shio, testShio.getCostForRamen());
//        assertEquals(1, testShio.getMenuID());
//        assertEquals("Shio ramen", testShio.getName());
//        assertNull(testShio.getToppings());
//        assertEquals(RamenSize.Large, testShio.getSize());
//        assertEquals(0, testShio.getPrice());
//        assertEquals(Shio.COST_FOR_Shio * Menu.LARGE_SIZE_COEFFICIENT, testShio.getMaterialCost());
//
//    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Shio first = new Shio(RamenSize.Large);
        int firstID = first.getMenuID() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Shio Shio = new Shio(RamenSize.Large);
            assertEquals(firstID + i, Shio.getMenuID());
        }
    }

    @Test
    public void testSetNameValid() {
        testShio.setName("Taisho special");
        assertEquals("Taisho special", testShio.getName());
    }
    @Test
    public void testSetNameNull() {
        testShio.setName(null);
        assertEquals("Shio ramen", testShio.getName());
    }

    @Test
    public void testSetNameBlank() {
        testShio.setName("  ");
        assertEquals("Shio ramen", testShio.getName());
    }

    @Test
    public void testSetNameUpperCase() {
        testShio.setName("NEW RAMEN");
        assertEquals("New ramen", testShio.getName());
    }

    @Test
    public void testSetPriceValid() {
        testShio.setPrice(10.0);
        assertEquals(10.0, testShio.getPrice());
    }

    @Test
    public void testSetPriceNegative() {
        testShio.setPrice(-5.0);
        assertEquals(0, testShio.getPrice());
    }

    // set topping


    @Test
    public void testToString() {
        final String expected = "Menu{"
                + "costForRamen=5.2"
                + ", menuID=" + testShio.getMenuID()
                + ", name='Shio ramen'"
                + ", toppings=null"
                + ", size=Large"
                + ", price=0.0"
                + ", materialCost=5.2}";
        final String actual = testShio.toString();
        assertEquals(expected, actual);
    }
}
