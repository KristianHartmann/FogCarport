package dat.startcode.model.services;

import dat.startcode.model.entities.PartsList;

public class SideView {

    int beamheight = 210;
    int beamDimens = 10;
    int cpHeight = 230;
    int airBack = 30;


    //  int restbeam = ((partsListAmount-1)/2)-2;
    // int placement = xb1-xb2/(restbeam+1);


    int cpLength;
    int toolLength;
    int xb1 = 100;
    int xb2;
    int b1Tob2;
    int roofHeight = 30;
    int roofDeviderY;
    boolean isShed;
    int restbeam;
    StringBuilder svgSvSb = new StringBuilder();

    PartsList list;

    public SideView(PartsList list, int cpLength, int toolLength, boolean isShed) {
        this.cpLength = cpLength;
        this.toolLength = toolLength;
        this.list = list;
        this.xb2 = cpLength - beamDimens - airBack;
        this.roofDeviderY = roofHeight / 2;
        this.isShed = isShed;
    }

    private void calcBeams() {
        if (isShed) {
            restbeam = 1;
            b1Tob2 = (cpLength - airBack - toolLength) - xb1;
        } else {
            b1Tob2 = xb2 - xb1;
            if (b1Tob2 <= 310) {
                restbeam = 0;
            } else {
                if (cpLength < 750) {
                    restbeam = 1;
                } else {
                    restbeam = 2;
                }
            }
        }
        System.out.println("beams to place: " + restbeam);
        System.out.println("restair: " + b1Tob2);
        int placement = b1Tob2 / (restbeam + 1);
        System.out.println("Where to place next: " + placement);
        int nextBeamPos = 100 + placement;
        System.out.println("Next beam pos: " + nextBeamPos);
        svgSvSb.append("<rect x=\"100\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        for (int i = 0; i < restbeam; i++) {
            svgSvSb.append("<rect x=\"").append(nextBeamPos).append("\" y=\"20\" height=\"210\" width=\"10\"\n" +
                    "fill-opacity=\"0\" stroke=\"black\"></rect>");
            nextBeamPos = nextBeamPos + placement;
        }
        svgSvSb.append("<rect x=\"").append(xb2).append("\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
    }

    private void shedCalc() {
        int toolStart = cpLength - airBack - toolLength;
        System.out.println("toolstart: " + toolStart);
        int claddingWidth = 10;
        int toolCladdings = toolLength / (claddingWidth);
        int lastCladding = toolStart + claddingWidth;
        System.out.println("firs cladding: " + lastCladding);
        svgSvSb.append("<rect x=\"").append(toolStart).append("\" y=\"20\" height=\"210\" width=\"").append(toolLength).append("\"\n" +
                "fill-opacity=\"1\" fill=\"white\" stroke=\"black\"></rect>");
        for (int i = 0; i < toolCladdings; i++) {
            svgSvSb.append("<line x1=\"").append(lastCladding).append("\" y1=\"20\" x2=\"").append(lastCladding).append("\" y2=\"230\" stroke=\"black\" fill-opacity=\"0\" stroke-width=\"2\" />");
            lastCladding = lastCladding + claddingWidth;
        }
    }

    private void drawLowerMeasurments() {
        // tegner
        svgSvSb.append("<line x1=\"0\" y1=\"").append(37).append("\" x2=\"").append(0).append("\" y2=\"").append(cpHeight + 40).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        // skriver
        svgSvSb.append("<text style=\" text-anchor: middle \" transform=\" translate(").append(50).append(",").append(cpHeight + 30).append(") rotate(0)\" fill=\" black \" font-size=\"smaller\" font-weight=\"bold\">").append(100).append(" cm</text>");
        // PIL
        svgSvSb.append("<line marker-start=\"url(#markerArrow)\" marker-end=\"url(#markerArrow)\" x1=\"13\" y1=\"").append(cpHeight + 35).append("\" x2=\"").append(100 - 13).append("\" y2=\"").append(cpHeight + 35).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        // tegner
        svgSvSb.append("<line x1=\"100\" y1=\"").append(cpHeight + 20).append("\" x2=\"").append(100).append("\" y2=\"").append(cpHeight + 40).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        int lastbeamPos = 100;
        int placement = b1Tob2 / (restbeam + 1);
        for (int i = 0; i < restbeam + 1; i++) {
            // PIL
            svgSvSb.append("<line marker-start=\"url(#markerArrow)\" marker-end=\"url(#markerArrow)\" x1=\"").append(lastbeamPos + 13).append("\" y1=\"").append(cpHeight + 35).append("\" x2=\"").append(lastbeamPos + placement - 13).append("\" y2=\"").append(cpHeight + 35).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
            // skriver
            svgSvSb.append("<text style=\" text-anchor: middle \" transform=\" translate(").append((lastbeamPos / 2) + (55 + (placement / 2) * (i + 1))).append(",").append(cpHeight + 30).append(") rotate(0)\" fill=\" black \" font-size=\"smaller\" font-weight=\"bold\">").append(placement).append(" cm</text>");
            // tegner
            svgSvSb.append("<line x1=\"").append(lastbeamPos + placement).append("\" y1=\"").append(cpHeight + 20).append("\" x2=\"").append(lastbeamPos + placement).append("\" y2=\"").append(cpHeight + 40).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
            lastbeamPos = lastbeamPos + placement;
        }
        if (isShed) {
            // PIL
            svgSvSb.append("<line marker-start=\"url(#markerArrow)\" marker-end=\"url(#markerArrow)\" x1=\"").append(lastbeamPos + 13).append("\" y1=\"").append(cpHeight + 35).append("\" x2=\"").append(cpLength - airBack - 13).append("\" y2=\"").append(cpHeight + 35).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
            // Tegner
            svgSvSb.append("<line x1=\"").append(cpLength - airBack).append("\" y1=\"").append(cpHeight + 20).append("\" x2=\"").append(cpLength - airBack).append("\" y2=\"").append(cpHeight + 40).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
            // Skriver
            svgSvSb.append("<text style=\" text-anchor: middle \" transform=\" translate(").append(cpLength - (toolLength / 2) - airBack).append(",").append(cpHeight + 30).append(") rotate(0)\" fill=\" black \" font-size=\"smaller\" font-weight=\"bold\">").append(toolLength).append("* cm</text>");
        }
    }

    private void drawFirstSideLastSideMeasurments() {
        int fallInCm = (int) Math.round(1.28 * cpLength / 100);
        int backMeasurment = cpHeight - fallInCm;
        System.out.println("Fall in cm: " + fallInCm);
        System.out.println("Measurment at back: " + backMeasurment);
        svgSvSb.append("<line marker-start=\"url(#markerArrow)\" marker-end=\"url(#markerArrow)\" x1=\"-20\" y1=\"").append(20 + 13).append("\" x2=\"").append(-20).append("\" y2=\"").append(cpHeight - 13).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<text style=\" text-anchor: middle \" transform=\" translate(").append(-25).append(",").append(cpHeight / 2).append(") rotate(-90)\" fill=\" black \" font-size=\"smaller\" font-weight=\"bold\">").append(beamheight).append("*** cm</text>");
        svgSvSb.append("<line marker-start=\"url(#markerArrow)\" marker-end=\"url(#markerArrow)\" x1=\"-50\" y1=\"").append(13).append("\" x2=\"").append(-50).append("\" y2=\"").append(cpHeight - 13).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<text style=\" text-anchor: middle \" transform=\" translate(").append(-55).append(",").append(cpHeight / 2).append(") rotate(-90)\" fill=\" black \" font-size=\"smaller\" font-weight=\"bold\">").append(cpHeight).append(" cm</text>");
        svgSvSb.append("<line x1=\"-55\" y1=\"").append(cpHeight).append("\" x2=\"").append(-15).append("\" y2=\"").append(cpHeight).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<line x1=\"-25\" y1=\"").append(20).append("\" x2=\"").append(-15).append("\" y2=\"").append(20).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<line x1=\"-55\" y1=\"").append(0).append("\" x2=\"").append(-15).append("\" y2=\"").append(0).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<line marker-start=\"url(#markerArrow)\" marker-end=\"url(#markerArrow)\" x1=\"").append(cpLength + 30).append("\" y1=\"").append(fallInCm + 13 + fallInCm).append("\" x2=\"").append(cpLength + 30).append("\" y2=\"").append(cpHeight - 13).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<line x1=\"").append(cpLength + 15).append("\" y1=\"").append(fallInCm * 2).append("\" x2=\"").append(cpLength + 35).append("\" y2=\"").append(fallInCm * 2).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<line x1=\"").append(cpLength + 15).append("\" y1=\"").append(cpHeight).append("\" x2=\"").append(cpLength + 35).append("\" y2=\"").append(cpHeight).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<text style=\" text-anchor: middle \" transform=\" translate(").append(cpLength + 25).append(",").append(cpHeight / 2 + (fallInCm * 2)).append(") rotate(-90)\" fill=\" black \" font-size=\"smaller\" font-weight=\"bold\">").append(cpHeight - fallInCm).append(" cm</text>");
        svgSvSb.append("<line x1=\"").append(10).append("\" y1=\"").append(cpHeight).append("\" x2=\"").append(cpLength + 10).append("\" y2=\"").append(cpHeight).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<line x1=\"").append(cpLength).append("\" y1=\"").append(30 + (fallInCm * 2)).append("\" x2=\"").append(cpLength).append("\" y2=\"").append(cpHeight + 40).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<line marker-start=\"url(#markerArrow)\" x1=\"").append(cpLength + 13).append("\" y1=\"").append(cpHeight + 35).append("\" x2=\"").append(cpLength + 35).append("\" y2=\"").append(cpHeight + 35).append("\" stroke=\"black\" stroke-width=\"1.5\" />");
        svgSvSb.append("<text style=\" text-anchor: middle \" transform=\" translate(").append(cpLength + 17.5).append(",").append(cpHeight + 30).append(") rotate(0)\" fill=\" black \" font-size=\"smaller\" font-weight=\"bold\">").append(30).append(" cm</text>");

    }


    public StringBuilder svgSideGen() {
        int cplengthviewbox = cpLength + 120;
        int cpHeightviewbox = 230 + 40;

        svgSvSb.append("<svg width=\"100%\" height=\"100%\" viewBox=\"-70 0 ").append(cplengthviewbox).append(" ").append(cpHeightviewbox).append("\" preserveAspectRatio=\"xMidYMid meet\">");
        svgSvSb.append("<defs>\n" +
                "<marker id=\"markerArrow\" markerWidth=\"13\" markerHeight=\"13\" refX=\"2\" refY=\"6\"\n" +
                "orient=\"auto-start-reverse\">\n" +
                "<path d=\"M2,2 L2,11 L10,6 L2,2\" style=\"fill: #000000;\" />\n" +
                "</marker>\n" +
                "</defs>");
        calcBeams();
        svgSvSb.append("<rect x=\"0\" y=\"0\" height=\"30\" width=\"").append(cpLength).append("\"\n" +
                "fill-opacity=\"1\" fill=\"white\" stroke=\"black\" transform=\"rotate(1.28)\"></rect>");
        svgSvSb.append("<line x1=\"0\" y1=\"10\" x2=\"").append(cpLength).append("\" y2=\"10\" stroke=\"black\" transform=\"rotate(1.28)\" />");
        if (isShed) {
            shedCalc();
        }
        drawFirstSideLastSideMeasurments();
        drawLowerMeasurments();
        svgSvSb.append("</svg>");
        System.out.println(isShed);
        return svgSvSb;
    }

}
