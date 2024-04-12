import ca.bcit.comp2522.termproject.oishiiramen.Menu;
import ca.bcit.comp2522.termproject.oishiiramen.Shoyu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static ca.bcit.comp2522.termproject.oishiiramen.Menu.RamenSize;
import static org.junit.jupiter.api.Assertions.*;

class ShoyuTest {
    private Shoyu testShoyu;

    @BeforeEach
    public void setUp() {
        Menu.resetNumberOfMenu();
        testShoyu = new Shoyu(RamenSize.Large);
    }

    @Test
    public void containConstantCalledCOST_FOR_CHASHU() {
        assertEquals(0.5, Shoyu.COST_FOR_CHASHU);
    }

    @Test
    public void containConstantCalledCOST_FOR_CORN() {
        assertEquals(0.1, Shoyu.COST_FOR_CORN);
    }

    @Test
    public void containConstantCalledCOST_FOR_TAMAGO() {
        assertEquals(0.3, Shoyu.COST_FOR_TAMAGO);
    }

    @Test
    public void containConstantCalledCOST_FOR_SEAWEED() {
        assertEquals(0.1, Shoyu.COST_FOR_SEAWEED);
    }

    @Test
    public void containConstantCalledLARGE_SIZE_COEFFICIENT() {
        assertEquals(1.3, Shoyu.LARGE_SIZE_COEFFICIENT);
    }


    @Test
    public void staticCounterIsCorrectlyTrackingGetNumberOfMenu() {
        final int numberAlreadyCreated = Shoyu.getNumberOfMenu();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            new Shoyu(RamenSize.Large);
        }
        assertEquals(numberAlreadyCreated + numberCreated, Shoyu.getNumberOfMenu());
    }

    @Test
    public void ShoyuIsSetToCorrectValues() {
        assertEquals(Shoyu.COST_FOR_SHOYU, testShoyu.getCostForRamen());
        assertEquals(1, testShoyu.getMenuID());
        assertEquals("Shoyu ramen", testShoyu.getName());
        assertNull(testShoyu.getToppings());
        assertEquals(RamenSize.Large, testShoyu.getSize());
        assertEquals(0, testShoyu.getPrice());
        assertEquals(Shoyu.COST_FOR_SHOYU * Menu.LARGE_SIZE_COEFFICIENT, testShoyu.getMaterialCost());
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Shoyu first = new Shoyu(RamenSize.Large);
        int firstID = first.getMenuID() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Shoyu Shoyu = new Shoyu(RamenSize.Large);
            assertEquals(firstID + i, Shoyu.getMenuID());
        }
    }

    // set name
    @Test
    public void testSetNameValid() {
        testShoyu.setName("Taisho special");
        assertEquals("Taisho special", testShoyu.getName());
    }
    @Test
    public void testSetNameNull() {
        testShoyu.setName(null);
        assertEquals("Shoyu ramen", testShoyu.getName());
    }

    @Test
    public void testSetNameBlank() {
        testShoyu.setName("  ");
        assertEquals("Shoyu ramen", testShoyu.getName());
    }

    @Test
    public void testSetNameUpperCase() {
        testShoyu.setName("NEW RAMEN");
        assertEquals("New ramen", testShoyu.getName());
    }

    // set price
    @Test
    public void testSetPriceValid() {
        testShoyu.setPrice(10.0);
        assertEquals(10.0, testShoyu.getPrice());
    }

    @Test
    public void testSetPriceNegative() {
        testShoyu.setPrice(-5.0);
        assertEquals(testShoyu.getMaterialCost(), testShoyu.getPrice());
    }

    // set topping
    @Test
    public void testSetToppingValid() {
        ArrayList<Menu.Topping> newToppings = new ArrayList<>();
        newToppings.add(Menu.Topping.corn);
        newToppings.add(Menu.Topping.chashu);
        testShoyu.setToppings(newToppings);
        assertTrue(testShoyu.getToppings().contains(Menu.Topping.corn));
        assertTrue(testShoyu.getToppings().contains(Menu.Topping.chashu));
    }

    @Test
    public void testSetToppingNull() {
        ArrayList<Menu.Topping> newToppings = new ArrayList<>();
        testShoyu.setToppings(newToppings);
        assertTrue(testShoyu.getToppings().isEmpty());
    }

    @Test
    public void testToString() {
        final String expected = "Menu{"
                + "costForRamen=5.85"
                + ", menuID=1"
                + ", name='Shoyu ramen'"
                + ", toppings=null"
                + ", size=Large"
                + ", price=0.0"
                + ", materialCost=5.85}";
        final String actual = testShoyu.toString();
        assertEquals(expected, actual);
    }
}
