class Temp1 {
    // Instance variables
    int alpha, beta, zeta;

    // Constructor
    Temp1() {
        System.out.println("This is from Temp1 Constructor");
    }

    // Method to perform multiplication
    int multi() {
        return alpha * beta * zeta;
    }

    // Method to set values
    void setVal(int a, int b, int z) {
        alpha = a;
        beta = b;
        zeta = z;
    }
}

public class Temp { // Main class with the main method
    public static void main(String[] args) {
        // Create an instance of Temp1
        Temp1 t1 = new Temp1();

        // Set values using the setVal method
        t1.setVal(10, 20, 30);

        // Perform multiplication and display the result
        int ans = t1.multi();
        System.out.println("Answer of Multiplication: " + ans);

        // Update values and perform multiplication again
        t1.setVal(5, 6, 7);
        ans = t1.multi();
        System.out.println("Updated Answer of Multiplication: " + ans);
    }
}