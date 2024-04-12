import ca.bcit.comp2522.termproject.oishiiramen.Menu;
import ca.bcit.comp2522.termproject.oishiiramen.Miso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static ca.bcit.comp2522.termproject.oishiiramen.Menu.RamenSize;
import static org.junit.jupiter.api.Assertions.*;

class MisoTest {
    private Miso testMiso;

    @BeforeEach
    public void setUp() {
        Menu.resetNumberOfMenu();
        testMiso = new Miso(RamenSize.Large);
    }

    @Test
    public void containConstantCalledCOST_FOR_CHASHU() {
        assertEquals(0.5, Miso.COST_FOR_CHASHU);
    }

    @Test
    public void containConstantCalledCOST_FOR_CORN() {
        assertEquals(0.1, Miso.COST_FOR_CORN);
    }

    @Test
    public void containConstantCalledCOST_FOR_TAMAGO() {
        assertEquals(0.3, Miso.COST_FOR_TAMAGO);
    }

    @Test
    public void containConstantCalledCOST_FOR_SEAWEED() {
        assertEquals(0.1, Miso.COST_FOR_SEAWEED);
    }

    @Test
    public void containConstantCalledLARGE_SIZE_COEFFICIENT() {
        assertEquals(1.3, Miso.LARGE_SIZE_COEFFICIENT);
    }


    @Test
    public void staticCounterIsCorrectlyTrackingGetNumberOfMenu() {
        final int numberAlreadyCreated = Miso.getNumberOfMenu();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            new Miso(RamenSize.Large);
        }
        assertEquals(numberAlreadyCreated + numberCreated, Miso.getNumberOfMenu());
    }

    @Test
    public void MisoIsSetToCorrectValues() {
        assertEquals(Miso.COST_FOR_MISO, testMiso.getCostForRamen());
        assertEquals(1, testMiso.getMenuID());
        assertEquals("Miso ramen", testMiso.getName());
        assertNull(testMiso.getToppings());
        assertEquals(RamenSize.Large, testMiso.getSize());
        assertEquals(0, testMiso.getPrice());
        assertEquals(Miso.COST_FOR_MISO * Menu.LARGE_SIZE_COEFFICIENT, testMiso.getMaterialCost());
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Miso first = new Miso(RamenSize.Large);
        int firstID = first.getMenuID() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Miso Miso = new Miso(RamenSize.Large);
            assertEquals(firstID + i, Miso.getMenuID());
        }
    }

    // set name
    @Test
    public void testSetNameValid() {
        testMiso.setName("Taisho special");
        assertEquals("Taisho special", testMiso.getName());
    }
    @Test
    public void testSetNameNull() {
        testMiso.setName(null);
        assertEquals("Miso ramen", testMiso.getName());
    }

    @Test
    public void testSetNameBlank() {
        testMiso.setName("  ");
        assertEquals("Miso ramen", testMiso.getName());
    }

    @Test
    public void testSetNameUpperCase() {
        testMiso.setName("NEW RAMEN");
        assertEquals("New ramen", testMiso.getName());
    }

    // set price
    @Test
    public void testSetPriceValid() {
        testMiso.setPrice(10.0);
        assertEquals(10.0, testMiso.getPrice());
    }

    @Test
    public void testSetPriceNegative() {
        testMiso.setPrice(-5.0);
        assertEquals(testMiso.getMaterialCost(), testMiso.getPrice());
    }

    // set topping
    @Test
    public void testSetToppingValid() {
        ArrayList<Menu.Topping> newToppings = new ArrayList<>();
        newToppings.add(Menu.Topping.corn);
        newToppings.add(Menu.Topping.chashu);
        testMiso.setToppings(newToppings);
        assertTrue(testMiso.getToppings().contains(Menu.Topping.corn));
        assertTrue(testMiso.getToppings().contains(Menu.Topping.chashu));
    }

    @Test
    public void testSetToppingNull() {
        ArrayList<Menu.Topping> newToppings = new ArrayList<>();
        testMiso.setToppings(newToppings);
        assertTrue(testMiso.getToppings().isEmpty());
    }

    @Test
    public void testToString() {
        final String expected = "Menu{"
                + "costForRamen=7.15"
                + ", menuID=1"
                + ", name='Miso ramen'"
                + ", toppings=null"
                + ", size=Large"
                + ", price=0.0"
                + ", materialCost=7.15}";
        final String actual = testMiso.toString();
        assertEquals(expected, actual);
    }
}
