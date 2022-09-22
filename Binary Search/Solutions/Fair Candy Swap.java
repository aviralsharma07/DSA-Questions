class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int a = aliceSizes.length;
        int b = bobSizes.length;
        int[] answer = new int[2];
      
      // First we will sort the arrays to apply Binary Search
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
      
      // sumA = sum of Candies Alice has
      // sumB = sum of Candies Bob has
        int sumA = 0, sumB = 0;
        for (int i=0;i<a;i++){
            sumA+=aliceSizes[i];
        }
        for (int i=0;i<b;i++){
            sumB+=bobSizes[i];
        }
      
      // final candies = equal candies they must have at end of exchange
        int finalCandies = (sumA + sumB)/2;
      
      // We will iterate through all the elements of alice array and seach for a element in Bob array such that 
      // Sum of Candies Bob has - bob's candy box + alice's candy box =  final Candies
        for (int i=0; i<a; i++){
            if(binarySearch(aliceSizes[i],bobSizes,sumB,finalCandies) != -1){
                answer[0] = aliceSizes[i];
                answer[1] = binarySearch(aliceSizes[i],bobSizes,sumB,finalCandies);
            }
        }
        return answer;
    }
    
  // This function will find the Bob's Box that is to be exchanged
    public int binarySearch(int a, int[] arr, int sumOfB, int fC){
      
      // a = Alice's Box of Candies
      // arr = bobSizes Areray
      // sumofB = sumB = sum of total candies Bob have
      // fC=  final Candies
      
        int start =  0;
        int end = arr.length-1;
      
        while (start<=end){
            int mid = start + (end - start)/2;
            int newSum = sumOfB - arr[mid] + a;
            if (newSum == fC) return arr[mid];
            else if(newSum <= fC){
                end = mid - 1;
            }
            else start = mid + 1;
        }
      
        return -1;
    }

}
