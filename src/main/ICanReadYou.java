package main;

import methods.Essentials;
import methods.OptionalMethods;
import methods.Secrets;

import java.util.Scanner;

public class ICanReadYou {

    public static void main(String[] args) {
        Secrets secrets = new Secrets();
        Essentials essentials = new Essentials();
        OptionalMethods optionalMethods = new OptionalMethods();
        Scanner scanner = new Scanner(System.in);

        boolean isPlayActive;
        String userInputForPlay;

        System.out.print("Welcome!\nThis is the game in which I will read your mind and know all the numbers that you are going to enter while playing with me\nI will give you the secret number at the beginning of the game, and you will help me to achieve that number (unknowingly)\nSo do you want to start the game?\nAnswer: ");
        userInputForPlay = scanner.nextLine();

        int[] userInput = new int[5];

        // isPlayActive = userInputForPlay.contains("Yes") || userInputForPlay.contains("yes") || userInputForPlay.contains("Y") || userInputForPlay.contains("y") || userInputForPlay.contains("True") || userInputForPlay.contains("true") || userInputForPlay.contains("T") || userInputForPlay.contains("t") || userInputForPlay.contains("1") || userInputForPlay.contains("one");
        isPlayActive = essentials.validateIfUserWantsToPlay(userInputForPlay);

        while (isPlayActive) {
            optionalMethods.clear();

            System.out.print("Enter any number: ");
            userInput[0] = scanner.nextInt();
            scanner.nextLine(); // to consume the newline character left in the input stream after calling nextInt()

            int lengthOfUserInput = String.valueOf(userInput[0]).length();

            int secretNumber = secrets.generateSecretNumber(userInput[0]);

            int operationalNumber = secrets.generateOperationalNumber(userInput[0]);

            System.out.println("Keep this number secret: " + secretNumber);

            System.out.print("Enter any " + lengthOfUserInput + " digits number: ");
            userInput[1] = scanner.nextInt();
            userInput[1] = essentials.performValidationAndRevertUserInput(userInput[1], userInput[0]);
            scanner.nextLine(); // to consume the newline character left in the input stream after calling nextInt()

            System.out.println("Add this number to the list: " + (operationalNumber - userInput[1]));
            userInput[2] = (operationalNumber - userInput[1]);

            System.out.print("Enter any " + lengthOfUserInput + " digits number: ");
            userInput[3] = scanner.nextInt();
            userInput[3] = essentials.performValidationAndRevertUserInput(userInput[3], userInput[0]);
            scanner.nextLine(); // to consume the newline character left in the input stream after calling nextInt()

            System.out.println("Add this number to the list: " + (operationalNumber - userInput[3]));
            userInput[4] = (operationalNumber - userInput[3]);

            System.out.println("Add all the number we entered:\n" + userInput[0] + " + " + userInput[1] + " + " + userInput[2] + " + " + userInput[3] + " + " + userInput[4] + " = " + (userInput[0] + userInput[1] + userInput[2] + userInput[3] + userInput[4]));
            System.out.println("That's the same secret number I gave you at the beginning!\n");

            System.out.print("Do you want to try again?\nAnswer: ");
            userInputForPlay = scanner.nextLine();

            isPlayActive = userInputForPlay.contains("Yes") || userInputForPlay.contains("yes") || userInputForPlay.contains("Y") || userInputForPlay.contains("y") || userInputForPlay.contains("True") || userInputForPlay.contains("true") || userInputForPlay.contains("T") || userInputForPlay.contains("t") || userInputForPlay.contains("1") || userInputForPlay.contains("one");
        }
        scanner.close();
        optionalMethods.clear();
    }
}