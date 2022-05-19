package dat.startcode.model.services;

import dat.startcode.model.entities.PartsList;

public class TopView {

    boolean isShed;
    int cpLength;
    int cpWidth;
    int shedLength;
    int shedWidth;
    int halfShedWidth;
    int fullShedWidth;
    PartsList partsList;
    StringBuilder stringBuilder = new StringBuilder();

    //Statiske ----------------------
    int beamWidth = 10;
    float raftersWidth = 4.5f;
    float remsWidth = 4.5f;
    int airback = 30; // Der skal altid være 30 cm bag.

    int xb1 = 100; // Vores første stolpe skal altid stå 100cm inde.
    int xb2;// Vores sidste stolpe står ALTID 30cm inde fra bag.

    int topBeamsY = 35;
    int bottomHoleBandY;

    int bottomBeamsY;

    float bottomRemY;

    int shedStartX;

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
        bottomBeamsY  = cpWidth - 35 - 10;
        xb2 = cpLength - airback - beamWidth;
        NSxb1Ltoxb2L = xb2 - xb1;
        beamPlacement = xb1 + (WSxb1toxb2 / 2);
        bottomRemY = cpWidth - 35 - remsWidth;
        endBeam = (cpWidth/2)-5;
        bottomHoleBandY = cpWidth - 35;
        shedStartX = cpLength-30-shedLength;
        halfShedWidth = (cpWidth-70)/2;
        fullShedWidth = (cpWidth-70);
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
        int remainingBeams = amount; // Fjerner en stolpe fordi vi ikke tegner døren
        int midBeamX = (NSxb1Ltoxb2L / 2) + 100; // x positionen hvis der kun er 1 midterstolpe
        int midBeam1X = NSxb1Ltoxb2L / 3 + 100; // første stolpes x ved 2 midterstolper
        int midBeam2X = ((NSxb1Ltoxb2L / 3) * 2) + 100; // anden stolpes x ved 2 midterstolper
        int shedStartX = cpLength-30-shedLength; // Start position for skur
        int endBeamShedY = shedWidth+topBeamsY-beamWidth; // position for slut stolpen.
        int lowerEndBeamShedY = shedWidth+25;
        int LongShedMidLengthBeamX = cpLength - airback - (shedLength/2); // X position til stolperne hvis skur er over 310 langt
        int remainingSpaceForBeams = cpLength-130-shedLength;

        System.out.println("remainingbeams = " + remainingBeams);
        // ØVERSTE STOLPER FAST
        stringBuilder.append("<rect x=\"").append(xb1).append("\" y=\"").append(topBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke-width=\"2\"\n").append("fill-opacity=\"0\" stroke=\"black\"></rect>"); // Første stolpe øverst
        stringBuilder.append("<rect x=\"").append(xb2).append("\" y=\"").append(topBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"10\" stroke-width=\"2\"\n").append("stroke=\"black\" fill-opacity=\"0\"></rect>"); // Sidste stolpe øverst

        // NEDERSTE STOLPER FAST
        stringBuilder.append("<rect x=\"").append(xb1).append("\" y=\"").append(bottomBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke-width=\"2\"\n").append("fill-opacity=\"0\" stroke=\"black\"></rect>"); // Første stolpe nederst
        stringBuilder.append("<rect x=\"").append(xb2).append("\" y=\"").append(bottomBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"10\" stroke-width=\"2\"\n").append("stroke=\"black\" fill-opacity=\"0\"></rect>"); // Sidste stolpe nederst
        remainingBeams = remainingBeams - 4;
        System.out.println("remainingbeams = " + remainingBeams);

