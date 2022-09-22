class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      // First sort both the Arrays to Apply Binary Search
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ans = new ArrayList();
      
      // we will check for every element in nums1 in nums2 and if it is found, we add it to List "ans"
        if (binarySearch(nums2,nums1[0]) !=-1 ) ans.add(nums1[0]);
        for (int i=1;i<nums1.length;i++){
            if ((binarySearch(nums2, nums1[i])!=-1 && nums1[i-1]!=nums1[i])){
                ans.add(nums1[i]);
            }
        }
      
      // Create a array and copy elements from list to return the answer.
        int[] ansArr = new int[ans.size()];
        for(int i=0;i< ans.size();i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
    
  // if an element from nums1 in found in nums2 , this function returns the index else return -1
    public int binarySearch(int[] nums2, int target){
        int start = 0;
        int end = nums2.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (nums2[mid] < target){
                start = mid + 1;
            }
            else if (nums2[mid] > target){
                end = mid - 1;
            }
            else return mid;
        }
        return -1;
    } 
    
}


// Time Complexity: O(nums1.length * log(nums2.length)) = O(n*log(n))
