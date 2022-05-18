package dat.startcode.model.services;

import dat.startcode.model.entities.PartsList;

public class TopView {

    int cpLength;
    int cpWidth;
    int shedLength; // Bliver udregnet STOLPE INKLUSIV
    int shedWidth;
    PartsList partsList;
    StringBuilder stringBuilder = new StringBuilder();

    //Statiske ----------------------
    int beamWidth = 10;
    int beamLength = 10;
    float raftersWidth = 4.5f;
    float remsWidth = 4.5f;
    int airback = 30; // Der skal altid være 30 cm bag.

    int xb1 = 100; // Vores første stolpe skal altid stå 100cm inde.
    int xb2 = cpLength - airback - beamWidth; // Vores sidste stolpe står ALTID 30cm inde fra bag.

    int bottomBeamsY = cpWidth - 35 - beamWidth;
    int topBeamsY = 35;

    int remX = 0;
    int topRemY = 35;
    float buttomRemY = cpWidth - 35 - remsWidth;
    int remsLength = cpLength;


    int backEndMiddleBeamY = (bottomBeamsY - topBeamsY) / 2; // Hvis CP er over 310cm
//_________________________________

    public TopView(int cpLength, int cpWidth, int shedLength, int shedWidth, PartsList partsList) {
        this.cpLength = cpLength;
        this.cpWidth = cpWidth;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.partsList = partsList;
    }


    int xShedPos = cpLength - airback - shedLength; // HVIS skur.
    int NSxb1Ltoxb2L = xb2 - xb1; // Hvis IKKE SKUR
    int WSxb1toxb2 = xShedPos - xb1; // Hvis MED SKUR
    int beamPlacement = xb1 + (WSxb1toxb2 / 2); // Gælder kun hvis afstand er over 310 - Det vi dividere med er lufthuller ikke stolper.


    //rem
    //spær


    //hulbånd
    //skur


    public String beamCalc() {
        return null;
    }

    public void addRect(float x1, float y1, float length, float width) {

    }

    public void drawRafters() {
        int amount = partsList.getPartsListItemArrayList().get(32).getAmount();
        for (int x = 0; x < amount; x++) {
            addRect(0, raftersSpacing() * x, cpWidth, raftersWidth);
        }


    }

    public float raftersSpacing() {
//PartslistGenerator generator = new PartslistGenerator();
        int amount = partsList.getPartsListItemArrayList().get(32).getAmount();

        return (float) (cpLength / (amount - 1));
    }

    public StringBuilder svgTopViewGen() {
        float x = raftersSpacing();

        String viewbox = "<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 "+ cpLength+ " " + cpWidth+  "  \"\n" +
                "preserveAspectRatio=\"xMidYMid meet\">";
        //stringBuilder.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 ").append(cpLength).append(" ").append(cpWidth).append("\"\n").append("preserveAspectRatio=\"xMidYMid meet\">");
        // stringBuilder.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 600 \"\n" +
            //    "preserveAspectRatio=\"xMidYMid meet\">");

        stringBuilder.append(viewbox);



        return stringBuilder;
    }

}

