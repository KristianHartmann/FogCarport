package dat.startcode.model.services;

import dat.startcode.model.entities.PartsList;

public class TopView {

    int cpLength;
    int cpWidth;
    int shedLength; // Bliver udregnet STOLPE INKLUSIV
    int shedWidth;
    PartsList partsList;

    //Statiske ----------------------
    int TvBeamWidth = 10;
    int TvBeamLength = 10;
    float TvRaftersWidth = 4.5f;
    float TvRemsWidth = 4.5f;
    int TvAirback = 30; // Der skal altid være 30 cm bag.

    int xb1 = 100; // Vores første stolpe skal altid stå 100cm inde.
    int xb2 = cpLength -TvAirback-TvBeamWidth; // Vores sidste stolpe står ALTID 30cm inde fra bag.

    int bottomBeamsY = cpWidth -35-TvBeamWidth;
    int topBeamsY = 35;

    int backEndMiddleBeamY = (bottomBeamsY-topBeamsY)/2; // Hvis CP er over 310cm
//_________________________________

    public TopView(int cpLength, int cpWidth, int shedLength, int shedWidth, PartsList partsList) {
        this.cpLength = cpLength;
        this.cpWidth = cpWidth;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.partsList = partsList;
    }




    int xShedPos = cpLength -TvAirback- shedLength; // HVIS skur.
    int NSxb1Ltoxb2L = xb2-xb1; // Hvis IKKE SKUR
    int WSxb1toxb2 = xShedPos-xb1; // Hvis MED SKUR
    int beamPlacement = WSxb1toxb2 /2; // Gælder kun hvis afstand er over 310 - Det vi dividere med er lufthuller ikke stolper.


public String beamCalc(){
   return null;
}





}
