public class ceiling {
    public static int findCielingNumber(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
          int mid = start + (end-start) / 2 ;
          if(target == arr[mid])
          return mid;
          else if(target <= arr[mid])
          end = mid - 1 ;
          else
          start = mid + 1 ;
        }
        return start ;
    }
    //find the smallest letter i,e greater then the target ==> ceiling
     public static char ceilingLetters(char[] ch,char target){
        int start = 0;
        int end = ch.length-1;
        while(start <= end){
          int mid = start + (end-start) / 2 ;
          if(target == ch[mid])
          return ch[mid];
          else if(target <= ch[mid])
          end = mid - 1 ;
          else
          start = mid + 1 ;
        }
        return ch[start % ch.length] ;
     }
     public static void main(String[] args) {
        // int[] arr = {2,4,6,7,7,9};
        // int res = findCielingNumber(arr,8 );
        // System.out.println(res);
        char[] name = {'a','e','i','0','u'};
        System.out.println(ceilingLetters(name, 'b'));
     }
}
