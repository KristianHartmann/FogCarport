package dat.startcode.model.services;

import dat.startcode.model.entities.PartsList;

public class SideView {

    int cpLength;
    int cpWidth;
    int toolLength;
    int toolWidth;
    StringBuilder svgSvSb = new StringBuilder();

    PartsList list;

    public SideView(PartsList list, int cpLength, int toolLength) {
        this.cpLength = cpLength;
        this.toolLength = toolLength;
        this.list = list;
    }

    private void calcBeams() {

        int lastbeam = cpLength - 45;
        System.out.println("last beam " + lastbeam);

        int beamsToDisplay = (list.getPartsListItemArrayList().get(9).getAmount()) / 2;
        System.out.println("beams to display" + beamsToDisplay);

        int distanceBetweenBeams = (cpLength - 145) / beamsToDisplay;
        int increment = distanceBetweenBeams;
        int firstDynamicBeam = distanceBetweenBeams + 100;
        int lastDynamicBeam = distanceBetweenBeams - 45;
        System.out.println("distance between beams "+distanceBetweenBeams);

        svgSvSb.append("<rect x=\"100\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");

        for (int i = 0; i < beamsToDisplay; i++) {
            System.out.println(distanceBetweenBeams);
            if(i==0){
                svgSvSb.append("<rect x= \"" + firstDynamicBeam + "\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                        "fill-opacity=\"0\" stroke=\"black\"></rect>");
            } else if(i == beamsToDisplay - 1){
                svgSvSb.append("<rect x= \"" + lastDynamicBeam + "\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                        "fill-opacity=\"0\" stroke=\"black\"></rect>");
            } else {
                svgSvSb.append("<rect x= \"" + distanceBetweenBeams + "\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                        "fill-opacity=\"0\" stroke=\"black\"></rect>");
            }

            distanceBetweenBeams = distanceBetweenBeams + increment;
        }

        svgSvSb.append("<rect x=\""+ lastbeam + "\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "stroke=\"black\" fill-opacity=\"0\"></rect>");
    }

    public StringBuilder svgSideGen() {
        svgSvSb.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 780 230\"\n" +
                "preserveAspectRatio=\"xMidYMid meet\">");

        calcBeams();

        svgSvSb.append("<rect x=\"0\" y=\"0\" height=\"30\" width=\"780\" stroke=\"black\"\n" +
                "transform=\"rotate(1.28)\" stroke-width=\"1\" fill-opacity=\"1\"\n" +
                "fill=\"white\"></rect>");
        svgSvSb.append("<rect x=\"0\" y=\"15\" height=\"1\" width=\"780\" fill-opacity=\"0\"\n" +
                "stroke-width=\"0.3\" stroke=\"black\"\n" +
                "transform=\"rotate(1.28)\"></rect>");
        svgSvSb.append("</svg>");

        return svgSvSb;
    }

}
