public class DateCheck {
    int started = 2002;
    int ended = 2021;

    public static boolean CheckDate(int userInput) throws CalculatorException {
        int started = 2002;
        int ended = 2021;

        if (userInput >= started && userInput <= ended) {


        } else {
            throw new CalculatorException("Throw exception...");
        }

        return true;

    }
}
