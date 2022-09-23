class Solution {
    public int singleNonDuplicate(int[] nums) {
    int s = 0;
    int e = nums.length - 1;
    while (s<e){
       int m = s + (e-s)/2;
      // Check if Duplicate exist in Right
       if (nums[m]==nums[m+1]){
         // Check if elements in Both the Partition are Even
         if ((e-m)%2 == 0) s = m + 2;
         else e = m - 1;
        }
      // Check if Duplicate exist in Left
       else if (nums[m]==nums[m-1]){
         // Check if elements in Both the Partition are Even
         if ((e-m)%2 == 0) e = m - 2;
         else s = m + 1;
        }
      // if above 2 Conditions are not True, then current mid is Answer
       else return nums[m];
    }
   return nums[s];     
    }
}
// ALTERNATIVE METHOD: CHECK THE FIRST AND LAST OCCURENCE OF ALL THE ELEMENTS AND BREAK THE BINARY SEARCH OF ALL ELEMENTS WHEN FIRST OCCUR == LAST OCCUR
