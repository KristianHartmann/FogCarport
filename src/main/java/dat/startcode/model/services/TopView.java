package dat.startcode.model.services;

import dat.startcode.model.entities.PartsList;

public class TopView {

    boolean isShed;
    int cpLength;
    int cpWidth;
    int shedLength;
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
    int bottomHoleBandY;

    int bottomBeamsY;
    int backEndMiddleBeamY = (bottomBeamsY - topBeamsY) / 2; // Hvis CP er over 310cm

    int remX = 0;
    int topRemY = 35;
    float bottomRemY;
    int remsLength = cpLength;

    int endBeam; // Stolpen der placeres i midten for enden


//_________________________________

    int xShedPos = cpLength - airback - shedLength; // HVIS skur.
    int NSxb1Ltoxb2L; // Hvis IKKE SKUR
    int WSxb1toxb2 = xShedPos - xb1; // Hvis MED SKUR
    int beamPlacement; // Gælder kun hvis afstand er over 310 - Det vi dividere med er lufthuller ikke stolper.

    public TopView(int cpLength, int cpWidth, boolean isShed, int shedLength, int shedWidth, PartsList partsList) {
        this.cpLength = cpLength;
        this.cpWidth = cpWidth;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.partsList = partsList;
        this.isShed = isShed;
        bottomBeamsY  = cpWidth - 35;
        xb2 = cpLength - airback - beamWidth;
        NSxb1Ltoxb2L = xb2 - xb1;
        beamPlacement = xb1 + (WSxb1toxb2 / 2);
        bottomRemY = cpWidth - 35 + remsWidth;
        endBeam = cpWidth/2+5;
        bottomHoleBandY = cpWidth - 35;
    }




    //rem
    //spær


    //hulbånd
    //skur

    public void carportOutline() {
        stringBuilder.append("<rect x=\"0\" y=\"0\" height=\""+cpWidth+"\" width=\""+cpLength+"\" stroke-width=\"1\" fill-opacity=\"0\"\n" +
                "stroke=\"black\"></rect>");
    }

    public void drawBeams() { // Der er pt en fejl ved 240x240 carport. Måske en fejl i calcbeams metode.
        int amount = partsList.getPartsListItemArrayList().get(9).getAmount();
        int remainingBeams = amount - 4;
        int midBeamX = (NSxb1Ltoxb2L / 2) + 100; // x positionen hvis der kun er 1 midterstolpe
        int midBeam1X = NSxb1Ltoxb2L / 3 + 100; // første stolpes x ved 2 midterstolper
        int midBeam2X = ((NSxb1Ltoxb2L / 3) * 2) + 100; // anden stolpes x ved 2 midterstolper

        // ØVERSTE STOLPER FAST
        stringBuilder.append("<rect x=\"" + xb1 + "\" y=\"" + topBeamsY + "\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke-width=\"2\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>"); // Første stolpe øverst
        stringBuilder.append("<rect x=\"" + xb2 + "\" y=\"" + topBeamsY + "\" height=\"" + beamWidth + "\" width=\"10\" stroke-width=\"2\"\n" +
                "stroke=\"black\" fill-opacity=\"0\"></rect>"); // Sidste stolpe øverst

        // NEDERSTE STOLPER FAST
        stringBuilder.append("<rect x=\"" + xb1 + "\" y=\"" + bottomBeamsY + "\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke-width=\"2\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>"); // Første stolpe nederst
        stringBuilder.append("<rect x=\"" + xb2 + "\" y=\"" + bottomBeamsY + "\" height=\"" + beamWidth + "\" width=\"10\" stroke-width=\"2\"\n" +
                "stroke=\"black\" fill-opacity=\"0\"></rect>"); // Sidste stolpe nederst

        if (cpWidth > 380) {
            remainingBeams = remainingBeams - 1;
            stringBuilder.append("<rect x=\"" + xb2 + "\" y=\"" + endBeam + "\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke-width=\"2\"\n" +
                    "fill-opacity=\"0\" stroke=\"black\"></rect>"); // Tegner midterste stolpe

        }

        if (remainingBeams == 2) {
            stringBuilder.append("<rect x=\"" + midBeamX + "\" y=\"35\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke=\"black\" stroke-width=\"2\"\n" +
                    "fill-opacity=\"0\"stroke=\"black\"></rect>"); // Øverste midterstolpe
            stringBuilder.append("<rect x=\"" + midBeamX + "\" y=\"" + bottomBeamsY + "\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke-width=\"2\"\n" +
                    "fill-opacity=\"0\" stroke=\"black\"></rect>"); // Nederste midterstolpe
        } else if (remainingBeams == 4) {
            stringBuilder.append("<rect x=\"" + midBeam1X + "\" y=\"35\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke=\"black\" stroke-width=\"2\"\n" +
                    "fill-opacity=\"0\"stroke=\"black\"></rect>"); // Øverste 2. stolpe
            stringBuilder.append("<rect x=\"" + midBeam2X + "\" y=\"35\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke=\"black\" stroke-width=\"2\"\n" +
                    "fill-opacity=\"0\"stroke=\"black\"></rect>"); // Øverste 3. stolpe
            stringBuilder.append("<rect x=\"" + midBeam1X + "\" y=\"" + bottomBeamsY + "\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke=\"black\" stroke-width=\"2\"\n" +
                    "fill-opacity=\"0\"stroke=\"black\"></rect>"); // Nederste 2. stolpe
            stringBuilder.append("<rect x=\"" + midBeam2X + "\" y=\"" + bottomBeamsY + "\" height=\"" + beamWidth + "\" width=\"" + beamLength + "\" stroke=\"black\" stroke-width=\"2\"\n" +
                    "fill-opacity=\"0\"stroke=\"black\"></rect>"); // Nederste 3. stolpe

        }
    }
        public void drawRems() {
            stringBuilder.append("<rect x=\"0\" y=\"35\" height=\""+remsWidth+"\" width=\""+cpLength+"\" stroke=\"black\" stroke-width=\"1\"\n" +
                    "fill-opacity=\"0\"></rect>");
            stringBuilder.append("<rect x=\"0\" y=\""+ bottomRemY +"\" height=\""+remsWidth+"\" width=\""+cpLength+"\" stroke=\"black\" stroke-width=\"1\"\n" +
                    "fill-opacity=\"0\"></rect>");
        }


