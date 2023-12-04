import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputMismatchException {

        Scanner input = new Scanner(System.in);

        int min = 2002;
        int max = 2021;

        System.out.println("Введите год начала жизни на % от " + min + " до " + max + ":");

        double capital = 10000;
        double percent = 0.005;
        double capend = 0;

        while (true) {
            int userInput = input.nextInt();
            if (userInput >= min && userInput <= max) {
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
                break;
            } else {
                System.out.println("Введен некорректный год.");
                break;
            }

        }
    }
}