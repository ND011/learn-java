import java.util.Scanner;

public class shre { // Class name updated to follow naming conventions
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Dynamic input for name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("My name is " + name);

        // Dynamic input for variables
        System.out.print("Enter an integer: ");
        int i = getIntInput(scanner);

        System.out.print("Enter a float: ");
        float f = getFloatInput(scanner);

        System.out.print("Enter a double: ");
        double d = getDoubleInput(scanner);

        System.out.println("You entered:");
        System.out.println("Integer: " + i);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);

        // Hello World and overloaded method call
        System.out.println("Hello world");

        Temp t = new Temp();
        System.out.print("Enter an integer for the overloaded method: ");
        int valueForOverloaded = getIntInput(scanner);
        t.overloadedMethod(valueForOverloaded); // Updated method call

        scanner.close();
    }

    // Method to safely get an integer input
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Method to safely get a float input
    private static float getFloatInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a float: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Method to safely get a double input
    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a double: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}

class Temp { // Separate class Temp
    // Overloaded method renamed for clarity
    public void overloadedMethod(int i) {
        System.out.println("Hello world from the overloaded method");
        System.out.println("You passed the value: " + i);
    }
}