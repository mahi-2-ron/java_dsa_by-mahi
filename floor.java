public class floor {
    public static int findFloorumber(int[] arr,int target){
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
    
     public static void main(String[] args) {
        int[] arr = {2,4,6,7,7,9};
        int res = findFloorumber(arr,8 );
        System.out.println(res);
     }
}
