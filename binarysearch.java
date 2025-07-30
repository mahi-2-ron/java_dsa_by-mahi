

public class binarysearch {
    public static int binarySearch(int arr[],int key){
    int n = arr.length;
    int low = 0;
    int high = n-1;
    
    while(high >= low){
     int mid = low + (high - low ) / 2;
        if(arr[mid] == key){
     
            return mid;
            
        }
        else if(key >= arr[mid]){
            low = mid + 1;
        }else{
            high = mid -1;
        }
    }
    return -1;

   }

   public static int orderAgnosticBinarySearch(int arr[],int key){
    int n = arr.length;
    int low = 0;
    int high = n-1;
    
    while(high >= low){
     int mid = low + (high - low ) / 2;
        if(arr[mid] == key){
     
            return mid;
            
        }
        else if(key >= arr[mid]){
            
             high = mid -1;
        }else{
           low = mid + 1;
        }
    }
    return -1;

   }
   public static void main(String[] args) {
     int[] arr = {2,4,6,7,8,9};
    int res = binarySearch(arr, 6);
    if(res != -1)
      System.out.println("THe number is found at the index " + res);
      else
      System.out.println("The number not found");
   }
    
}
