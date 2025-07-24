public class Assignment {
    public static int findHCF(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b ;
            a = temp ;
        }
        return a ;
    }
    public static int findLCM(int a,int b){
        int lcm = a * b / findHCF(a,b);
        return lcm ;
    }
    public static void findPerfectNum(int n){
        int sum = 0;
        for(int i=1; i<= n/2 ; i++){
            if(n % i == 0){
                sum += i;
            }
        }
       if(sum == n)
           System.out.println("The " + n + " is the perfect number " );
       else
           System.out.println("The" + n + " is not the perfect number");
    }
    public static void main(String[] args) {
        System.out.println("Om shrre raghavendraswami namaha");
        System.out.println(findLCM(12,240));
        findPerfectNum(28);

    }
}