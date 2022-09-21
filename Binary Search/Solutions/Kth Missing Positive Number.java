class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int i = 1;
      // Exit the loop when count  = k i.e when Kth missing element is found.
        while (count < k){
          // start counting from 0
          // check for i in array
          // if i does not exist then increase the count 
            if (!(binarySearch(arr,i))){
                ++count;
            }
            ++i;
        }
      // i-1 will be kth missing element 
        return i-1;
    }
    
    public static boolean binarySearch(int[] arr, int target){
        int s = 0;
        int e = arr.length-1;
        while ( s<=e ){
            int mid = s + (e-s)/2;
            if (arr[mid] > target){
                e = mid - 1;
            }
            else if(arr[mid] < target){
                s = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
        
}
