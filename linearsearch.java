

public class linearsearch {
    // Linear search for the one dimesnsional array
    public static int linearSearch(int arr[], int key) {
      int n = arr.length;

      for(int i = 0; i < n; ++i) {
         if (arr[i] == key) {
            return i;
         }
      }
    //   //from the for-each loop
    //   for(int element : arr){
    //     if(element == key)
    //     return element;
    //   }

      return -1;
   }
    // Linear search for the two dimesnsional array
    public static int[] linearSearch2D(int[][] arr,int key){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(  key ==arr[i][j]){
                     return new int[] {i,j};
                }
                 
            }
        }
        return new int[] {-1,-1};
    }
    static boolean searchChar(String str,char target){
        if(str.length() == 0){
            return false;
        }
        for(int i=0;i<str.length();i++){
            if(target == str.charAt(i))
            return true;
        }

        // by for-each loop 
        for(char ch : str.toCharArray()){
            if(target == ch){
                return true ;
            }
        }
        return false;
    }
    public static int searchinRange(int arr[], int key,int from,int to) {
      int n = arr.length;

      for(int i = from; i < to; ++i) {
         if (arr[i] == key) {
            return i;
         }
      }
    

      return -1;
   }

   public static void main(String[] args) {
    int[] arr = {2,4,6,7,8,9};
    int res = linearSearch(arr, 6);
    if(res != -1)
      System.out.println("THe number is found at the index " + res);
      else
      System.out.println("The number not found");
      int[][] matrix = {
        {1,2,3,4},
        {2,3,4,5}
      };
      int[] Res = linearSearch2D(matrix, 2);
      if(Res[0] != -1)
      System.out.println("The number is found at the indexes of " + Res[0] + "and " + Res[1]);
      else
      System.out.println("The nuber is not found ");

   }
}
