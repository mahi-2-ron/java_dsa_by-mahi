
class test extends Thread {

    // public void run() {
    //     System.out.println("Thread is running");
    //     try {
    //         Thread.sleep(4000);
    //     } catch (Exception e) {
    //         System.out.println("Thread completed.");
    //     }
    // }
    // public void run() {
    //     System.out.println("Running thread: " + Thread.currentThread().getName());
    // }
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " — Priority: " + getPriority());
    }

    public static void main(String[] args) {
        // test t = new test();
        // System.out.println("State : " + t.getState());
        // t.start();
        // System.out.println("State : " + t.getState());
        // try {
        //     Thread.sleep(3000);
        // } catch (Exception e) {
        // }
        // System.out.println("State :" + t.getState());
        test t1 = new test();
        test t2 = new test();
        test t3 = new test();

        t1.setPriority(Thread.MIN_PRIORITY);  // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t3.setPriority(Thread.MAX_PRIORITY);  // 10

        // t1.run();   // called from main thread
        // t1.start(); // starts new thread
        t1.start();
        t2.start();
        t3.start();

    }
}
