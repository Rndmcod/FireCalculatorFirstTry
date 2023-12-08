import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    public static double calcul(int userInput) throws CalculatorException {

        double capital = 10000;
        double capend;
        double maxpercent = 100.0;
        double oppercent = 0.005;
        double percent;
        int formyear = 2001;
        int hundredpercent = 1;
        int onehundred = 100;
        int zeroresult = 0;
        boolean isRight = false;

        for (percent = oppercent; percent < maxpercent; percent += oppercent) {
            double start = capital * percent;
            double nextyearcap = capital - start;

            for (int i = userInput - formyear; i < Constants.MOEX_RATE.length; i++) {
                double rashod = start * (Constants.INFLATION_RATE[i - hundredpercent] / onehundred) + start;
                double dohod = nextyearcap * (hundredpercent + (Constants.MOEX_RATE[i] -
                        Constants.MOEX_RATE[i - hundredpercent]) / Constants.MOEX_RATE[i - hundredpercent]);

                capend = dohod - rashod;
                nextyearcap = capend;
                start = rashod;

                if (capend < zeroresult) {
                    isRight = true;
                    break;
                }
            }
            if (isRight) {
                break;
            }
        }
        double number = percent;
        DecimalFormat answer = new DecimalFormat("#.0");
        String formatedAnswer = answer.format((number * onehundred));
        System.out.println(formatedAnswer);
        return (percent);
    }
}
