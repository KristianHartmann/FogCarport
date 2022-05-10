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
        this.shedBeams = extraShedBeams();
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
        int secound = 0;
        if (carportLength > 540 && carportLength <= 720) {
            first = 4;
        }
        if (carportWidth > 540 && carportWidth <= 720) {
            secound = 4;
        }
        return first + secound;
    }

    @Override
    public int underStern540Calc() {
        int first = 0;
        int secound = 0;
        if (carportLength > 720) {
            first = 4;
        }
        if (carportWidth > 720) {
            secound = 2;
        }
        return first + secound;
        // =IF(L2>720;4;0)+IF(L3>720;2;0)
    }

    @Override
    public int overStern360Calc() {
        int first = 0;
        int secound = 0;
        if (carportLength > 540 && carportLength <= 720) {
            first = 4;
        }
        if (carportWidth > 540 && carportWidth <= 720) {
            secound = 2;
        }
        return first + secound;
    }


    @Override
    public int overStern540Calc() {
        int first = 0;
        int secound = 0;
        if (carportLength > 720) {
            first = 4;
        }
        if (carportWidth > 720) {
            secound = 2;
        }
        return first + secound;
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
    public int looseHolterWidth() {
        int first = 0;
        int secound = 0;

        if (shedLength > 260 && shedLength <= 290) {
            first = 4;
        }
        if (shedWidth > 260 && shedWidth <= 290) {
            secound = 6;
        } else if (shedWidth > 500 && shedWidth <= 530) {
            secound = 12;

        }
        return first + secound;
    }

    @Override
    public int looseHolterLength() {
        int first = 0;
        int secound = 0;
        int third = 0;
        int fourth = 0;

        if (shedLength >= 90 && shedLength <= 260) {
            first = 4;
        }
        if (shedLength > 290 && shedLength <= 360) {
            secound = 8;
        }
        if (shedWidth >= 90 && shedWidth <= 260) {
            third = 6;
        }
        if (shedWidth > 290 && shedWidth <= 500) {
            fourth = 12;
        }

        return first + secound + third + fourth;
    }

    @Override
    public int remCarCalc() {
        int first = 0;
        int secound = 0;
        int third = 0;
        int fourth = 0;

        if (carportLength * 2 > 1200) {
            first = 2;
        }
        if (carportLength * 2 <= 1200 && carportLength * 2 > 1080) {
            secound = 2;
        }
        if (carportLength * 2 <= 1080 && carportLength * 2 > 960) {
            third = 1;
        }
        if (carportLength * 2 <= 600 && carportLength * 2 > 480) {
            fourth = 1;
        }
        return first + secound + third + fourth;
    }

    @Override
    public int remShedCalc() {
        int first = 0;
        int secound = 0;
        int third = 0;
        int fourth = 0;

        if (carportLength * 2 < 1680 && carportLength * 2 > 1200) {
            first = 1;
        }
        if (carportLength * 2 <= 1080 && carportLength * 2 > 960) {
            secound = 1;
        }
        if (carportLength * 2 <= 960 && carportLength * 2 > 600) {
            third = 2;
        }
        if (carportLength * 2 <= 480) {
            fourth = 1;
        }


        return first + secound + third + fourth;
    }


    @Override
    public int raftersCalc() { // Denne regner hvor mange spær, der skal bruges.
        int rafters = (int) (carportLength / 55);
        return rafters + 1;
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
    public int dressShedCalc() {
        int dressingBoards = (int) (shedLength * 2) + (shedWidth * 2);
        return (int) (dressingBoards / 7.4);
    }

    @Override
    public int waterBoardSidesCalc() {
        int first = 0;
        int secound = 0;

        if (carportLength > 720) {
            first = 4;
        }
        if (carportWidth > 720) {
            secound = 2;
        }
        return first + secound;
    }

    @Override
    public int waterBoardEndsCalc() {
        int first = 0;
        int secound = 0;

        if (carportLength > 540 && carportLength <= 720) {
            first = 4;
        }
        if (carportWidth > 540 && carportWidth <= 720) {
            secound = 2;
        }
        return first + secound;
    }

    @Override
    public int roofPlates600Calc() {
        if (carportLength > 360 && carportLength <= 600) {
            return (carportWidth / 100);
        } else if (carportLength > 700) {
            return (carportWidth / 100);
        } else {
            return 0;
        }
    }


    @Override
    public int roofPlates360Calc() {
        if (carportLength <= 360) {
            return (carportWidth / 100);
        } else if (carportLength > 600 && carportLength <= 700) {
            return 2 * carportWidth / 100;
        } else if (carportLength > 700) {
            return carportWidth / 100;
        } else {
            return 0;
        }
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
        int screws = (carportLength / 100) * (carportWidth / 100) * 12;
        return (int) (screws / 200) + 1;
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
    public int bracketScrewsCalc() {
        int i = universalBracketRightCalc() + universalBracketLeftCalc() + angleBracketCalc();

        int first = 0;
        int secound = 0;
        int third = 0;

        if (i * 9 + (raftersCalc() * 4) <= 250) {
            first = 1;
        }
        if (i * 9 + (raftersCalc() * 4) > 250 && i * 9 + (raftersCalc() * 4) <= 500) {
            secound = 2;
        }
        if (i * 9 + (raftersCalc() * 4) > 500) {
            third = 3;
        }
        return first + secound + third;
    }


    @Override
    public int boardBoltCalc() {
        return (beamsCalc() - 2) * 2;
    }

    @Override
    public int squareDiscsCalc() {
        return (int) ((boardBoltCalc() * 0.6666666) + 1);
    }

    @Override
    public int outerDressScrewsCalc() {
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
    public int innderDressScrewsCalc() {
        return outerDressScrewsCalc();
    }

    @Override
    public int barnDoorHandlesCalc() {
        if (shedLength > 0 && shedWidth > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int tHingeCalc() {
        if (shedLength > 0 && shedWidth > 0) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int angleBracketCalc() {
        return (looseHolterWidth()+ looseHolterLength())*2;
    }
}
