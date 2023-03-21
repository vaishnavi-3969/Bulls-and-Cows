package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //        public static void stage1() {
//            System.out.println("The secret code is prepared: ****");
//            System.out.println();
//            System.out.println("Turn 0. Answer: \n1234\nGrade: None.");
//            System.out.println();
//            System.out.println("Turn 1. Answer: \n9876\nGrade: 4 bulls. \nCongrats The secret code is 9876");
//        }

    public static boolean guess(String secretCode) {
        char[] numArray = secretCode.toCharArray();
        char[] secret = new char[numArray.length];
        String number = scanner.next();
        char[] array = number.toCharArray();
        char[] arr = new char[array.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
            secret[i] = numArray[i];
        }
//        System.out.println("Input no.: ");
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Secret Code");
//        System.out.println(Arrays.toString(secret));
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < secret.length; j++) {
                if (arr[i] == secret[j] && i == j) {
                    bulls += 1;
                }
                if (arr[i] == secret[j] && i != j) {
                    cows += 1;
                }
            }
        }
        System.out.print("Grade: ");
        if (bulls > 0 && cows > 0) {
            System.out.println(bulls + " bull(s)" + " and " + cows + " cow(s). ");
        } else if (bulls > 0) {
            System.out.print(bulls + " bull(s). ");
        } else if (cows > 0) {
            System.out.println(cows + " cow(s). ");
        } else {
            System.out.println("None. ");
        }
//            System.out.print("The secret code is."+num);
        if (bulls == secret.length) {
            System.out.println("Congratulations! You guessed the secret code");
            return true;
        }
        return false;
    }

    static final Scanner scanner = new Scanner(System.in);

    //--------------------------------------------------------------------
    public static void main(String[] args) {
        String secretCode = "";
//        boolean checkFlag = false;
//        do {
        int length = 0;
        int symbols = 0;
        System.out.println("Please, enter the secret code's length:");
        StringBuilder sb = new StringBuilder();
        StringBuilder symb = new StringBuilder();
        try {
            sb.append(scanner.nextLine());
//            len = scanner.nextLine();
            length = Integer.parseInt(String.valueOf(sb));

        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error: \"" + sb.toString() + "\" isn't a valid number.");
            System.exit(0);
        }
        if (length <= 0) {
            System.out.println("Error");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        try {
            symb.append(scanner.nextLine());
//            symb = scanner.next();
            symbols = Integer.parseInt(String.valueOf(symb));
        } catch (NumberFormatException | NegativeArraySizeException e) {
//            e.printStackTrace();
            System.out.println("Error: \"" + symb + "\" isn't a valid number.");
            System.exit(0);
        }
        if (symbols <= 0) {
            System.out.println("Error");
            System.exit(0);
        }
        if (symbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        if (symbols >= length) {
            secretCode = generateNumber(length, symbols - 1);


//            if (length > 0 && length < 10) {
//                secretCode = generateNumber(length);
//                checkFlag = true;
//            } else {
//                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
//            }

//        } while (!checkFlag);
            boolean flag = false;
            int i = 1;
//        System.out.println(secretCode);
            System.out.print("The secret code is prepared: ");
            for (int j = 0; j < secretCode.length(); j++) {
                System.out.print("*");
            }
            System.out.print(" (0-9, a-");
            String alpha = "0123456789abcdefghijklmnopqrstuvwxyz";
            char[] alphabets = alpha.toCharArray();
            System.out.println(alphabets[symbols - 1] + ").");
            System.out.println("Okay, let's start a game!");
            while (!flag) {
                System.out.println("Turn " + i + ":");
                flag = guess(secretCode);
                System.out.println();
                i += 1;
            }
        } else {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + symb + " unique symbols.");
        }
    }


    public static String generateNumber(int digit, int symbols) {
        return generateString(digit, symbols);
    }

    public static String generateString(int n, int symbols) {
        String alpha = "0123456789abcdefghijklmnopqrstuvwxyz";
        char[] alphabets = alpha.toCharArray();

        String[] finalSymbols = new String[symbols];
        for (int i = 0; i < symbols; i++) {
            finalSymbols[i] = String.valueOf(alphabets[i]);
        }
        Random random = new Random();
        boolean[] arr = new boolean[symbols];
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            int temp = random.nextInt();
            while (temp > 0) {
                if (!arr[temp % symbols] && sb.length() < n) {
                    arr[temp % symbols] = true;
                    sb.append(finalSymbols[temp % symbols]);
                }
                temp /= symbols;
            }
        }
        return sb.toString();
    }
}
