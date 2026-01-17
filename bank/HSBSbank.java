
class HSBSbank {
// this is thee object level locking 

    int accBal;

    public HSBSbank(int accBal) {
        this.accBal = accBal;
    }

    synchronized public void withdrawal(int withdrawal) {
        System.out.println(Thread.currentThread().getName() + "Withddrawing " + withdrawal);
        accBal = accBal - withdrawal;
        System.out.println("Balance after withdrawal: ₹" + accBal);
    }

    synchronized public void deposit(int deposit) {
        System.out.println(Thread.currentThread().getName() + "depositing " + deposit);

        accBal = accBal + deposit;
        System.out.println("Balance after deposit: ₹" + accBal);
    }

    synchronized public void checkBalance() {
        System.out.println(Thread.currentThread().getName() + "Checking balancce: ₹" + accBal);
        System.out.println("The balance is: ₹" + accBal);
    }

    public static void main(String[] args) {
        HSBSbank account = new HSBSbank(1000);
        Thread atm = new Thread(() -> {
            account.withdrawal(500);
        }, "ATM");

        Thread gpay = new Thread(() -> {
            account.deposit(1000);
        }, "Gpay");

        Thread Phonepay = new Thread(() -> {
            account.checkBalance();
        }, "Phonepay");

        atm.start();
        gpay.start();
        Phonepay.start();

    }
}
