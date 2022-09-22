class Solution {
    public boolean checkIfExist(int[] arr) {
      // First Sort the array to apply Binary Search
        Arrays.sort(arr);
      
        for (int i=0;i<arr.length;i++){
          // For Each element in array we will check if its double exist
          
          // BINARY SEARCH :
            int start = 0;
            int end = arr.length - 1;
            int target = 2*arr[i];
            while (start<=end){
                int mid = start + (end-start)/2;
                if (arr[mid]==target && mid!=i){
                  // if target is found we must check that the index is different since 0 can have same index
                    return true;
                }
                else if (arr[mid]<target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
      // if none of above cases in loop is true, it means that double of any number in array does not exist
      // Hence, return False !
        return false;
    }
}
