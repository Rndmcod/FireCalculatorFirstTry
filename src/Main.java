import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("Введите год начала жизни на % от 2002 до 2022:");

        int userInput = input.nextInt();

        if (DateCheck.CheckDate(userInput)) {

            Calculator.calcul(userInput);

        }
    }
}