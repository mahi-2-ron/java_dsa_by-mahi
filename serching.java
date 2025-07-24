public class serching {

   public static int linearSearch(int arr[], int key) {
      int n = arr.length;

      for(int i = 0; i < n; ++i) {
         if (arr[i] == key) {
            return i;
         }
      }

      return -1;
   }
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
   public static void insertonSort(int arr[]){
    int n = arr.length;
    for(int i=1;i<n;i++){
        int j = i - 1;
        int key = arr[i];
        while( j>=0 && arr[j] >= key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key ;
    }
   }

   public static void main(String[] args) {
   

    int arr [] = {1,2,3,4,5,6,7,8,9};
    int res = binarySearch(arr, 7);
    if(res >= 0){
        System.out.println("The key found at the index :"+res);
    }else{
        System.out.println("The key is not founding");
    }
    System.out.println(res);
    System.out.println("Om ganeshaya namaha");
    int num[] = { 0,5,8,4,6,2};
    insertonSort(num);
    //PRINTING THE ARRAY WHICH WILL BE SORT
    for(int i = 0;i<num.length;i++){
        System.out.println(num[i]);
    }




   }
}


