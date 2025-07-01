public class serching {
  
  
   

   public static int linearSearch(int[] var0, int var1) {
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if (var0[var3] == var1) {
            return var3;
         }
      }

      return -1;
   }

   public static void main(String[] var0) {
      int[] var1 = new int[]{2, 4, 6, 8};
      int var2 = linearSearch(var1, 2);
      if (var2 >= 0) {
         System.out.println("The key found at the index of " + var2);
      } else {
         System.out.println("The key isn't found");
      }

   }
}


