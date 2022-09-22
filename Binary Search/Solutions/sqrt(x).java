class Solution {
    public int mySqrt(int n) {
        if (n<=1) return n;
        if (n<=3 && n>=2) return 1;
        int s = 0;
        int e = n/2;
        while (s<=e){
            int m = s + (e-s)/2;
            if (m > n/m){
                e = m - 1;
            }
            else{
                s = m + 1;
            }
        }
        return e;
    }
}
