class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end  = nums.length-1;
        int[] answer = {-1,-1};
        
        //Finding first occurence
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<nums[mid]){
                end = mid -1;
            }else if(target>nums[mid]){
                start = mid+1;
            }else{
                answer[0] = mid;
                start = 0;
                end = mid - 1;
            }
        }
        
        
        //Finding Last occurence
        start = 0;
        end  = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<nums[mid]){
                end = mid -1;
            }else if(target>nums[mid]){
                start = mid+1;
            }else{
                answer[1] = mid;
                start = mid+1;
                end = nums.length-1;
            }
        }
        return answer;
    }
}
