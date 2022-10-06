class Solution {
    public int findMin(int[] nums) {
      
      // Find Pivot in the Given Rotated Array
      // Pivot  = index of Greatest Element
        int pivot = findPivot(nums);
      
      // if Array is not completely rotated then Smallest Element is element just Right to Pivot
        if (pivot != nums.length-1) return nums[pivot+1];
      
      // if pivot == array length - 1. then it means Array is rotated N times and is completely sorted as if not roated at all
      //array = [A0, A1, A2, - - - - - An-1 ]
        else return nums[0];
    }
    
  // Function to Find Pivot in a Rotated Sorted Array
    public int findPivot(int arr[]){
        int start = 0;
        int end = arr.length - 1;
        while (start<=end){
            int mid  = start + (end - start)/2;
            if (mid < end && arr[mid]>arr[mid+1]) return mid;
            if (mid > start && arr[mid] < arr[mid-1]) return mid-1;
            if (arr[mid] < arr[start]) end = mid - 1;
            else start = mid + 1;
        }
        return arr.length - 1;
    }
    
}
