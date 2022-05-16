package dat.startcode.model.services;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlatRoofCalc implements ICalculator {
    private int carportWidth;
    private int carportLength;
    private int shedWidth;
    private int shedLength;
    private int shedBeams;
    private int maxShedWidth = carportWidth - 70;
    private double maxHalfShedWidth = maxShedWidth * 0.5;


    public FlatRoofCalc(int carportWidth, int carportLength, int shedWidth, int shedLength) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.shedBeams = extraShedBeams();
    }

    @Override
    public int getAmount(int partsID){
        switch (partsID){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                return beamsCalc();
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
            case 24:
                break;
            case 25:
                break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                break;
            case 29:
                break;
            case 30:
                break;
            case 31:
                break;
            case 32:
                break;
                default:
                return 0;
        }
        return 0;
    }

    @Override
    public int extraShedBeams() { // Denne regner ud hvor mange stolper der skal lægges til MED skur
        if (shedWidth <= 0 && shedLength <= 0) {
            return 0;
        } else if (shedWidth <= 310) {
            return 1;
        } else {
            return 2;
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
        return (int) Math.ceil((double) carportLength/55);
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
        if (carportLength > 380) {
            second = 1;
        }
        if ((((carportLength - 130) - shedLength) / 310) < 1) {
            third = 2;
        }
        if (shedWidth > maxHalfShedWidth && shedWidth < maxShedWidth) {
            if (shedLength <= 310) {
                fourth = 2;
            } else {
                fourth = 3;
            }
        }
        return first + second + shedBeams + third + fourth;
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
            return (int) Math.ceil((float) carportWidth / 100)*2;
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
        return (int) Math.ceil(((double) screws/200));
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
        int beslagSkruer = 9 * (universalBracketRightCalc() + universalBracketLeftCalc() + angleBracketCalc()) ;
        // Antal universalbeslaghøjre + universalbeslag venstre + antal vinkel beslag
        return (int) Math.ceil((double) beslagSkruer/250);
    }


    @Override
    public int boardBoltCalc() {
        int maxShedWidth = carportWidth-70;
        int maxHalfShedWidth = (carportWidth-70)/2;
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
            return beamsThatNeedBolt*2;
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
        return (looseHolter270()+ looseHolter240())*2;
    }

    @Override
    public int holePlate() { // beslag der bruges til de skrå spær i raised roof
        return 0;
    }
}
