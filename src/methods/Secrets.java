package methods;

public class Secrets {
    public int generateSecretNumber(int userInput) {
        return Integer.parseInt("2" + userInput) - 2;
    }

    public int generateOperationalNumber(int userInput) {
        return Integer.parseInt("9".repeat(Math.max(0, String.valueOf(userInput).length())));
    }
}
