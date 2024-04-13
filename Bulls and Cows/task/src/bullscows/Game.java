package bullscows;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*8763
int answerFirstDigit = answers/1000;  //8
int answerSecondDigit = answers%1000/100; //7
int answerThirdDigit = answers%1000%100/10; //6
int answerForthDigit =answers%1000%100%10; //3

// initialize a Random object somewhere; you should only need one
Random random = new Random();
// generate a random integer from 0 to 899, then add 100
int x = random.nextInt(900) + 100;
 */

public class Game {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    private final char ZERO = 48;
    private final char NINE = 57;
    private final char a = 97;
    private final char z = 122;
    private final int MIN_NUMBER_LEGAL_SYMBOLS = 1;
    private final int MAX_NUMBER_LEGAL_SYMBOLS = (NINE - ZERO + 1) + (z - a + 1);

    public void execution() {
        int secretCodeLength = inputLevel();
        if (secretCodeLength == -1) {
            return;
        }

        int numberSymbols = inputNumberSymbols(secretCodeLength);
        if (numberSymbols == -1) {
            return;
        }

        String theNumber = generateTheNumber(secretCodeLength, numberSymbols);
        printSecretCode(secretCodeLength, numberSymbols);
        tryToGuess(theNumber);

        sc.close();
    }

    private int inputLevel() {
        System.out.println("Input the length of the secret code:");
        System.out.print(">");
        String userInput = sc.nextLine();
        int inputLength;
        try {
            inputLength = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.printf("Error: %s isn't a valid number. Exit...\n", userInput);
            return -1;
        }

        if (inputLength < MIN_NUMBER_LEGAL_SYMBOLS || inputLength > MAX_NUMBER_LEGAL_SYMBOLS) {
            System.out.printf("Error: length should be between %d and %d. But you input %s. Exit...\n",
                    MIN_NUMBER_LEGAL_SYMBOLS, MAX_NUMBER_LEGAL_SYMBOLS, userInput);
            return -1;
        }

        return inputLength;
    }

