import java.util.Scanner;

public class Shre { // Class name matches the file name (lowercase)
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Dynamic input for name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("My name is " + name);

        // Dynamic input for variables
        System.out.print("Enter an integer: ");
        int i = scanner.nextInt();

        System.out.print("Enter a float: ");
        float f = scanner.nextFloat();

        System.out.print("Enter a double: ");
        double d = scanner.nextDouble();

        System.out.println("You entered:");
        System.out.println("Integer: " + i);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);

        // Hello World and overloaded method call
        System.out.println("Hello world");

        Temp t = new Temp();
        System.out.print("Enter an integer for the overloaded method: ");
        int valueForOverloaded = scanner.nextInt();
        t.main(valueForOverloaded);

        scanner.close();
    }
}

class Temp { // Separate class Temp
    // Overloaded main method
    public void main(int i) {
        System.out.println("Hello world from the overloaded main method");
        System.out.println("You passed the value: " + i);
    }
}

