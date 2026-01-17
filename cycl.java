class cycl{
     private static void cyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int crtidx = arr[i]-1;
            
            if(arr[i] != arr[crtidx]){
                int temp = arr[i];
                arr[i] = arr[crtidx];
                arr[crtidx] = temp ;
            }else{
                i++;
            }

        }
        for(int j=0;j<arr.length;j++){
            System.out.println(arr[j]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        cyclicSort(arr);
        
    }
}