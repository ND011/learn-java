public class SingleThreadApp {
    public static void printNumbers() { // Fixed method name
        for (int i = 1; i <= 5; i++) { // Fixed loop initialization
            System.out.println("Number: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) { // Fixed typo
                System.out.println("Thread interrupted!");
                Thread.currentThread().interrupt(); // Restore the interrupt flag
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Single Threaded Execution Started");
        long start = System.currentTimeMillis();

        printNumbers(); // Corrected method call

        long end = System.currentTimeMillis();
        System.out.println("Execution Time: " + (end - start) + "ms"); // Print execution time
    }
}
