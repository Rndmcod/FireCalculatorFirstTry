public class Main {
    public static void main(String[] args)  {
        System.out.println("Введите год начала жизни на % от 2002 до 2022:");
        Calculator calculator = new Calculator();
        double resultCapital = calculator.maxPercentWithdraw();
        System.out.println(resultCapital);

    }
}