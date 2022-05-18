package dat.startcode.model.services;

import dat.startcode.model.entities.PartsList;

public class SideView {

    int SvBeamheight = 210;
    int SvBeamWidth = 10;
    int SvBeamLength = 10;
    int CpHeight = 230;
    int ShedLength = 0;
    int SvCpLength = 0;
    int SvAirback = 30;
    int xb1 = SvCpLength-100;
    int xb2 = xb1-SvBeamWidth-SvAirback;
    int b1Tob2 = xb1-xb2;
  //  int restbeam = ((partsListAmount-1)/2)-2;
  // int placement = xb1-xb2/(restbeam+1);
    int SvRoofHeight = 30;
    int SvRoofDevider = SvRoofHeight/2;


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

    private void calcBeams(){
        svgSvSb.append("<rect x=\"100\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSvSb.append("<rect x=\"313.333\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSvSb.append("<rect x=\"52x6\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "fill-opacity=\"0\" stroke=\"black\"></rect>");
        svgSvSb.append("<rect x=\"750\" y=\"20\" height=\"210\" width=\"10\" stroke-width=\"1\"\n" +
                "stroke=\"black\" fill-opacity=\"0\"></rect>");
    }
    public StringBuilder svgSideGen(){
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
