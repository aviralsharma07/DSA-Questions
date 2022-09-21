class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
          
            if(target>=letters[mid]){
              // if middle element is Less than target it means that all elements before mid are also less than target.
              // hence target lies ahead of current mid so we set start pointer to mid + 1
                start=mid+1;
            }
          
          else{
            // if mid element is greater than target it means either mid is smallest element Greater than Target
            // or such a number already exist before mid so we check elements before mid and set end to mid - 1;
                end=mid-1;
            }
        }
      
      // we have used modulus operator  because characters wrap , thus if a character greater than target doesn't exist
      // then we print smallest element in array
        return letters[start % letters.length];
    }
}   
