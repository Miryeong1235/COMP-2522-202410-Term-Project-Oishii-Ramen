import ca.bcit.comp2522.termproject.oishiiramen.Tonkotsu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static ca.bcit.comp2522.termproject.oishiiramen.Menu.RamenSize;
import static org.junit.jupiter.api.Assertions.*;

class TonkotsuTest {
    private Tonkotsu testTonkotsu;

    @BeforeEach
    public void setUp() {
        testTonkotsu = new Tonkotsu(RamenSize.Medium);
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
        assertEquals(5.50, testTonkotsu.getCostForRamen());
        assertEquals(1, testTonkotsu.getMenuID());
        assertEquals("Tonkotsu Ramen", testTonkotsu.getName());
        assertNull(testTonkotsu.getToppings());
        assertEquals(RamenSize.Medium, testTonkotsu.getSize());
        assertEquals(0, testTonkotsu.getPrice());
        assertEquals(5.50, testTonkotsu.getMaterialCost());

    }

//    @Test
//    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
//        Tonkotsu first = new Tonkotsu("Ichiro", 1);
//        int firstID = first.getTonkotsuID() + 1;
//        int numberCreated = 100;
//        for (int i = 0; i < numberCreated; ++i) {
//            Tonkotsu Tonkotsu = new Tonkotsu("Shohei", 3);
//            assertEquals(firstID + i, Tonkotsu.getTonkotsuID());
//        }
//    }
//
//    @Test
//    public void TonkotsuNameIsCorrectlyFormatted() {
//        Tonkotsu newTonkotsu = new Tonkotsu("  jiRo    ", 2);
//        assertEquals("Jiro", newTonkotsu.getName());
//    }
//
//    @Test
//    public void nullNameThrownThenDefaultValueIsUsed() {
//        Tonkotsu nullNameTonkotsu = new Tonkotsu(null, 2);
//        assertEquals("Kenta", nullNameTonkotsu.getName());
//    }
//
//    @Test
//    public void TonkotsuLevelIsCorrectlySetIfItIsTooHigh() {
//        Tonkotsu newTonkotsu = new Tonkotsu("Yusuke", 4);
//        assertEquals(3, newTonkotsu.getLevel());
//        assertEquals(30.0, newTonkotsu.getHourlyWage());
//    }
//
//    @Test
//    public void TonkotsuLevelIsCorrectlySetIfItIsTooLow() {
//        Tonkotsu newTonkotsu = new Tonkotsu("Yusuke", 0);
//        assertEquals(1, newTonkotsu.getLevel());
//        assertEquals(20.0, newTonkotsu.getHourlyWage());
//    }
//
//    @Test
//    public void testSetNameValid() {
//        testTonkotsu.setName("Gojiro");
//        assertEquals("Gojiro", testTonkotsu.getName());
//    }
//    @Test
//    public void testSetNameNull() {
//        testTonkotsu.setName(null);
//        assertEquals("Taro", testTonkotsu.getName());
//    }
//
//    @Test
//    public void testSetNameBlank() {
//        testTonkotsu.setName("  ");
//        assertEquals("Taro", testTonkotsu.getName());
//    }
//
//    @Test
//    public void testSetLevelValid() {
//        testTonkotsu.setLevel(3);
//        assertEquals(3, testTonkotsu.getLevel());
//        assertEquals(30.0, testTonkotsu.getHourlyWage());
//    }
//
//    @Test
//    public void testSetLevelTooHigh() {
//        testTonkotsu.setLevel(5);
//        assertEquals(3, testTonkotsu.getLevel());
//        assertEquals(30.0, testTonkotsu.getHourlyWage());
//    }
//
//    @Test
//    public void testSetLevelTooLow() {
//        testTonkotsu.setLevel(0);
//        assertEquals(1, testTonkotsu.getLevel());
//        assertEquals(20.0, testTonkotsu.getHourlyWage());
//    }
//
//    @Test
//    public void testToString() {
//        Tonkotsu newTonkotsu = new Tonkotsu("Sakura", 1);
//        final int numberAlreadyCreated = Tonkotsu.getTotalTonkotsuNumber();
//        final String expected = "Tonkotsu{"
//                + "TonkotsuID=" + numberAlreadyCreated
//                + ", name='Sakura'"
//                + ", level=1"
//                + ", hourlyWage=20.0}";
//        final String actual = newTonkotsu.toString();
//        assertEquals(expected, actual);
//    }
}