import ca.bcit.comp2522.termproject.oishiiramen.Menu;
import ca.bcit.comp2522.termproject.oishiiramen.Tonkotsu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static ca.bcit.comp2522.termproject.oishiiramen.Menu.RamenSize;
import static org.junit.jupiter.api.Assertions.*;

class TonkotsuTest {
    private Tonkotsu testTonkotsu;

    @BeforeEach
    public void setUp() {
        Menu.resetNumberOfMenu();
        testTonkotsu = new Tonkotsu(RamenSize.Large);
    }

    @Test
    public void containConstantCalledCOST_FOR_CHASHU() {
        assertEquals(0.5, Tonkotsu.COST_FOR_CHASHU);
    }

    @Test
    public void containConstantCalledCOST_FOR_CORN() {
        assertEquals(0.1, Tonkotsu.COST_FOR_CORN);
    }

    @Test
    public void containConstantCalledCOST_FOR_TAMAGO() {
        assertEquals(0.3, Tonkotsu.COST_FOR_TAMAGO);
    }

    @Test
    public void containConstantCalledCOST_FOR_SEAWEED() {
        assertEquals(0.1, Tonkotsu.COST_FOR_SEAWEED);
    }

    @Test
    public void containConstantCalledLARGE_SIZE_COEFFICIENT() {
        assertEquals(1.3, Tonkotsu.LARGE_SIZE_COEFFICIENT);
    }


    @Test
    public void staticCounterIsCorrectlyTrackingGetNumberOfMenu() {
        final int numberAlreadyCreated = Tonkotsu.getNumberOfMenu();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            new Tonkotsu(RamenSize.Large);
        }
        assertEquals(numberAlreadyCreated + numberCreated, Tonkotsu.getNumberOfMenu());
    }

    @Test
    public void TonkotsuIsSetToCorrectValues() {
        assertEquals(Tonkotsu.COST_FOR_TONKOTSU, testTonkotsu.getCostForRamen());
        assertEquals(1, testTonkotsu.getMenuID());
        assertEquals("Tonkotsu ramen", testTonkotsu.getName());
        assertNull(testTonkotsu.getToppings());
        assertEquals(RamenSize.Large, testTonkotsu.getSize());
        assertEquals(0, testTonkotsu.getPrice());
        assertEquals(Tonkotsu.COST_FOR_TONKOTSU * Menu.LARGE_SIZE_COEFFICIENT, testTonkotsu.getMaterialCost());
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Tonkotsu first = new Tonkotsu(RamenSize.Large);
        int firstID = first.getMenuID() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Tonkotsu Tonkotsu = new Tonkotsu(RamenSize.Large);
            assertEquals(firstID + i, Tonkotsu.getMenuID());
        }
    }

    // set name
    @Test
    public void testSetNameValid() {
        testTonkotsu.setName("Taisho special");
        assertEquals("Taisho special", testTonkotsu.getName());
    }
    @Test
    public void testSetNameNull() {
        testTonkotsu.setName(null);
        assertEquals("Tonkotsu ramen", testTonkotsu.getName());
    }

    @Test
    public void testSetNameBlank() {
        testTonkotsu.setName("  ");
        assertEquals("Tonkotsu ramen", testTonkotsu.getName());
    }

    @Test
    public void testSetNameUpperCase() {
        testTonkotsu.setName("NEW RAMEN");
        assertEquals("New ramen", testTonkotsu.getName());
    }

    // set price
    @Test
    public void testSetPriceValid() {
        testTonkotsu.setPrice(10.0);
        assertEquals(10.0, testTonkotsu.getPrice());
    }

    @Test
    public void testSetPriceNegative() {
        testTonkotsu.setPrice(-5.0);
        assertEquals(0, testTonkotsu.getPrice());
    }

    // set topping
    @Test
    public void testSetToppingValid() {
        ArrayList<Menu.Topping> newToppings = new ArrayList<>();
        newToppings.add(Menu.Topping.corn);
        newToppings.add(Menu.Topping.chashu);
        testTonkotsu.setToppings(newToppings);
        assertTrue(testTonkotsu.getToppings().contains(Menu.Topping.corn));
        assertTrue(testTonkotsu.getToppings().contains(Menu.Topping.chashu));
    }

    @Test
    public void testSetToppingNull() {
        ArrayList<Menu.Topping> newToppings = new ArrayList<>();
        testTonkotsu.setToppings(newToppings);
        assertTrue(testTonkotsu.getToppings().isEmpty());
    }

    @Test
    public void testToString() {
        final String expected = "Menu{"
                + "costForRamen=7.15"
                + ", menuID=1"
                + ", name='Tonkotsu ramen'"
                + ", toppings=null"
                + ", size=Large"
                + ", price=0.0"
                + ", materialCost=7.15}";
        final String actual = testTonkotsu.toString();
        assertEquals(expected, actual);
    }
}
