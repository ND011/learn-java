 class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                Thread.currentThread().interrupt(); // Restore the interrupted status
                return; // Exit the loop
            }
        }
    }
}

public class MultiThreadRunnableExample {
    public static void main(String[] args) {
        System.out.println("Start of main thread");

        MyRunnable myRunnable = new MyRunnable();

        // Creating multiple threads using the same Runnable instance
        Thread thread1 = new Thread(myRunnable, "Thread-1");
        Thread thread2 = new Thread(myRunnable, "Thread-2");

        // Start both threads
        thread1.start();
        thread2.start();

        System.out.println("End of main thread");
    }
}