    public void drawRafters() {
        int amount = partsList.getPartsListItemArrayList().get(32).getAmount();
        float spacing = 0;
        float spacingAdded = (float) ((cpLength-4.5) / (amount - 1));
        for (int i = 0; i < amount; i++) {
            stringBuilder.append("<rect x=\""+spacing+"\" y=\"0\" height=\""+cpWidth+"\" width=\"4.5\" stroke=\"black\" stroke-width=\"1\"\n" +
               "fill-opacity=\"0\"></rect>");
            spacing += spacingAdded;
        }
    }
    public void drawHoleBand() {
        float startX = (float) ((cpLength-4.5) / (partsList.getPartsListItemArrayList().get(32).getAmount() - 1));
        float endX = startX*(partsList.getPartsListItemArrayList().get(32).getAmount() - 2);

        stringBuilder.append("<line x1=\""+startX+"\" y1=\""+topBeamsY+"\" x2=\""+endX+"\" y2=\""+bottomHoleBandY+"\" stroke=\"black\" stroke-dasharray=\"5.5\" stroke-width=\"1.5\" />");
        stringBuilder.append("<line x1=\""+startX+"\" y1=\""+bottomHoleBandY+"\" x2=\""+endX+"\" y2=\""+topBeamsY+"\" stroke=\"black\" stroke-dasharray=\"5.5\" stroke-width=\"1.5\" />");
    }



    public StringBuilder svgTopViewGen() {

        String viewbox = "<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 "+ cpLength+ " " + cpWidth+  "  \"\n" +
                "preserveAspectRatio=\"xMidYMid meet\">";
        String udenViewbox = "<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 600 \"\n" +
                "preserveAspectRatio=\"xMidYMid meet\">";

        //stringBuilder.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 600 \"\n" +
        //     "preserveAspectRatio=\"xMidYMid meet\">");

        stringBuilder.append(viewbox);
        carportOutline();
        drawRems();
        drawRafters();
        drawBeams();
        drawHoleBand();

        stringBuilder.append("</svg>");

        return stringBuilder;
    }

}

