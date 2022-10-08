class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for (int i=0;i<weights.length;i++){
            start = Math.max(start,weights[i]);
            end += weights[i];
        }
        int ans = 0;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (timeTaken(weights,mid,days)){
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }

    public static boolean timeTaken(int[] arr, int maxCap, int days){
        int n = arr.length;
        int sum = 0, daysTaken = 1;
        for (int i=0;i<n;i++){
            if (sum+arr[i] <= maxCap){
                sum += arr[i];
            }
            else{
                sum  = arr[i];
                daysTaken++;
            }
        }
        return daysTaken<=days;
    }
}









