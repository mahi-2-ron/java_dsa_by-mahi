
class CanaraBank {

    static int accBal = 1000;

    static synchronized void withdrawal(int withdrawal) {
        System.out.println(Thread.currentThread().getName() + "withdrwaing " + withdrawal);
        accBal = accBal - withdrawal;
        System.out.println("Balance after withdrawl: " + accBal);

    }

    static synchronized void deposit(int deposit) {
        System.out.println(Thread.currentThread().getName() + "depositing " + deposit);
        accBal = accBal + deposit;
        System.out.println("Balance after withdrawl: " + accBal);

    }

    static synchronized void checkBalance() {
        System.out.println(Thread.currentThread().getName() + "checking the balance " + accBal);
    }

    public static void main(String[] args) {
        CanaraBank acc1 = new CanaraBank();
        CanaraBank acc3 = new CanaraBank();
        Thread atm = new Thread(() -> {
            acc1.withdrawal(500);
        }, "ATM");
        Thread phonepay = new Thread(() -> {
            acc3.deposit(1000);
        }, "Phonepay");
        Thread gpay = new Thread(() -> {
            CanaraBank.checkBalance();
        }, "Gpay");
        atm.start();
        phonepay.start();
        gpay.start();

    }
}
