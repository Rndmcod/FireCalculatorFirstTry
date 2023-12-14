import java.util.Scanner;

public class Calculator {

    private int year = 0;
    private int startIndex = 0;
    private final double[] MOEX_RATE = Constants.MOEX_RATE;
    private final double[] INFLATION_RATE = Constants.INFLATION_RATE;

    private final YearCheck checkYear = new YearCheck();


    public void readYear() {
        Scanner inputYear = new Scanner(System.in);
        this.year = inputYear.nextInt();
        checkYear.validateInputYear(this.year);
    }

    public double maxPercentWithdraw() {
        this.readYear();
        int minYear = 2002;
        this.startIndex = this.year - minYear;
        double capital = 10000;

        double minPercent = 0.5;

        boolean percentCheck = true;
        double minResult = Double.MAX_VALUE;
        while (percentCheck) {
            double result = getLastCapital(minPercent, capital);
            if (result < minResult) {
                minResult = result;
                minPercent += 0.5;
            } else {
                percentCheck = false;
            }
        }
        return minPercent;
    }

    public double getLastCapital(double minPercent, double capital) {
        double liveCost = capital / 100 * minPercent;

        for (int i = startIndex; i < MOEX_RATE.length; i++) {
            capital = this.calculateNextYear(capital, liveCost, i);
            if (capital <= 0) {
                return Double.MAX_VALUE;
            }
            if (i == MOEX_RATE.length - 1) {
                return capital;
            }

        }
        return Double.MAX_VALUE;
    }

    private double calculateNextYear(double currentCapital, double livecost, int yearIndex) {
        double thisYearCapital = currentCapital - livecost;
        if (this.startIndex != yearIndex) {
            double changedPercents = (MOEX_RATE[yearIndex] * 100) / MOEX_RATE[yearIndex - 1] - 100;
            thisYearCapital += thisYearCapital / 100 * changedPercents;
        }
        thisYearCapital -= thisYearCapital / 100 * INFLATION_RATE[yearIndex];
        return thisYearCapital;

    }

}