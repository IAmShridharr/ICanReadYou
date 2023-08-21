package methods;

import java.util.Scanner;

public class Essentials {
    public boolean validateIfUserWantsToPlay(String userInputForPlay) {
        // Convert the user input to lowercase
        String lowerCaseInput = userInputForPlay.toLowerCase();

        // Check for positive responses (in lowercase)
        boolean hasPositiveResponse = lowerCaseInput.contains("yes") ||
                lowerCaseInput.contains("yup") ||
                lowerCaseInput.contains("y") ||
                lowerCaseInput.contains("true") ||
                lowerCaseInput.contains("1") ||
                lowerCaseInput.contains("one");

        // Check for negative responses (in lowercase)
        boolean hasNegativeResponse = lowerCaseInput.contains("no") ||
                lowerCaseInput.contains("not") ||
                lowerCaseInput.contains("never") ||
                lowerCaseInput.contains("don't") ||
                lowerCaseInput.contains("won't") ||
                lowerCaseInput.contains("nope");

        // Return the final result
        return hasPositiveResponse && !hasNegativeResponse;
    }

    public boolean verifyUserInput(int userInput, int userFirstInput) {
        return String.valueOf(userInput).length() == String.valueOf(userFirstInput).length();
    }

    public int performValidationAndRevertUserInput(int userInput, int firstUserInput) {
        Scanner sc = new Scanner(System.in);
        boolean isUserInputValid = verifyUserInput(userInput, firstUserInput);
        if (!isUserInputValid) {
            while (!isUserInputValid) {
                System.out.print("You could only enter " + String.valueOf(firstUserInput).length() + " digits number: ");
                userInput = sc.nextInt();
                sc.nextLine(); // to consume the newline character left in the input stream after calling nextInt()
                isUserInputValid = verifyUserInput(userInput, firstUserInput);
            }
        }
        return userInput;
    }
}
