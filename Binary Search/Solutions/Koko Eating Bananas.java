class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
      
      // Minimum value of Eating Speed = 1 Banana per hour
        long start = 1;
      // Maximum value of Eating speed = Max Banana in i Pile per hour
        long end = piles[n-1];
      
        while (start <= end){
            long mid = start + (end - start)/2;
            int[] arr = piles.clone();
            if (hoursTaken(arr,mid,h)) end = mid - 1;
            else start = mid + 1;
        }
        return (int)start;
    }

    public static boolean hoursTaken(int[] piles, long k, int h) {
        int n = piles.length;
        long hours = 0;
        for (int pile: piles){
            hours += pile/k;
            if (pile%k != 0) ++hours;
        }
        return hours<=h;
    }
}
