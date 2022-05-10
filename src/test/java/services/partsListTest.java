package services;

import dat.startcode.model.entities.Part;
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
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Part(1, "board", "25x200 mm. trykmp. Brædt",
                360, "stk", 60), 0, "understernbrædder til for & bag ende"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Part(2, "board", "25x200 mm. trykmp. Brædt",
                540, "stk", 65), 0, "understernbrædder til siderne"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Part(3, "beam", "97x97 mm. trykimp. Stolpe",
                300, "stk", 40), 0, "Stolper nedgraves 90 cm. i jord"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Part(4, "rafters", "45x195 mm. spærtræ ubh.",
                600, "stk", 40), 0, "Spær, monteres på rem"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Part(5, "universalBrackets", "universal 190 mm",
                0, "stk", 40), 0, "Til montering af spær på rem"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Part(6, "universalBrackets", "universal 190 mm",
                0, "stk", 40), 0, "Til montering af spær på rem"));
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
        assertEquals(6, testPartsList.getPartsListItemArrayList().size());
        assertEquals("board", testPartsList.getPartsListItemArrayList().get(0).getPart().getName());
        assertEquals(360, testPartsList.getPartsListItemArrayList().get(0).getPart().getLength());
        assertEquals("board", testPartsList.getPartsListItemArrayList().get(1).getPart().getName());
        assertEquals(540, testPartsList.getPartsListItemArrayList().get(1).getPart().getLength());
        assertEquals("beam", testPartsList.getPartsListItemArrayList().get(2).getPart().getName());
        assertEquals(300, testPartsList.getPartsListItemArrayList().get(2).getPart().getLength());
    }

    @Test
    void testRaftersCalc(){
        testPartsList.getPartsListItemArrayList().get(3).setAmount(flatcalc.raftersCalc());
        assertEquals(15, testPartsList.getPartsListItemArrayList().get(3).getAmount());
    }

    @Test
    void testUniversalBracketRightCalc(){
        testPartsList.getPartsListItemArrayList().get(4).setAmount(flatcalc.universalBracketRightCalc());
        assertEquals(15, testPartsList.getPartsListItemArrayList().get(4).getAmount());

    }
    @Test
    void testUniversalBracketLeftCalc(){
        testPartsList.getPartsListItemArrayList().get(5).setAmount(flatcalc.universalBracketLeftCalc());
        assertEquals(15, testPartsList.getPartsListItemArrayList().get(5).getAmount());

    }


}
