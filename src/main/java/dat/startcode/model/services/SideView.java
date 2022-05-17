package dat.startcode.model.services;

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





}
