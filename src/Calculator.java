import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    public static void calc() throws Exception {

        Scanner input = new Scanner(System.in);
        double capital = 10000;
        double percent;
        double capend;
        int userInput = input.nextInt();

        if (userInput >= 2002 && userInput <= 2021) {
            outer:
            for (percent = 0.005; percent < 100.0; percent += 0.005) {
                double start = capital * percent;
                double nextyearcap = capital - start;

                for (int i = userInput - 2001; i < Constants.MOEX_RATE.length; i++) {
                    double rashod = start * (Constants.INFLATION_RATE[i - 1] / 100) + start;
                    double dohod = nextyearcap * (1 + (Constants.MOEX_RATE[i] - Constants.MOEX_RATE[i - 1]) / Constants.MOEX_RATE[i - 1]);
                    capend = dohod - rashod;
                    nextyearcap = capend;
                    start = rashod;
                    if (capend < 0) {
                        break outer;
                    }
                }
            }
            double number = percent;
            DecimalFormat answer = new DecimalFormat("#.0");
            String formatedAnswer = answer.format((number * 100));
            System.out.println(formatedAnswer);


        } else {
            throw new CalculatorException("Throw exception...");
        }
    }
}
