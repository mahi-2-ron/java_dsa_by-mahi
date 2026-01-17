// without the treading 

import java.util.Scanner;
import jdk.jshell.spi.ExecutionControl;

class threading {

    public static void main(String[] args) throws InterruptedException {
        // System.out.println("Application started ... ");
        // Bank b = new Bank();
        // b.bankingActivity();
        // Beta beta = new Beta();
        // Gamma gamma = new Gamma();
        // beta.start();
        // gamma.start();
        // System.out.println("Main thread finished");
        System.out.println("Without the synchronization");
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                c.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.count);

    }
}

class Beta extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Collect your cash ");
            System.out.println("Banking Activity terminated");
            System.out.println("Printing activity started");
            for (int i = 0; i <= 5; i++) {
                System.out.println(" ** ");
                Thread.sleep(4000);
            }
            System.out.println("Printing the cash is completed");
            System.out.println("Application Terminated");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}

class Gamma extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("What you must learn from the king KOHLI");
            for (int i = 0; i < 10; i++) {
                System.out.println("Focus -- commitmenet -- passion -- hardwork -- risk");
                Thread.sleep(3000);
            }
            System.out.println("Mahi dont worry one day you will get successful");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Counter {

    int count = 0;

    synchronized void increment() {
        count++;
    }
}

class Bank {

    public void bankingActivity() {
        System.out.println("Jai java");
        System.out.println("Application started ....");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user number");
        int un = sc.nextInt();
        System.out.println("Enter the password");
        int pass = sc.nextInt();

    }
}
// ==> with the synchronization - correct

// class Counter {
//     int count = 0;
//     synchronized void increment() {
//         count++;
//     }
// }
// public class Demo {
//     public static void main(String[] args) throws Exception {
//         Counter c = new Counter();
//         Thread t1 = new Thread(() -> {
//             for(int i=0; i<1000; i++) c.increment();
//         });
//         Thread t2 = new Thread(() -> {
//             for(int i=0; i<1000; i++) c.increment();
//         });
//         t1.start();
//         t2.start();
//         t1.join();
//         t2.join();
//         System.out.println(c.count);
//     }
// }
//  ==> without the synchronization - correct
// class Counter {
//     int count = 0;
//     void increment() {
//         count++;
//     }
// }
// public class Demo {
//     public static void main(String[] args) throws Exception {
//         Counter c = new Counter();
//         Thread t1 = new Thread(() -> {
//             for(int i=0; i<1000; i++) c.increment();
//         });
//         Thread t2 = new Thread(() -> {
//             for(int i=0; i<1000; i++) c.increment();
//         });
//         t1.start();
//         t2.start();
//         t1.join();
//         t2.join();
//         System.out.println(c.count);
//     }
// }
