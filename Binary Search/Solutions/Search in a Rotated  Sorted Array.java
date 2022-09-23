class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int pivot = findPivot(nums);
        if (binarySearch(nums,target,0,pivot) != -1) return binarySearch(nums,target,0,pivot);
        else if (binarySearch(nums,target,pivot + 1, nums.length-1) != -1) return binarySearch(nums,target,pivot+1,nums.length-1);
        else return -1;
    }
        
    public static int findPivot(int[] arr){
        if (arr.length == 1) return 0;
        int n = arr.length;
        int s = 0;
        int e = n - 1;
        while (s<=e){
            int m = s + (e-s)/2;
            int next = (m + 1) % n;
            int prev = (m + n - 1) % n;
            if (arr[m]> arr[prev] && arr[m]>arr[next]) return m;
            else if ((arr[m]>=arr[0])) s = m + 1;
            else e = m - 1;
        }
        return s;    
    }
    
    public static int binarySearch(int[] arr, int target, int start, int end){
        while (start<=end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
