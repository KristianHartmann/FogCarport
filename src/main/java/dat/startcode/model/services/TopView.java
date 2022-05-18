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
    int xb2;// Vores sidste stolpe står ALTID 30cm inde fra bag.

    int topBeamsY = 35;
    int bottomBeamsY;
    int backEndMiddleBeamY = (bottomBeamsY - topBeamsY) / 2; // Hvis CP er over 310cm

    int remX = 0;
    int topRemY = 35;
    float buttomRemY = cpWidth - 35 - remsWidth;
    int remsLength = cpLength;


//_________________________________

    public TopView(int cpLength, int cpWidth, int shedLength, int shedWidth, PartsList partsList) {
        this.cpLength = cpLength;
        this.cpWidth = cpWidth;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.partsList = partsList;
        bottomBeamsY  = cpWidth - 35 - beamWidth;
        xb2 = cpLength - airback - beamWidth;
        NSxb1Ltoxb2L = xb2 - xb1;
        beamPlacement = xb1 + (WSxb1toxb2 / 2);
    }


    int xShedPos = cpLength - airback - shedLength; // HVIS skur.
    int NSxb1Ltoxb2L; // Hvis IKKE SKUR
    int WSxb1toxb2 = xShedPos - xb1; // Hvis MED SKUR
    int beamPlacement; // Gælder kun hvis afstand er over 310 - Det vi dividere med er lufthuller ikke stolper.


    //rem
    //spær


    //hulbånd
    //skur

    public void carportOutline() {
        stringBuilder.append("<rect x=\"0\" y=\"0\" height=\""+cpWidth+"\" width=\""+cpLength+"\" stroke-width=\"1\" fill-opacity=\"0\"\n" +
                "stroke=\"black\"></rect>");
    }

   public void drawBeams() {
       int amount = partsList.getPartsListItemArrayList().get(32).getAmount();
       int remainingBeams = amount-4;

        // ØVERSTE STOLPER FAST
       stringBuilder.append("<rect x=\""+xb1+"\" y=\""+topBeamsY+"\" height=\""+beamWidth+"\" width=\""+beamLength+"\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>"); // Første stolpe øverst
       stringBuilder.append("<rect x=\""+xb2+"\" y=\""+topBeamsY+"\" height=\""+beamWidth+"\" width=\"10\" stroke-width=\"1.5\"\n" +
               "stroke=\"black\" fill-opacity=\"0\"></rect>"); // Sidste stolpe øverst

       // NEDERSTE STOLPER FAST
       stringBuilder.append("<rect x=\""+xb1+"\" y=\""+bottomBeamsY+"\" height=\""+beamWidth+"\" width=\""+beamLength+"\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>"); // Første stolpe nederst
       stringBuilder.append("<rect x=\""+xb2+"\" y=\""+bottomBeamsY+"\" height=\""+beamWidth+"\" width=\"10\" stroke-width=\"1.5\"\n" +
               "stroke=\"black\" fill-opacity=\"0\"></rect>"); // Sidste stolpe nederst

       if(cpWidth > 380) {
           remainingBeams = remainingBeams-1;
       }

       if(remainingBeams ==  2) {
           stringBuilder.append("<rect x=\""+beamPlacement+"\" y=\"35\" height=\""+beamWidth+"\" width=\""+beamLength+"\" stroke=\"black\" stroke-width=\"1.5\"\n" +
                "fill-opacity=\"0\"stroke=\"black\"></rect>");
       }




       // ØVERSTE STOLPER DYNAMISK

       //        stringBuilder.append("<rect x=\"0\" y=\"35\" height=\"9\" width=\"780\" stroke=\"black\" stroke-width=\"1\"\n" +
//                "fill-opacity=\"0\"></rect>");
//        stringBuilder.append("<rect x=\"0\" y=\"565\" height=\"9\" width=\"780\" stroke=\"black\" stroke-width=\"1\"\n" +
//                "fill-opacity=\"0\"></rect>");
//        stringBuilder.append("</svg>");

       // NEDERSTE STOLPER DYNAMISK
//        stringBuilder.append("<rect x=\"313.333\" y=\"565\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
//                "fill-opacity=\"0\" stroke=\"black\"></rect>");
//        stringBuilder.append("<rect x=\"526.666\" y=\"565\" height=\"10\" width=\"10\" stroke-width=\"1.5\"\n" +
//                "fill-opacity=\"0\" stroke=\"black\"></rect>");

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
        String udenViewbox = "<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 600 \"\n" +
                 "preserveAspectRatio=\"xMidYMid meet\">";

         //stringBuilder.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 600 \"\n" +
        //     "preserveAspectRatio=\"xMidYMid meet\">");

          stringBuilder.append(udenViewbox);
          carportOutline();
          drawBeams();





        return stringBuilder;
    }

}

