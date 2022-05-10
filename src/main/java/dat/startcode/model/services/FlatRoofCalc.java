package dat.startcode.model.services;

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
        this.shedBeams = exstraShedBeams();
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
    public int exstraShedBeams() {
        if(shedWidth <= 0 && shedLength <= 0){
            return 0;
        }else if(shedWidth<=310){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public int underStern360Calc() {
        int first = 0;
        int secound = 0;
        if(carportLength>540 && carportLength<=720){
            first = 4;
        }
        if(carportWidth>540 && carportWidth<=720){
            secound = 4;
        }
        return first + secound;
    }

    @Override
    public int underStern540Calc() {
        int first = 0;
        int secound = 0;
        if(carportLength>720){
            first = 4;
        }
        if(carportWidth>720){
            secound = 2;
        }
        return first + secound;
        // =IF(L2>720;4;0)+IF(L3>720;2;0)
    }

    @Override
    public int overStern360Calc() {
        return 0;
    }

    @Override
    public int overStern540Calc() {
        return 0;
    }

    @Override
    public int zShedDoorCalc() {
        return 0;
    }

    @Override
    public int looseHolterEnds() {
        return 0;
    }

    @Override
    public int looseHolterSides() {
        return 0;
    }

    @Override
    public int remCarCalc() {
        return 0;
    }

    @Override
    public int remShedCalc() {
        return 0;
    }

    @Override
    public int raftersCalc() {
        return 0;
    }



    @Override
    public int beamsCalc() {
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
    public int dressShedCalc() {
        return 0;
    }

    @Override
    public int waterBoardSidesCalc() {
        return 0;
    }

    @Override
    public int waterBoardEndsCalc() {
        return 0;
    }

    @Override
    public int roofPlates600Calc() {
        return 0;
    }

    @Override
    public int roofPlates360Calc() {
        return 0;
    }

    @Override
    public int roofBackCalc() {
        return 0;
    }

    @Override
    public int laths360Calc() {
        return 0;
    }

    @Override
    public int laths480Calc() {
        return 0;
    }

    @Override
    public int roofScrewsCalc() {
        return 0;
    }

    @Override
    public int holeBandCalc() {
        return 0;
    }

    @Override
    public int universalBracketRightCalc() {
        return 0;
    }

    @Override
    public int universalBracketLeftCalc() {
        return 0;
    }

    @Override
    public int sternScrewsCalc() {
        return 0;
    }

    @Override
    public int bracketScrewsCalc() {
        return 0;
    }

    @Override
    public int boardBoltCalc() {
        return 0;
    }

    @Override
    public int squareDiscsCalc() {
        return 0;
    }

    @Override
    public int outerDressScrewsCalc() {
        return 0;
    }

    @Override
    public int innderDressScrewsCalc() {
        return 0;
    }

    @Override
    public int barnDoorHandlesCalc() {
        return 0;
    }

    @Override
    public int tHingeCalc() {
        return 0;
    }

    @Override
    public int angleBracketCalc() {
        return 0;
    }
}
