package services;

import dat.startcode.model.entities.Parts;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.services.FlatRoofCalc;
import dat.startcode.model.services.ICalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class partsListTest {

    private static PartsList testPartsList;
    private static ICalculator flatcalc;

    @BeforeAll
    public static void setUpClass() {
        testPartsList = new PartsList();
        flatcalc = new FlatRoofCalc(600, 780, 530, 210);
    }

    @BeforeEach
    void setUp() {
        testPartsList.getPartsListItemArrayList().clear();
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(1, "board", "25x200 mm. trykmp. Brædt",
                360, "stk", 60), 0, "understernbrædder til for & bag ende"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(2, "board", "25x200 mm. trykmp. Brædt",
                540, "stk", 65), 0, "understernbrædder til siderne"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(3, "beam", "97x97 mm. trykimp. Stolpe",
                300, "stk", 40), 0, "Stolper nedgraves 90 cm. i jord"));
    }

    @Test
    void testUnderBoard360(){
        testPartsList.getPartsListItemArrayList().get(0).setAmount(flatcalc.underStern360Calc());
        assertEquals(4, testPartsList.getPartsListItemArrayList().get(0).getAmount());
    }

    @Test
    void testUnderBoard540(){
        testPartsList.getPartsListItemArrayList().get(1).setAmount(flatcalc.underStern540Calc());
        assertEquals(4, testPartsList.getPartsListItemArrayList().get(1).getAmount());
    }

    @Test
    void testBeamCalc(){
        testPartsList.getPartsListItemArrayList().get(2).setAmount(flatcalc.beamsCalc());
        assertEquals(11, testPartsList.getPartsListItemArrayList().get(2).getAmount());
    }

    @Test
    void testPartsList(){
        assertEquals(3, testPartsList.getPartsListItemArrayList().size());
        assertEquals("board", testPartsList.getPartsListItemArrayList().get(0).getParts().getName());
        assertEquals(360, testPartsList.getPartsListItemArrayList().get(0).getParts().getLength());
        assertEquals("board", testPartsList.getPartsListItemArrayList().get(1).getParts().getName());
        assertEquals(540, testPartsList.getPartsListItemArrayList().get(1).getParts().getLength());
        assertEquals("beam", testPartsList.getPartsListItemArrayList().get(2).getParts().getName());
        assertEquals(300, testPartsList.getPartsListItemArrayList().get(2).getParts().getLength());
    }

}
