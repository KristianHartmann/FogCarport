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
    StringBuilder svgSvSb = new StringBuilder();

    PartsList list;

    public SideView(PartsList list, int cpLength, int toolLength, boolean isShed) {
        this.cpLength = cpLength;
        this.toolLength = toolLength;
        this.list = list;
        this.xb2 = cpLength - beamDimens - airBack;
        this.b1Tob2 = xb2 - xb1;
        this.roofDeviderY = roofHeight/2;
        this.isShed = isShed;
    }

    private void calcBeams() {
        int restbeam;
        if (isShed){
            restbeam = 1;
        }else{
            restbeam = ((list.getPartsListItemArrayList().get(9).getAmount()-1)/2)-2;
        }
        System.out.println("beams to place: " + restbeam);
        System.out.println("restair: " + b1Tob2);
        int placement = b1Tob2/(restbeam+1);
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

    private void shedCalc(){
        int toolStart = cpLength - airBack - toolLength;
        System.out.println("toolstart: " + toolStart);
        int claddingWidth = 10;
        int toolCladdings = toolLength/(claddingWidth);
        int lastCladding = toolStart + claddingWidth;
        System.out.println("firs cladding: " + lastCladding);
        svgSvSb.append("<rect x=\"").append(toolStart).append("\" y=\"20\" height=\"210\" width=\"").append(toolLength).append("\"\n" +
                "fill-opacity=\"1\" fill=\"white\" stroke=\"black\"></rect>");
        for (int i = 0; i < toolCladdings; i++) {
            svgSvSb.append("<line x1=\"").append(lastCladding).append("\" y1=\"20\" x2=\"").append(lastCladding).append("\" y2=\"230\" stroke=\"black\" fill-opacity=\"0\" stroke-width=\"2\" />");
            lastCladding = lastCladding + claddingWidth;
        }
    }


    public StringBuilder svgSideGen() {

        svgSvSb.append("<svg width=\"100%\" height=\"100%\" viewBox=\"0 0 ").append(cpLength).append(" 230\" preserveAspectRatio=\"xMidYMid meet\">");
        calcBeams();
        svgSvSb.append("<rect x=\"0\" y=\"0\" height=\"30\" width=\"").append(cpLength).append("\"\n" +
                "fill-opacity=\"1\" fill=\"white\" stroke=\"black\" transform=\"rotate(1)\"></rect>");
        svgSvSb.append("<line x1=\"0\" y1=\"15\" x2=\"").append(cpLength).append("\" y2=\"15\" stroke=\"black\" transform=\"rotate(1)\" />");
        if(isShed){
            if(toolLength > 0){
                shedCalc();
            }
        }
        svgSvSb.append("</svg>");
        System.out.println(isShed);
        return svgSvSb;
    }

}
