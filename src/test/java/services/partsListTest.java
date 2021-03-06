package services;

import dat.startcode.model.entities.Parts;
import dat.startcode.model.entities.PartsList;
import dat.startcode.model.entities.PartsListItem;
import dat.startcode.model.services.FlatRoofCalc;
import dat.startcode.model.services.ICalculator;
import dat.startcode.model.services.RaisedRoofCalc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class partsListTest {

    private static PartsList testPartsList;
    private static ICalculator flatcalc;
    private static ICalculator raisedcalc;

    @BeforeAll
    public static void setUpClass() {
        testPartsList = new PartsList();
        flatcalc = new FlatRoofCalc(600, 780, 530, 210);
        raisedcalc = new RaisedRoofCalc(600,780,530,210, 40);
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
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(4, "rafters", "45x195 mm. spærtræ ubh.",
                600, "stk", 40), 0, "Spær, monteres på rem"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(5, "universalBrackets", "universal 190 mm",
                0, "stk", 40), 0, "Til montering af spær på rem"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(6, "universalBrackets", "universal 190 mm",
                0, "stk", 40), 0, "Til montering af spær på rem"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(7, "board", "25x200 mm. trykmp. Brædt",
                360, "stk", 60), 0, "oversternbrædder til for & bag ende"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(8, "board", "25x200 mm. trykmp. Brædt",
                540, "stk", 65), 0, "over til siderne"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(9, "zShedDoor", "38x73 mm. Lægte ubh.",420,"stk",
                123), 0, "til z på bagside af dør"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(10, "looseHolterboard", "45x95 mm. Reglar ub.",
                270,"stk",123), 0, "løsholter til skur gavle"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(11, "looseHolterboard", "45x95 mm. Reglar ub.",
                240,"stk", 123), 0, "løsholter til skur side"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(12, "remCar", "45x195 mm. Spærtræ ub.",
                600,"stk", 123), 0, "Remme i sider, sadles ned i stolper"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(13, "remShed", "45x195 mm. Spærtræ ub.",
                480,"stk", 123), 0, "Remme i sider, sadles ned i stolper ( skur del, deles)"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(14, "DressingShed", "19x100 mm. trykimp. Brædt",
                210,"stk", 123), 0, "til beklædning af skur 1 på 2"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(15, "WaterBoardSides", "19x100 mm. trykimp. Brædt",
                540,"stk", 123), 0, "vandbrædt på stern i sider"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(16, "WaterBoardsEnd", "19x100 mm. trykimp. Brædt",
                360,"stk", 123), 0, "vandbrædt på stern i forende"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(17, "RoofPlates600", "Plastmo Ecolite blåtonet",
                600,"stk", 123), 0, "tagplader monteres på spær"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(18, "RoofPlates360", "Plastmo Ecolite blåtonet",
                360,"stk", 123), 0, "tagplader monteres på spær"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(19, "RoofScrew", "plastmo bundskruer 200 stk.",
                0,"stk", 123), 0, "Skruer til tagplader"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(20, "HoleBand", "hulbånd 1x20 mm. 10 mtr.",
                0,"stk", 123), 0, "Til vindkryds på spær"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(21, "SternScrew", "4,5 x 60 mm. skruer 200 stk.",
                0,"stk", 123), 0, "Til montering af stern&vandbrædt"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(22, "BracketScrew", "4,0 x 50 mm. beslagskruer 250 stk.",
                0,"stk", 123), 0, "Til montering af universalbeslag + hulbånd"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(23, "boardBolts", "10 x 120 mm.",
                0,"stk", 123), 0, "Til montering af rem på stolper"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(24, "SquareDiscs", "40x40x11mm",
                0,"stk", 123), 0, "Til montering af rem på stolper"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(25, "OuterDressScrew", "4,5 x 70 mm. Skruer 400 stk.",
                0,"stk", 123), 0, "til montering af yderste beklædning"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(26, "InnerDressScrew", "4,5 x 50 mm. Skruer 300 stk",
                0,"stk", 123), 0, "til montering af inderste beklædning"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(27, "t-hinge", "t hængsel 390 mm",
                0,"stk", 123), 0, "Til skurdør"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(28, "angleBracket", "vinkelbeslag 35",
                0,"stk", 123), 0, "Til montering af løsholter i skur"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(29, "barnDoorHandles", "stalddørsgreb 50x75",
                0,"stk", 123), 0, "Til lås på dør i skur"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(30, "roofTop", "tagryg",
                400,"stk", 123), 0, "Til tagryg"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(31, "laths360Calc", "lægter 360",
                360,"stk", 123), 0, "lægter til skråtag"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(32, "laths480Calc", "lægter 480",
                480,"stk", 123), 0, "lægter til skråtag"));
        testPartsList.addToPartsListItemArrayList(new PartsListItem(new Parts(33, "holePlate", "hulplade",
                0,"stk", 123), 0, "hulplade"));
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
        assertEquals(33, testPartsList.getPartsListItemArrayList().size());
        assertEquals("board", testPartsList.getPartsListItemArrayList().get(0).getParts().getName());
        assertEquals(360, testPartsList.getPartsListItemArrayList().get(0).getParts().getLength());
        assertEquals("board", testPartsList.getPartsListItemArrayList().get(1).getParts().getName());
        assertEquals(540, testPartsList.getPartsListItemArrayList().get(1).getParts().getLength());
        assertEquals("beam", testPartsList.getPartsListItemArrayList().get(2).getParts().getName());
        assertEquals(300, testPartsList.getPartsListItemArrayList().get(2).getParts().getLength());
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
    @Test
    void testOverStern360() {
        testPartsList.getPartsListItemArrayList().get(6).setAmount(flatcalc.overStern360Calc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(6).getAmount());
    }
    @Test
    void testOverStern540(){
        testPartsList.getPartsListItemArrayList().get(7).setAmount(flatcalc.overStern540Calc());
        assertEquals(4, testPartsList.getPartsListItemArrayList().get(7).getAmount());
    }
    @Test
    void testzSheedDoorCalc(){
        testPartsList.getPartsListItemArrayList().get(8).setAmount(flatcalc.zShedDoorCalc());
        assertEquals(1, testPartsList.getPartsListItemArrayList().get(8).getAmount());
    }
    @Test
    void testLooseHolter270(){
        testPartsList.getPartsListItemArrayList().get(9).setAmount(flatcalc.looseHolter270());
        assertEquals(12, testPartsList.getPartsListItemArrayList().get(9).getAmount());
    }
    @Test
    void testLooseHolter240(){
        testPartsList.getPartsListItemArrayList().get(10).setAmount(flatcalc.looseHolter240());
        assertEquals(4, testPartsList.getPartsListItemArrayList().get(10).getAmount());
    }
    @Test
        void testRemCar600(){
        testPartsList.getPartsListItemArrayList().get(11).setAmount(flatcalc.remCarCalc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(11).getAmount());
    }

    @Test
    void testRemShed480(){
        testPartsList.getPartsListItemArrayList().get(12).setAmount(flatcalc.remShedCalc());
        assertEquals(1, testPartsList.getPartsListItemArrayList().get(12).getAmount());
    }

    @Test
    void testDressingShed() {
        testPartsList.getPartsListItemArrayList().get(13).setAmount(flatcalc.dressShedCalc());
        assertEquals(200, testPartsList.getPartsListItemArrayList().get(13).getAmount());
    }

    @Test
    void testWaterBoardSides() {
        testPartsList.getPartsListItemArrayList().get(14).setAmount(flatcalc.waterBoardSidesCalc());
        assertEquals(4, testPartsList.getPartsListItemArrayList().get(14).getAmount());
    }

    @Test
    void testWaterBoardsEnd() {
        testPartsList.getPartsListItemArrayList().get(15).setAmount(flatcalc.waterBoardEndsCalc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(15).getAmount());
    }

    @Test
    void testRoofPlate600() {
        testPartsList.getPartsListItemArrayList().get(16).setAmount(flatcalc.roofPlates600Calc());
        assertEquals(6, testPartsList.getPartsListItemArrayList().get(16).getAmount());
    }

    @Test
    void testRoofPlate360() {
        testPartsList.getPartsListItemArrayList().get(17).setAmount(flatcalc.roofPlates360Calc());
        assertEquals(6, testPartsList.getPartsListItemArrayList().get(17).getAmount());
    }
    @Test
    void testRoofScrew() {
        testPartsList.getPartsListItemArrayList().get(18).setAmount(flatcalc.roofScrewsCalc());
        assertEquals(3, testPartsList.getPartsListItemArrayList().get(18).getAmount());
    }
    @Test
    void testHoleBand() {
        testPartsList.getPartsListItemArrayList().get(19).setAmount(flatcalc.holeBandCalc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(19).getAmount());
    }
  @Test
    void testSternScrew() {
        testPartsList.getPartsListItemArrayList().get(20).setAmount(flatcalc.sternScrewsCalc());
        assertEquals(1, testPartsList.getPartsListItemArrayList().get(20).getAmount());
    }
  @Test
    void testBracketScrew() {
        testPartsList.getPartsListItemArrayList().get(21).setAmount(flatcalc.bracketScrewsCalc());
        assertEquals(3, testPartsList.getPartsListItemArrayList().get(21).getAmount());
    }
  @Test
    void testBoardBolt() {
        testPartsList.getPartsListItemArrayList().get(22).setAmount(flatcalc.boardBoltCalc());
        assertEquals(18, testPartsList.getPartsListItemArrayList().get(22).getAmount());
    }
  @Test
    void testSquareDiscs() {
        testPartsList.getPartsListItemArrayList().get(23).setAmount(flatcalc.squareDiscsCalc());
        assertEquals(12, testPartsList.getPartsListItemArrayList().get(23).getAmount());
    }
  @Test
    void testOuterDressScrew() {
        testPartsList.getPartsListItemArrayList().get(24).setAmount(flatcalc.outerDressScrewsCalc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(24).getAmount());
    }

    @Test
    void testInnerDressScrew() {
        testPartsList.getPartsListItemArrayList().get(25).setAmount(flatcalc.innerDressScrewsCalc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(25).getAmount());
    }

    @Test
    void testTHinge() {
        testPartsList.getPartsListItemArrayList().get(26).setAmount(flatcalc.tHingeCalc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(26).getAmount());
    }

    @Test
    void testAnglebracket() {
        testPartsList.getPartsListItemArrayList().get(27).setAmount(flatcalc.angleBracketCalc());
        assertEquals(32, testPartsList.getPartsListItemArrayList().get(27).getAmount());
    }

    @Test
    void testBarnDoorhandles() {
        testPartsList.getPartsListItemArrayList().get(28).setAmount(flatcalc.barnDoorHandlesCalc());
        assertEquals(1, testPartsList.getPartsListItemArrayList().get(28).getAmount());
    }

    @Test
    void testRoofBack() {
        testPartsList.getPartsListItemArrayList().get(29).setAmount(raisedcalc.roofBackCalc());
        assertEquals(2, testPartsList.getPartsListItemArrayList().get(29).getAmount());
    }

    @Test
    void testLaths360() {
        testPartsList.getPartsListItemArrayList().get(30).setAmount(raisedcalc.laths360Calc());
        assertEquals(1, testPartsList.getPartsListItemArrayList().get(30).getAmount());
    }

    @Test
    void testLaths480() {
        testPartsList.getPartsListItemArrayList().get(31).setAmount(raisedcalc.laths480Calc());
        assertEquals(1, testPartsList.getPartsListItemArrayList().get(31).getAmount());
    }

    @Test
    void testHolePlate() {
        testPartsList.getPartsListItemArrayList().get(32).setAmount(raisedcalc.holePlate());
        assertEquals(112, testPartsList.getPartsListItemArrayList().get(32).getAmount());
    }

    @Test
    void raftersCalcRaisedRoof() {
        testPartsList.getPartsListItemArrayList().get(3).setAmount(raisedcalc.raftersCalc());
        assertEquals(16, testPartsList.getPartsListItemArrayList().get(3).getAmount());
    }

    @Test
    void roofPlate600RaisedRoof() {
        testPartsList.getPartsListItemArrayList().get(16).setAmount(raisedcalc.roofPlates600Calc());
        assertEquals(16, testPartsList.getPartsListItemArrayList().get(16).getAmount());
    }

    @Test
    void roofPlate360RaisedRoof() {
        testPartsList.getPartsListItemArrayList().get(17).setAmount(raisedcalc.roofPlates360Calc());
        assertEquals(0, testPartsList.getPartsListItemArrayList().get(17).getAmount());
    }

    @Test
    void roofScrewRaisedRoof() {
        testPartsList.getPartsListItemArrayList().get(18).setAmount(raisedcalc.roofScrewsCalc());
        assertEquals(4, testPartsList.getPartsListItemArrayList().get(18).getAmount());
    }
    @Test
    void testBracketScrewRaisedRoof() {
        testPartsList.getPartsListItemArrayList().get(21).setAmount(raisedcalc.bracketScrewsCalc());
        assertEquals(7, testPartsList.getPartsListItemArrayList().get(21).getAmount());
    }




}