    private int inputNumberSymbols(int secretCodeLength) {
        System.out.println("Input the number of possible symbols in the code:");
        System.out.print(">");
        String userInput = sc.nextLine();
        int inputNumberSymbols;
        try {
            inputNumberSymbols = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.printf("Error: %s isn't a valid number. Exit...\n", userInput);
            return -1;
        }

        if (inputNumberSymbols < secretCodeLength) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols. Exit...\n",
                    secretCodeLength, inputNumberSymbols);
            return -1;
        } else if (inputNumberSymbols > MAX_NUMBER_LEGAL_SYMBOLS) {
            System.out.printf("Error: maximum number of possible symbols in the code is %d (%c-%c, %c-%c). Exit...\n",
                    MAX_NUMBER_LEGAL_SYMBOLS, ZERO, NINE, a, z);
            return -1;
        } else if (inputNumberSymbols < 1) {
            System.out.printf("Error: minimum number of possible symbols in the code is %d (%c-%c, %c-%c). Exit...\n",
                    MIN_NUMBER_LEGAL_SYMBOLS, ZERO, NINE, a, z);
            return -1;
        }

        return inputNumberSymbols;
    }


    private char generateDigits(int numberDigits) {
        int leftLimit = ZERO;
        int rightLimit = numberDigits > (NINE - ZERO) ? NINE : leftLimit + numberDigits;

        int randomLimitedInt = leftLimit + (int)
                (random.nextFloat() * (rightLimit - leftLimit + 1));
        return (char) randomLimitedInt;
    }

    private char generateLetters(int numberLetters) {
        int countNumbers = 10;
        int leftLimit = a;
        int rightLimit = numberLetters < 37 ? leftLimit + numberLetters - countNumbers - 1 : z;

        int randomLimitedInt = leftLimit + (int)
                (random.nextFloat() * (rightLimit - leftLimit + 1));
        return (char) randomLimitedInt;
    }

    private char generateOneChar(int numberSymbols) {
        boolean isDigits = random.nextBoolean();
        char ch;

        if (numberSymbols < 11) {
            ch = generateDigits(numberSymbols);
        } else {
            ch = isDigits ? generateDigits(numberSymbols) : generateLetters(numberSymbols);
        }

        return ch;
    }

    private String generateTheNumber(int length, int numberSymbols) {

        StringBuilder sb = new StringBuilder(generateOneChar(numberSymbols));
        //full inn array
        for (int i = 0; i < length; i++) {
            int index;
            char next;
            do {
                next = generateOneChar(numberSymbols);
                index = sb.indexOf(String.valueOf(next));
            } while (index >= 0);
            sb.append(next);
        }
        System.out.println(sb);
        return sb.toString();
    }

    private void printSecretCode(int length, int numberSymbols) {

        char[] stars = new char[length];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = '*';
        }
        char maxDigits;
        char minLetters;
        char maxLetters;
        if (numberSymbols < 11) {
            maxDigits = (char) (numberSymbols - 1 + ZERO);
            System.out.printf("The secret is prepared: %s (%c - %c).\n",
                    String.valueOf(stars), ZERO, maxDigits);
        } else {
            maxDigits = NINE;
            minLetters = a;
            maxLetters = (char) (minLetters + numberSymbols - 1 - 10);
            System.out.printf("The secret is prepared: %s (%c - %c), (%c - %c).\n",
                    String.valueOf(stars), ZERO, maxDigits, minLetters, maxLetters);
        }
    }

    private int[] compareNumberWithAnswer(String answer, String theNumber) {
        int[] bullsCows = {0, 0};        //bulls, cows

        char[] answerArray = splitToElements(answer);
        char[] theNumberArray = splitToElements(theNumber);

        //check that the answer contains only legal symbols
        for (int i = 0; i < answerArray.length; i++) {
            if (answerArray[i] < ZERO ||
                    (answerArray[i] > NINE && answerArray[i] < a) ||
                    (answerArray[i] > z)) {
                System.out.println("Error. Your input contains illegal symbols.");
                bullsCows[0] = -1;
                bullsCows[1] = -1;
                return bullsCows;
            }
        }

        for (int i = 0; i < answerArray.length; i++) {
            if (answerArray[i] == theNumberArray[i]) {
                bullsCows[0]++;
                continue;
            }
            for (int j = 0; j < answerArray.length; j++) {
                if (answerArray[i] == theNumberArray[j] && i != j) {
                    bullsCows[1]++;
                }
            }
        }
        return bullsCows;
    }

    private char[] splitToElements(String number) {
        StringBuilder sb = new StringBuilder(number);
        char[] elements = new char[sb.length()];

        for (int i = 0; i < sb.length(); i++) {
            elements[i] = sb.charAt(i);
        }
        return elements;
    }


    private void tryToGuess(String theNumber) {
        boolean isGuessed = false;
        int counter = 1;

        System.out.println("Okay, let's start a game!");

        do {
            System.out.printf("Turn %d:\n", counter);
            System.out.print(">");
            String answer = sc.next();

            if (answer.length() != theNumber.length()) {
                System.out.printf("Error: wrong input! The number of symbols should be %d! \n", theNumber.length());
//                continue;
                return;
            }

            //if answer contains invalid symbols

            int[] bullCows = compareNumberWithAnswer(answer, theNumber);
            int bulls = bullCows[0];
            int cows = bullCows[1];
            if (bulls == -1 || cows == -1) {
                return;
            }

            printGuessAnswer(bulls, cows);

            if (bullCows[0] == theNumber.length()) {
                isGuessed = true;
            }
            counter++;
        } while (!isGuessed);
        System.out.println("Congratulations! You guessed the secret code.");
    }

    private void printGuessAnswer(int bulls, int cows) {
        Locale.setDefault(Locale.ENGLISH);
        String outputBulls = "";
        switch (bulls) {
            case 0:
                outputBulls = "";
                break;
            case 1:
                outputBulls = "1 bull";
                break;
            default:
                outputBulls = String.format("%d bulls", bulls);
                break;
        }

        String outputCows = "";
        switch (cows) {
            case 0:
                outputCows = "";
                break;
            case 1:
                outputCows = "1 cow";
                break;
            default:
                outputCows = String.format("%d cows", cows);
                break;
        }

        if (bulls == 0 && cows == 0) {
            System.out.printf("Grade: None.");
        } else if (bulls == 0) {
            System.out.printf("Grade:  %s", outputCows);
        } else if (cows == 0) {
            System.out.printf("Grade:  %s", outputBulls);
        } else {
            System.out.printf("Grade:  %s and %s", outputBulls, outputCows);
        }
        System.out.println();
    }

    private String depr_generateTheNumber(int secretCodeLength) {
        Random rand = new Random();
        int upper = (int) Math.pow(10, secretCodeLength);
        int lower = (int) Math.pow(10, secretCodeLength - 1);
        int num = 0;
        boolean isUnique = false;

        do {
            num = rand.nextInt(upper - lower - 1) + lower;
            int[] arr = depr_splitToDigits(num);
            isUnique = true;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    if (arr[j] == arr[i]) {
                        isUnique = false;
                    }
                }
            }
        } while (!isUnique);
        System.out.println(num);

        return String.valueOf(num);
    }

    private int[] depr_splitToDigits(int number) {
        int tempForTens = number;

        int tens = 0;
        while (tempForTens > 9) {
            tempForTens = tempForTens / 10;
            tens++;
        }

        int[] digits = new int[tens + 1];
        int tempForArray = number;

        for (int i = 0; i < digits.length; i++) {
            digits[i] = tempForArray / (int) Math.pow(10, tens);  //9235 / 1000 = 9       235/100 = 2
            tempForArray = tempForArray % (int) Math.pow(10, tens);     //9235 % 1000 = 235     235%100
            tens--;
        }

        return digits;
    }
}
