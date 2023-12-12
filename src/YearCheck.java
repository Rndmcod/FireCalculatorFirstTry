public class YearCheck {

    public void validateInputYear(int year) {
        if (year < 2002 || year > 2021) {
            throw new RuntimeException("Throw exception...");
        }
    }
}