        if (cpWidth > 380) { // Tester om der skal ekstra midterstolpe
            StringBuilder append = stringBuilder.append("<rect x=\"").append(xb2).append("\" y=\"").append(endBeam).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke-width=\"2\"\n").append("fill-opacity=\"0\" stroke=\"black\"></rect>");// Tegner midterste stolpe
            remainingBeams = remainingBeams- 1;
        }

        if (isShed) { // Tester om der er skur på
            stringBuilder.append("<rect x=\"").append(shedStartX).append("\" y=\"").append(endBeamShedY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // tegner skurets ende stolpe
            stringBuilder.append("<rect x=\"").append(shedStartX).append("\" y=\"").append(topBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // tegner skurets første stolpe
            remainingBeams = remainingBeams- 3;
            if(shedLength > 310) { // Tester om skuret er mere end 310 langt så der skal ekstra midterstolper
                stringBuilder.append("<rect x=\"").append(LongShedMidLengthBeamX).append("\" y=\"").append(topBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // Tegner øverste midterstolpe på skur, hvis over 310 langt
                stringBuilder.append("<rect x=\"").append(LongShedMidLengthBeamX).append("\" y=\"").append(endBeamShedY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // Tegner nederste midterstolpe på skur, hvis over 310 langt
                remainingBeams = remainingBeams- 2;
                System.out.println("remainingbeams = " + remainingBeams);
            }
            if (shedWidth > 310) { // Tjekker om der skal tegnes en midterstolpe på skuret modsatte side af midterstolpen for enden af carporten
                stringBuilder.append("<rect x=\"").append(shedStartX).append("\" y=\"").append(endBeam).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // Tegner endnu en midterstolpe, hvis skuret er over 310 bredt.
                remainingBeams = remainingBeams-1;
            }

            if(shedWidth+70 < cpWidth) { // Hvis det ikke er fuldt skur, skal der tegnes stolpe på modsatte side
                stringBuilder.append("<rect x=\"").append(shedStartX).append("\" y=\"").append(bottomBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // Tegner stolpen på modsatte side af skuret, hvis det IKKE er fuldt skur
                remainingBeams = remainingBeams-1;
                System.out.println("remainingbeams = " + remainingBeams);

                if(shedLength>310) { // Hvis skuret er længere end 310, skal stolpe på nederste del af carport, placeres med en X pos der er midt i skuret.
                    stringBuilder.append("<rect x=\"").append(LongShedMidLengthBeamX).append("\" y=\"").append(bottomBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // Tegner midterste stolpe på modsatte side af skuret, hvis det IKKE er fuldt skur, men det er længere end 310
                    remainingBeams = remainingBeams-1;
                    System.out.println("remainingbeams = " + remainingBeams);
                }
            }
            if(shedWidth != halfShedWidth && shedWidth != fullShedWidth) { // Hvis det ikke er helt eller halvt skur, skal der tegnes en stolpe nederste højre hjørne
                stringBuilder.append("<rect x=\"").append(xb2).append("\" y=\"").append(lowerEndBeamShedY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>"); // Tegner skurets sidste stole (nede højre) hvis den ikke allerede findes
                remainingBeams = remainingBeams-1;
            }
        }

        int remainingBeamsToPlace = remainingBeams/2; // Hver beam her skal placeres både i top og i bund
        System.out.println("remainingbeams = " + remainingBeams);
        int placementX = remainingSpaceForBeams/(remainingBeamsToPlace+1);
        int nextBeamPos = 100 + placementX;

        for (int i = 0; i < remainingBeamsToPlace; i++) {
            stringBuilder.append("<rect x=\"").append(nextBeamPos).append("\" y=\"").append(topBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>");
            stringBuilder.append("<rect x=\"").append(nextBeamPos).append("\" y=\"").append(bottomBeamsY).append("\" height=\"").append(beamWidth).append("\" width=\"").append(beamWidth).append("\" stroke=\"black\" stroke-width=\"2\"\n").append("fill-opacity=\"0\"stroke=\"black\"></rect>");
            nextBeamPos = nextBeamPos + placementX;
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
        float startX = (float) ((cpLength - 4.5) / (partsList.getPartsListItemArrayList().get(32).getAmount() - 1));
        float endX = startX * (partsList.getPartsListItemArrayList().get(32).getAmount() - 2);
        float endXShed = cpLength - shedLength - airback;

        if (isShed) {
            stringBuilder.append("<line x1=\"" + startX + "\" y1=\"" + topBeamsY + "\" x2=\"" + endXShed + "\" y2=\"" + bottomHoleBandY + "\" stroke=\"black\" stroke-dasharray=\"5.5\" stroke-width=\"1.5\" />");
            stringBuilder.append("<line x1=\"" + startX + "\" y1=\"" + bottomHoleBandY + "\" x2=\"" + endXShed + "\" y2=\"" + topBeamsY + "\" stroke=\"black\" stroke-dasharray=\"5.5\" stroke-width=\"1.5\" />");

        } else {
            stringBuilder.append("<line x1=\"" + startX + "\" y1=\"" + topBeamsY + "\" x2=\"" + endX + "\" y2=\"" + bottomHoleBandY + "\" stroke=\"black\" stroke-dasharray=\"5.5\" stroke-width=\"1.5\" />");
            stringBuilder.append("<line x1=\"" + startX + "\" y1=\"" + bottomHoleBandY + "\" x2=\"" + endX + "\" y2=\"" + topBeamsY + "\" stroke=\"black\" stroke-dasharray=\"5.5\" stroke-width=\"1.5\" />");
        }
    }

    public void drawShed(){
        if(isShed) {
            stringBuilder.append("<rect x=\""+shedStartX+"\" y=\""+topBeamsY+"\" height=\""+shedWidth+"\" width=\""+shedLength+"\" stroke-dasharray=\"5.5\" stroke=\"black\" stroke-width=\"3\"\n" +
                    "fill-opacity=\"0\"></rect>");
        }

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
        drawShed();

        stringBuilder.append("</svg>");

        return stringBuilder;
    }

}

