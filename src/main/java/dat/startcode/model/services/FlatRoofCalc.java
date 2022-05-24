package dat.startcode.model.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatRoofCalc implements ICalculator {
    private int carportWidth;
    private int carportLength;
    private int shedWidth;
    private int shedLength;
    private int maxShedWidth;
    private double maxHalfShedWidth;


    public FlatRoofCalc(int carportWidth, int carportLength, int shedWidth, int shedLength) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
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
    public int remCarCalc() { // // Beregner hvor mange 600 Rem vi skal bruge
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
    public int raftersCalc() { // Denne regner hvor mange spær, der skal bruges på tværs af carporten

        int amount = carportLength/55;

        float distance = carportLength/amount;

        if (distance> 55) {
            amount = amount+2;

        } else {
            amount = amount+1;
        }
        return amount;
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
    public int dressShedCalc() { // Denne beregner hvor mange brædder der skal bruges rundt om skuret
        int dressingBoards = (int) (shedLength * 2) + (shedWidth * 2);
        return (int) (dressingBoards / 7.4);
    }

    @Override
    public int waterBoardSidesCalc() { // Denne beregner hvor mange 540 vandbræt der skal bruges
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
    public int waterBoardEndsCalc() { // Denne beregner hvor mange 360 vandbræt der skal bruges
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
    public int roofPlates600Calc() { // Math.ceil runder op til nærmeste heltal i double og vi parser til int for at fjerne ".0" i heltallet
        if (carportLength > 360) {
            return (int) Math.ceil((float) carportWidth / 100);
        } else {
            return 0;
        }
    }

    @Override
    public int roofPlates360Calc() { // Math.ceil runder op til nærmeste heltal i double og vi parser til int for at fjerne ".0" i heltallet
        if (carportLength <= 360) {
            return (int) Math.ceil((float) carportWidth / 100);
        } else if (carportLength > 600 && carportLength <= 700) {
            return (int) Math.ceil((float) carportWidth / 100) * 2;
        } else if (carportLength > 700) {
            return (int) Math.ceil((float) carportWidth / 100);
        } else {
            return 0;
        }
    }

    @Override
    public int roofBackCalc() {
        return 0;
    }

    @Override
    public int laths360Calc() { // Lægter 360
        return 0;
    }

    @Override
    public int laths480Calc() { // Lægter 480
        return 0;
    }

    @Override
    public int roofScrewsCalc() {
        int screws = (carportLength / 100) * (carportWidth / 100) * 12;
        return (int) Math.ceil(((double) screws / 200));
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
        return raftersCalc();
    }

    @Override
    public int universalBracketLeftCalc() { // Denne regner samlet antal universalbeslag ud.
        return raftersCalc();
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
        int beslagSkruer = 9 * (universalBracketRightCalc() + universalBracketLeftCalc() + angleBracketCalc());
        // Antal universalbeslaghøjre + universalbeslag venstre + antal vinkel beslag
        return (int) Math.ceil((double) beslagSkruer / 250);
    }


    @Override
    public int boardBoltCalc() {
        int maxShedWidth = carportWidth - 70;
        int maxHalfShedWidth = (carportWidth - 70) / 2;
        int beamsThatNeedBolt = beamsCalc();

        // Det nedenunder kommer til at virke perfekt, hvis de vores beregning for de kan vælge halvt skur
        // og 3 kvart skur er korrekte på hjemmesiden!

        if (shedWidth > 0 && shedLength > 0) {
            beamsThatNeedBolt = beamsThatNeedBolt - 2;
        }
        if (shedWidth > maxHalfShedWidth && shedWidth < maxShedWidth) {
            beamsThatNeedBolt = beamsThatNeedBolt - 1;
        }
        if (shedWidth > maxHalfShedWidth && shedWidth < maxShedWidth && shedLength > 310) {
            beamsThatNeedBolt = beamsThatNeedBolt - 1;
        }
        return beamsThatNeedBolt * 2;
    }

    @Override
    public int squareDiscsCalc() {// Hvor mange discs der skal bruges
        return (int) ((boardBoltCalc() * 0.6666666) + 1);
    }

    @Override
    public int outerDressScrewsCalc() { // Skruer til ydre beklædning
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
    public int innerDressScrewsCalc() { // Skruer til indre beklædning
        return outerDressScrewsCalc();
    }

    @Override
    public int barnDoorHandlesCalc() { // Standard ting der bruges til alle skurer
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
    public int holePlate() { // beslag der bruges til de skrå spær i raised roof
        return 0;
    }

    public static void main(String[] args) { // Til test

        int a = 780;
        int b = 55;

        int amount = a/55;

        float distance = a/amount;

        if (distance> 55) {
            amount = amount+2;

        } else {
            amount = amount+1;
        }
        System.out.println("Du får den her mængte spær: " +amount);
    }
}
