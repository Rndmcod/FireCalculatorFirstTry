public class YearCheck {

    public void validateInputYear(int year) {
        final int minYear = 2002;
        final int maxYear = 2021;
        if (year < minYear || year > maxYear) {
            throw new RuntimeException("Throw exception...");
        }
    }
}