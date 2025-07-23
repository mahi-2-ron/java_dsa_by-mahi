import java.util.Scanner;
public class FUNCTION {

    public static void main(String[] args) {
//        System.out.println("Om shree raghavendraswami namaha");
          Scanner in = new Scanner(System.in);
//        System.out.println("Enter the number 1");
//        int num0 = in.nextInt();
//        System.out.println("Enter the number 2");
//        int num1 = in.nextInt();
//        int res = addTwo(num0,num1);
//        System.out.println("the addition two numbers :" + res);
//        System.out.println("Enter the number n to check its prime or not :");
//        int n = in.nextInt();
//        System.out.println("Emter the number to get n prime numbers");
//        int p = in.nextInt();
//        printPrime(p);
        System.out.println("Enter the 1 three digit number to get armstrong number :");
        int a = in.nextInt();




    }
    public static  int addTwo(int a,int b){
        return  (a+b);
    }
    public static boolean isPrime(int n){
        int i = 2;
        boolean prime = true;
        while(i * i < n){
            if(n % i == 0){
                prime = false;
            }
            i++;
        }
        return prime;
    }
    public static void  printPrime(int n){
        for(int i = 2 ; i<= n ; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;

        while (n != 0) {
            int rem = n % 10;
            sum += rem * rem * rem;
            n /= 10;
        }

        return sum == original;
    }
    public static void print3DigitArmstrongNumbers() {
        for (int i = 100; i <= 999; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }
}
