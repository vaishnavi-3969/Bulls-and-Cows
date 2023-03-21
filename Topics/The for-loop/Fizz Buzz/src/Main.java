import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int start = scanner.nextInt();
        int end = scanner.nextInt();
        do {
            if (start % 3 == 0 && start % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (start % 3 == 0) {
                System.out.println("Fizz");
            } else if (start % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(start);
            }
            start += 1;
        } while (start <= end);
    }
}