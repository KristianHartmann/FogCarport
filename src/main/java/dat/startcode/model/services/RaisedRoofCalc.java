package dat.startcode.model.services;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RaisedRoofCalc implements ICalculator {
    private int carportWidth;
    private int carportLength;
    private int shedWidth;
    private int shedLength;
    private double angle;
    private int maxShedWidth;
    private double maxHalfShedWidth;


    public RaisedRoofCalc(int carportWidth, int carportLength, int shedWidth, int shedLength, int angle) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.angle = angle;
        maxShedWidth = carportWidth - 70;
        maxHalfShedWidth = maxShedWidth * 0.5;
    }

    @Override
    public int getAmount(int partsID) {
        switch (partsID) {
            case 1:
                return underStern360Calc();
            case 2:
                return underStern540Calc();
            case 3:
                return overStern360Calc();
            case 4:
                return overStern540Calc();
            case 5:
                return zShedDoorCalc();
            case 6:
                return looseHolter270();
            case 7:
                return looseHolter240();
            case 8:
                return remCarCalc();
            case 9:
                return remShedCalc();
            case 10:
                return beamsCalc();
            case 11:
                return dressShedCalc();
            case 12:
                return waterBoardSidesCalc();
            case 13:
                return waterBoardEndsCalc();
            case 14:
                return roofPlates600Calc();
            case 15:
                return roofPlates360Calc();
            case 16:
                return roofBackCalc();
            case 17:
                return laths360Calc();
            case 18:
                return laths480Calc();
            case 19:
                return roofScrewsCalc();
            case 20:
                return holeBandCalc();
            case 21:
                return universalBracketRightCalc();
            case 22:
                return sternScrewsCalc();
            case 23:
                return bracketScrewsCalc();
            case 24:
                return boardBoltCalc();
            case 25:
                return squareDiscsCalc();
            case 26:
                return outerDressScrewsCalc();
            case 27:
                return innerDressScrewsCalc();
            case 28:
                return barnDoorHandlesCalc();
            case 29:
                return tHingeCalc();
            case 30:
                return angleBracketCalc();
            case 31:
                return universalBracketLeftCalc();
            case 32:
                return holePlate();
            case 33:
                return raftersCalc();
            case 34:
            default:
                return 0;
        }

    }


    @Override
    public int underStern360Calc() {
        int first = 0;
        int second = 0;
        if (carportLength > 540 && carportLength <= 720) {
            first = 4;
        }
        if (carportWidth > 540 && carportWidth <= 720) {
            second = 4;
        }
        return first + second;
    }

    @Override
    public int underStern540Calc() {
        int first = 0;
        int second = 0;
        if (carportLength > 720) {
            first = 4;
        }
        if (carportWidth > 720) {
            second = 2;
        }
        return first + second;
    }

    @Override
    public int overStern360Calc() {
        int first = 0;
        int second = 0;
        if (carportLength > 540 && carportLength <= 720) {
            first = 4;
        }
        if (carportWidth > 540 && carportWidth <= 720) {
            second = 2;
        }
        return first + second;
    }


    @Override
    public int overStern540Calc() {
        int first = 0;
        int second = 0;
        if (carportLength > 720) {
            first = 4;
        }
        if (carportWidth > 720) {
            second = 2;
        }
        return first + second;
    }

    @Override
    public int zShedDoorCalc() { // regner om der er valgt et skur eller ej.
        if (shedLength > 0 && shedWidth > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int looseHolter270() {
        int first = 0;
        int second = 0;

        if (shedLength > 260 && shedLength <= 290) {
            first = 4;
        }
        if (shedWidth > 260 && shedWidth <= 290) {
            second = 6;
        } else if (shedWidth > 500 && shedWidth <= 530) {
            second = 12;

        }
        return first + second;
    }

    @Override
    public int looseHolter240() {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;

        if (shedLength >= 90 && shedLength <= 260) {
            first = 4;
        }
        if (shedLength > 290 && shedLength <= 360) {
            second = 8;
        }
        if (shedWidth >= 90 && shedWidth <= 260) {
            third = 6;
        }
        if (shedWidth > 290 && shedWidth <= 500) {
            fourth = 12;
        }

        return first + second + third + fourth;
    }

    @Override
    public int remCarCalc() { // Beregner hvor mange 600 Rem vi skal bruge
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;

        if (carportLength * 2 > 1200) {
            first = 2;
        }
        if (carportLength * 2 <= 1200 && carportLength * 2 > 1080) {
            second = 2;
        }
        if (carportLength * 2 <= 1080 && carportLength * 2 > 960) {
            third = 1;
        }
        if (carportLength * 2 <= 600 && carportLength * 2 > 480) {
            fourth = 1;
        }
        return first + second + third + fourth;
    }

    @Override
    public int remShedCalc() { // Beregner hvor mange 480 Rem vi skal bruge
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;

        if (carportLength * 2 < 1680 && carportLength * 2 > 1200) {
            first = 1;
        }
        if (carportLength * 2 <= 1080 && carportLength * 2 > 960) {
            second = 1;
        }
        if (carportLength * 2 <= 960 && carportLength * 2 > 600) {
            third = 2;
        }
        if (carportLength * 2 <= 480) {
            fourth = 1;
        }


        return first + second + third + fourth;
    }


    @Override
    public int raftersCalc() { // Denne regner hvor mange sp??r, der skal bruges inklusiv dem p?? skr?? tag
        double raisedLength; // L??ngden p?? en side af det skr?? tag
        double raisedHeight; // H??jden p?? midterstykket der holder skr??taget
        double totalLength; // Den totale l??ngde af ekstra sp??r der skal bruges
        int rafters; // Det totale antal sp??r vi skal bruge



        raisedLength = (0.5 * carportWidth) / Math.cos(angle);
        raisedHeight = Math.sqrt((Math.pow(raisedLength, 2)) + (Math.pow(0.5 * carportWidth, 2)));
        totalLength = 2 * raisedLength + raisedHeight;

        rafters = carportLength/55;
        float distance = carportLength/rafters;

        if (distance> 55) {
            rafters = rafters+2;

        } else {
            rafters = rafters+1;
        }

        if (totalLength <= 600) {
            rafters++;
        } else {
            rafters = rafters + 2;
        }

        return rafters;
    }

    @Override
    public int beamsCalc() { // Denne regner ud hvor mange stolper der skal bruges UDEN skur
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;

        if (carportLength >= 240 && carportLength <= 440) {
            first = 4;
        } else if (carportLength >= 470 && carportLength <= 750) {
            first = 6;
        } else if (carportLength > 750 && carportLength <= 780) {
            first = 8;
        }
        if (carportWidth > 380) {
            second = 1;
        }
        if (shedWidth > 0 && shedLength > 0) {
            third = 2;
        }

        if (shedWidth > maxHalfShedWidth && shedWidth < maxShedWidth || shedWidth < maxHalfShedWidth && shedWidth > 0); {
            if (shedLength <= 310) {
                fourth = 2;
            } else {
                fourth = 3;
            }
        }
        return first + second + third + fourth;
    }

    @Override
    public int dressShedCalc() { // Denne beregner hvor mange br??dder der skal bruges rundt om skuret
        int dressingBoards = (int) (shedLength * 2) + (shedWidth * 2);
        return (int) (dressingBoards / 7.4);
    }

    @Override
    public int waterBoardSidesCalc() { // Denne beregner hvor mange 540 vandbr??t der skal bruges
        int first = 0;
        int second = 0;

        if (carportLength > 720) {
            first = 4;
        }
        if (carportWidth > 720) {
            second = 2;
        }
        return first + second;
    }

    @Override
    public int waterBoardEndsCalc() {  // Denne beregner hvor mange 360 vandbr??t der skal bruges
        int first = 0;
        int second = 0;

        if (carportLength > 540 && carportLength <= 720) {
            first = 4;
        }
        if (carportWidth > 540 && carportWidth <= 720) {
            second = 2;
        }
        return first + second;
    }

    @Override
    public int roofPlates600Calc() { // Math.ceil runder op til n??rmeste heltal i double og vi parser til int for at fjerne ".0" i heltallet
        double radians = Math.toRadians(angle);
        double raisedLength = (0.5 * carportWidth) / Math.cos(radians); // L??ngden p?? en side af det skr?? tag
        if (raisedLength > 360) {
            return (int) Math.ceil((float) carportLength / 100) * 2;
        } else {
            return 0;
        }
    }


    @Override
    public int roofPlates360Calc() { // Math.ceil runder op til n??rmeste heltal i double og vi parser til int for at fjerne ".0" i heltallet
        double radians = Math.toRadians(angle);
        double raisedLength = (0.5 * carportWidth) / Math.cos(radians); // L??ngden p?? en side af det skr?? tag
        if (raisedLength <= 360) {
            return (int) (Math.ceil((float) carportLength / 100)) * 2;
        } else {
            return 0;
        }

    }


    @Override
    public int roofBackCalc() { // Tagryggen.
        if (carportLength <= 400) {
            return 1;
        } else {
            return 2;
        }

    }

    @Override // L??gter p?? 360
    public int laths360Calc() {
        if(carportLength >= 240 && carportLength <= 360) {
            return 1;
        } else if(carportLength > 480 && carportLength <= 720) {
            return 2;
        } else if (carportLength > 720 && carportLength <= 780) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int laths480Calc() { // L??gter p?? 480
        if(carportLength > 360 && carportLength <= 480 || carportLength > 720 && carportLength <= 780) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int roofScrewsCalc() {
        double radians = Math.toRadians(angle);
        double raisedLength = (0.5 * carportWidth) / Math.cos(radians); // L??ngden p?? en side af det skr?? tag
        double screws = (2 * (raisedLength/100) * (carportLength/100) * 12); // Arealet af en skr??t tag * 12 skruer pr m^2
        return (int) Math.ceil(screws/200);
    }


    @Override
    public int holeBandCalc() {
        int i = carportLength - 50 - shedLength;
        int j = carportWidth - 70;
        if ((Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2)) * 2 / 100) > 10) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public int universalBracketRightCalc() { // Denne regner samlet antal universalbeslag ud.
        return (int) Math.ceil((double) carportLength/55);
    }

    @Override
    public int universalBracketLeftCalc() { // Denne regner samlet antal universalbeslag ud.
        return (int) Math.ceil((double) carportLength/55);
    }


    @Override
    public int sternScrewsCalc() {
        if (beamsCalc() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int bracketScrewsCalc() { // 9 skruer pr alle forskellige slags beslag vi skal bruge. 250 skruer i en pakke
        int beslagSkruer = 9 * (universalBracketRightCalc() + universalBracketLeftCalc() + angleBracketCalc() + holePlate());
        //Antal universalbeslagh??jre + universalbeslag venstre + antal vinkel beslag + antal hulplader

        return (int) Math.ceil((double) beslagSkruer/250);
    }


    @Override
    public int boardBoltCalc() { // Hvor mange bolte der skal bruges
        int maxShedWidth = carportWidth-70;
        int maxHalfShedWidth = (carportWidth-70)/2;
        int beamsThatNeedBolt = beamsCalc();

        // Det nedenunder kommer til at virke perfekt, hvis de vores beregning for de kan v??lge halvt skur
        // og 3 kvart skur er korrekte p?? hjemmesiden!

        if (shedWidth > 0 && shedLength > 0) {
            beamsThatNeedBolt = beamsThatNeedBolt - 2;
        }
        if (shedWidth > maxHalfShedWidth && shedWidth < maxShedWidth) {
            beamsThatNeedBolt = beamsThatNeedBolt - 1;
        }
        if (shedWidth > maxHalfShedWidth && shedWidth < maxShedWidth && shedLength > 310) {
            beamsThatNeedBolt = beamsThatNeedBolt - 1;
        }
        return beamsThatNeedBolt*2;
    }

    @Override
    public int squareDiscsCalc() { // Hvor mange discs der skal bruges
        return (int) ((boardBoltCalc() * 0.6666666) + 1);
    }

    @Override
    public int outerDressScrewsCalc() { // Skruer til ydre bekl??dning
        if ((2 * shedLength) + (2 * shedWidth) > 0 && (2 * shedLength) + (2 * shedWidth) <= 740) {
            return 1;
        } else if ((2 * shedLength) + (2 * shedWidth) > 740 && (2 * shedLength) + (2 * shedWidth) <= 1480) {
            return 2;
        } else if ((2 * shedLength) + (2 * shedWidth) > 1480) {
            return 3;
        } else {
            return 0;
        }
    }


    @Override
    public int innerDressScrewsCalc() { // Skruer til indre bekl??dning
        return outerDressScrewsCalc();
    }

    @Override
    public int barnDoorHandlesCalc() {  // Standard ting der bruges til alle skurer
        if (shedLength > 0 && shedWidth > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int tHingeCalc() { // Standard ting der bruges til alle skurer
        if (shedLength > 0 && shedWidth > 0) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int angleBracketCalc() {
        return (looseHolter270() + looseHolter240()) * 2;
    }

    @Override
    public int holePlate() { // beslag der bruges til de skr?? sp??r i raised roof
        int rafters = (int) Math.ceil((double) carportLength/55); // Hvor mange sp??r der g??r p?? tv??rs
        return (rafters-1)*8; // Der bruges 8 hulplader pr sp??r (-1 fordi der kun bruges 4 i hver ende)
    }
}
