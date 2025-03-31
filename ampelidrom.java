import java.util.Scanner;

public class Ampelidrom {

    // Function to check if a number is an Armstrong number
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    // Function to check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean armstrong = isArmstrong(number);
        boolean palindrome = isPalindrome(number);

        System.out.println("\nResults:");
        System.out.println("Is Armstrong: " + armstrong);
        System.out.println("Is Palindrome: " + palindrome);

        if (armstrong && palindrome) {
            System.out.println("The number is both an Armstrong number and a Palindrome!");
        } else if (armstrong) {
            System.out.println("The number is an Armstrong number but not a Palindrome.");
        } else if (palindrome) {
            System.out.println("The number is a Palindrome but not an Armstrong number.");
        } else {
            System.out.println("The number is neither an Armstrong number nor a Palindrome.");
        }

        scanner.close();
    }
}
